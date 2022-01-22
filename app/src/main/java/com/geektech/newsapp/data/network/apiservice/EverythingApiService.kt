package com.geektech.newsapp.data.network.apiservice

import com.geektech.newsapp.data.dtos.modelsdto.NewsResponseDto
import com.geektech.newsapp.data.dtos.modelsdto.TopHeadlinesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface EverythingApiService {

    @GET("/v2/everything?apiKey=8d897801c99d40dda2e5bdd665453eeb")
    suspend fun fetchEverything(
        @Query("q") query: String,
        @Query("page") page: Int,
    ): NewsResponseDto<TopHeadlinesDto>
}