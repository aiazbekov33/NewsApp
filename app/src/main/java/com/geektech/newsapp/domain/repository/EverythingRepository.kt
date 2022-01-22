package com.geektech.newsapp.domain.repository

import com.geektech.newsapp.common.Resource
import com.geektech.newsapp.domain.models.TopHeadlinesModel
import kotlinx.coroutines.flow.Flow

interface EverythingRepository {
    fun fetchEverything(page:Int): Flow<Resource<List<TopHeadlinesModel>>>

    fun fetchEverything2(page:Int): Flow<Resource<List<TopHeadlinesModel>>>

}