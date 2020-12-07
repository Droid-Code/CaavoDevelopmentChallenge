package app.caavo.foodhub.data.remote

import app.caavo.foodhub.data.remote.ApiConstants.RECIPE_LIST
import app.caavo.foodhub.model.response.FoodResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface ApiServices {


    @GET(RECIPE_LIST)
    fun getRecipe() : Observable<FoodResponse>

}