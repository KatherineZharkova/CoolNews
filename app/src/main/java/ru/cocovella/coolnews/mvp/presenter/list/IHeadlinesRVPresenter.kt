package ru.cocovella.coolnews.mvp.presenter.list

import ru.cocovella.coolnews.mvp.view.list.HeadlinesItemView

interface IHeadlinesRVPresenter {
    var itemClickListener: ((HeadlinesItemView) -> Unit)?
    fun getCount(): Int
    fun bindView(view: HeadlinesItemView)
}