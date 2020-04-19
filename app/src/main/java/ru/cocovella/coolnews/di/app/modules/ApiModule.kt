package ru.cocovella.coolnews.di.app.modules

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.cocovella.coolnews.mvp.model.api.IDataSource
import ru.cocovella.coolnews.mvp.model.network.NetworkStatus
import ru.cocovella.coolnews.ui.App
import ru.cocovella.coolnews.ui.network.AndroidNetworkStatus
import javax.inject.Named
import javax.inject.Singleton

@Module
class  ApiModule {

    @Named("baseUrl")
    @Provides
    fun baseUrl(): String {
        return "https://newsapi.org/v2/"
    }

    @Singleton
    @Provides
    fun api(@Named("baseUrl") baseUrl: String, gson: Gson): IDataSource {
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
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun networkStatus(app: App): NetworkStatus {
        return AndroidNetworkStatus(app)
    }

}