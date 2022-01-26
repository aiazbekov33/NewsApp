package com.geektech.newsapp.presentation.models


import com.geektech.domain.models.TopHeadlinesModel
import com.geektech.newsapp.base.IBaseDiffModel
import java.io.Serializable

data class TopHeadlinesUI(
    val source: SourceUI,
    val author: String?,
    val title: String?,
    val description: String?,
    override val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
) : IBaseDiffModel,Serializable

fun TopHeadlinesModel.toUI() = TopHeadlinesUI(
    source.toUi(),
    author,
    title,
    description,
    url,
    urlToImage,
    publishedAt,
    content
)
