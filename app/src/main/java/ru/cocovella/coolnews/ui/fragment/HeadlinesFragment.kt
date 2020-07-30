package ru.cocovella.coolnews.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import kotlinx.android.synthetic.main.fragment_headlines.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.cocovella.coolnews.R
import ru.cocovella.coolnews.mvp.model.image.IImageLoader
import ru.cocovella.coolnews.mvp.presenter.HeadlinesPresenter
import ru.cocovella.coolnews.mvp.view.HeadlinesView
import ru.cocovella.coolnews.ui.App
import ru.cocovella.coolnews.ui.BackButtonListener
import ru.cocovella.coolnews.ui.adapter.MyAdapter
import timber.log.Timber
import javax.inject.Inject


class HeadlinesFragment : MvpAppCompatFragment(), HeadlinesView, BackButtonListener {

    companion object {
        private const val KEY = "headlines"
        fun newInstance(sourcesId: String) = HeadlinesFragment().apply {
            arguments = Bundle().apply { putString(KEY, sourcesId) }
        }
    }

    @InjectPresenter lateinit var presenter: HeadlinesPresenter

    @Inject lateinit var imageLoader: IImageLoader<ImageView>

    private val component = App.instance.articleSubcomponent

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        View.inflate(context, R.layout.fragment_headlines, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        component.inject(this)

        view_pager.adapter = MyAdapter(childFragmentManager).apply {
            addFragment(HeadlinesTopFragment.newInstance(arguments?.getString(KEY).toString()), "Top Headlines")
            addFragment(HeadlinesEverythingFragment.newInstance(arguments?.getString(KEY).toString()), "Everything")
        }
        tabs.setupWithViewPager(view_pager)
    }

    @ProvidePresenter
    fun providePresenter() = HeadlinesPresenter().apply { component.inject(this) }

    override fun init() {}

    override fun updateList() {}

    override fun setHeader(text: String) {}

    override fun backClicked(): Boolean {
        return presenter.backClicked()
    }
}