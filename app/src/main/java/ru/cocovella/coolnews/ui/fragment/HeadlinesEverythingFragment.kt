package ru.cocovella.coolnews.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_headlines_recycler.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.cocovella.coolnews.R
import ru.cocovella.coolnews.mvp.model.image.IImageLoader
import ru.cocovella.coolnews.mvp.presenter.HeadlinesEverythingPresenter
import ru.cocovella.coolnews.mvp.view.HeadlinesEverythingView
import ru.cocovella.coolnews.mvp.view.HeadlinesView
import ru.cocovella.coolnews.ui.App
import ru.cocovella.coolnews.ui.BackButtonListener
import ru.cocovella.coolnews.ui.adapter.EverythingRVAdapter
import timber.log.Timber
import javax.inject.Inject

class HeadlinesEverythingFragment : MvpAppCompatFragment(), HeadlinesEverythingView, BackButtonListener {

    companion object {
        private const val KEY = "everything"
        fun newInstance(sourcesId: String) = HeadlinesEverythingFragment().apply {
            arguments = Bundle().apply { putString(KEY, sourcesId) }
        }
    }

    @InjectPresenter
    lateinit var presenter: HeadlinesEverythingPresenter

    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>

    var adapter: EverythingRVAdapter? = null

    private val component = App.instance.everythingArticlesSubcomponent

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        View.inflate(context, R.layout.fragment_headlines_recycler, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        component.inject(this)
    }

    @ProvidePresenter
    fun providePresenter() = HeadlinesEverythingPresenter(AndroidSchedulers.mainThread(), arguments?.getString(KEY).toString()).apply {
        Timber.e("HeadlinesEverythingPresenter created $this")
        component.inject(this)
    }


    override fun init() {
        adapter = EverythingRVAdapter(presenter.presenter).apply {
            rv_headlines.adapter = this
            component.inject(this)
        }
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun setHeader(text: String) {

    }

    override fun backClicked() = presenter.backClicked()
}