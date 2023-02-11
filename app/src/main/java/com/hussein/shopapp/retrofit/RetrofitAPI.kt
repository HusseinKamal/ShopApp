package com.hussein.shopapp.retrofit
import com.hussein.shopapp.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitAPI {
    @GET("products")
    suspend fun getProducts(): Response<Product>
}