package com.ashish.demo

import android.app.Application
import di.AdapterModule
import di.repoImplementation
import di.retrofitModule
import di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class StationApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@StationApplication)
            androidLogger(Level.ERROR)
            modules(
                listOf(
                    retrofitModule,
                    viewModelModule,
                    AdapterModule,
                    repoImplementation
                )
            )
        }
    }
}