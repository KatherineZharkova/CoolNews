package ru.cocovella.coolnews.di.app.modules

import android.widget.ImageView
import dagger.Module
import dagger.Provides
import ru.cocovella.coolnews.mvp.model.image.IImageLoader
import ru.cocovella.coolnews.ui.image.GlideImageLoader

@Module
class ImageModule {

    @Provides
    fun imageLoader(): IImageLoader<ImageView> {
        return GlideImageLoader()
    }

}
