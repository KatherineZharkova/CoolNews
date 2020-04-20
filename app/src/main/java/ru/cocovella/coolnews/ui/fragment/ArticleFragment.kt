package ru.cocovella.coolnews.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.ImageView
import kotlinx.android.synthetic.main.fragment_article.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.cocovella.coolnews.R
import ru.cocovella.coolnews.mvp.model.entity.Article
import ru.cocovella.coolnews.mvp.model.image.IImageLoader
import ru.cocovella.coolnews.mvp.presenter.ArticlePresenter
import ru.cocovella.coolnews.mvp.view.ArticleView
import ru.cocovella.coolnews.ui.App
import ru.cocovella.coolnews.ui.BackButtonListener
import javax.inject.Inject

class ArticleFragment : MvpAppCompatFragment(), ArticleView, BackButtonListener {

    companion object {
        const val KEY = "article"

        fun newInstance(article: Article) = ArticleFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY, article)
            }
        }
    }

    @Inject lateinit var imageLoader: IImageLoader<ImageView>

    @InjectPresenter
    lateinit var presenter: ArticlePresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        View.inflate(context, R.layout.fragment_article, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.instance.articleSubcomponent.inject(this)
    }

    @ProvidePresenter
    fun providePresenter() = ArticlePresenter(arguments!![KEY] as Article).apply {
        App.instance.articleSubcomponent.inject(this)
    }

    override fun setAppbarTitle(text: String) {
        appbar_title.text = text
    }

    override fun setAppbarSubtitle(text: String) {
        appbar_subtitle.text = text
    }

    override fun setImage(urlToImage: String?) {
        imageLoader.loadInto(urlToImage.toString(), appbar_background)
    }

    override fun setPublishedAt(text: String) {
        publishedAtDate.text = text
    }

    override fun setArticleTitle(text: String) {
        article_title.text = text
    }

    override fun setSourceAuthorTime(text: String) {
        publishedAgoTime.text = text
    }

    override fun setWebView(url: String) {
        webView.apply {
            settings.apply {
                loadsImagesAutomatically = true
                domStorageEnabled = true
                setSupportZoom(true)
                builtInZoomControls = true
                displayZoomControls = false
            }
            scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    }

    override fun backClicked() = presenter.backClicked()
}