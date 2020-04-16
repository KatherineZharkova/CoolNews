package ru.cocovella.coolnews.navigation

import ru.cocovella.coolnews.mvp.model.entity.Article
import ru.cocovella.coolnews.mvp.model.entity.GithubRepository
import ru.cocovella.coolnews.ui.fragment.ArticleFragment
import ru.cocovella.coolnews.ui.fragment.HeadlinesFragment
import ru.cocovella.coolnews.ui.fragment.RepositoriesFragment
import ru.cocovella.coolnews.ui.fragment.RepositoryFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class RepositoriesScreen() : SupportAppScreen() {
        override fun getFragment() = RepositoriesFragment.newInstance()
    }

    class RepositoryScreen(val repository: GithubRepository) : SupportAppScreen() {
        override fun getFragment() = RepositoryFragment.newInstance(repository)
    }

    class ArticleScreen(val article: Article) : SupportAppScreen() {
        override fun getFragment()= ArticleFragment.newInstance(article)
    }

    class HeadlinesScreen() : SupportAppScreen() {
        override fun getFragment() = HeadlinesFragment.newInstance()
    }


}