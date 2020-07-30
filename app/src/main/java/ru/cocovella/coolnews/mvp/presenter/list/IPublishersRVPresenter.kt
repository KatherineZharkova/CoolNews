package ru.cocovella.coolnews.mvp.presenter.list

import ru.cocovella.coolnews.mvp.view.list.PublishersItemView

interface IPublishersRVPresenter {
    var itemClickListener: ((PublishersItemView) -> Unit)?
    fun getCount(): Int
    fun bindView(view: PublishersItemView)
}