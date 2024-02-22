package com.hw.coffeeapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hw.coffeeapp.R
import com.hw.coffeeapp.data.model.CoffeeResponseItem
import com.hw.coffeeapp.databinding.ItemCoffeeBinding

class CoffeeAdapter(private val coffeeList: List<CoffeeResponseItem>, private val onClick: (position: Int) -> Unit) :
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
                llItem.setOnClickListener { onClick(adapterPosition) }
                tvCoffeeName.text = coffee.title
                tvCoffeeDesc.text = coffee.description
                Glide.with(itemView.context).load(coffee.image).into(ivCoffeeImg)
            }
        }
    }
}