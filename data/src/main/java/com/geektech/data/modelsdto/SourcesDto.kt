package com.geektech.data.modelsdto

import com.geektech.domain.models.SourcesModel
import com.google.gson.annotations.SerializedName

data class SourcesDto(
    @SerializedName("id")
    val id: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("url")
    val url: String?,

    @SerializedName("category")
    val category: String?,

    @SerializedName("language")
    val language: String?,

    @SerializedName("country")
    val country: String?
)

fun SourcesDto.toDomain() = SourcesModel(
    id,
    name,
    description,
    url,
    category,
    language,
    country
)
