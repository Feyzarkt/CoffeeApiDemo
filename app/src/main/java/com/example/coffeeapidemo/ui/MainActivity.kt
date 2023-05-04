package com.example.coffeeapidemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coffeeapidemo.R
import com.example.coffeeapidemo.data.repository.CoffeeRepository
import com.example.coffeeapidemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val factory = MyViewModelFactory(CoffeeRepository(application))
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        initObserver()

        setContentView(binding.root)
    }

    private fun initObserver() {
        viewModel.coffeeData.observe(this){ coffeeList->
            binding.rvCoffee.adapter = coffeeList?.let { CoffeeAdapter(it) }
        }
    }
}

class MyViewModelFactory constructor(val coffeeRepository: CoffeeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(coffeeRepository) as T
    }
}