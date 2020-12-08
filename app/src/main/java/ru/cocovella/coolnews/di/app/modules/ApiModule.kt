package ru.cocovella.coolnews.di.app.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.cocovella.coolnews.R
import ru.cocovella.coolnews.mvp.model.api.IDataSource
import ru.cocovella.coolnews.mvp.model.network.NetworkStatus
import ru.cocovella.coolnews.ui.App
import ru.cocovella.coolnews.ui.network.AndroidNetworkStatus
import javax.inject.Named
import javax.inject.Singleton

@Module
class  ApiModule {

    companion object {
        const val BASE_URL = "baseUrl"
    }

    @Named(BASE_URL)
    @Provides
    fun baseUrl(): String {
        return App.instance.resources.getString(R.string.source_api_url)
    }

    @Singleton
    @Provides
    fun api(@Named(BASE_URL) baseUrl: String, gson: Gson): IDataSource {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(IDataSource::class.java)
    }

    @Provides
    fun gson(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun networkStatus(app: App): NetworkStatus {
        return AndroidNetworkStatus(app)
    }

}