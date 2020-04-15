package ru.cocovella.coolnews.mvp.view

import ru.cocovella.coolnews.mvp.model.entity.Sources

interface NewsPublishersView {
    fun init()
    fun showStatus(status: String)
    fun setSources(sources: List<Sources>)
}