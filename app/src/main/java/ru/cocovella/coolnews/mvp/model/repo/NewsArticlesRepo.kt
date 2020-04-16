package ru.cocovella.coolnews.mvp.model.repo

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.cocovella.coolnews.mvp.model.entity.Article
import ru.cocovella.coolnews.mvp.model.entity.Source

class NewsArticlesRepo {

    val articles = listOf(
        Article(Source("rbc", "RBC"), "RBC News", "Трамп заявил о готовности помочь России с аппаратами ИВЛ из-за вируса",
            "В начале апреля Москва оказала помощь Вашингтону. " +
                    "Она доставила в Нью-Йорк медицинское оборудование, однако поставка была не безвозмездной. " +
                    "По данным МИД России, половину оплатил Российский фонд прямых инвестиций, а другую — США",
            "https://www.rbc.ru/rbcfreenews/5e978f249a79478dba9b8258?from=from_main",
            "https://s0.rbk.ru/v6_top_pics/media/img/8/38/755869915432388.jpg", "2020-04-15T12:30:32Z", ""),
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