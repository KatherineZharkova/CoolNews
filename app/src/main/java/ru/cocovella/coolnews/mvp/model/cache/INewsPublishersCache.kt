package ru.cocovella.coolnews.mvp.model.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.cocovella.coolnews.mvp.model.entity.Publishers

interface INewsPublishersCache {
    fun getPublishers(): Single<Publishers>
    fun putPublishers(publishers: Publishers): Completable
}
