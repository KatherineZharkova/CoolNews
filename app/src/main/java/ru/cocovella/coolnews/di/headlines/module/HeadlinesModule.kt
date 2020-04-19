package ru.cocovella.coolnews.di.headlines.module

import dagger.Module
import dagger.Provides
import ru.cocovella.coolnews.di.headlines.HeadlinesScope
import ru.cocovella.coolnews.mvp.model.api.IDataSource
import ru.cocovella.coolnews.mvp.model.cache.INewsPublishersCache
import ru.cocovella.coolnews.mvp.model.cache.room.RoomNewsPublishersCache
import ru.cocovella.coolnews.mvp.model.entity.room.db.Database
import ru.cocovella.coolnews.mvp.model.network.NetworkStatus
import ru.cocovella.coolnews.mvp.model.repo.NewsPublishersRepo

@Module
open class HeadlinesModule {

    @HeadlinesScope
    @Provides
    open fun publishersRepo(api: IDataSource, networkStatus: NetworkStatus,
                            cache: INewsPublishersCache): NewsPublishersRepo {
        return NewsPublishersRepo(api, networkStatus, cache)
    }

    @HeadlinesScope
    @Provides
    fun publishersCache(database: Database): INewsPublishersCache {
        return RoomNewsPublishersCache(database)
    }

}
