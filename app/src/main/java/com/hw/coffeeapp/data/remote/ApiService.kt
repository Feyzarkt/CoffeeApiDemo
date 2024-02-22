package com.hw.coffeeapp.data.remote

import com.hw.coffeeapp.data.model.CoffeeResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("coffee/iced")
    fun getCoffeeResult() : Call<List<CoffeeResponseItem>>

}