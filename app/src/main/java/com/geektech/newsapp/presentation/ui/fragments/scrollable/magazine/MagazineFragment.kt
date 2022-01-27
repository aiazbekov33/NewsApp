package com.geektech.newsapp.presentation.ui.fragments.scrollable.magazine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.newsapp.R
import com.geektech.newsapp.databinding.FragmentBusinessBinding
import com.geektech.newsapp.databinding.FragmentMagazineBinding
import com.geektech.newsapp.presentation.base.BaseFragment
import com.geektech.newsapp.presentation.ui.fragments.scrollable.business.BusinessViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MagazineFragment :
    BaseFragment<FragmentMagazineBinding, MagazineViewModel>(R.layout.fragment_magazine) {

    override val binding by viewBinding(FragmentMagazineBinding::bind)
    override val viewModel: MagazineViewModel by viewModels()

}