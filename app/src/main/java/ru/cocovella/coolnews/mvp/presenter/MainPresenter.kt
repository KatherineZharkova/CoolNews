package ru.cocovella.coolnews.mvp.presenter

import moxy.InjectViewState
import moxy.MvpPresenter
import ru.cocovella.coolnews.mvp.view.MainView
import ru.cocovella.coolnews.navigation.Screens
import ru.terrakok.cicerone.Router

@InjectViewState
class MainPresenter(val router: Router) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        router.replaceScreen(Screens.HeadlinesScreen())
    }

    fun backClicked() {
        router.exit()
    }

}
