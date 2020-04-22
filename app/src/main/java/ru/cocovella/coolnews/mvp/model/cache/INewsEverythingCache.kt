package ru.cocovella.coolnews.mvp.model.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.cocovella.coolnews.mvp.model.entity.Headlines

interface INewsEverythingCache {
    fun get(sourceId: String): Single<Headlines>
    fun put(headlines: Headlines): Completable
}
