package ru.cocovella.coolnews.navigation

import ru.cocovella.coolnews.mvp.model.entity.Article
import ru.cocovella.coolnews.ui.fragment.ArticleFragment
import ru.cocovella.coolnews.ui.fragment.HeadlinesFragment
import ru.cocovella.coolnews.ui.fragment.PublishersFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class PublishersScreen : SupportAppScreen() {
        override fun getFragment() = PublishersFragment.newInstance()
    }

    class HeadlinesScreen(private val sourcesId: String) : SupportAppScreen() {
        override fun getFragment() = HeadlinesFragment.newInstance(sourcesId)
    }

    class ArticleScreen(private val article: Article) : SupportAppScreen() {
        override fun getFragment() = ArticleFragment.newInstance(article)
    }

}