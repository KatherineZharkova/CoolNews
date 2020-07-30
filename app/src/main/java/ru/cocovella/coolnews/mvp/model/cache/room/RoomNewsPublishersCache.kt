package ru.cocovella.coolnews.mvp.model.cache.room

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.cocovella.coolnews.mvp.model.cache.INewsPublishersCache
import ru.cocovella.coolnews.mvp.model.entity.Publishers
import ru.cocovella.coolnews.mvp.model.entity.room.RoomPublishers
import ru.cocovella.coolnews.mvp.model.entity.room.db.Database

class RoomNewsPublishersCache(val database: Database) : INewsPublishersCache {

    override fun get(): Single<Publishers> = Single.fromCallable {
        return@fromCallable database.publishersDao.getAll().run {
                Publishers(status, sources)
        }
    }.subscribeOn(Schedulers.io())

    override fun put(publishers: Publishers): Completable = Completable.fromAction {
        database.publishersDao.insert(RoomPublishers(publishers.status, publishers.sources))
    }.subscribeOn(Schedulers.io())

}