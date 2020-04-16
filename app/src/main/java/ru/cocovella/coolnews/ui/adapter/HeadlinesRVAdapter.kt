package ru.cocovella.coolnews.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_headline.view.*
import ru.cocovella.coolnews.R
import ru.cocovella.coolnews.mvp.presenter.list.IHeadlinesListPresenter
import ru.cocovella.coolnews.mvp.view.list.HeadlinesItemView
import ru.cocovella.coolnews.ui.image.GlideImageLoader

class HeadlinesRVAdapter(val presenter: IHeadlinesListPresenter) : RecyclerView.Adapter<HeadlinesRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_headline, parent, false))

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        holder.containerView.setOnClickListener { presenter.itemClickListener?.invoke(holder) }
        presenter.bindView(holder)
    }


    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer, HeadlinesItemView {
        override var pos = -1

        override fun setImage(urlToImage: String) = with(containerView){
            GlideImageLoader().loadInto(urlToImage, headline_background) }

        override fun setAuthor(text: String) = with(containerView){ author.text = text }

        override fun setPublishedAtDate(text: String)  = with(containerView){ publishedAtDate.text = text }

        override fun setArticleTitle(text: String)  = with(containerView){ article_title.text = text }

        override fun setDescription(text: String)  = with(containerView){ description.text = text }

        override fun setPublishedAgoTime(text: String)  = with(containerView){ publishedAgoTime.text = text }

        override fun setSource(text: String)  = with(containerView){ source.text = text }

    }

}