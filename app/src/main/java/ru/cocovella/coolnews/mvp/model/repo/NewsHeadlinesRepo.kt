package ru.cocovella.coolnews.mvp.model.repo

import io.reactivex.rxjava3.schedulers.Schedulers
import ru.cocovella.coolnews.mvp.model.api.IDataSource
import ru.cocovella.coolnews.mvp.model.cache.INewsHeadlinesCache
import ru.cocovella.coolnews.mvp.model.entity.Headlines
import ru.cocovella.coolnews.mvp.model.network.NetworkStatus
import timber.log.Timber

class NewsHeadlinesRepo(
    val api: IDataSource,
    private val networkStatus: NetworkStatus,
    val cache: INewsHeadlinesCache
) {

    fun getNewsHeadlines(sourceId: String)  =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                api.getNewsHeadlines(sourceId).flatMap {
                    val headline = Headlines(it.articles[0].source.id, it.status, it.articles)
                    Timber.e("api.getNewsHeadlines(${sourceId}) => STATUS: ${it.status}; Articles count: ${it.articles.size}")

                    cache.putNewsHeadlines(headline).toSingleDefault(headline)
                }
            } else {
                cache.getNewsHeadlines(sourceId)
            }
        }.subscribeOn(Schedulers.io())

}
