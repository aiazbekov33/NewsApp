package com.geektech.newsapp.data.network.apiservice

import com.geektech.newsapp.data.dtos.modelsDto.NewsResponseDto
import com.geektech.newsapp.data.dtos.modelsDto.TopHeadlinesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadlinesApiService {

    @GET("/v2/top-headlines?apiKey=0ef15f73c03b4ca0a19a25cbdf3c43d2")
    suspend fun fetchTopHeadlines(
        @Query("country") query: String,
        @Query("page") page: Int
    ): NewsResponseDto<TopHeadlinesDto>
}