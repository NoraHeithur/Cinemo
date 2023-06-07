package com.nora.cinemoapp.domain.interactor

import com.nora.cinemoapp.data.mapper.toEntityModel
import com.nora.cinemoapp.domain.MovieRepository
import com.nora.cinemoapp.domain.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AddFavoriteMovieUseCase(
    private val repository: MovieRepository
) {
    suspend fun addFavoriteMovie(movie: Movie) {
        withContext(Dispatchers.IO) {
            repository.addFavoriteMovie(movie.apply {
                this.favorite = true
            }.toEntityModel())
        }
    }
}
