package ru.cocovella.coolnews.mvp.model.repo

import io.reactivex.rxjava3.schedulers.Schedulers
import ru.cocovella.coolnews.mvp.model.api.ApiInterface
import ru.cocovella.coolnews.mvp.model.api.IDataSource

class NewsHeadlinesRepo(val api: ApiInterface) {
    fun getHeadlines(headlineId: String) =
        api.getHeadlines(headlineId).subscribeOn(Schedulers.io())

    fun getPublishers(language: String) =
        api.getPublishers(language).subscribeOn(Schedulers.io())
}
