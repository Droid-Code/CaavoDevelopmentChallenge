package app.caavo.foodhub.adapter


import androidx.recyclerview.widget.RecyclerView
import app.caavo.foodhub.BR
import app.caavo.foodhub.databinding.ItemFoodBinding
import app.caavo.foodhub.model.food.Food

class FoodViewHolder(private val foodItemBinding: ItemFoodBinding) :
    RecyclerView.ViewHolder(foodItemBinding.root) {

    fun bind(foodItem: Food){
        foodItemBinding.setVariable(BR.foodItem,foodItem)
        foodItemBinding.executePendingBindings()
    }
}