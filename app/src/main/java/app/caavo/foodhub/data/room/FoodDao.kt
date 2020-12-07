package app.caavo.foodhub.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import app.caavo.foodhub.model.food.Food
import io.reactivex.Completable

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFood(vararg food: Food) : Completable
}