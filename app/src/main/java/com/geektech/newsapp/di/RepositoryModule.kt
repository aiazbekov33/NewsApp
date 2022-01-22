package com.geektech.newsapp.di

import com.geektech.newsapp.data.repository.EverythingRepositoryImpl
import com.geektech.newsapp.data.repository.SourcesRepositoryImpl
import com.geektech.newsapp.data.repository.TopHeadlinesRepositoryImpl
import com.geektech.newsapp.domain.repository.EverythingRepository
import com.geektech.newsapp.domain.repository.SourcesRepository
import com.geektech.newsapp.domain.repository.TopHeadlinesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn((SingletonComponent::class))
abstract class RepositoryModule {

    @Binds
    abstract fun provideEverythingRepository(
        everythingRepositoryImpl: EverythingRepositoryImpl
    ): EverythingRepository

    @Binds
    abstract fun provideTopHeadlinesRepository(
        topHeadlinesRepositoryImpl: TopHeadlinesRepositoryImpl
    ): TopHeadlinesRepository

    @Binds
    abstract fun provideSourcesRepository(sourcesRepositoryImpl: SourcesRepositoryImpl
    ): SourcesRepository
}
