package com.geektech.domain.models


data class TopHeadlinesModel(
    val source: SourceModel,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)

