package app.caavo.foodhub.activity.home


import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import app.caavo.foodhub.R
import app.caavo.foodhub.activity.cart.CartActivity
import app.caavo.foodhub.adapter.FoodListGridAdapter
import app.caavo.foodhub.base.BaseActivity
import app.caavo.foodhub.callback.DatabaseCallback
import app.caavo.foodhub.callback.ResponseCallback
import app.caavo.foodhub.databinding.ActivityHomeBinding
import app.caavo.foodhub.model.response.FoodResponse
import io.reactivex.rxjava3.disposables.CompositeDisposable



class HomeActivity : BaseActivity(), DatabaseCallback{

    private lateinit var binding: ActivityHomeBinding
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val adapter = FoodListGridAdapter(FoodResponse(), this)
    override fun enableFullScreen() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.recyclerView.layoutManager = GridLayoutManager(this@HomeActivity, 2)
        binding.recyclerView.adapter = adapter

        loadRecipe()

        binding.floatingActionButton.setOnClickListener {
            startActivity(Intent(this@HomeActivity,CartActivity::class.java))
        }
    }

    private fun loadRecipe(){
        showProgress()
        compositeDisposable.add(api.getRecipeRequest(object: ResponseCallback{
            override fun onSuccess(any: Any) {
                adapter.udateItem(any as FoodResponse)
                hideProgress()
            }

            override fun onFailure(message: String) {
                notifyItemAdded(binding.coordinatorLayout,"No Internet Connection Available")
                hideProgress()
            }
        }))
    }



    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

    override fun onSuccess(model: Any) {
        notifyItemAdded(binding.coordinatorLayout,"Item Added to Cart")
    }

    override fun onError(e: Throwable) {

    }
}