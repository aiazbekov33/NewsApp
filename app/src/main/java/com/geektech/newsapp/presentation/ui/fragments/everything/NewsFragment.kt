package com.geektech.newsapp.presentation.ui.fragments.everything

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.newsapp.R
import com.geektech.newsapp.databinding.FragmentNewsBinding
import com.geektech.newsapp.domain.models.TopHeadlinesModel
import com.geektech.newsapp.presentation.base.BaseFragment
import com.geektech.newsapp.presentation.state.UIState
import com.geektech.newsapp.presentation.ui.adapter.TopHeadlinesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment :
    BaseFragment<FragmentNewsBinding, NewEverythingViewModel>(R.layout.fragment_news) {

    override val binding by viewBinding(FragmentNewsBinding::bind)
    override val viewModel: NewEverythingViewModel by viewModels()
    private val topHeadlinesAdapter = TopHeadlinesAdapter()

}