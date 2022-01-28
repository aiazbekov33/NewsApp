package com.geektech.newsapp.di

import com.geektech.data.repository.EverythingRepositoryImpl
import com.geektech.data.repository.SourcesRepositoryImpl
import com.geektech.data.repository.TopHeadlinesRepositoryImpl
import com.geektech.domain.repositories.EverythingRepository
import com.geektech.domain.repositories.SourcesRepository
import com.geektech.domain.repositories.TopHeadlinesRepository
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
