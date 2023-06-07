package com.nora.cinemoapp.di

import com.nora.cinemoapp.BuildConfig
import com.nora.cinemoapp.data.network.MovieAvailableApi
import com.nora.cinemoapp.data.network.MovieAvailableClient
import com.nora.cinemoapp.data.network.MovieAvailableService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    single { provideMoshi() }
    single { provideOkHttpClient() }
    single { MovieAvailableClient(get(), get()) }
    single { MovieAvailableService(get()) }
}

private fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().apply {
        addInterceptor(provideHttpLoggingInterceptor())
    }.build()
}

private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
        .setLevel(HttpLoggingInterceptor.Level.BODY)
}

private fun provideMoshi(): Moshi {
    return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
}
