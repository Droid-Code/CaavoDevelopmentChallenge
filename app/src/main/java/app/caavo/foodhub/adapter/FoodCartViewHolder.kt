package app.caavo.foodhub.adapter

import androidx.recyclerview.widget.RecyclerView
import app.caavo.foodhub.BR
import app.caavo.foodhub.databinding.ItemFoodBinding
import app.caavo.foodhub.databinding.ItemFoodCartBinding
import app.caavo.foodhub.model.food.FoodCart

class FoodCartViewHolder(private val foodItemBinding: ItemFoodCartBinding) :
    RecyclerView.ViewHolder(foodItemBinding.root) {

    fun bind(foodItem: FoodCart){
        foodItemBinding.setVariable(BR.foodItem,foodItem)
        foodItemBinding.executePendingBindings()
    }
}