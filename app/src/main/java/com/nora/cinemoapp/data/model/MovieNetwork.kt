package com.nora.cinemoapp.data.model

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class MovieNetwork(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "movieCode")
    val movieCode: List<String> = listOf(),
    @Json(name = "title_en")
    val titleEn: String = "",
    @Json(name = "title_th")
    val titleTh: String = "",
    @Json(name = "rating")
    val rating: String = "",
    @Json(name = "rating_id")
    val ratingId: Int = 0,
    @Json(name = "duration")
    val duration: Int = 0,
    @Json(name = "release_date")
    val releaseDate: String = "",
    @Json(name = "sneak_date")
    val sneakDate: String = "",
    @Json(name = "synopsis_th")
    val synopsisTh: String = "",
    @Json(name = "synopsis_en")
    val synopsisEn: String = "",
    @Json(name = "director")
    val director: String = "",
    @Json(name = "actor")
    val actor: String = "",
    @Json(name = "genre")
    val genre: String = "",
    @Json(name = "poster_ori")
    val posterOri: String = "",
    @Json(name = "poster_url")
    val posterUrl: String = "",
    @Json(name = "trailer")
    val trailer: String = "",
    @Json(name = "tr_ios")
    var trIos: String? = "",
    @Json(name = "tr_hd")
    var trHd: String? = "",
    @Json(name = "tr_sd")
    var trSd: String? = "",
    @Json(name = "tr_mp4")
    var trMp4: String? = "",
    @Json(name = "priority")
    val priority: String = "",
    @Json(name = "now_showing")
    val nowShowing: String = "",
    @Json(name = "advance_ticket")
    val advanceTicket: String = "",
    @Json(name = "date_update")
    val dateUpdate: String = "",
    @Json(name = "show_buyticket")
    val showBuyticket: String = "",
    @Json(name = "trailer_cms_id")
    val trailerCmsId: String = "",
    @Json(name = "trailer_ivx_key")
    val trailerIvxKey: String = ""
)
