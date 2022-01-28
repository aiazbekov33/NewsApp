package com.geektech.newsapp.presentation.ui.fragments.scrollable.world

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.newsapp.R
import com.geektech.newsapp.base.BaseFragment
import com.geektech.newsapp.databinding.FragmentWorldBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorldFragment :
    BaseFragment<FragmentWorldBinding, WorldViewModel>(R.layout.fragment_world) {

    override val binding by viewBinding(FragmentWorldBinding::bind)
    override val viewModel: WorldViewModel by viewModels()

}