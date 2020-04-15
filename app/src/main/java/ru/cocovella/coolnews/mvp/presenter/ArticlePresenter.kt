package ru.cocovella.coolnews.mvp.presenter

import moxy.MvpPresenter
import ru.cocovella.coolnews.mvp.model.entity.Article
import ru.cocovella.coolnews.mvp.view.ArticleView
import ru.terrakok.cicerone.Router

class ArticlePresenter (val article: Article, val router: Router) : MvpPresenter<ArticleView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
//        viewState.setId(article.id)
//        viewState.setTitle(article.name)
//        viewState.setForksCount(article.forksCount.toString())
    }

    fun backClicked() : Boolean {
        router.exit()
        return true
    }
}