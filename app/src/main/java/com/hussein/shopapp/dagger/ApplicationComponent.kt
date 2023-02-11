package com.hussein.shopapp.dagger

import android.content.Context
import com.hussein.shopapp.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class,DatabaseModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity) // for field inject property inside the MainActivity

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}