package com.example.coffeeapidemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.coffeeapidemo.data.local.CoffeeDB
import com.example.coffeeapidemo.data.remote.ApiService
import com.example.coffeeapidemo.data.repository.CoffeeRepository
import com.example.coffeeapidemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val repository = CoffeeRepository(CoffeeDB.getInstance(this), ApiService.create())
        val factory = MyViewModelFactory(repository)
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