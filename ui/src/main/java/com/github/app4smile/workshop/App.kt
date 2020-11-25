package com.github.app4smile.workshop

import android.app.Application
import com.github.app4smile.workshop.di.component.AppComponent
import com.github.app4smile.workshop.di.component.DaggerAppComponent
import com.github.app4smile.workshop.di.module.AppModule

class App : Application() {
    val applicationComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        initInjector()
    }

    private fun initInjector() {
        applicationComponent.inject(this)
    }
}
