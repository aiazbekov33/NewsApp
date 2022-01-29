package com.geektech.data.network.apiservice

import com.geektech.data.modelsdto.NewsResponseDto
import com.geektech.data.modelsdto.TopHeadlinesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface EverythingApiService {

    @GET("/v2/everything?apiKey=8d897801c99d40dda2e5bdd665453eeb")
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

    @GET("/v2/everything?apiKey=8d897801c99d40dda2e5bdd665453eeb")
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