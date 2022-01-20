package com.geektech.newsapp.presentation.models

import com.geektech.newsapp.presentation.base.IBaseDiffModel
import com.geektech.newsapp.domain.models.SourcesModel

data class SourcesUI(

    val id: String?,
    val name: String?,
    val description: String?,
    override val url: String?,
    val category: String?,
    val language: String?,
    val country: String?
) : IBaseDiffModel

fun SourcesModel.toUI() = SourcesUI(
    id,
    name,
    description,
    url,
    category,
    language,
    country
)
