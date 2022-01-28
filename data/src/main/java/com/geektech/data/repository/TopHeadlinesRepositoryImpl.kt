package com.geektech.data.repository

import com.geektech.data.modelsdto.toDomain
import com.geektech.data.network.apiservice.TopHeadlinesApiService
import com.geektech.data.repository.base.BaseRepository
import com.geektech.domain.common.Resource
import com.geektech.domain.models.TopHeadlinesModel
import com.geektech.domain.repositories.TopHeadlinesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TopHeadlinesRepositoryImpl @Inject constructor(
    private val service: TopHeadlinesApiService
) : BaseRepository(), TopHeadlinesRepository {

    override fun fetchTopHeadlines(page: Int): Flow<Resource<List<TopHeadlinesModel>>> = doRequest {
        service.fetchTopHeadlines("us", page).articles.map { it.toDomain() }
    }

    override fun searchNews(q: String): Flow<Resource<List<TopHeadlinesModel>>> = doRequest {
        service.searchTopHeadlines(q).articles.map { it.toDomain() }
    }
}
