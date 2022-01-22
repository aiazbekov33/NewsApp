package com.geektech.newsapp.data.dtos.modelsdto

import com.geektech.newsapp.domain.models.SourceModel
import com.google.gson.annotations.SerializedName

data class SourceDto(
    @SerializedName("id") var id: String?,
    @SerializedName("name") var name: String
)

fun SourceDto.toDomain() = SourceModel(
    id,
    name
)
