package ru.cocovella.coolnews.di.article

import dagger.Subcomponent
import ru.cocovella.coolnews.di.article.module.ArticleModule
import ru.cocovella.coolnews.mvp.presenter.ArticlePresenter
import ru.cocovella.coolnews.mvp.presenter.HeadlinesPresenter
import ru.cocovella.coolnews.ui.adapter.HeadlinesRVAdapter
import ru.cocovella.coolnews.ui.fragment.ArticleFragment
import ru.cocovella.coolnews.ui.fragment.HeadlinesFragment


@ArticleScope
@Subcomponent(
    modules = [
        ArticleModule::class
    ]
)
interface ArticleSubcomponent {

    fun inject(headlinesPresenter: HeadlinesPresenter)
    fun inject(headlinesFragment: HeadlinesFragment)
    fun inject(articlePresenter: ArticlePresenter)

    fun inject(articleFragment: ArticleFragment)
    fun inject(headlinesRVAdapter: HeadlinesRVAdapter)
}