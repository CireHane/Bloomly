package com.bloomly.bloomly

import android.app.Application
import com.bloomly.bloomly.di.AppContainer
import com.bloomly.bloomly.di.DefaultContainer

class MainApplication: Application() {

    lateinit var container: AppContainer
        private set

    override fun onCreate() {
        super.onCreate()
        container = DefaultContainer()
    }
}