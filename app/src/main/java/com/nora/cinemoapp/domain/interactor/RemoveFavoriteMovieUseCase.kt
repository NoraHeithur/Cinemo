package com.nora.cinemoapp.domain.interactor

import com.nora.cinemoapp.domain.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoveFavoriteMovieUseCase(
    private val repository: MovieRepository
) {
    suspend fun removeFavoriteMovie(id: Int) {
        withContext(Dispatchers.IO) {
            repository.removeFavoriteMovie(id)
        }
    }
}
