package com.geektech.newsapp.presentation.ui.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.geektech.newsapp.databinding.ItemHotNewsBinding
import com.geektech.newsapp.presentation.base.BaseComparator
import com.geektech.newsapp.presentation.models.TopHeadlinesUI

class EverythingHotNewsAdapter :
    ListAdapter<TopHeadlinesUI, EverythingHotNewsAdapter.EverythingHotNewsViewHolder>(
        BaseComparator()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EverythingHotNewsViewHolder {
        return EverythingHotNewsViewHolder(
            ItemHotNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: EverythingHotNewsViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    class EverythingHotNewsViewHolder(
        private val binding: ItemHotNewsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(it: TopHeadlinesUI) = with(binding) {
            Glide.with(hotNewsIm)
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
                        dataSource: com.bumptech.glide.load.DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressPhoto.visibility = View.GONE
                        return false
                    }
                })
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(hotNewsIm)

            textForHotNews.text = it.title
            dateTop.text = it.publishedAt

        }
    }
}
