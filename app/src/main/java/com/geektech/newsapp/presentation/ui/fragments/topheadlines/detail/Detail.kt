package com.geektech.newsapp.presentation.ui.fragments.topheadlines.detail

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.geektech.newsapp.R
import com.geektech.newsapp.base.BaseFragment
import com.geektech.newsapp.databinding.FragmentDetailBinding
import com.geektech.newsapp.presentation.models.TopHeadlinesUI
import com.geektech.newsapp.presentation.ui.fragments.topheadlines.TopHeadlinesViewModel
class Detail :
    BaseFragment<FragmentDetailBinding, TopHeadlinesViewModel>(R.layout.fragment_detail) {

    override val binding: FragmentDetailBinding by viewBinding(FragmentDetailBinding::bind)
    override val viewModel: TopHeadlinesViewModel by viewModels()

    override fun initialize() {
        if (arguments != null) {
            val model: TopHeadlinesUI = arguments?.getSerializable("model") as TopHeadlinesUI
            binding.image.load(model.urlToImage)
            binding.title.text = model.title
            binding.author.text = model.author
            binding.date.text = model.publishedAt
            binding.description.text = model.description
        }
    }
}

