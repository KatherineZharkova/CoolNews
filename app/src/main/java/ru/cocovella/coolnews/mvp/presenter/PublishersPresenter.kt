package ru.cocovella.coolnews.mvp.presenter

import io.reactivex.rxjava3.core.Scheduler
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.cocovella.coolnews.mvp.model.entity.Sources
import ru.cocovella.coolnews.mvp.model.repo.NewsHeadlinesRepo
import ru.cocovella.coolnews.mvp.model.repo.NewsPublishersRepo
import ru.cocovella.coolnews.mvp.presenter.list.IPublishersRVPresenter
import ru.cocovella.coolnews.mvp.view.PublishersView
import ru.cocovella.coolnews.mvp.view.list.PublishersItemView
import ru.cocovella.coolnews.navigation.Screens
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class PublishersPresenter(private val mainThreadScheduler: Scheduler) : MvpPresenter<PublishersView>() {

    class PublishersRVPresenter : IPublishersRVPresenter {
        val list = mutableListOf<Sources>()
        override var itemClickListener: ((PublishersItemView) -> Unit)? = null

        override fun getCount() = list.size

        override fun bindView(view: PublishersItemView) {
            val sources = list[view.pos]
            view.setTitle(sources.name)
        }
    }

    @Inject lateinit var publishersRepo: NewsPublishersRepo
    @Inject lateinit var headlinesRepo: NewsHeadlinesRepo
    @Inject lateinit var router: Router
    val presenter = PublishersRVPresenter()


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        presenter.itemClickListener = {
            loadHeadlinesScreen(it)
        }
    }

    private fun loadData() {
        publishersRepo.getNewsPublishers()
            .observeOn(mainThreadScheduler)
            .subscribe({
                presenter.list.clear()
                presenter.list.addAll(it.sources)
                viewState.updateList()
            }, { Timber.e(it) })
    }

    private fun loadHeadlinesScreen(view: PublishersItemView) {
        val sourcesId = presenter.list[view.pos].id
            headlinesRepo.getNewsHeadlines(sourcesId)
                .observeOn(mainThreadScheduler)
                .subscribe({
                    router.navigateTo(Screens.HeadlinesScreen(it))
                }, { Timber.e(it) })
        }

    fun backClicked(): Boolean {
        router.exit()
        return true
    }

}
