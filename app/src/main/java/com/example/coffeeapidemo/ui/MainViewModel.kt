package com.example.coffeeapidemo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coffeeapidemo.data.model.CoffeeResponseItem
import com.example.coffeeapidemo.data.repository.CoffeeRepository

class MainViewModel(private val coffeeRepository: CoffeeRepository): ViewModel() {

    private val _coffeeData = MutableLiveData<List<CoffeeResponseItem>?>()
    val coffeeData: LiveData<List<CoffeeResponseItem>?> = _coffeeData
    init {
        getAllData()
    }
    private fun getAllData() {
        coffeeRepository.getAllData {
            _coffeeData.postValue(it)
        }
    }
}

