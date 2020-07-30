package ru.cocovella.coolnews.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndStrategy::class)
interface HeadlinesEverythingView : MvpView {
    fun init()
    fun setHeader(text: String)
    fun updateList()
}
