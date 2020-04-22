package ru.cocovella.coolnews.mvp.presenter

import io.reactivex.rxjava3.core.Scheduler
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.cocovella.coolnews.mvp.model.entity.Article
import ru.cocovella.coolnews.mvp.model.repo.NewsHeadlinesRepo
import ru.cocovella.coolnews.mvp.presenter.list.IHeadlinesRVPresenter
import ru.cocovella.coolnews.mvp.view.HeadlinesView
import ru.cocovella.coolnews.mvp.view.list.HeadlinesItemView
import ru.cocovella.coolnews.navigation.Screens
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class HeadlinesPresenter(private val mainThreadScheduler: Scheduler, private val sourcesId: String) : MvpPresenter<HeadlinesView>() {

    class HeadlinesRVPresenter : IHeadlinesRVPresenter {
        private val dateFormatter = DateFormatter()

        val list = mutableListOf<Article>()
        override var itemClickListener: ((HeadlinesItemView) -> Unit)? = null

        override fun getCount() = list.size

        override fun bindView(view: HeadlinesItemView) {
            val article = list[view.pos]
            with(view) {
                setImage(checkNull(article.urlToImage))
                setArticleTitle(checkNull(article.title))
                setDescription(checkNull(article.description))
                setSource(checkNullAddDot(article.author))
                setPublishedAtDate(dateFormatter.formatDate(article.publishedAt) ?: "")
                setPublishedAgoTime(dateFormatter.formatDateToTime(article.publishedAt) ?: "")
            }
        }

        private fun checkNullAddDot(text: String?) : String =
            if (text.isNullOrBlank()) { "" } else { " • $text" }

        private fun checkNull(text: String?) : String =
            if (text.isNullOrBlank()) { "" } else { text }

        }


    @Inject lateinit var headlinesRepo: NewsHeadlinesRepo
    @Inject lateinit var router: Router
    val presenter = HeadlinesRVPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        presenter.itemClickListener = {
            val article = presenter.list[it.pos]
            router.navigateTo(Screens.ArticleScreen(article))
        }
    }

    private fun loadData() {
        headlinesRepo.getNewsHeadlines(sourcesId)
            .observeOn(mainThreadScheduler)
            .subscribe({
                presenter.list.clear()
                presenter.list.addAll(it.articles)
                viewState.setHeader("Top Headlines  • " +  it.articles[0].source.name)
                viewState.updateList()
            }, { Timber.e(it) })
    }



    fun backClicked(): Boolean {
        router.exit()
        return true
    }

}
