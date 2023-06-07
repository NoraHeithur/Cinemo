package com.nora.cinemoapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieListNetwork(
    @Json(name = "movies")
    val movies: List<MovieNetwork> = listOf()
)
