package com.nora.cinemoapp.data.network

import com.nora.cinemoapp.data.model.MovieListNetwork
import retrofit2.Response
import retrofit2.http.GET

interface MovieAvailableApi {
    @GET("get_movie_avaiable")
    suspend fun getAvailableMovies(): Response<MovieListNetwork>
}
