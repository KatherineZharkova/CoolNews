package ru.cocovella.coolnews.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_headlines.*
import kotlinx.android.synthetic.main.fragment_repositories.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.cocovella.coolnews.R
import ru.cocovella.coolnews.mvp.model.api.NewsApiHolder
import ru.cocovella.coolnews.mvp.model.repo.NewsArticlesRepo
import ru.cocovella.coolnews.mvp.model.repo.NewsHeadlinesRepo
import ru.cocovella.coolnews.mvp.presenter.HeadlinesPresenter
import ru.cocovella.coolnews.mvp.view.HeadlinesView
import ru.cocovella.coolnews.ui.App
import ru.cocovella.coolnews.ui.BackButtonListener
import ru.cocovella.coolnews.ui.adapter.HeadlinesRVAdapter
import ru.cocovella.coolnews.ui.adapter.RepositoriesRVAdapter
import ru.cocovella.coolnews.ui.image.GlideImageLoader

class HeadlinesFragment : MvpAppCompatFragment(), HeadlinesView, BackButtonListener {

    companion object {
        fun newInstance() = HeadlinesFragment()
    }

    @InjectPresenter lateinit var presenter: HeadlinesPresenter

    @ProvidePresenter
    fun providePresenter() = HeadlinesPresenter(
        AndroidSchedulers.mainThread(),
        App.instance.router,
        NewsArticlesRepo(),
        NewsHeadlinesRepo(NewsApiHolder.api)
    )

    val imageLoader = GlideImageLoader()

    var adapter: HeadlinesRVAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        View.inflate(context, R.layout.fragment_headlines, null)

    override fun init() {
        rv_headlines.layoutManager = LinearLayoutManager(context)
        adapter = HeadlinesRVAdapter(presenter.headlinesListPresenter)
        rv_headlines.adapter = adapter
    }

    override fun setHeader(text: String) {
        headlines_header.text = text
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backClicked() = presenter.backClicked()

}
