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
        DarkModeScSetting.setOnClickListener {
            if (DarkModeScSetting.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    override fun setupListeners() {
        binding.searchButton.setOnClickListener {
            findNavController().navigate(R.id.searchFragment)
        }
    }

    override fun setupLanguage() {
        binding.LanguageIbSetting.setOnClickListener {
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
        binding.LanguageTvSetting.text = resource.getString(R.string.language)
        (activity as AppCompatActivity).supportActionBar?.title =
            resource.getString(R.string.app_name)
        binding.EditBtnSetting.text = resource.getString(R.string.edit)
        binding.PreferencesTv.text = resource.getString(R.string.preferences)
        binding.DarkModeTvSetting.text = resource.getString(R.string.darkmode)
        binding.NotificationTvSetting.text = resource.getString(R.string.notification)
        binding.SummaryTv.text = resource.getString(R.string.summary)
        binding.LocationTvSetting.text = resource.getString(R.string.news_by_location)
        binding.TimeTvSetting.text = resource.getString(R.string.time_to_read)
        binding.BlockTvSetting.text = resource.getString(R.string.block_content_and_sources)
        binding.HelpTvSetting.text = resource.getString(R.string.help)
        binding.searchTvSetting.text = resource.getString(R.string.search)
    }

    private fun showRussianText() {
        val context = LocalHelper().setLocale(requireContext(), "ru")
        val resource = context.resources
        binding.LanguageTvSetting.text = resource.getString(R.string.language)
        (activity as AppCompatActivity).supportActionBar?.title =
            resource.getString(R.string.app_name)
        binding.EditBtnSetting.text = resource.getString(R.string.edit)
        binding.PreferencesTv.text = resource.getString(R.string.preferences)
        binding.DarkModeTvSetting.text = resource.getString(R.string.darkmode)
        binding.NotificationTvSetting.text = resource.getString(R.string.notification)
        binding.SummaryTv.text = resource.getString(R.string.summary)
        binding.LocationTvSetting.text = resource.getString(R.string.news_by_location)
        binding.TimeTvSetting.text = resource.getString(R.string.time_to_read)
        binding.BlockTvSetting.text = resource.getString(R.string.block_content_and_sources)
        binding.HelpTvSetting.text = resource.getString(R.string.help)
        binding.searchTvSetting.text = resource.getString(R.string.search)
    }

}