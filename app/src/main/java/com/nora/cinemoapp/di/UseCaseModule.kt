package com.nora.cinemoapp.di

import com.nora.cinemoapp.domain.interactor.AddFavoriteMovieUseCase
import com.nora.cinemoapp.domain.interactor.GetAvailableMoviesUseCase
import com.nora.cinemoapp.domain.interactor.GetFavoriteMovieUseCase
import com.nora.cinemoapp.domain.interactor.RemoveFavoriteMovieUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetAvailableMoviesUseCase(get()) }
    single { GetFavoriteMovieUseCase(get()) }
    single { AddFavoriteMovieUseCase(get()) }
    single { RemoveFavoriteMovieUseCase(get()) }
}