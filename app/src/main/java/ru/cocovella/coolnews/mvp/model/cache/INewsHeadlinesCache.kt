package ru.cocovella.coolnews.mvp.model.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.cocovella.coolnews.mvp.model.entity.Headlines

interface INewsHeadlinesCache {
    fun getNewsHeadlines(sourceId: String): Single<Headlines>
    fun putNewsHeadlines(headlines: Headlines): Completable
}
