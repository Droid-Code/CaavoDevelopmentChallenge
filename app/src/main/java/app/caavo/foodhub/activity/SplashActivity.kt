package app.caavo.foodhub.activity

import android.content.Intent
import android.os.Bundle
import app.caavo.foodhub.R
import app.caavo.foodhub.activity.home.HomeActivity
import app.caavo.foodhub.base.BaseActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SplashActivity : BaseActivity() {

    override fun enableFullScreen() = true
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()
        delayStart()
    }

    private fun delayStart() {
        compositeDisposable.add(Observable.timer(3000, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnNext {
                startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
                finish()
            }
            .subscribe())
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}