package ru.cocovella.coolnews.mvp.presenter

import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.cocovella.coolnews.mvp.model.entity.Article
import ru.cocovella.coolnews.mvp.model.repo.NewsArticlesRepo
import ru.cocovella.coolnews.mvp.model.repo.NewsHeadlinesRepo
import ru.cocovella.coolnews.mvp.presenter.list.IHeadlinesListPresenter
import ru.cocovella.coolnews.mvp.view.HeadlinesView
import ru.cocovella.coolnews.mvp.view.list.HeadlinesItemView
import ru.cocovella.coolnews.navigation.Screens
import ru.terrakok.cicerone.Router
import timber.log.Timber

class HeadlinesPresenter (
    val mainThreadScheduler: Scheduler,
    val router: Router,
    val articlesRepo: NewsArticlesRepo,
    val headlinesRepo: NewsHeadlinesRepo
) :
    MvpPresenter<HeadlinesView>() {

    class HeadlinesListPresenter : IHeadlinesListPresenter {
        val articles = mutableListOf<Article>()
        override var itemClickListener: ((HeadlinesItemView) -> Unit)? = null

        override fun getCount() = articles.size

        override fun bindView(view: HeadlinesItemView) {
            val article = articles[view.pos]
            with(view) {
                setImage(article.urlToImage)
                setAuthor(article.author)
                setArticleTitle(article.title)
                setDescription(article.description)
                setSource(article.source.name)
                setPublishedAtDate(DateFormatter().formatDate(article.publishedAt) ?: "")
                setPublishedAgoTime(DateFormatter().formatDateToTime(article.publishedAt) + " • ")
            }
        }
    }

    val headlinesListPresenter = HeadlinesListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadHeadlines()
        loadArticles()
        headlinesListPresenter.itemClickListener = { itemView ->
            val article = headlinesListPresenter.articles[itemView.pos]
            router.navigateTo(Screens.ArticleScreen(article))
        }
    }

    fun loadHeadlines() {
        headlinesRepo.getHeadlines("rt")
            .observeOn(mainThreadScheduler)
            .subscribe({headlines ->
                viewState.setHeader(
                   "Top Headlines  • " +  headlines[0].articles[0].source.name + " • " + headlines[0].totalResult)
            }, {
                Timber.e(it)
            })
    }

    fun loadArticles() {
        articlesRepo.getArticles()
            .observeOn(mainThreadScheduler)
            .subscribe({ repos ->
                headlinesListPresenter.articles.clear()
                headlinesListPresenter.articles.addAll(repos)
                viewState.updateList()
            }, {
                Timber.e(it)
            })
    }



    fun backClicked(): Boolean {
        router.exit()
        return true
    }

}
