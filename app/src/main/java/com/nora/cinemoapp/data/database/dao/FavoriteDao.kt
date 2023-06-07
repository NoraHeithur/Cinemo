package com.nora.cinemoapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nora.cinemoapp.data.model.FavoriteEntity

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteMovie(movie: FavoriteEntity)

    @Query("SELECT * FROM favorite_movies_table")
    suspend fun getFavoriteMovies(): List<FavoriteEntity>

    @Query("DELETE FROM favorite_movies_table WHERE id == :movieId")
    suspend fun deleteFavorite(movieId: Int)
}