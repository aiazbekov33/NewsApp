package com.geektech.data.network.apiservice

import com.geektech.data.modelsdto.NewsResponseDto
import com.geektech.data.modelsdto.SourcesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SourceApiService {
    @GET("/v2/top-headlines/sources?apiKey=8d897801c99d40dda2e5bdd665453eeb")
    suspend fun fetchSources(
        @Query("country") query: String,
        @Query("page") page: Int
    ): NewsResponseDto<SourcesDto>
}