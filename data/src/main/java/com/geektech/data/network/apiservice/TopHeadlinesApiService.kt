package com.geektech.data.network.apiservice

import com.geektech.data.modelsdto.NewsResponseDto
import com.geektech.data.modelsdto.TopHeadlinesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadlinesApiService {

    @GET("/v2/top-headlines?apiKey=8d897801c99d40dda2e5bdd665453eeb")
    suspend fun fetchTopHeadlines(
        @Query("country") query: String,
        @Query("page") page: Int
    ): NewsResponseDto<TopHeadlinesDto>

    @GET("/v2/top-headlines?apiKey=8d897801c99d40dda2e5bdd665453eeb")
    suspend fun searchTopHeadlines(
        @Query("q") q: String
    ): NewsResponseDto<TopHeadlinesDto>
}