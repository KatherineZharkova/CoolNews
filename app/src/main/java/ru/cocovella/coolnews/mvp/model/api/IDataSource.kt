package ru.cocovella.coolnews.mvp.model.api

import android.content.res.Resources
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.cocovella.coolnews.R
import ru.cocovella.coolnews.mvp.model.entity.Headlines
import ru.cocovella.coolnews.mvp.model.entity.Publishers
import ru.cocovella.coolnews.ui.App

interface IDataSource {
    companion object{
        private val resources: Resources = App.instance.resources
        private val KEY = resources.getString(R.string.api_key)
        private val LOCALIZATION = resources.getString(R.string.language)
        private val ARTICLES_ON_PAGE = resources.getInteger(R.integer.page_size)

        const val SOURCES = "sources"
        const val EVERYTHING = "everything"
        const val TOP_HEADLINES = "top-headlines"
        const val API_KEY = "apiKey"
        const val LANGUAGE = "language"
        const val PAGE_SIZE = "pageSize"
    }

    @GET(TOP_HEADLINES)
    fun getNewsHeadlines(
        @Query(SOURCES) sourceId: String,
        @Query(API_KEY) apiKey: String = KEY
    ): Single<Headlines>

    @GET(EVERYTHING)
    fun getNewsEverything(
        @Query(SOURCES) sourceId: String,
        @Query(PAGE_SIZE) pageSize: Int = ARTICLES_ON_PAGE,
        @Query(LANGUAGE) language: String = LOCALIZATION,
        @Query(API_KEY) apiKey: String = KEY
    ): Single<Headlines>

    @GET(SOURCES)
    fun getNewsPublishers(
        @Query(LANGUAGE) language: String = LOCALIZATION,
        @Query(API_KEY) apiKey: String = KEY
    ): Single<Publishers>

}
