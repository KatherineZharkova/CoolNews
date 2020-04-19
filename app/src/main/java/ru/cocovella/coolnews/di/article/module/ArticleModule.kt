package ru.cocovella.coolnews.di.article.module

import dagger.Module
import dagger.Provides
import ru.cocovella.coolnews.di.article.ArticleScope
import ru.cocovella.coolnews.mvp.model.api.IDataSource
import ru.cocovella.coolnews.mvp.model.cache.INewsHeadlinesCache
import ru.cocovella.coolnews.mvp.model.cache.room.RoomNewsHeadlinesCache
import ru.cocovella.coolnews.mvp.model.entity.room.db.Database
import ru.cocovella.coolnews.mvp.model.network.NetworkStatus
import ru.cocovella.coolnews.mvp.model.repo.NewsHeadlinesRepo

@Module
open class ArticleModule {

    @Provides
    fun headlinesRepo(api: IDataSource, networkStatus: NetworkStatus,
                      cache: INewsHeadlinesCache
    ): NewsHeadlinesRepo {
        return NewsHeadlinesRepo(api, networkStatus, cache)
    }

    @ArticleScope
    @Provides
    fun headlinesCache(database: Database): INewsHeadlinesCache {
        return RoomNewsHeadlinesCache(database)
    }
}