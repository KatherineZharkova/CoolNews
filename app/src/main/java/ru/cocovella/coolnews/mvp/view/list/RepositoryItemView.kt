package ru.cocovella.coolnews.mvp.view.list

interface RepositoryItemView {
    var pos: Int
    fun setTitle(text: String)
}