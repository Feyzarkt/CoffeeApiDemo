package com.example.coffeeapidemo.data.repository

import com.example.coffeeapidemo.data.local.CoffeeDAO
import com.example.coffeeapidemo.data.local.CoffeeDB
import com.example.coffeeapidemo.data.model.CoffeeResponseItem
import com.example.coffeeapidemo.data.remote.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CoffeeRepository @Inject constructor(private val coffeeDao: CoffeeDAO, private val apiService: ApiService) {

    fun getAllData(callback: (List<CoffeeResponseItem>?)-> Unit) {
        apiService.getCoffeeResult().enqueue(object : Callback<List<CoffeeResponseItem>> {
            override fun onResponse(
                call: Call<List<CoffeeResponseItem>>,
                coffeeResponse: Response<List<CoffeeResponseItem>>
            ) {
                if (coffeeResponse.isSuccessful) {
                    val response = coffeeResponse.body()
                    callback(response)
                    Thread {
                        response?.let { coffeeDao.insert(it) }
                    }.start()
                }
            }
            override fun onFailure(call: Call<List<CoffeeResponseItem>>, t: Throwable) {
                Thread {
                    val coffeeList = coffeeDao.getAll()
                    callback(coffeeList)
                }.start()
            }
        })
    }
}