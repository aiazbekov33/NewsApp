package com.geektech.newsapp.domain.models

import com.geektech.newsapp.presentation.base.IBaseDiffModel

data class TopHeadlinesModel(
    val source: SourceModel,
    val author: String?,
    val title: String?,
    val description: String?,
    override val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
): IBaseDiffModel

