package com.geektech.newsapp.presentation.ui.fragments.search

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.newsapp.R
import com.geektech.newsapp.base.BaseFragment
import com.geektech.newsapp.databinding.FragmentSearchBinding
import com.geektech.newsapp.presentation.models.TopHeadlinesUI
import com.geektech.newsapp.presentation.state.UIState
import com.geektech.newsapp.presentation.ui.adapters.search.SearchAdapter
import com.geektech.newsapp.presentation.ui.fragments.topheadlines.TopHeadlinesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment :
    BaseFragment<FragmentSearchBinding, TopHeadlinesViewModel>(R.layout.fragment_search) {

    override val binding: FragmentSearchBinding by viewBinding(FragmentSearchBinding::bind)
    override val viewModel: TopHeadlinesViewModel by viewModels()
    private lateinit var adapter: SearchAdapter
    private var currentText = ""
    private val handler = Handler(Looper.getMainLooper())
    private val searchRunnable = Runnable {
        viewModel.searchNews(currentText)
    }

    override fun initialize() {
        adapter = SearchAdapter(this::itemClick)
        binding.recycler.adapter = adapter
    }

    private fun itemClick(model: TopHeadlinesUI) {
       findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToDetail(model))
    }

    override fun setupRequests() {
        binding.edit.doAfterTextChanged {
            currentText = it?.toString() ?: ""
            handler.removeCallbacks(searchRunnable)
            handler.postDelayed(searchRunnable, 500L)
        }
    }

    override fun setupObserves() {
        viewModel.searchNews.subscribe {
            when (it) {
                is UIState.Error -> {}
                is UIState.Loading -> {}
                is UIState.Success -> {
                    adapter.submitList(it.data)
                }
            }
        }
    }
}