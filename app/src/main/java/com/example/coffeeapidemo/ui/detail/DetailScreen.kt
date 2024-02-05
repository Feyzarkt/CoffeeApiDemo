package com.example.coffeeapidemo.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.coffeeapidemo.databinding.FragmentDetailScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailScreen : Fragment() {

    private val navArgs: DetailScreenArgs by navArgs()
    private lateinit var binding: FragmentDetailScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailScreenBinding.inflate(inflater)
        initUI ()

        return binding.root
    }

    private fun initUI () {
        val coffeeItem = navArgs.item
        with(binding) {
            Glide.with(requireContext()).load(coffeeItem.image).into(ivBackdrop)
            collapsingToolBar.title = coffeeItem.title

            var ingredients = ""
            coffeeItem.ingredients.forEach {
                ingredients += it + "\n"
            }
            tvCoffeeIngredients.text = ingredients
        }
    }
}