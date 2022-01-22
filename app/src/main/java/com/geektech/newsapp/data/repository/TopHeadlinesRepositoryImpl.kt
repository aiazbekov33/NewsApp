package com.geektech.newsapp.data.repository

import com.geektech.newsapp.data.dtos.modelsdto.toDomain
import com.geektech.newsapp.data.network.apiservice.TopHeadlinesApiService
import com.geektech.newsapp.data.repository.base.BaseRepository
import com.geektech.newsapp.common.Resource
import com.geektech.newsapp.domain.models.TopHeadlinesModel
import com.geektech.newsapp.domain.repository.TopHeadlinesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TopHeadlinesRepositoryImpl @Inject constructor(
    private val service: TopHeadlinesApiService
) : BaseRepository(), TopHeadlinesRepository {

    override fun fetchTopHeadlines(page:Int):Flow<Resource<List<TopHeadlinesModel>>> = doRequest {
        service.fetchTopHeadlines("us", page).articles.map { it.toDomain() }
    }

    override fun searchNews(q: String): Flow<Resource<List<TopHeadlinesModel>>> = doRequest {
        service.searchTopHeadlines(q).articles.map { it.toDomain() }
    }
}
