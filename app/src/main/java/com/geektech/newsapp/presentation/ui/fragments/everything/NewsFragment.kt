package com.geektech.newsapp.presentation.ui.fragments.everything

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.newsapp.R
import com.geektech.newsapp.databinding.FragmentNewsBinding
import com.geektech.newsapp.extensions.scrollListenNextPage
import com.geektech.newsapp.base.BaseFragment
import com.geektech.newsapp.presentation.models.TopHeadlinesUI
import com.geektech.newsapp.presentation.state.UIState
import com.geektech.newsapp.presentation.ui.adapters.everything.EverythingAdapter
import com.geektech.newsapp.presentation.ui.adapters.everything.EverythingHotNewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment :
    BaseFragment<FragmentNewsBinding, NewEverythingViewModel>(R.layout.fragment_news) {

    override val binding by viewBinding(FragmentNewsBinding::bind)
    override val viewModel: NewEverythingViewModel by viewModels()
    private val everythingAdapter = EverythingAdapter()
    private val everythingHotNewsAdapter = EverythingHotNewsAdapter()


    override fun initialize() = with(binding) {
        recyclerNews.layoutManager = LinearLayoutManager(context)
        recyclerNews.adapter = everythingAdapter

        recyclerHotNews.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerHotNews.adapter = everythingHotNewsAdapter
    }

    override fun setupListeners() {
        setupOnScrollListener()
    }

    private fun setupOnScrollListener() = with(binding) {
        recyclerNews.scrollListenNextPage(viewModel)
        recyclerHotNews.scrollListenNextPage(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }

//    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
//        menuInflater.inflate(R.menu.menu_toolbar, menu)
//
//        val search = menu.findItem(R.id.news_search)
//
//        val searchView = search.actionView as SearchView
//        searchView.queryHint = "Search"
//
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                return false
//            }
//        })
//    }

    override fun setupObserves() {
        viewModel.everythingState2.subscribe{
            when(it){
                is UIState.Error -> {}
                is UIState.Loading -> {}
                is UIState.Success -> {
                    everythingHotNewsAdapter.submitList(it.data)
                }
            }
        }

        viewModel.everythingState.subscribe {
            when (it) {
                is UIState.Error -> {

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