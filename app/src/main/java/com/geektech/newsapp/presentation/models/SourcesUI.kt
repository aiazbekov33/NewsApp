package com.geektech.newsapp.presentation.models

import com.geektech.newsapp.base.IBaseDiffModel
import com.geektech.domain.models.SourcesModel

data class SourcesUI(

    val id: String?,
    val name: String?,
    val description: String?,
    override val url: String?,
    val category: String?,
    val language: String?,
    val country: String?
) : IBaseDiffModel

fun SourcesModel.toUi() = SourcesUI(
    id,
    name,
    description,
    url,
    category,
    language,
    country
)
