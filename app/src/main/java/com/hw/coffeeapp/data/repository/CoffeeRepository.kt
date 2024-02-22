package com.hw.coffeeapp.data.repository

import com.hw.coffeeapp.data.local.CoffeeDAO
import com.hw.coffeeapp.data.model.CoffeeResponseItem
import com.hw.coffeeapp.data.remote.ApiService
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