package ru.cocovella.coolnews.mvp.presenter

import moxy.InjectViewState
import moxy.MvpPresenter
import ru.cocovella.coolnews.mvp.view.HeadlinesView
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class HeadlinesPresenter : MvpPresenter<HeadlinesView>() {

    @Inject
    lateinit var router: Router

    fun backClicked(): Boolean {
        router.exit()
        return true
    }

}
