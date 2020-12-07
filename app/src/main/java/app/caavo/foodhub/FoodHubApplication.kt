package app.caavo.foodhub

import android.app.Application
import androidx.multidex.MultiDex
import androidx.room.Room
import app.caavo.foodhub.data.room.FoodDatabase

class FoodHubApplication : Application() {

    companion object {
        lateinit var dbInstance: FoodDatabase
    }

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        dbInstance = Room.databaseBuilder(
            this,
            FoodDatabase::class.java, "app_db"
        ).allowMainThreadQueries().build()
    }
}