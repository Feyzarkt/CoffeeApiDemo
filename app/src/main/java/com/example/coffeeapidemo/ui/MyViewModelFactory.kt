package com.example.coffeeapidemo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coffeeapidemo.data.repository.CoffeeRepository

class MyViewModelFactory constructor(val coffeeRepository: CoffeeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(coffeeRepository) as T
    }
}