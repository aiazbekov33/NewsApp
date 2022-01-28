package com.geektech.data.network.apiservice

import com.geektech.data.modelsdto.NewsResponseDto
import com.geektech.data.modelsdto.TopHeadlinesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface EverythingApiService {

    @GET("/v2/everything?apiKey=c08ab6a617d0486d8677c0ba7bcb18bc")
    suspend fun fetchEverything(
        @Query("q") query: String?,
        @Query("qinTitle") qinTitle: String?,
        @Query("domains") domains: String?,
        @Query("from") from: String?,
        @Query("to") to: String?,
        @Query("language") lang: String?,
        @Query("sortBy") sortBy: String?,
        @Query("page") page: Int,
    ): NewsResponseDto<TopHeadlinesDto>

    @GET("/v2/everything?apiKey=c08ab6a617d0486d8677c0ba7bcb18bc")
    suspend fun fetchEverything2(
        @Query("q") query: String?,
        @Query("qinTitle") qinTitle: String?,
        @Query("domains") domains: String?,
        @Query("from") from: String?,
        @Query("to") to: String?,
        @Query("language") lang: String?,
        @Query("sortBy") sortBy: String?,
        @Query("page") page: Int,
    ): NewsResponseDto<TopHeadlinesDto>
}