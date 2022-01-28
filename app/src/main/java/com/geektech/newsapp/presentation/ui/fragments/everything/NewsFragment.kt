package com.geektech.newsapp.presentation.ui.fragments.everything

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.newsapp.R
import com.geektech.newsapp.base.BaseFragment
import com.geektech.newsapp.databinding.FragmentNewsBinding
import com.geektech.newsapp.presentation.base.BaseFragment
import com.geektech.newsapp.presentation.ui.adapter.TopHeadlinesAdapter
import com.geektech.newsapp.extensions.scrollListenNextPage
import com.geektech.newsapp.presentation.models.TopHeadlinesUI
import com.geektech.newsapp.presentation.state.UIState
import com.geektech.newsapp.presentation.ui.adapters.everything.EverythingAdapter
import com.geektech.newsapp.presentation.ui.adapters.everything.EverythingHotNewsAdapter
import com.geektech.newsapp.presentation.ui.fragments.topheadlines.TopHeadlinesFragment_GeneratedInjector
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment :
    BaseFragment<FragmentNewsBinding, NewEverythingViewModel>(R.layout.fragment_news) {

    override val binding by viewBinding(FragmentNewsBinding::bind)
    override val viewModel: NewEverythingViewModel by viewModels()
    private val everythingAdapter = EverythingAdapter(this::itemClickVertical)
    private val everythingHotNewsAdapter = EverythingHotNewsAdapter(this::itemClickHorizontal)


    override fun initialize() = with(binding) {
        recyclerNews.layoutManager = LinearLayoutManager(context)
        recyclerNews.adapter = everythingAdapter

        recyclerHotNews.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerHotNews.adapter = everythingHotNewsAdapter
    }

    override fun setupListeners() {
        setupOnScrollListener()
    }

    override fun checkRecycler()= with(binding) {
        recyclerNews.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (recyclerView.canScrollVertically(-1)) {
                    recyclerHotNews.visibility = View.GONE;
                }else{
                    if (recyclerHotNews.visibility != View.VISIBLE) {
                        recyclerHotNews.visibility = View.VISIBLE;

                    }
                }

            }
        })

    }

    private fun setupOnScrollListener() = with(binding) {
        recyclerNews.scrollListenNextPage(viewModel)
        recyclerHotNews.scrollListenNextPage(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }

    private fun itemClickHorizontal(model: TopHeadlinesUI) {
        findNavController().navigate(NewsFragmentDirections.actionNavigationNewToDetailEverything(model))
    }

    private fun itemClickVertical(model: TopHeadlinesUI) {
        findNavController().navigate(NewsFragmentDirections.actionNavigationNewToDetailEverything(model))
    }

    override fun setupObserves() {
        viewModel.everythingState2.subscribe {
            when (it) {
                is UIState.Error -> {}
                is UIState.Loading -> {}
                is UIState.Success -> {
                    everythingHotNewsAdapter.submitList(it.data)
                }
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.everythingState.subscribe {
                when (it) {
                    is UIState.Error -> {

                    }
                    is UIState.Loading -> {
                }
                is UIState.Loading -> {

                    }
                    is UIState.Success -> {
                        val list = ArrayList<TopHeadlinesUI>(everythingAdapter.currentList)
                        it.data.let { data -> list.addAll(data) }
                        everythingAdapter.submitList(list)
                    }
                }
            }
        }
    }
}