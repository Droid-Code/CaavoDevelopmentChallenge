package app.caavo.foodhub.adapter


import androidx.recyclerview.widget.RecyclerView
import app.caavo.foodhub.BR
import app.caavo.foodhub.databinding.ItemFoodGridBinding
import app.caavo.foodhub.model.food.Food

class FoodGridViewHolder(private val foodItemBinding: ItemFoodGridBinding) :
    RecyclerView.ViewHolder(foodItemBinding.root) {
    var viewItems = foodItemBinding
    fun bind(foodItem: Food){
        foodItemBinding.setVariable(BR.foodItem,foodItem)
        foodItemBinding.executePendingBindings()
    }
}