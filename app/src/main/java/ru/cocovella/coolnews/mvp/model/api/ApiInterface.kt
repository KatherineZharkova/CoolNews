package ru.cocovella.coolnews.mvp.model.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.cocovella.coolnews.mvp.model.entity.Headlines
import ru.cocovella.coolnews.mvp.model.entity.NewsPublishers


interface ApiInterface {

    @GET("/top-headlines")
    fun getHeadlines(
        @Query("sources") sourceId: String? = "rbc,tr,lenta,google-news-ru",
        @Query("apiKey") apiKey: String? = "520802e1bb5b4ac1b94aa5927bcf1b00"
    ): Single<List<Headlines>>

    @GET("/sources")
    fun getPublishers(
        @Query("language") language: String? = "ru",
        @Query("apiKey") apiKey: String? = "520802e1bb5b4ac1b94aa5927bcf1b00"
    ): Single<List<NewsPublishers>>
}