package com.kalterfad.movietest.di

import android.app.Application
import com.kalterfad.movietest.network.API
import com.kalterfad.movietest.network.RetrofitModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RetrofitModule::class])
@Singleton
interface ApplicationGraph {
    fun movie(): API
    fun inject(app: MainApp)
}

class MainApp: Application() {
    companion object {
        lateinit var instance: MainApp
            private set
    }

    lateinit var appComponent: ApplicationGraph
        private set


    override fun onCreate() {
        super.onCreate()
        instance = this
        initComponent()
    }

    private fun initComponent() {
        appComponent = DaggerApplicationGraph.builder()
            .build()
        appComponent.inject(this)
    }
}