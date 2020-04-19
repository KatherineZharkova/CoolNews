package ru.cocovella.coolnews.mvp.presenter

import io.reactivex.rxjava3.core.Scheduler
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.cocovella.coolnews.mvp.model.entity.Article
import ru.cocovella.coolnews.mvp.model.entity.Headlines
import ru.cocovella.coolnews.mvp.model.repo.NewsHeadlinesRepo
import ru.cocovella.coolnews.mvp.presenter.list.IHeadlinesRVPresenter
import ru.cocovella.coolnews.mvp.view.HeadlinesView
import ru.cocovella.coolnews.mvp.view.list.HeadlinesItemView
import ru.cocovella.coolnews.navigation.Screens
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class HeadlinesPresenter(private val mainThreadScheduler: Scheduler, private val headlines: Headlines) :
    MvpPresenter<HeadlinesView>() {

    class HeadlinesRVPresenter : IHeadlinesRVPresenter {
        val list = mutableListOf<Article>()
        override var itemClickListener: ((HeadlinesItemView) -> Unit)? = null

        override fun getCount() = list.size

        override fun bindView(view: HeadlinesItemView) {
            val article = list[view.pos]
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

    @Inject lateinit var headlinesRepo: NewsHeadlinesRepo
    @Inject lateinit var router: Router

    val presenter = HeadlinesRVPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()

        viewState.setHeader(headlines.sourceId)

        loadData()

        presenter.itemClickListener = {
            val article = presenter.list[it.pos]
            router.navigateTo(Screens.ArticleScreen(article))
        }
    }

    private fun loadData() {
        headlinesRepo.getNewsHeadlines(headlines.sourceId)
            .observeOn(mainThreadScheduler)
            .subscribe({
                presenter.list.clear()
                presenter.list.addAll(it.articles)
                viewState.setHeader("Top Headlines  • " +  it.articles[0].source.name)
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