package ru.cocovella.coolnews.ui.fragment

import moxy.MvpAppCompatFragment
import ru.cocovella.coolnews.mvp.view.NewsDetailsView
import ru.cocovella.coolnews.ui.BackButtonListener

class NewsDetailsFragment : MvpAppCompatFragment(), NewsDetailsView, BackButtonListener {



    override fun backClicked(): Boolean {
        TODO("Not yet implemented")
    }

}