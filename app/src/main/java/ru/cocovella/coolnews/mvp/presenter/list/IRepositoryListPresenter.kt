package ru.cocovella.coolnews.mvp.presenter.list

import ru.cocovella.coolnews.mvp.view.list.RepositoryItemView

interface IRepositoryListPresenter {
    var itemClickListener: ((RepositoryItemView) -> Unit)?
    fun getCount(): Int
    fun bindView(view: RepositoryItemView)
}