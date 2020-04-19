package ru.cocovella.coolnews.mvp.model.repo

import io.reactivex.rxjava3.schedulers.Schedulers
import ru.cocovella.coolnews.mvp.model.api.IDataSource
import ru.cocovella.coolnews.mvp.model.cache.INewsPublishersCache
import ru.cocovella.coolnews.mvp.model.network.NetworkStatus
import timber.log.Timber

class NewsPublishersRepo(
    val api: IDataSource,
    private val networkStatus: NetworkStatus,
    val cache: INewsPublishersCache
) {

    fun getNewsPublishers() =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                api.getNewsPublishers().flatMap {
                    Timber.e(" api.getNewsPublishers() => STATUS: ${it.status}; SOURCES: ${it.sources.map { it.id + " (" + it.name + ")" }}")
                    cache.putPublishers(it).toSingleDefault(it)
                }
            } else {
                cache.getPublishers()
            }
        }.subscribeOn(Schedulers.io())

}
