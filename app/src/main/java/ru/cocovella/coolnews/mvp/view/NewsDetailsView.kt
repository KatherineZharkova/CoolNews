package ru.cocovella.coolnews.mvp.view

interface NewsDetailsView {
    fun init()
    fun setSource(sourceName:String)
    fun setAuthor(author:String)
    fun setTitle(title:String)
    fun setDescription(description:String)
    fun setWebView(url:String)
    fun setImage(urlToImage:String)
    fun setPublishedAt(publishedAt:String)
    fun setContent(content:String)
}
