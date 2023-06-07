package com.nora.cinemoapp.ui.favorite

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nora.cinemoapp.domain.interactor.GetFavoriteMovieUseCase
import com.nora.cinemoapp.domain.model.MovieList
import kotlinx.coroutines.launch

class MyFavoriteViewModel(
    private val getFavoriteMovieUseCase: GetFavoriteMovieUseCase
) : ViewModel() {

    private val _favoriteList: MutableLiveData<MovieList> = MutableLiveData()
    val favoriteList: LiveData<MovieList> = _favoriteList

    init {
        getFavoriteMovie()
    }

    private fun getFavoriteMovie() {
        viewModelScope.launch {
            _favoriteList.value = getFavoriteMovieUseCase.getFavoriteMovies()
        }
    }

    fun refreshData() {
        getFavoriteMovie()
    }
}