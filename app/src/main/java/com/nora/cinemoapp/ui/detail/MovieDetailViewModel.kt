package com.nora.cinemoapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nora.cinemoapp.data.model.FavoriteEntity
import com.nora.cinemoapp.domain.interactor.AddFavoriteMovieUseCase
import com.nora.cinemoapp.domain.interactor.RemoveFavoriteMovieUseCase
import com.nora.cinemoapp.domain.model.Movie
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val addFavoriteMovieUseCase: AddFavoriteMovieUseCase,
    private val removeFavoriteMovieUseCase: RemoveFavoriteMovieUseCase
): ViewModel() {

    private val _addedToFavorite: MutableLiveData<Boolean> = MutableLiveData()
    val addToFavorite: LiveData<Boolean> = _addedToFavorite

    fun addFavoriteMovie(movie: Movie) {
        viewModelScope.launch {
            addFavoriteMovieUseCase.addFavoriteMovie(movie)
        }
        _addedToFavorite.value = true
    }

    fun removeFromFavorite(id: Int) {
        viewModelScope.launch {
            removeFavoriteMovieUseCase.removeFavoriteMovie(id)
        }
        _addedToFavorite.value = false
    }

    fun initIsFavorite(isFavorite: Boolean) {
        _addedToFavorite.value = isFavorite
    }

}