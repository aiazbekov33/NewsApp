package com.geektech.newsapp.data.network.apiservice

import com.geektech.newsapp.data.dtos.modelsdto.NewsResponseDto
import com.geektech.newsapp.data.dtos.modelsdto.TopHeadlinesDto
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Qualifier

interface EverythingApiService {

    @GET("/v2/everything?apiKey=4633cbf21ce74b59850d9c56f1cbc60f")
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

    @GET("/v2/everything?apiKey=4633cbf21ce74b59850d9c56f1cbc60f")
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