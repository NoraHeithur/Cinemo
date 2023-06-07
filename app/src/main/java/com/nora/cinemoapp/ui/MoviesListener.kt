package com.nora.cinemoapp.ui

import android.view.View
import com.nora.cinemoapp.domain.model.Movie

interface MoviesListener {
    fun onItemClicked(view: View, movie: Movie)
}