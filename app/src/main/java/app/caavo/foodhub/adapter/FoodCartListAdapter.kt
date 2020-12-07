package app.caavo.foodhub.adapter

import android.view.LayoutInflater
import android.view.ViewGroup


import androidx.recyclerview.widget.RecyclerView
import app.caavo.foodhub.databinding.ItemFoodBinding
import app.caavo.foodhub.databinding.ItemFoodCartBinding
import app.caavo.foodhub.model.food.FoodCart

class FoodCartListAdapter(var foodResponse: List<FoodCart>) :
    RecyclerView.Adapter<FoodCartViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodCartViewHolder {
        val foodItemBinding = ItemFoodCartBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return FoodCartViewHolder(foodItemBinding)
    }

    override fun getItemCount(): Int = foodResponse.size

    override fun onBindViewHolder(holder: FoodCartViewHolder, position: Int) {
        holder.bind(foodResponse[position])
    }


}