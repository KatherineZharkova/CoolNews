package ru.cocovella.coolnews.di.headlines

import dagger.Subcomponent
import ru.cocovella.coolnews.di.article.ArticleSubcomponent
import ru.cocovella.coolnews.di.headlines.module.HeadlinesModule
import ru.cocovella.coolnews.mvp.presenter.PublishersPresenter
import ru.cocovella.coolnews.ui.adapter.PublishersRVAdapter
import ru.cocovella.coolnews.ui.fragment.PublishersFragment

@HeadlinesScope
@Subcomponent(modules = [HeadlinesModule::class])
interface HeadlinesSubcomponent {
    fun articleSubcomponent(): ArticleSubcomponent

    fun inject(publishersFragment: PublishersFragment)
    fun inject(publishersPresenter: PublishersPresenter)
    fun inject(publishersRVAdapter: PublishersRVAdapter)

}
