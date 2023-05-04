package com.example.coffeeapidemo.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coffeeapidemo.data.local.CoffeeDB
import com.example.coffeeapidemo.data.model.CoffeeResponseItem
import com.example.coffeeapidemo.data.remote.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(app: Application): AndroidViewModel(app) {
    private val coffeeDb = CoffeeDB.getInstance(app)
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
                    Thread {
                        response?.let { coffeeDb.coffeeDao().insert(it) }
                    }.start()
                }
            }
            override fun onFailure(call: Call<List<CoffeeResponseItem>>, t: Throwable) {
                Thread {
                    val coffeeList = coffeeDb.coffeeDao().getAll()
                    _coffeeData.postValue(coffeeList)
                }.start()
            }
        })
    }
}