package com.geektech.newsapp.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geektech.newsapp.databinding.ItemSourcesBinding
import com.geektech.newsapp.domain.models.SourcesModel
import com.geektech.newsapp.presentation.base.BaseComparator
import com.geektech.newsapp.presentation.models.SourcesUI

class SourcesAdapter : ListAdapter<SourcesUI, SourcesAdapter.SourcesViewHolder>(
    BaseComparator()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourcesViewHolder {
        return SourcesViewHolder(
            ItemSourcesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SourcesViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }

    }

    class SourcesViewHolder(
        private val binding: ItemSourcesBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(it: SourcesUI) = with(binding) {
            txtItemUs.text = it.id.toString()
            txtItemName.text = it.name
            textDescription.text = it.description
            txtItemCountry.text = it.language
            itemCategory.text = it.category
        }

    }
}