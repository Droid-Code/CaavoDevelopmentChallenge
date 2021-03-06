package app.caavo.ui

import android.widget.ImageView

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


class BindingAdapters {
    companion object{
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun loadImage(view: ImageView, url: String) {
            Glide.with(view.context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(view)
        }
    }

}