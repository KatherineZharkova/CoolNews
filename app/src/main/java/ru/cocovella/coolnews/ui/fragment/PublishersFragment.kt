package ru.cocovella.coolnews.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_publishers.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.cocovella.coolnews.R
import ru.cocovella.coolnews.mvp.model.image.IImageLoader
import ru.cocovella.coolnews.mvp.presenter.PublishersPresenter
import ru.cocovella.coolnews.mvp.view.PublishersView
import ru.cocovella.coolnews.ui.App
import ru.cocovella.coolnews.ui.BackButtonListener
import ru.cocovella.coolnews.ui.adapter.PublishersRVAdapter
import javax.inject.Inject

class PublishersFragment : MvpAppCompatFragment(), PublishersView, BackButtonListener {

    companion object {

        fun newInstance() = PublishersFragment()
    }

    @InjectPresenter lateinit var presenter: PublishersPresenter

    @Inject lateinit var imageLoader: IImageLoader<ImageView>

    private var adapter: PublishersRVAdapter? = null

    private val component = App.instance.headlinesSubcomponent

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        View.inflate(context, R.layout.fragment_publishers, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        component.inject(this)
    }

    @ProvidePresenter
    fun providePresenter() = PublishersPresenter(AndroidSchedulers.mainThread()).apply {
        component.inject(this)
    }


    override fun init() {
        rv_publishers.layoutManager = LinearLayoutManager(context)
        adapter = PublishersRVAdapter(presenter.presenter).apply {
            component.inject(this)
        }
        rv_publishers.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backClicked() = presenter.backClicked()
}