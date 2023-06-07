package com.nora.cinemoapp.data.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nora.cinemoapp.data.database.dao.FavoriteDao
import com.nora.cinemoapp.data.database.dao.MovieDao
import com.nora.cinemoapp.data.model.FavoriteEntity
import com.nora.cinemoapp.data.model.MovieEntity

@Database(entities = [MovieEntity::class, FavoriteEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun favoriteDao(): FavoriteDao
}