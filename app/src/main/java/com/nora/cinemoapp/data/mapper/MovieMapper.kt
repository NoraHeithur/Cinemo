package com.nora.cinemoapp.data.mapper

import com.nora.cinemoapp.data.model.FavoriteEntity
import com.nora.cinemoapp.data.model.MovieEntity
import com.nora.cinemoapp.data.model.MovieNetwork
import com.nora.cinemoapp.domain.model.Movie

fun MovieNetwork.toEntityModel(): MovieEntity {
    return MovieEntity(
        id = id,
        titleEn = titleEn,
        titleTh = titleTh,
        rating = rating,
        ratingId = ratingId,
        duration = duration,
        releaseDate = releaseDate,
        sneakDate = sneakDate,
        synopsisTh = synopsisTh,
        synopsisEn = synopsisEn,
        director = director,
        actor = actor,
        genre = genre,
        posterOri = posterOri,
        posterUrl = posterUrl,
        trailer = trailer,
        trIos = trIos ?: "",
        trHd = trHd ?: "",
        trSd = trSd ?: "",
        trMp4 = trMp4 ?: "",
        priority = priority,
        nowShowing = nowShowing,
        advanceTicket = advanceTicket,
        dateUpdate = dateUpdate,
        showBuyticket = showBuyticket,
        trailerCmsId = trailerCmsId,
        trailerIvxKey = trailerIvxKey
    )
}

fun MovieEntity.toDomainModel(): Movie {
    return Movie(
        id = id,
        titleEn = titleEn,
        titleTh = titleTh,
        rating = rating,
        ratingId = ratingId,
        duration = duration,
        releaseDate = releaseDate,
        sneakDate = sneakDate,
        synopsisTh = synopsisTh,
        synopsisEn = synopsisEn,
        director = director,
        actor = actor,
        genre = genre,
        posterOri = posterOri,
        posterUrl = posterUrl,
        trailer = trailer,
        trIos = trIos,
        trHd = trHd,
        trSd = trSd,
        trMp4 = trMp4,
        priority = priority,
        nowShowing = nowShowing,
        advanceTicket = advanceTicket,
        dateUpdate = dateUpdate,
        showBuyticket = showBuyticket,
        trailerCmsId = trailerCmsId,
        trailerIvxKey = trailerIvxKey
    )
}

fun FavoriteEntity.toDomainModel(): Movie {
    return Movie(
        id = id,
        titleEn = titleEn,
        titleTh = titleTh,
        rating = rating,
        ratingId = ratingId,
        duration = duration,
        releaseDate = releaseDate,
        sneakDate = sneakDate,
        synopsisTh = synopsisTh,
        synopsisEn = synopsisEn,
        director = director,
        actor = actor,
        genre = genre,
        posterOri = posterOri,
        posterUrl = posterUrl,
        trailer = trailer,
        trIos = trIos,
        trHd = trHd,
        trSd = trSd,
        trMp4 = trMp4,
        priority = priority,
        nowShowing = nowShowing,
        advanceTicket = advanceTicket,
        dateUpdate = dateUpdate,
        showBuyticket = showBuyticket,
        trailerCmsId = trailerCmsId,
        trailerIvxKey = trailerIvxKey,
        favorite = favorite
    )
}

fun Movie.toEntityModel(): FavoriteEntity {
    return FavoriteEntity(
        id = id,
        titleEn = titleEn,
        titleTh = titleTh,
        rating = rating,
        ratingId = ratingId,
        duration = duration,
        releaseDate = releaseDate,
        sneakDate = sneakDate,
        synopsisTh = synopsisTh,
        synopsisEn = synopsisEn,
        director = director,
        actor = actor,
        genre = genre,
        posterOri = posterOri,
        posterUrl = posterUrl,
        trailer = trailer,
        trIos = trIos,
        trHd = trHd,
        trSd = trSd,
        trMp4 = trMp4,
        priority = priority,
        nowShowing = nowShowing,
        advanceTicket = advanceTicket,
        dateUpdate = dateUpdate,
        showBuyticket = showBuyticket,
        trailerCmsId = trailerCmsId,
        trailerIvxKey = trailerIvxKey,
        favorite = favorite
    )
}
