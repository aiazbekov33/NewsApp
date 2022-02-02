package com.geektech.newsapp.presentation.ui.adapters.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.geektech.newsapp.base.BaseComparator
import com.geektech.newsapp.databinding.SearchItemsBinding
import com.geektech.newsapp.presentation.models.TopHeadlinesUI

class SearchAdapter(private val itemClick: (model: TopHeadlinesUI) -> Unit) :
    ListAdapter<TopHeadlinesUI, SearchAdapter.TopHeadlinesViewHolder>(
        BaseComparator()
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TopHeadlinesViewHolder {
        return TopHeadlinesViewHolder(
            SearchItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: TopHeadlinesViewHolder,
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
                getItem(absoluteAdapterPosition)?.let {
                    itemClick(it)
                }
            }
        }

        fun onBind(it: TopHeadlinesUI) = with(binding) {
            textTitle.text = it.title
            textDescription.text = it.description
            newsIm.load(it.urlToImage)
        }
    }
}
