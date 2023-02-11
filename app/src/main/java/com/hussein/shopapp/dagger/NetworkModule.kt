package com.hussein.shopapp.dagger

import android.app.Application
import android.content.Context
import com.hussein.shopapp.database.AppDatabase
import com.hussein.shopapp.database.ShopDao
import com.hussein.shopapp.retrofit.RetrofitAPI
import com.hussein.shopapp.util.Constant
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule{

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit
    {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitAPI(retrofit: Retrofit): RetrofitAPI
    {
        return retrofit.create(RetrofitAPI::class.java)
    }
}