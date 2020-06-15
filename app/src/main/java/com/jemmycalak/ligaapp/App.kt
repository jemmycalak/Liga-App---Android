package com.jemmycalak.ligaapp

import android.app.Application
import com.jemmycalak.ligaapp.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setupDi()
    }

    fun setupDi() = startKoin {
        androidLogger()

        // use the Android context given there
        androidContext(this@App)

        // load properties from assets/koin.properties file
        androidFileProperties()

        modules(appComponent)
    }
}