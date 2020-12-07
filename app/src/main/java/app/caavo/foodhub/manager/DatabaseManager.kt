package app.caavo.foodhub.manager

import app.caavo.foodhub.FoodHubApplication
import app.caavo.foodhub.callback.DatabaseCallback
import app.caavo.foodhub.model.food.FoodCart
import io.reactivex.CompletableObserver
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class DatabaseManager {
    companion object {
        val instance = DatabaseManager()
        private val foodDao = FoodHubApplication.dbInstance.foodDao()
        private val foodCart= FoodHubApplication.dbInstance.foodCartDao()
    }

    fun addFoodToCart(foodCartItem: FoodCart, callback: DatabaseCallback?) {
        foodCart
            .insertFood(foodCartItem)
            .subscribeOn(Schedulers.io())
            .subscribe(object : CompletableObserver {
                override fun onComplete() {
                    callback?.onSuccess(foodCartItem)
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    callback?.onError(e)
                }

            })

    }


    fun getAllCartList(callback: DatabaseCallback?) = foodCart
        .getAll()
        .subscribeOn(Schedulers.io())
        .subscribe {
            callback?.onSuccess(it)
        }

    fun clearCart(callback: DatabaseCallback?){
        foodCart.deleteAll()
        callback?.onSuccess(1)
    }
}