package com.hussein.shopapp

import android.app.Application
import com.hussein.shopapp.dagger.ApplicationComponent
import com.hussein.shopapp.dagger.DaggerApplicationComponent

class App :Application() {
    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        //component= DaggerApplicationComponent.builder().build()
        //component= DaggerApplicationComponent.builder().networkModule(NetworkModule()).build()
        component= DaggerApplicationComponent.factory().create(this)
    }
}