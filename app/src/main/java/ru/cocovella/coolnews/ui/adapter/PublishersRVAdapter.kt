package ru.cocovella.coolnews.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_publisher.view.*
import ru.cocovella.coolnews.R
import ru.cocovella.coolnews.mvp.presenter.list.IPublishersRVPresenter
import ru.cocovella.coolnews.mvp.view.list.PublishersItemView

class PublishersRVAdapter(val presenter: IPublishersRVPresenter) : RecyclerView.Adapter<PublishersRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_publisher, parent, false))

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        holder.containerView.setOnClickListener { presenter.itemClickListener?.invoke(holder) }
        presenter.bindView(holder)
    }


    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer, PublishersItemView {
        override var pos = -1

        override fun setTitle(text: String) = with(containerView) { name.text = text }

        override fun setUrl(text: String)  = with(containerView) { url.text = text }

        override fun setDescription(text: String) = with(containerView)  { description.text = text }

    }

}