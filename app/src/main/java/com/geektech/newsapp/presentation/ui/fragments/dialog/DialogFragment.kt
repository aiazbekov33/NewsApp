package com.geektech.newsapp.presentation.ui.fragments.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.geektech.newsapp.databinding.FragmentDialogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DialogFragment : DialogFragment() {
//    private var _binding: FragmentDialogBinding? = null
    private lateinit var binding: FragmentDialogBinding
//    private val binding get() = _binding!!
    private val args: DialogFragmentArgs by navArgs()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = FragmentDialogBinding.inflate(LayoutInflater.from(context))
        val builder = AlertDialog.Builder(activity)
            .setView(binding.root)
            .create()
        builder.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setupArgs()
        return builder
    }

    private fun setupArgs() {
        Log.e("image", args.image)
        Glide.with(binding.dialogIv)
            .load(args.image)
            .into(binding.dialogIv)
    }
}