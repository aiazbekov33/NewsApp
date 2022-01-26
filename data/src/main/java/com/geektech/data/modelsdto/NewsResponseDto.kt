package com.geektech.data.modelsdto

import com.google.gson.annotations.SerializedName

data class NewsResponseDto<T>(

    @SerializedName("status") val status: String,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("articles") val articles: List<T>,
    @SerializedName("sources") val sources: List<T>

)




