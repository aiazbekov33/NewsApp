package com.geektech.newsapp.presentation.ui.fragments.settings

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.newsapp.R
import com.geektech.newsapp.base.BaseFragment
import com.geektech.newsapp.databinding.FragmentSettingBinding
import com.geektech.newsapp.extensions.LocalHelper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment() :
    BaseFragment<FragmentSettingBinding, SettingViewModel>(R.layout.fragment_setting) {

    override val binding by viewBinding(FragmentSettingBinding::bind)
    override val viewModel: SettingViewModel by viewModels()
    var currentPosition = 0

    override fun setupDarkNight() = with(binding) {
        switchCompat.setOnClickListener {
            if (switchCompat.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    override fun setupListeners() {
        binding.search.setOnClickListener {
            findNavController().navigate(R.id.searchFragment)
        }
    }

    override fun setupLanguage() {
        binding.language.setOnClickListener {
            openLanguageDialog()
        }
    }

    private fun openLanguageDialog() {
        val list = arrayOf("English", "Русский")
        val alertBuilder = AlertDialog.Builder(requireContext())
        alertBuilder.setTitle("Выберите язык")
        alertBuilder.setSingleChoiceItems(
            list, currentPosition
        ) { dialog, which -> currentPosition = which }
        alertBuilder.setPositiveButton(
            "Применять"
        ) { dialog, which ->
            if (currentPosition == 0) {
                showEnglishText()
            } else {
                showRussianText()
            }
            dialog!!.dismiss()
        }
        alertBuilder.setNegativeButton(
            "Отмена"
        ) { dialog, which ->
            dialog!!.dismiss()
        }
        alertBuilder.create()
        alertBuilder.show()
    }

    private fun showEnglishText() {
        val context = LocalHelper().setLocale(requireContext(), "en")
        val resource = context.resources
        binding.languageTv.text = resource.getString(R.string.language)
        (activity as AppCompatActivity).supportActionBar?.title =
            resource.getString(R.string.app_name)
        binding.EditBtnSetting.text = resource.getString(R.string.edit)
        binding.PreferencesTv.text = resource.getString(R.string.preferences)
        binding.switchCompat.text = resource.getString(R.string.dark_mode)
        binding.switchCompatNotification.text = resource.getString(R.string.notification)
        binding.SummaryTv.text = resource.getString(R.string.summary)
        binding.switchCompatLocation.text = resource.getString(R.string.news_by_location)
//        binding.BlockTvSetting.text = resource.getString(R.string.block_content_and_sources)
        binding.helpTv.text = resource.getString(R.string.help)
        binding.searchTv.text = resource.getString(R.string.search)
    }

    private fun showRussianText() {
        val context = LocalHelper().setLocale(requireContext(), "ru")
        val resource = context.resources
        binding.languageTv.text = resource.getString(R.string.language)
        (activity as AppCompatActivity).supportActionBar?.title =
            resource.getString(R.string.app_name)
        binding.EditBtnSetting.text = resource.getString(R.string.edit)
        binding.PreferencesTv.text = resource.getString(R.string.preferences)
        binding.switchCompat.text = resource.getString(R.string.dark_mode)
        binding.switchCompatNotification.text = resource.getString(R.string.notification)
        binding.SummaryTv.text = resource.getString(R.string.summary)
        binding.switchCompatLocation.text = resource.getString(R.string.news_by_location)
//        binding.BlockTvSetting.text = resource.getString(R.string.block_content_and_sources)
        binding.helpTv.text = resource.getString(R.string.help)
        binding.searchTv.text = resource.getString(R.string.search)
    }

}