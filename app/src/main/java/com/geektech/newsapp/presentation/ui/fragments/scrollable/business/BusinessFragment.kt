package com.geektech.newsapp.presentation.ui.fragments.scrollable.business

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.newsapp.R
import com.geektech.newsapp.base.BaseFragment
import com.geektech.newsapp.databinding.FragmentBusinessBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BusinessFragment :
    BaseFragment<FragmentBusinessBinding, BusinessViewModel>(R.layout.fragment_business) {

    override val binding by viewBinding(FragmentBusinessBinding::bind)
    override val viewModel: BusinessViewModel by viewModels()

}