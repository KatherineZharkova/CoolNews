package ru.cocovella.coolnews.ui.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.BehaviorSubject
import ru.cocovella.coolnews.mvp.model.network.NetworkStatus
import java.util.concurrent.TimeUnit

class AndroidNetworkStatus(context: Context) : NetworkStatus {

    companion object {
        const val NETWORK_CHECK_TIMEOUT_MILLIS = 500L
    }

    private val statusSubject = BehaviorSubject.create<Boolean>()

    init {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val builder = NetworkRequest.Builder()
        connectivityManager.registerNetworkCallback(builder.build(), object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                statusSubject.onNext(true)
            }

            override fun onLost(network: Network) {
                statusSubject.onNext(false)
            }

            override fun onUnavailable() {
                statusSubject.onNext(false)
            }

            override fun onLosing(network: Network, maxMsToLive: Int) {
                statusSubject.onNext(false)
            }
        })
    }

    override fun isOnline(): @NonNull BehaviorSubject<Boolean> = statusSubject

    override fun isOnlineSingle(): @NonNull Single<Boolean> = statusSubject
        .timeout(NETWORK_CHECK_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
        .onErrorReturnItem(false)
        .first(false)
}