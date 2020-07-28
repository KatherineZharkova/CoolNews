package ru.cocovella.coolnews.di.article.everything

import dagger.Subcomponent
import ru.cocovella.coolnews.mvp.presenter.HeadlinesEverythingPresenter
import ru.cocovella.coolnews.ui.adapter.EverythingRVAdapter
import ru.cocovella.coolnews.ui.adapter.TopRVAdapter
import ru.cocovella.coolnews.ui.fragment.HeadlinesEverythingFragment

@EverythingArticlesScope
@Subcomponent(modules = [EverythingArticlesModule::class])
interface EverythingArticlesSubcomponent {
    fun inject(topRVAdapter: EverythingRVAdapter)
    fun inject(headlinesEverythingPresenter: HeadlinesEverythingPresenter)
    fun inject(headlinesEverythingFragment: HeadlinesEverythingFragment)
}