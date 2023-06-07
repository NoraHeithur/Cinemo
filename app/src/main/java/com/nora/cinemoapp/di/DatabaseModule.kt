package com.nora.cinemoapp.di

import androidx.room.Room
import com.nora.cinemoapp.data.database.db.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

private const val DATABASE_NAME = "Cinemo_Database"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<AppDatabase>().movieDao() }
    single { get<AppDatabase>().favoriteDao() }
}