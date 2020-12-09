package ru.cocovella.coolnews.di.article.top

import dagger.Module
import dagger.Provides
import ru.cocovella.coolnews.mvp.model.cache.INewsHeadlinesCache
import ru.cocovella.coolnews.mvp.model.cache.room.RoomNewsHeadlinesCache
import ru.cocovella.coolnews.mvp.model.entity.room.db.Database

@Module
open class TopArticlesModule {

    @TopArticlesScope
    @Provides
    fun headlinesCache(database: Database): INewsHeadlinesCache {
        return RoomNewsHeadlinesCache(database)
    }

}