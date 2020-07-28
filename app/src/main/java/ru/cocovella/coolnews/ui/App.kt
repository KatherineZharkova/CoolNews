package ru.cocovella.coolnews.ui

import android.app.Application
import ru.cocovella.coolnews.di.app.AppComponent
import ru.cocovella.coolnews.di.app.DaggerAppComponent
import ru.cocovella.coolnews.di.app.modules.AppModule
import ru.cocovella.coolnews.di.headlines.HeadlinesSubcomponent
import ru.cocovella.coolnews.di.article.ArticleSubcomponent
import ru.cocovella.coolnews.di.article.everything.EverythingArticlesSubcomponent
import ru.cocovella.coolnews.di.article.top.TopArticlesSubcomponent
import timber.log.Timber

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent
        private set

    private var tHeadlinesSubcomponent: HeadlinesSubcomponent? = null

    private var tArticleSubcomponent: ArticleSubcomponent? = null


    val headlinesSubcomponent: HeadlinesSubcomponent
        get() = appComponent.headlinesSubcomponent().also {
            tHeadlinesSubcomponent = it
        }

    val articleSubcomponent: ArticleSubcomponent
        get() = tHeadlinesSubcomponent!!.articleSubcomponent().also {
            tArticleSubcomponent = it
        }

    val topArticlesSubcomponent: TopArticlesSubcomponent
        get() = tArticleSubcomponent!!.topArticleSubcomponent()

    val everythingArticlesSubcomponent: EverythingArticlesSubcomponent
        get() = tArticleSubcomponent!!.everythingArticleSubcomponent()


    override fun onCreate() {
        super.onCreate()
        instance = this
        Timber.plant(Timber.DebugTree())

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }


}