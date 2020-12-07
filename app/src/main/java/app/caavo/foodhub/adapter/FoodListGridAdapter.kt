package app.caavo.foodhub.adapter

import android.view.LayoutInflater
import android.view.ViewGroup


import androidx.recyclerview.widget.RecyclerView
import app.caavo.foodhub.callback.DatabaseCallback
import app.caavo.foodhub.databinding.ItemFoodGridBinding
import app.caavo.foodhub.manager.DatabaseManager
import app.caavo.foodhub.model.food.FoodCart
import app.caavo.foodhub.model.response.FoodResponse

class FoodListGridAdapter(var foodResponse: FoodResponse, var callback: DatabaseCallback) :
    RecyclerView.Adapter<FoodGridViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodGridViewHolder {
        val foodItemBinding = ItemFoodGridBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return FoodGridViewHolder(foodItemBinding)
    }

    override fun getItemCount(): Int = foodResponse.size

    override fun onBindViewHolder(holder: FoodGridViewHolder, position: Int) {
        holder.bind(foodResponse[position])
        holder.viewItems.btnAddCart.setOnClickListener {
            addItemToCart(position)
        }
    }

    fun udateItem(foodItems: FoodResponse) {
        foodResponse.addAll(foodItems)
        notifyDataSetChanged()
    }


    fun addItemToCart(position: Int) {
        var foodItem = foodResponse[position]
        DatabaseManager.instance.addFoodToCart(
            FoodCart(
                name = foodItem.name,
                category = foodItem.category,
                description = foodItem.description,
                image = foodItem.image,
                id = foodItem.id,
                label = foodItem.label,
                price = foodItem.price.toFloat()
            ),
            callback
        )
        //callback.onSuccess(foodResponse.get(0))
        foodResponse.removeAt(position)
        notifyDataSetChanged()
    }

}