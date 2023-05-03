package com.example.coffeeapidemo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coffeeapidemo.R
import com.example.coffeeapidemo.data.model.CoffeeResponseItem
import com.example.coffeeapidemo.databinding.ItemCoffeeBinding

class CoffeeAdapter(private val coffeeList: List<CoffeeResponseItem>) :
    RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CoffeeViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_coffee, parent, false)
        return CoffeeViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CoffeeViewHolder,
        position: Int
    ) {
        holder.bind(coffeeList[position])
    }

    override fun getItemCount(): Int {
        return coffeeList.size
    }

    inner class CoffeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(coffee: CoffeeResponseItem) {
            val binding = ItemCoffeeBinding.bind(itemView)
            with(binding) {
                tvCoffeeName.text = coffee.title
                tvCoffeeDesc.text = coffee.description
                Glide.with(itemView.context).load(coffee.image).into(ivCoffeeImg)
            }
        }
    }
}