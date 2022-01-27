package com.geektech.newsapp.presentation.ui.fragments.topheadlines

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.newsapp.R
import com.geektech.newsapp.base.BaseFragment
import com.geektech.newsapp.databinding.FragmentTopHeadlinesBinding
import com.geektech.newsapp.extensions.scrollListenNextPage
import com.geektech.newsapp.presentation.models.TopHeadlinesUI
import com.geektech.newsapp.presentation.state.UIState
import com.geektech.newsapp.presentation.ui.adapters.topheadlines.TopHeadlinesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopHeadlinesFragment :
    BaseFragment<FragmentTopHeadlinesBinding, TopHeadlinesViewModel>(R.layout.fragment_top_headlines) {

    override val binding by viewBinding(FragmentTopHeadlinesBinding::bind)
    override val viewModel: TopHeadlinesViewModel by viewModels()
    private val topHeadlinesAdapter = TopHeadlinesAdapter(this::itemClick)

    private fun itemClick(model: TopHeadlinesUI) {
        val bundle = Bundle()
        bundle.putSerializable("model", model)
        findNavController().navigate(R.id.detail, bundle)
    }

    override fun initialize() = with(binding) {
        recyclerNews.layoutManager = LinearLayoutManager(context)
        recyclerNews.adapter = topHeadlinesAdapter
    }

    override fun setupListeners() {
        setupOnScrollListener()
    }

    private fun setupOnScrollListener() = with(binding) {
        recyclerNews.scrollListenNextPage(viewModel)
    }

    override fun setupObserves() {
        viewModel.topHeadlinesState.subscribe {
            when (it) {
                is UIState.Error -> {

                }
                is UIState.Loading -> {

                }
                is UIState.Success -> {
                    val list = ArrayList<TopHeadlinesUI>(topHeadlinesAdapter.currentList)
                    it.data.let { data -> list.addAll(data) }
                    topHeadlinesAdapter.submitList(list)
                }
            }
        }
    }
}


