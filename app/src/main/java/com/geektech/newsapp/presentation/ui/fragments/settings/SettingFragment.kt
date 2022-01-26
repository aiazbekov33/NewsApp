package com.geektech.newsapp.presentation.ui.fragments.settings

import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.newsapp.R
import com.geektech.newsapp.databinding.FragmentSettingBinding
import com.geektech.newsapp.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment :
    BaseFragment<FragmentSettingBinding, SettingViewModel>(R.layout.fragment_setting) {

    override val binding by viewBinding(FragmentSettingBinding::bind)
    override val viewModel: SettingViewModel by viewModels()

    override fun setupDarkNight() = with(binding){
        DarkModeScSetting.setOnClickListener{
            if (DarkModeScSetting.isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    override fun setupListeners() {
        binding.searchButton.setOnClickListener{
            findNavController().navigate(R.id.searchFragment)
        }
    }

}