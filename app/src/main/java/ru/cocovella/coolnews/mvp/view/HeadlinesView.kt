package ru.cocovella.coolnews.mvp.view

import ru.cocovella.coolnews.mvp.model.entity.Article

interface HeadlinesView {
    fun init()
    fun showStatus(status:String)
    fun setTotalResult(totalResult:String)
    fun setArticlesRV(articles:List<Article>)
}
