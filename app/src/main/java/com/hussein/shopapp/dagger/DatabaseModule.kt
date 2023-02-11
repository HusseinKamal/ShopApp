package com.hussein.shopapp.dagger

import android.app.Application
import android.content.Context
import com.hussein.shopapp.database.AppDatabase
import com.hussein.shopapp.database.ShopDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule (/*val application: Application*/)  {

    @Singleton
    @Provides
    fun getShopDao(appDatabase: AppDatabase): ShopDao {
        return appDatabase.getShopDao()
    }

    @Singleton
    @Provides
    fun getRoomDBInstance(context: Context): AppDatabase {
        return AppDatabase.getDatabaseInstance(context)
    }

  /*  @Singleton
    @Provides
    fun provideAppContext(): Context {
        return application.applicationContext
    }*/
}