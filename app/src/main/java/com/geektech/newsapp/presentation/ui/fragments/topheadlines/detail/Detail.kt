package com.geektech.newsapp.presentation.ui.fragments.topheadlines.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.geektech.newsapp.R
import com.geektech.newsapp.databinding.FragmentDetailBinding
import com.geektech.newsapp.presentation.base.BaseFragment
import com.geektech.newsapp.presentation.models.TopHeadlinesUI
import com.geektech.newsapp.presentation.ui.fragments.topheadlines.TopHeadlinesFragment_GeneratedInjector
import com.geektech.newsapp.presentation.ui.fragments.topheadlines.TopHeadlinesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Detail : BaseFragment<FragmentDetailBinding,TopHeadlinesViewModel>(R.layout.fragment_detail) {

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

