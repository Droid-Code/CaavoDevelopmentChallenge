package app.caavo.foodhub.activity.cart


import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import app.caavo.foodhub.R
import app.caavo.foodhub.adapter.FoodCartListAdapter
import app.caavo.foodhub.base.BaseActivity
import app.caavo.foodhub.callback.DatabaseCallback
import app.caavo.foodhub.databinding.ActivityCartBinding
import app.caavo.foodhub.manager.DatabaseManager
import app.caavo.foodhub.model.food.FoodCart


class CartActivity : BaseActivity(), DatabaseCallback {
    override fun enableFullScreen() = false
    private lateinit var binding: ActivityCartBinding
    private var foodCartItems : List<FoodCart> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart)
        binding.recyclerCartView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        loadCart()
        binding.floatClear.setOnClickListener {
            DatabaseManager.instance.clearCart(this)
        }
    }

    private fun loadCart(){
        DatabaseManager.instance.getAllCartList(object : DatabaseCallback{
            override fun onSuccess(model: Any) {
                foodCartItems = model as List<FoodCart>

                binding.recyclerCartView.adapter = FoodCartListAdapter(foodCartItems)
            }

            override fun onError(e: Throwable) {

            }

        })

    }

    override fun onSuccess(model: Any) {
        showToast("Cart Cleared")
        loadCart()
    }

    override fun onError(e: Throwable) {

    }
}