package com.geektech.data.network.apiservice

import com.geektech.data.modelsdto.NewsResponseDto
import com.geektech.data.modelsdto.TopHeadlinesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadlinesApiService {

    @GET("/v2/top-headlines?apiKey=c08ab6a617d0486d8677c0ba7bcb18bc")
    suspend fun fetchTopHeadlines(
        @Query("country") query: String,
        @Query("page") page: Int
    ): NewsResponseDto<TopHeadlinesDto>

    @GET("/v2/top-headlines?apiKey=c08ab6a617d0486d8677c0ba7bcb18bc")
    suspend fun searchTopHeadlines(
        @Query("q") q: String
    ): NewsResponseDto<TopHeadlinesDto>
}