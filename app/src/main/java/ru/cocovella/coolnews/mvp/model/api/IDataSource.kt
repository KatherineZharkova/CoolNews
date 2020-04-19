package ru.cocovella.coolnews.mvp.model.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.cocovella.coolnews.mvp.model.entity.Headlines
import ru.cocovella.coolnews.mvp.model.entity.Publishers

interface IDataSource {
    companion object{
        const val API_KEY = "520802e1bb5b4ac1b94aa5927bcf1b00"
        const val LANGUAGE = "ru"
    }

    @GET("top-headlines")
    fun getNewsHeadlines(
        @Query("sources") sourceId: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): Single<Headlines>

    @GET("sources")
    fun getNewsPublishers(
        @Query("language") language: String = LANGUAGE,
        @Query("apiKey") apiKey: String = API_KEY
    ): Single<Publishers>

}
