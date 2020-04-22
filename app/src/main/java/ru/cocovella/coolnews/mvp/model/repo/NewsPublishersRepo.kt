package ru.cocovella.coolnews.mvp.model.repo

import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.cocovella.coolnews.mvp.model.api.IDataSource
import ru.cocovella.coolnews.mvp.model.cache.INewsPublishersCache
import ru.cocovella.coolnews.mvp.model.entity.Publishers
import ru.cocovella.coolnews.mvp.model.network.NetworkStatus

class NewsPublishersRepo(
    val api: IDataSource,
    private val networkStatus: NetworkStatus,
    val cache: INewsPublishersCache
) {

    fun getNewsPublishers(): @NonNull Single<Publishers> =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                api.getNewsPublishers().flatMap {
                    cache.put(it).toSingleDefault(it)
                }
            } else {
                cache.get()
            }
        }.subscribeOn(Schedulers.io())

}
