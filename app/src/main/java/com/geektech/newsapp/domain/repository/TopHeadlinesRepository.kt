package com.geektech.newsapp.domain.repository

import com.geektech.newsapp.common.Resource
import com.geektech.newsapp.domain.models.TopHeadlinesModel
import kotlinx.coroutines.flow.Flow

interface TopHeadlinesRepository {
    fun fetchTopHeadlines(page:Int): Flow<Resource<List<TopHeadlinesModel>>>
}