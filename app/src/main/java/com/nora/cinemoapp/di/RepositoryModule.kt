package com.nora.cinemoapp.di

import com.nora.cinemoapp.data.MovieRepositoryImpl
import com.nora.cinemoapp.domain.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get(), get(), get()) }
}