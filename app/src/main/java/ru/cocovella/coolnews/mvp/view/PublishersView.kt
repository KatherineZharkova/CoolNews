package ru.cocovella.coolnews.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.cocovella.coolnews.mvp.model.entity.Sources

@StateStrategyType(AddToEndSingleStrategy::class)
interface PublishersView : MvpView {
    fun init()
    fun showStatus(status: String)
    fun updateList()
}
