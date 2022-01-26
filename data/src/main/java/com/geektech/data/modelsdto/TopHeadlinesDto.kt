package com.geektech.data.modelsdto

import com.geektech.domain.models.TopHeadlinesModel
import com.google.gson.annotations.SerializedName

data class TopHeadlinesDto(
    @SerializedName("source") val source: SourceDto,
    @SerializedName("author") val author: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("url") val url: String?,
    @SerializedName("urlToImage") val urlToImage: String?,
    @SerializedName("publishedAt") val publishedAt: String?,
    @SerializedName("content") val content: String?
)

fun TopHeadlinesDto.toDomain() = TopHeadlinesModel(
    source.toDomain(),
    author,
    title,
    description,
    url,
    urlToImage,
    publishedAt,
    content
)
