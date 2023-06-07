package com.nora.cinemoapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nora.cinemoapp.data.model.MovieEntity
import com.nora.cinemoapp.data.model.MovieListEntity
import com.nora.cinemoapp.domain.model.Movie
import com.nora.cinemoapp.domain.model.MovieList

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movies: List<MovieEntity>)

    @Query("SELECT * FROM available_movies_table")
    suspend fun getAllAvailableMovies(): List<MovieEntity>
}
