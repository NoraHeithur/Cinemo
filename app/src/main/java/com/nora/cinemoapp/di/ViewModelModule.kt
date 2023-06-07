package com.nora.cinemoapp.di

import com.nora.cinemoapp.ui.detail.MovieDetailViewModel
import com.nora.cinemoapp.ui.favorite.MyFavoriteViewModel
import com.nora.cinemoapp.ui.movie.MoviesViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { MoviesViewModel(get()) }
    single { MovieDetailViewModel(get(), get()) }
    single { MyFavoriteViewModel(get()) }
}