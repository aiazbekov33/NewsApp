package com.geektech.newsapp.data.network.apiservice

import com.geektech.newsapp.data.dtos.modelsDto.NewsResponseDto
import com.geektech.newsapp.data.dtos.modelsDto.SourcesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SourceApiService {
    @GET("/v2/top-headlines/sources?apiKey=0ef15f73c03b4ca0a19a25cbdf3c43d2")
    suspend fun fetchSources(
        @Query("country") query: String,
        @Query("page") page: Int
    ): NewsResponseDto<SourcesDto>
}