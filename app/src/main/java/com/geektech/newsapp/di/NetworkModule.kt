package com.geektech.newsapp.di

import com.geektech.data.network.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofit: RetrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideEverythingApiService() = retrofit.provideEverythingApiService()

    @Singleton
    @Provides
    fun provideTopHeadlinesApiService() = retrofit.provideTopHeadlinesApiService()

    @Singleton
    @Provides
    fun provideSourcesApiService() = retrofit.provideSourcesApiService()
}