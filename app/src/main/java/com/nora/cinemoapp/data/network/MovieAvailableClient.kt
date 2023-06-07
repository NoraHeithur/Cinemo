package com.nora.cinemoapp.data.network

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class MovieAvailableClient(
    private val okHttpClient: OkHttpClient,
    private val moshi: Moshi
) {
    fun getClient(endPoint: String): Retrofit {
        return ClientBuilder.build(okHttpClient, moshi, endPoint)
    }
 }
