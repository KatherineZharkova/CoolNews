package ru.cocovella.coolnews.mvp.model.network

import io.reactivex.rxjava3.core.Single

interface NetworkStatus {
    fun isOnlineSingle(): Single<Boolean>
}