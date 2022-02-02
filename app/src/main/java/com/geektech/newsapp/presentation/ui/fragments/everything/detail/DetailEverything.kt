package com.geektech.newsapp.presentation.ui.fragments.everything.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.geektech.newsapp.R
import com.geektech.newsapp.databinding.FragmentDetailEverythingBinding


class DetailEverything : Fragment(R.layout.fragment_detail_everything) {

    private val binding: FragmentDetailEverythingBinding by viewBinding(FragmentDetailEverythingBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        val model = DetailEverythingArgs.fromBundle(requireArguments()).model
        binding.image.load(model.urlToImage)
        binding.title.text = model.title
        binding.author.text = model.author
        binding.date.text = model.publishedAt
        binding.description.text = model.description

    }

}
