package com.nora.cinemoapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nora.cinemoapp.databinding.ItemMovieBinding
import com.nora.cinemoapp.domain.model.Movie
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.format.FormatStyle
import java.util.Locale

class MoviesAdapter(private val listener: MoviesListener) :
    ListAdapter<Movie, MoviesAdapter.MovieViewHolder>(MovieComparator) {

    companion object {
        const val DATE_PATTERN = "yyyy-MM-dd"
        const val DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss"
        const val TIME_START = "00:00:00"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val bindingLayout = ItemMovieBinding.inflate(inflater, parent, false)

        return MovieViewHolder(bindingLayout)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        getItem(position)?.let { holder.bindView(it, listener) }
    }

    inner class MovieViewHolder(private val itemBinding: ItemMovieBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bindView(item: Movie, listener: MoviesListener) {
            itemBinding.sivMoviePoster.load(item.posterUrl)
            itemBinding.tvMovieGenre.text = item.genre
            itemBinding.tvMovieName.text = if (Locale.getDefault() == Locale("th")) {
                item.titleTh
            } else {
                item.titleEn
            }
            itemBinding.tvMovieReleaseDate.text = parseTimeFormat(item.releaseDate)
            itemBinding.cvCardMovieItem.setOnClickListener {
                listener.onItemClicked(it, item)
            }
        }

        private fun parseTimeFormat(dateTime: String) : String {
            val inputDateTime = if (dateTime.length == DATE_PATTERN.length) {
                "$dateTime $TIME_START"
            } else {
                dateTime
            }
            val inputPattern = DateTimeFormatterBuilder()
                .appendPattern(DATETIME_PATTERN)
                .toFormatter()
            val outputPattern = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.getDefault())
            val parsedInput = LocalDateTime.parse(inputDateTime, inputPattern)
            return parsedInput.format(outputPattern)
        }
    }

    object MovieComparator : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }
    }
}