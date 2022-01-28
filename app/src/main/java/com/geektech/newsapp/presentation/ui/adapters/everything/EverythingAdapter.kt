package com.geektech.newsapp.presentation.ui.adapters.everything

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.geektech.newsapp.base.BaseComparator
import com.geektech.newsapp.databinding.ItemNewsBinding
import com.geektech.newsapp.presentation.models.TopHeadlinesUI

class EverythingAdapter(private val itemClick:(model: TopHeadlinesUI)-> Unit) :
    ListAdapter<TopHeadlinesUI, EverythingAdapter.EverythingViewHolder>(
        BaseComparator()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EverythingViewHolder {
        return EverythingViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: EverythingViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class EverythingViewHolder(
        private val binding: ItemNewsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let{
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
                        target: Target<Drawable?>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressPhoto.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable?>?,
                        dataSource: DataSource?,
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
