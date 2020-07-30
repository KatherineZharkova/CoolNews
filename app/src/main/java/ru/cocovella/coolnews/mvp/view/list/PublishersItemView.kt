package ru.cocovella.coolnews.mvp.view.list

interface PublishersItemView {
    var pos: Int
    fun setTitle(text: String)
    fun setUrl(text: String)
    fun setDescription(text: String)
}