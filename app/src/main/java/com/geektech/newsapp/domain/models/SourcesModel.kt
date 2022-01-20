package com.geektech.newsapp.domain.models

import com.geektech.newsapp.presentation.base.IBaseDiffModel

data class SourcesModel(
    val id: String?,
    val name: String?,
    val description: String?,
    override val url: String?,
    val category: String?,
    val language: String?,
    val country: String?
) : IBaseDiffModel

