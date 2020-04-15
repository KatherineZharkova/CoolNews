package ru.cocovella.coolnews.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_news_details.*
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



    override fun init() {    }

    override fun setSource(sourceName: String) {
        title_on_appbar.text = sourceName
    }

    override fun setAuthor(author: String) {
        TODO("Not yet implemented")
    }

    override fun setTitle(title: String) {
        TODO("Not yet implemented")
    }

    override fun setDescription(description: String) {
        TODO("Not yet implemented")
    }

    override fun setWebView(url: String) {
        subtitle_on_appbar.text = url
    }

    override fun setImage(urlToImage: String) {
        TODO("Not yet implemented")
    }

    override fun setPublishedAt(publishedAt: String) {
        TODO("Not yet implemented")
    }

    override fun setContent(content: String) {
        TODO("Not yet implemented")
    }

    override fun backClicked(): Boolean {
        TODO("Not yet implemented")
    }

}