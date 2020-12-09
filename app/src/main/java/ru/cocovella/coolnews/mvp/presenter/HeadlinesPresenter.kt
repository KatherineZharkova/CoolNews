package ru.cocovella.coolnews.mvp.presenter

import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.MvpView
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class HeadlinesPresenter : MvpPresenter<MvpView>() {

    @Inject
    lateinit var router: Router

    fun backClicked(): Boolean {
        router.exit()
        return true
    }

}
