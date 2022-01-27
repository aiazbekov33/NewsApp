package com.geektech.newsapp.presentation.ui.fragments.scrollable.business

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.newsapp.R
import com.geektech.newsapp.databinding.FragmentBusinessBinding
import com.geektech.newsapp.databinding.FragmentSettingBinding
import com.geektech.newsapp.presentation.base.BaseFragment
import com.geektech.newsapp.presentation.ui.fragments.settings.SettingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BusinessFragment :
    BaseFragment<FragmentBusinessBinding, BusinessViewModel>(R.layout.fragment_business) {

    override val binding by viewBinding(FragmentBusinessBinding::bind)
    override val viewModel: BusinessViewModel by viewModels()

}