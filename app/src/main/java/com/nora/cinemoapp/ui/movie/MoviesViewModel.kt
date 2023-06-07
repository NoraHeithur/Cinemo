package com.nora.cinemoapp.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nora.cinemoapp.domain.interactor.GetAvailableMoviesUseCase
import com.nora.cinemoapp.domain.model.MovieList
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val getAvailableMoviesUseCase: GetAvailableMoviesUseCase
) : ViewModel() {

    private val _movieList: MutableLiveData<MovieList> = MutableLiveData()
    val movieList: LiveData<MovieList> = _movieList

    init {
        getMovie()
    }

    private fun getMovie() {
        viewModelScope.launch {
            _movieList.value = getAvailableMoviesUseCase.getAvailableMovies()
        }
    }

    fun getRefreshData() {
        getMovie()
    }
}