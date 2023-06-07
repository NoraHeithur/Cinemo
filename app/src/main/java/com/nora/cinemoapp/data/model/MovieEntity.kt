package com.nora.cinemoapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "available_movies_table")
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    val titleEn: String,
    val titleTh: String,
    val rating: String,
    val ratingId: Int,
    val duration: Int,
    val releaseDate: String,
    val sneakDate: String,
    val synopsisTh: String,
    val synopsisEn: String,
    val director: String,
    val actor: String,
    val genre: String,
    val posterOri: String,
    val posterUrl: String,
    val trailer: String,
    val trIos: String,
    val trHd: String,
    val trSd: String,
    val trMp4: String,
    val priority: String,
    val nowShowing: String,
    val advanceTicket: String,
    val dateUpdate: String,
    val showBuyticket: String,
    val trailerCmsId: String,
    val trailerIvxKey: String
)
