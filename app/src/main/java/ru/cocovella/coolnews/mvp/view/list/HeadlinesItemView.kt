package ru.cocovella.coolnews.mvp.view.list

interface HeadlinesItemView {
    var pos: Int
    fun setImage(urlToImage: String)
    fun setAuthor(text: String)
    fun setPublishedAtDate(text: String)
    fun setArticleTitle(text: String)
    fun setDescription(text: String)
    fun setPublishedAgoTime(text: String)
    fun setSource(text: String)
}
