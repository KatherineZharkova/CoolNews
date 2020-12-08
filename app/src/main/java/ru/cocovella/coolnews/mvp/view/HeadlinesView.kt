package ru.cocovella.coolnews.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface HeadlinesView : MvpView {
    fun init()
    fun updateList()
}
