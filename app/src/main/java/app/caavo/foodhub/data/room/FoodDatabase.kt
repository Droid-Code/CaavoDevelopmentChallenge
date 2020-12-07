package app.caavo.foodhub.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import app.caavo.foodhub.model.food.Food
import app.caavo.foodhub.model.food.FoodCart

@Database(entities = [Food::class, FoodCart::class], version = 1)
abstract class FoodDatabase :RoomDatabase() {
    abstract fun foodDao(): FoodDao
    abstract fun foodCartDao(): FoodCartDao
}