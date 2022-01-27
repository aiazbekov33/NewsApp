package com.geektech.data.network.apiservice

import com.geektech.data.modelsdto.NewsResponseDto
import com.geektech.data.modelsdto.SourcesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SourceApiService {
    @GET("/v2/top-headlines/sources?apiKey=4633cbf21ce74b59850d9c56f1cbc60f")
    suspend fun fetchSources(
        @Query("country") query: String,
        @Query("page") page: Int
    ): NewsResponseDto<SourcesDto>
}