package com.geektech.newsapp.presentation.ui.adapters.topheadlines

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.geektech.newsapp.base.BaseComparator
import com.geektech.newsapp.databinding.ItemNewsBinding
import com.geektech.newsapp.presentation.models.TopHeadlinesUI

class TopHeadlinesAdapter(private val itemClick: (model: TopHeadlinesUI) -> Unit) :
    ListAdapter<TopHeadlinesUI, TopHeadlinesAdapter.TopHeadlinesViewHolder>(
        BaseComparator()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopHeadlinesViewHolder {
        return TopHeadlinesViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TopHeadlinesViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class TopHeadlinesViewHolder(
        private val binding: ItemNewsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let {
                    itemClick(it)
                }
            }
        }

        fun onBind(it: TopHeadlinesUI) = with(binding) {
            Glide.with(newsIm)
                .load(it.urlToImage)
                .listener(object : RequestListener<Drawable?> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: com.bumptech.glide.request.target.Target<Drawable?>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressPhoto.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: com.bumptech.glide.request.target.Target<Drawable?>?,
                        dataSource: com.bumptech.glide.load.DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressPhoto.visibility = View.GONE
                        return false
                    }
                })
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(newsIm)

            textTitle.text = it.title
            textDescription.text = it.description
            newsDate.text = it.publishedAt
        }
    }
}
