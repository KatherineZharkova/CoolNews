package ru.cocovella.coolnews.mvp.presenter

import moxy.InjectViewState
import moxy.MvpPresenter
import ru.cocovella.coolnews.mvp.model.entity.Article
import ru.cocovella.coolnews.mvp.view.ArticleView
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ArticlePresenter(private val article: Article) : MvpPresenter<ArticleView>() {

    @Inject lateinit var router: Router
    private val dateFormatter = DateFormatter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.apply {
            init()
            setAppbarTitle(article.source.name)
            setAppbarSubtitle(article.url)
            setImage(article.urlToImage)
            setPublishedAt(dateFormatter.formatDate(article.publishedAt) ?: "")
            setArticleTitle(article.title)
            setSourceAuthorTime()
            setWebView(article.url)
        }

    }

    private fun setSourceAuthorTime() {
        val dateText: String = dateFormatter.formatDateToTime(article.publishedAt).toString()
        val author = article.author
        val authorText: String = if (author.isNullOrBlank()) { "" } else { " • $author" }
        viewState.setSourceAuthorTime(dateText + authorText)
    }

    fun backClicked(): Boolean {
        router.exit()
        return true
    }
}
