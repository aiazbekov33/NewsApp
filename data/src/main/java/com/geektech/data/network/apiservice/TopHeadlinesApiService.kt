package com.geektech.data.network.apiservice

import com.geektech.data.modelsdto.NewsResponseDto
import com.geektech.data.modelsdto.TopHeadlinesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadlinesApiService {

    @GET("/v2/top-headlines?apiKey=0ef15f73c03b4ca0a19a25cbdf3c43d2")
    suspend fun fetchTopHeadlines(
        @Query("country") query: String,
        @Query("page") page: Int
    ): NewsResponseDto<TopHeadlinesDto>

    @GET("/v2/top-headlines?apiKey=0ef15f73c03b4ca0a19a25cbdf3c43d2")
    suspend fun searchTopHeadlines(
        @Query("q") q: String
    ): NewsResponseDto<TopHeadlinesDto>
}