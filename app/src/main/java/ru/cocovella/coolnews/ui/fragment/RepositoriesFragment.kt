package ru.cocovella.coolnews.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_repositories.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.cocovella.coolnews.R
import ru.cocovella.coolnews.mvp.model.api.ApiHolder
import ru.cocovella.coolnews.mvp.model.repo.GithubRepositoriesRepo
import ru.cocovella.coolnews.mvp.model.repo.GithubUsersRepo
import ru.cocovella.coolnews.mvp.presenter.RepositoriesPresenter
import ru.cocovella.coolnews.mvp.view.RepositoriesView
import ru.cocovella.coolnews.ui.App
import ru.cocovella.coolnews.ui.BackButtonListener
import ru.cocovella.coolnews.ui.adapter.RepositoriesRVAdapter
import ru.cocovella.coolnews.ui.image.GlideImageLoader


class RepositoriesFragment : MvpAppCompatFragment(), RepositoriesView, BackButtonListener {

    companion object {
        private const val PICK_IMAGE_REQUEST_ID = 1
        fun newInstance() = RepositoriesFragment()
    }

    @InjectPresenter
    lateinit var presenter: RepositoriesPresenter

    val imageLoader = GlideImageLoader()

    var adapter: RepositoriesRVAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        View.inflate(context, R.layout.fragment_repositories, null)


    @ProvidePresenter
    fun providePresenter() = RepositoriesPresenter(
        AndroidSchedulers.mainThread(),
        App.instance.router,
        GithubRepositoriesRepo(),
        GithubUsersRepo(ApiHolder.api)
    )


    override fun init() {
        rv_repos.layoutManager = LinearLayoutManager(context)
        adapter = RepositoriesRVAdapter(presenter.repositoryListPresenter)
        rv_repos.adapter = adapter

    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun setUsername(text: String) {
        tv_username.text = text
    }

    override fun loadAvatar(avatarUrl: String) {
        imageLoader.loadInto(avatarUrl, iv_avatar)
    }

    override fun backClicked() = presenter.backClicked()
}