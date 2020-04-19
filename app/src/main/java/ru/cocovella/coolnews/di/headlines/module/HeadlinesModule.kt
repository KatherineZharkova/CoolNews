package ru.cocovella.coolnews.di.headlines.module

import dagger.Module
import dagger.Provides
import ru.cocovella.coolnews.mvp.model.api.IDataSource
import ru.cocovella.coolnews.mvp.model.cache.INewsHeadlinesCache
import ru.cocovella.coolnews.mvp.model.cache.INewsPublishersCache
import ru.cocovella.coolnews.mvp.model.cache.room.RoomNewsHeadlinesCache
import ru.cocovella.coolnews.mvp.model.cache.room.RoomNewsPublishersCache
import ru.cocovella.coolnews.mvp.model.entity.room.db.Database
import ru.cocovella.coolnews.mvp.model.network.NetworkStatus
import ru.cocovella.coolnews.mvp.model.repo.NewsHeadlinesRepo
import ru.cocovella.coolnews.mvp.model.repo.NewsPublishersRepo

@Module
open class HeadlinesModule {

//    @PublishersScope
    @Provides
    open fun publishersRepo(api: IDataSource, networkStatus: NetworkStatus,
                            cache: INewsPublishersCache): NewsPublishersRepo {
        return NewsPublishersRepo(api, networkStatus, cache)
    }

//    @PublishersScope
    @Provides
    fun publishersCache(database: Database): INewsPublishersCache {
        return RoomNewsPublishersCache(database)
    }

//    @Provides
//    fun headlinesRepo(api: IDataSource, networkStatus: NetworkStatus,
//                      cache: INewsHeadlinesCache
//    ): NewsHeadlinesRepo {
//        return NewsHeadlinesRepo(api, networkStatus, cache)
//    }
//
//    //    @HeadlinesScope
//    @Provides
//    fun headlinesCache(database: Database): INewsHeadlinesCache {
//        return RoomNewsHeadlinesCache(database)
//    }
}
