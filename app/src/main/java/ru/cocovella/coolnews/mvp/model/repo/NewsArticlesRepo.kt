package ru.cocovella.coolnews.mvp.model.repo

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.cocovella.coolnews.mvp.model.entity.Article
import ru.cocovella.coolnews.mvp.model.entity.GithubRepository
import ru.cocovella.coolnews.mvp.model.entity.Source

class NewsArticlesRepo {

    val articles = listOf(
        Article(Source("abc-news", "BBC News"), "BBC News", "Title 1", "", "",
            "https://ichef.bbci.co.uk/images/ic/1024x576/p089hx0q.jpg", "2020-04-15T12:30:32Z", ""),
        Article(Source("bbc-news", "BBC News"), "BBC News", "Title 2", "", "",
            "https://ichef.bbci.co.uk/images/ic/1024x576/p089hx0q.jpg", "2020-04-15T12:30:32Z", ""),
        Article(Source("cbc-news", "BBC News"), "BBC News", "Title 3", "", "",
            "https://ichef.bbci.co.uk/images/ic/1024x576/p089hx0q.jpg", "2020-04-15T12:30:32Z", ""),
        Article(Source("dbc-news", "BBC News"), "BBC News", "Title 4", "", "",
            "https://ichef.bbci.co.uk/images/ic/1024x576/p089hx0q.jpg", "2020-04-15T12:30:32Z", "")
    )

    fun getArticles() = Single.fromCallable {
        articles
    }.subscribeOn(Schedulers.io())
}