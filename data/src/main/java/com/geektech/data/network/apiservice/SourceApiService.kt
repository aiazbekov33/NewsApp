package com.geektech.data.network.apiservice

import com.geektech.data.modelsdto.NewsResponseDto
import com.geektech.data.modelsdto.SourcesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SourceApiService {
    @GET("/v2/top-headlines/sources?apiKey=0ef15f73c03b4ca0a19a25cbdf3c43d2")
    suspend fun fetchSources(
        @Query("country") query: String,
        @Query("page") page: Int
    ): NewsResponseDto<SourcesDto>
}