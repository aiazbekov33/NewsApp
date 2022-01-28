package com.geektech.data.network.apiservice

import com.geektech.data.modelsdto.NewsResponseDto
import com.geektech.data.modelsdto.SourcesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SourceApiService {
    @GET("/v2/top-headlines/sources?apiKey=c08ab6a617d0486d8677c0ba7bcb18bc")
    suspend fun fetchSources(
        @Query("country") query: String,
        @Query("page") page: Int
    ): NewsResponseDto<SourcesDto>
}