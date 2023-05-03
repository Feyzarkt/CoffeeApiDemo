package com.example.coffeeapidemo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coffeeapidemo.data.model.CoffeeResponseItem
import com.example.coffeeapidemo.data.remote.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {

    private val apiService = ApiService.create()

    private val _coffeeData = MutableLiveData<List<CoffeeResponseItem>?>()
    val coffeeData: LiveData<List<CoffeeResponseItem>?> = _coffeeData

    fun getAllData() {
        apiService.getCoffeeResult().enqueue(object : Callback<List<CoffeeResponseItem>> {
            override fun onResponse(
                call: Call<List<CoffeeResponseItem>>,
                coffeeResponse: Response<List<CoffeeResponseItem>>
            ) {
                if (coffeeResponse.isSuccessful) {
                    val response = coffeeResponse.body()
                    _coffeeData.value = response
                    /*Thread(Runnable {
                        weatherDb.weatherDao().deleteAll()
                        response?.let { weatherDb.weatherDao().insert(it) }
                    }).start()*/
                }
            }
            override fun onFailure(call: Call<List<CoffeeResponseItem>>, t: Throwable) {
                /*Thread(Runnable {
                    val weatherList = weatherDb.weatherDao().getAll()
                    _coffeeData.postValue(weatherList)
                }).start()*/
            }
        })
    }
}