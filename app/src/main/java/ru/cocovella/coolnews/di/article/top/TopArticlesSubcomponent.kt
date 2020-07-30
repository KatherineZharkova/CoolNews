package ru.cocovella.coolnews.di.article.top

import dagger.Subcomponent
import ru.cocovella.coolnews.mvp.presenter.HeadlinesTopPresenter
import ru.cocovella.coolnews.ui.adapter.TopRVAdapter
import ru.cocovella.coolnews.ui.fragment.HeadlinesTopFragment

@TopArticlesScope
@Subcomponent(modules = [TopArticlesModule::class])
interface TopArticlesSubcomponent {
    fun inject(topRVAdapter: TopRVAdapter)
    fun inject(headlinesTopPresenter: HeadlinesTopPresenter)
    fun inject(headlinesTopFragment: HeadlinesTopFragment)
}