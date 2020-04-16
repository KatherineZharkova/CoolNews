package ru.cocovella.coolnews.navigation

import ru.cocovella.coolnews.mvp.model.entity.Article
import ru.cocovella.coolnews.ui.fragment.ArticleFragment
import ru.cocovella.coolnews.ui.fragment.HeadlinesFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {


    class ArticleScreen(val article: Article) : SupportAppScreen() {
        override fun getFragment()= ArticleFragment.newInstance(article)
    }

    class HeadlinesScreen() : SupportAppScreen() {
        override fun getFragment() = HeadlinesFragment.newInstance()
    }


}