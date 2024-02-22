package com.hw.coffeeapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hw.coffeeapp.data.model.CoffeeResponseItem
import com.hw.coffeeapp.data.repository.CoffeeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val coffeeRepository: CoffeeRepository): ViewModel() {

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

