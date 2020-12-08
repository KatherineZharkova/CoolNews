package ru.cocovella.coolnews.mvp.model.cache.room

import android.content.res.Resources
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.cocovella.coolnews.R
import ru.cocovella.coolnews.mvp.model.cache.INewsHeadlinesCache
import ru.cocovella.coolnews.mvp.model.entity.Headlines
import ru.cocovella.coolnews.mvp.model.entity.room.RoomHeadlines
import ru.cocovella.coolnews.mvp.model.entity.room.db.Database

class RoomNewsHeadlinesCache(val database: Database) : INewsHeadlinesCache {

    override fun get(sourceId: String): @NonNull Single<Headlines> = Single.fromCallable {
        database.headlinesDao.findHeadlines(sourceId)?.run {
            Headlines(sourceId, status, totalResult, articlesList) }
            ?: run {
                throw RuntimeException(Resources.getSystem().getString(R.string.error_empty_headlines_cache))
            }
    }.subscribeOn(Schedulers.io())


    override fun put(headlines: Headlines): @NonNull Completable = Completable.fromAction {
                database.headlinesDao.insert(
                    (database.headlinesDao.findHeadlines(headlines.sourceId))?.apply {
                        articlesList = headlines.articles
                    } ?: RoomHeadlines(headlines.sourceId, headlines.status, headlines.totalResult, headlines.articles)
                )
    }.subscribeOn(Schedulers.io())

}
