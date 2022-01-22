package com.geektech.newsapp.data.network

import com.geektech.newsapp.constants.Constants
import com.geektech.newsapp.data.network.apiservice.EverythingApiService
import com.geektech.newsapp.data.network.apiservice.SourceApiService
import com.geektech.newsapp.data.network.apiservice.TopHeadlinesApiService
import com.geektech.newsapp.data.network.interceptor.ApiKeyInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient: OkHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(ApiKeyInterceptor())
        .addInterceptor(provideHttpLoggingInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor().setLevel(
        HttpLoggingInterceptor.Level.BODY
    )

    private val retrofitClient = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun provideTopHeadlinesApiService(): TopHeadlinesApiService = retrofitClient
        .create(TopHeadlinesApiService::class.java)

    fun provideEverythingApiService(): EverythingApiService = retrofitClient
        .create(EverythingApiService::class.java)

    fun provideSourcesApiService(): SourceApiService = retrofitClient
        .create(SourceApiService::class.java)


}