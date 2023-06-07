package com.nora.cinemoapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieList(
    val movies: List<Movie>
): Parcelable
