package com.geektech.newsapp.data.dtos.modelsDto

import com.geektech.newsapp.domain.models.SourcesModel
import com.geektech.newsapp.presentation.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class SourcesDto(
    @SerializedName("id")
    val id: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("url")
    override val url: String?,

    @SerializedName("category")
    val category: String?,

    @SerializedName("language")
    val language: String?,

    @SerializedName("country")
    val country: String?
) : IBaseDiffModel

fun SourcesDto.toDomain() = SourcesModel(
    id,
    name,
    description,
    url,
    category,
    language,
    country
)
