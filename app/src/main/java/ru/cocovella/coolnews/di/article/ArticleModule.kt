package ru.cocovella.coolnews.di.article

import dagger.Module
import dagger.Provides
import ru.cocovella.coolnews.di.article.everything.EverythingArticlesScope
import ru.cocovella.coolnews.di.article.top.TopArticlesScope
import ru.cocovella.coolnews.mvp.model.api.IDataSource
import ru.cocovella.coolnews.mvp.model.cache.INewsEverythingCache
import ru.cocovella.coolnews.mvp.model.cache.INewsHeadlinesCache
import ru.cocovella.coolnews.mvp.model.cache.room.RoomNewsEverythingCache
import ru.cocovella.coolnews.mvp.model.cache.room.RoomNewsHeadlinesCache
import ru.cocovella.coolnews.mvp.model.entity.room.db.Database
import ru.cocovella.coolnews.mvp.model.network.NetworkStatus
import ru.cocovella.coolnews.mvp.model.repo.NewsHeadlinesRepo

@Module
open class ArticleModule {

    @Provides
    fun headlinesRepo(api: IDataSource, networkStatus: NetworkStatus,
                      headlinesCache: INewsHeadlinesCache, everythingCache: INewsEverythingCache
    ) : NewsHeadlinesRepo = NewsHeadlinesRepo(api, networkStatus, headlinesCache, everythingCache)


//    @EverythingArticlesScope
    @Provides
    fun everythingCache(database: Database): INewsEverythingCache {
        return RoomNewsEverythingCache(database)
    }

//    @TopArticlesScope
    @Provides
    fun headlinesCache(database: Database): INewsHeadlinesCache {
        return RoomNewsHeadlinesCache(database)
    }


}