package com.geektech.newsapp.presentation.ui.fragments.topheadlines.detail

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.geektech.newsapp.R
import com.geektech.newsapp.base.BaseFragment
import com.geektech.newsapp.databinding.FragmentDetailBinding
import com.geektech.newsapp.presentation.models.TopHeadlinesUI
import com.geektech.newsapp.presentation.ui.fragments.topheadlines.TopHeadlinesViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Detail :
    BaseFragment<FragmentDetailBinding, TopHeadlinesViewModel>(R.layout.fragment_detail) {

    override val binding: FragmentDetailBinding by viewBinding(FragmentDetailBinding::bind)
    override val viewModel: TopHeadlinesViewModel by viewModels()

    override fun initialize() {
            val model = DetailArgs.fromBundle(requireArguments()).model
            binding.image.load(model.urlToImage)
            binding.title.text = model.title
            binding.author.text = model.author
            binding.date.text = model.publishedAt
            binding.description.text = model.description
        }
    }


