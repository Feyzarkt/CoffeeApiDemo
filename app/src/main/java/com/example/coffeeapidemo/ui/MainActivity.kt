package com.example.coffeeapidemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.coffeeapidemo.R
import com.example.coffeeapidemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        viewModel.getAllData()
        initObserver()

        setContentView(binding.root)
    }

    private fun initObserver() {
        viewModel.coffeeData.observe(this){ coffeeList->
            binding.rvCoffee.adapter = coffeeList?.let { CoffeeAdapter(it) }
        }
    }
}