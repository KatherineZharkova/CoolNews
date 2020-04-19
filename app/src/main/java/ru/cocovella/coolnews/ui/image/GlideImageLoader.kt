package ru.cocovella.coolnews.ui.image

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import ru.cocovella.coolnews.mvp.model.image.IImageLoader


class GlideImageLoader : IImageLoader<ImageView> {
    override fun loadInto(url: String, container: ImageView) {
        val requestOptions = RequestOptions()
                    Glide.with(container.context)
//                        .asBitmap()
                        .load(url)
                        .apply(requestOptions)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(container)
    }

}