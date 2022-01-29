package com.geektech.newsapp.presentation.models


import android.os.Parcelable
import com.geektech.domain.models.TopHeadlinesModel
import com.geektech.newsapp.base.IBaseDiffModel
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
@Parcelize
data class TopHeadlinesUI(
    val source: SourceUI,
    val author: String?,
    val title: String?,
    val description: String?,
    override val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
) : IBaseDiffModel,Parcelable

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
