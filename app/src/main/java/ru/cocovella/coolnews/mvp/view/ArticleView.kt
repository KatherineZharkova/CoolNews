package ru.cocovella.coolnews.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ArticleView : MvpView {
    fun init()
    fun setAppbarTitle(text:String)
    fun setAppbarSubtitle(text: String)
    fun setImage(urlToImage:String?)
    fun setPublishedAt(text:String)
    fun setArticleTitle(text:String)
    fun setSourceAuthorTime(text: String)
    fun setWebView(url:String)
}
