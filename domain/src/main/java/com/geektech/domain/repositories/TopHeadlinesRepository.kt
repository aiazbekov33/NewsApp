package com.geektech.domain.repositories

import com.geektech.domain.common.Resource
import com.geektech.domain.models.TopHeadlinesModel
import kotlinx.coroutines.flow.Flow

interface TopHeadlinesRepository {
    fun fetchTopHeadlines(page: Int): Flow<Resource<List<TopHeadlinesModel>>>

    fun searchNews(q: String): Flow<Resource<List<TopHeadlinesModel>>>
}