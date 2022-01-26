package com.geektech.newsapp.presentation.ui.fragments.sources

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.newsapp.R
import com.geektech.newsapp.databinding.FragmentSourcesBinding
import com.geektech.newsapp.extensions.scrollListenNextPage
import com.geektech.newsapp.base.BaseFragment
import com.geektech.newsapp.presentation.models.SourcesUI
import com.geektech.newsapp.presentation.state.UIState
import com.geektech.newsapp.presentation.ui.adapters.sources.SourcesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SourcesFragment :
    BaseFragment<FragmentSourcesBinding, SourcesViewModel>(R.layout.fragment_sources) {

    override val binding by viewBinding(FragmentSourcesBinding::bind)
    override val viewModel: SourcesViewModel by viewModels()
    private val sourcesAdapter = SourcesAdapter()

    override fun initialize() {
       binding.recyclerSources.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sourcesAdapter
        }
    }

    override fun setupListeners() {
        setupOnScrollListener()
    }

    private fun setupOnScrollListener() = with(binding) {
        recyclerSources.scrollListenNextPage(viewModel)
    }

    override fun setupObserves() {
        viewModel.sourcesState.subscribe {
            when (it) {
                is UIState.Error -> {

                }
                is UIState.Loading -> {
                    binding.swipeRefresh.isRefreshing = true

                }
                is UIState.Success -> {
                    val list = ArrayList<SourcesUI>(sourcesAdapter.currentList)
                    it.data.let { data -> list.addAll(data) }
                    sourcesAdapter.submitList(list)
                    binding.swipeRefresh.isRefreshing = false
                }
            }
        }
    }
}