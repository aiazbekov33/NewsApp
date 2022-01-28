package com.geektech.newsapp.presentation.ui.fragments.scrollable.magazine

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.newsapp.R
import com.geektech.newsapp.base.BaseFragment
import com.geektech.newsapp.databinding.FragmentMagazineBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MagazineFragment :
    BaseFragment<FragmentMagazineBinding, MagazineViewModel>(R.layout.fragment_magazine) {

    override val binding by viewBinding(FragmentMagazineBinding::bind)
    override val viewModel: MagazineViewModel by viewModels()

}