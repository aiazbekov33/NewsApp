package com.geektech.newsapp.presentation.ui.fragments.settings

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.newsapp.R
import com.geektech.newsapp.databinding.FragmentSettingBinding
import com.geektech.newsapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment :
    BaseFragment<FragmentSettingBinding, SettingViewModel>(R.layout.fragment_setting) {

    override val binding by viewBinding(FragmentSettingBinding::bind)
    override val viewModel: SettingViewModel by viewModels()

}