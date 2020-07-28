package ru.cocovella.coolnews.mvp.model.repo

import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.cocovella.coolnews.mvp.model.api.IDataSource
import ru.cocovella.coolnews.mvp.model.cache.INewsEverythingCache
import ru.cocovella.coolnews.mvp.model.cache.INewsHeadlinesCache
import ru.cocovella.coolnews.mvp.model.entity.Headlines
import ru.cocovella.coolnews.mvp.model.network.NetworkStatus
import timber.log.Timber

class NewsHeadlinesRepo(
    val api: IDataSource,
    private val networkStatus: NetworkStatus,
    private val topHeadlinesCache: INewsHeadlinesCache,
    private val everythingCache: INewsEverythingCache
) {

    fun getNewsHeadlines(sourceId: String): @NonNull Single<Headlines> =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                api.getNewsHeadlines(sourceId).flatMap {
                    val headline = Headlines(sourceId, it.status, it.totalResult, it.articles)
                    Timber.e("Published at = ${headline.articles[1].publishedAt}")
                    Timber.e("URL to Image = ${headline.articles[1].urlToImage}")
                    topHeadlinesCache.put(headline).toSingleDefault(headline)
                }
            } else {
                topHeadlinesCache.get(sourceId)
            }
        }.subscribeOn(Schedulers.io())

    fun getNewsEverything(sourceId: String): @NonNull Single<Headlines> =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                api.getNewsEverything(sourceId).flatMap {
                    val headline = Headlines(sourceId, it.status, it.totalResult, it.articles)
                    everythingCache.put(headline).toSingleDefault(headline)
                }
            } else {
                everythingCache.get(sourceId)
            }
        }.subscribeOn(Schedulers.io())

}
