package app.caavo.foodhub.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.caavo.foodhub.model.food.FoodCart
import io.reactivex.Completable
import io.reactivex.Flowable


@Dao
interface FoodCartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFood(vararg food: FoodCart) : Completable

    @Query("SELECT * FROM FoodCart")
    fun getAll(): Flowable<List<FoodCart>>

    @Query("DELETE FROM FoodCart")
    fun deleteAll()
}