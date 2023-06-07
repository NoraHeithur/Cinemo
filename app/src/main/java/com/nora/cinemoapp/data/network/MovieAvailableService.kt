package com.nora.cinemoapp.data.network

import com.nora.cinemoapp.BuildConfig
import com.nora.cinemoapp.data.model.MovieListNetwork
import retrofit2.Response

class MovieAvailableService(
    private val client: MovieAvailableClient
): MovieAvailableApi {

    private val movieClient by lazy {
        client.getClient(endPoint = BuildConfig.BASE_ENDPOINT).create(MovieAvailableApi::class.java)
    }

    override suspend fun getAvailableMovies(): Response<MovieListNetwork> {
        return movieClient.getAvailableMovies()
    }

}
