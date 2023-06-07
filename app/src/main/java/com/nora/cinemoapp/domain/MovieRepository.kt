package com.nora.cinemoapp.domain

import com.nora.cinemoapp.data.model.FavoriteEntity
import com.nora.cinemoapp.data.model.FavoriteListEntity
import com.nora.cinemoapp.data.model.MovieListEntity

interface MovieRepository {
    suspend fun getAvailableMovies(): MovieListEntity
    suspend fun getFavoriteMovies(): FavoriteListEntity
    suspend fun addFavoriteMovie(movie: FavoriteEntity)
    suspend fun removeFavoriteMovie(id: Int)
}