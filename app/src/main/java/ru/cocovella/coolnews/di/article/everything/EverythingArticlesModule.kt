package ru.cocovella.coolnews.di.article.everything

import dagger.Module
import dagger.Provides
import ru.cocovella.coolnews.mvp.model.cache.INewsEverythingCache
import ru.cocovella.coolnews.mvp.model.cache.room.RoomNewsEverythingCache
import ru.cocovella.coolnews.mvp.model.entity.room.db.Database

@Module
open class EverythingArticlesModule {

    @EverythingArticlesScope
    @Provides
    fun everythingCache(database: Database): INewsEverythingCache {
        return RoomNewsEverythingCache(database)
    }

}