package com.example.coffeeapidemo.data.remote

import com.example.coffeeapidemo.data.model.CoffeeResponseItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface ApiService {

    @GET("coffee/iced")
    fun getCoffeeResult() : Call<List<CoffeeResponseItem>>

}