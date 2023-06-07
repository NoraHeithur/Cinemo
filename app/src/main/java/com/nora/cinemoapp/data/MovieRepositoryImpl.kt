package com.nora.cinemoapp.data

import com.nora.cinemoapp.data.database.dao.FavoriteDao
import com.nora.cinemoapp.data.database.dao.MovieDao
import com.nora.cinemoapp.data.mapper.toEntityModel
import com.nora.cinemoapp.data.model.FavoriteEntity
import com.nora.cinemoapp.data.model.FavoriteListEntity
import com.nora.cinemoapp.data.model.MovieListEntity
import com.nora.cinemoapp.data.model.MovieListNetwork
import com.nora.cinemoapp.data.network.MovieAvailableService
import com.nora.cinemoapp.domain.MovieRepository

class MovieRepositoryImpl(
    private val movieService: MovieAvailableService,
    private val movieDao: MovieDao,
    private val favoriteDao: FavoriteDao
): MovieRepository {

    override suspend fun getAvailableMovies(): MovieListEntity {
        val movieResponse = movieService.getAvailableMovies().body() ?: MovieListNetwork()
        val movieEntityList = MovieListEntity(
            movies = movieResponse.movies.map { it.toEntityModel() }
        )
        movieDao.insertMovie(movieEntityList.movies)
        val movies = movieDao.getAllAvailableMovies()
        return MovieListEntity(movies = movies)
    }

    override suspend fun getFavoriteMovies(): FavoriteListEntity {
        val favoriteList = favoriteDao.getFavoriteMovies()
        return FavoriteListEntity(movies = favoriteList)
    }

    override suspend fun addFavoriteMovie(movie: FavoriteEntity) {
        favoriteDao.insertFavoriteMovie(movie)
    }

    override suspend fun removeFavoriteMovie(id: Int) {
        favoriteDao.deleteFavorite(id)
    }
}