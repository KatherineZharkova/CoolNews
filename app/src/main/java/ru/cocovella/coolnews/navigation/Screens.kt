package ru.cocovella.coolnews.navigation

import ru.cocovella.coolnews.mvp.model.entity.GithubRepository
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

}