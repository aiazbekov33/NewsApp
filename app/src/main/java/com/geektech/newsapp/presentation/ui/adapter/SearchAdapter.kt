package com.geektech.newsapp.presentation.ui.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.geektech.newsapp.databinding.ItemNewsBinding
import com.geektech.newsapp.databinding.SearchItemsBinding
import com.geektech.newsapp.presentation.base.BaseComparator
import com.geektech.newsapp.presentation.models.TopHeadlinesUI

class SearchAdapter(private val itemClick:(model: TopHeadlinesUI)-> Unit) :
    ListAdapter<TopHeadlinesUI, SearchAdapter.TopHeadlinesViewHolder>(
        BaseComparator()
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchAdapter.TopHeadlinesViewHolder {
        return TopHeadlinesViewHolder(SearchItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(
        holder: SearchAdapter.TopHeadlinesViewHolder,
        position: Int
    ) {

        getItem(position)?.let {
            holder.onBind(it)
        }
    }




    inner class TopHeadlinesViewHolder(
        private val binding: SearchItemsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let{
                    itemClick(it)
                }
            }
        }

        fun onBind(it: TopHeadlinesUI) = with(binding) {
            txt.text = it.title
            image.load(it.urlToImage)
        }
    }


}
