package ru.cocovella.coolnews.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import ru.cocovella.coolnews.R
import ru.cocovella.coolnews.mvp.view.NewsDetailsView
import ru.cocovella.coolnews.ui.BackButtonListener

class NewsDetailsFragment : MvpAppCompatFragment(), NewsDetailsView, BackButtonListener {

    companion object {
        const val REPOSITORY_KEY = "repository"

        fun newInstance() = RepositoryFragment().apply {
            arguments = Bundle().apply {
//                putParcelable(REPOSITORY_KEY, repository)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        View.inflate(context, R.layout.fragment_news_details, null)


    override fun backClicked(): Boolean {
        TODO("Not yet implemented")
    }

    override fun init() {
        TODO("Not yet implemented")
    }

}