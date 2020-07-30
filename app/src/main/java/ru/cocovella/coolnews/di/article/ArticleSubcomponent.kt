package ru.cocovella.coolnews.di.article

import dagger.Subcomponent
import ru.cocovella.coolnews.di.article.everything.EverythingArticlesSubcomponent
import ru.cocovella.coolnews.di.article.top.TopArticlesSubcomponent
import ru.cocovella.coolnews.mvp.presenter.ArticlePresenter
import ru.cocovella.coolnews.mvp.presenter.HeadlinesPresenter
import ru.cocovella.coolnews.ui.fragment.ArticleFragment
import ru.cocovella.coolnews.ui.fragment.HeadlinesFragment

@ArticleScope
@Subcomponent(modules = [ArticleModule::class])
interface ArticleSubcomponent {
    fun topArticleSubcomponent(): TopArticlesSubcomponent
    fun everythingArticleSubcomponent(): EverythingArticlesSubcomponent

    fun inject(headlinesPresenter: HeadlinesPresenter)
    fun inject(headlinesFragment: HeadlinesFragment)
    fun inject(articlePresenter: ArticlePresenter)
    fun inject(articleFragment: ArticleFragment)
}