package ru.cocovella.coolnews.mvp.model.image


interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}