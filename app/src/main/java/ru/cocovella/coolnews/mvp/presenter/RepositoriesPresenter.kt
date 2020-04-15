package ru.cocovella.coolnews.mvp.presenter

import io.reactivex.rxjava3.core.Scheduler
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.cocovella.coolnews.mvp.model.entity.GithubRepository
import ru.cocovella.coolnews.mvp.model.repo.GithubRepositoriesRepo
import ru.cocovella.coolnews.mvp.model.repo.GithubUsersRepo
import ru.cocovella.coolnews.mvp.presenter.list.IRepositoryListPresenter
import ru.cocovella.coolnews.mvp.view.RepositoriesView
import ru.cocovella.coolnews.mvp.view.list.RepositoryItemView
import ru.cocovella.coolnews.navigation.Screens
import ru.terrakok.cicerone.Router
import timber.log.Timber

@InjectViewState
class RepositoriesPresenter(
    val mainThreadScheduler: Scheduler,
    val router: Router,
    val repositoriesRepo: GithubRepositoriesRepo,
    val usersRepo: GithubUsersRepo
) :
    MvpPresenter<RepositoriesView>() {


    class RepositoryListPresenter : IRepositoryListPresenter {
        val repositories = mutableListOf<GithubRepository>()
        override var itemClickListener: ((RepositoryItemView) -> Unit)? = null

        override fun getCount() = repositories.size

        override fun bindView(view: RepositoryItemView) {
            val repository = repositories[view.pos]
            view.setTitle(repository.name)
        }
    }

    val repositoryListPresenter = RepositoryListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadUser()

        loadRepos()

        repositoryListPresenter.itemClickListener = { itemView ->
            val repository = repositoryListPresenter.repositories[itemView.pos]
            router.navigateTo(Screens.RepositoryScreen(repository))
        }
    }

    fun loadUser() {
        usersRepo.getUser("googlesamples")
            .observeOn(mainThreadScheduler)
            .subscribe({ user ->
                viewState.setUsername(user.login)
                viewState.loadAvatar(user.avatarUrl)
            }, {
                Timber.e(it)
            })
    }

    fun loadRepos() {
        repositoriesRepo.getRepos()
            .observeOn(mainThreadScheduler)
            .subscribe({ repos ->
                repositoryListPresenter.repositories.clear()
                repositoryListPresenter.repositories.addAll(repos)
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
