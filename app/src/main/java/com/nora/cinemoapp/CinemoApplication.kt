package com.nora.cinemoapp

import android.app.Application
import com.nora.cinemoapp.di.databaseModule
import com.nora.cinemoapp.di.networkModule
import com.nora.cinemoapp.di.repositoryModule
import com.nora.cinemoapp.di.useCaseModule
import com.nora.cinemoapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CinemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@CinemoApplication)
            androidLogger(Level.ERROR)
            modules(listOf(databaseModule, networkModule, repositoryModule, useCaseModule, viewModelModule))
        }
    }
}