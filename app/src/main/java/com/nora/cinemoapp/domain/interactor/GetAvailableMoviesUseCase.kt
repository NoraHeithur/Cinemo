package com.nora.cinemoapp.domain.interactor

import com.nora.cinemoapp.data.mapper.toDomainModel
import com.nora.cinemoapp.domain.MovieRepository
import com.nora.cinemoapp.domain.model.Movie
import com.nora.cinemoapp.domain.model.MovieList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAvailableMoviesUseCase(
    private val repository: MovieRepository
) {
    suspend fun getAvailableMovies(): MovieList {
        var movies = listOf<Movie>()
        withContext(Dispatchers.IO) {
            movies = repository.getAvailableMovies().movies.map { it.toDomainModel() }
        }
        return MovieList(movies = movies)
    }
}
