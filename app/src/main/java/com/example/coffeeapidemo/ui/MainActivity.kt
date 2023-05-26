package com.example.coffeeapidemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.coffeeapidemo.data.local.CoffeeDB
import com.example.coffeeapidemo.data.remote.ApiService
import com.example.coffeeapidemo.data.repository.CoffeeRepository
import com.example.coffeeapidemo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        initObserver()

        setContentView(binding.root)
    }

    private fun initObserver() {
        viewModel.coffeeData.observe(this){ coffeeList->
            binding.rvCoffee.adapter = coffeeList?.let { CoffeeAdapter(it) }
        }
    }
}