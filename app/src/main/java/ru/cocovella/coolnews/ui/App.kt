package ru.cocovella.coolnews.ui

import android.app.Application
import ru.cocovella.coolnews.di.app.AppComponent
import ru.cocovella.coolnews.di.app.DaggerAppComponent
import ru.cocovella.coolnews.di.app.modules.AppModule
import ru.cocovella.coolnews.di.headlines.HeadlinesSubcomponent
import ru.cocovella.coolnews.di.article.ArticleSubcomponent
import timber.log.Timber

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent
        private set

    private var tHeadlinesSubcomponent: HeadlinesSubcomponent? = null

    val headlinesSubcomponent: HeadlinesSubcomponent
        get() = appComponent.headlinesSubcomponent().also {
            tHeadlinesSubcomponent = it
        }

    val articleSubcomponent: ArticleSubcomponent
        get() = tHeadlinesSubcomponent!!.articleSubcomponent()


    override fun onCreate() {
        super.onCreate()
        instance = this
        Timber.plant(Timber.DebugTree())

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }


}