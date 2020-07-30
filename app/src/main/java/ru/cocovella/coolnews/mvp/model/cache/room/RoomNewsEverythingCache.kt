package ru.cocovella.coolnews.mvp.model.cache.room

import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.cocovella.coolnews.mvp.model.cache.INewsEverythingCache
import ru.cocovella.coolnews.mvp.model.entity.Headlines
import ru.cocovella.coolnews.mvp.model.entity.room.RoomEverything
import ru.cocovella.coolnews.mvp.model.entity.room.db.Database

class RoomNewsEverythingCache(val database: Database) : INewsEverythingCache {

    override fun get(sourceId: String): @NonNull Single<Headlines> = Single.fromCallable {
        database.everythingDao.findEverything(sourceId)?.run {
            Headlines(sourceId, status, totalResult, articlesList) }
            ?: run {
                throw RuntimeException("No such headline in cache")
            }
    }.subscribeOn(Schedulers.io())


    override fun put(headlines: Headlines): @NonNull Completable = Completable.fromAction {
                database.everythingDao.insert(
                    (database.everythingDao.findEverything(headlines.sourceId))?.apply {
                        articlesList = headlines.articles
                    } ?: RoomEverything(headlines.sourceId, headlines.status, headlines.totalResult, headlines.articles)
                )
    }.subscribeOn(Schedulers.io())

}
