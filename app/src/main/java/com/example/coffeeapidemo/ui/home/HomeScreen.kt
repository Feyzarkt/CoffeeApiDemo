package com.example.coffeeapidemo.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.coffeeapidemo.databinding.FragmentHomeScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeScreen : Fragment() {

    private lateinit var binding: FragmentHomeScreenBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeScreenBinding.inflate(inflater)
        initObserver()

        return binding.root
    }


    private fun initObserver() {
        viewModel.coffeeData.observe(this) { coffeeList ->
            binding.rvCoffee.adapter = coffeeList?.let { coffeeItem ->
                CoffeeAdapter(coffeeItem) { position ->
                    findNavController().navigate(HomeScreenDirections.actionHomeScreenToDetailScreen(coffeeItem[position]))
                }
            }
        }
    }
}