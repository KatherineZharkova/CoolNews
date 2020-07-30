package ru.cocovella.coolnews.di.article.everything

import dagger.Module
import dagger.Provides
import ru.cocovella.coolnews.di.article.ArticleScope
import ru.cocovella.coolnews.mvp.model.api.IDataSource
import ru.cocovella.coolnews.mvp.model.cache.INewsEverythingCache
import ru.cocovella.coolnews.mvp.model.cache.INewsHeadlinesCache
import ru.cocovella.coolnews.mvp.model.cache.room.RoomNewsEverythingCache
import ru.cocovella.coolnews.mvp.model.entity.room.db.Database
import ru.cocovella.coolnews.mvp.model.network.NetworkStatus
import ru.cocovella.coolnews.mvp.model.repo.NewsHeadlinesRepo

@Module
open class EverythingArticlesModule {

    @EverythingArticlesScope
    @Provides
    fun everythingCache(database: Database): INewsEverythingCache {
        return RoomNewsEverythingCache(database)
    }

}