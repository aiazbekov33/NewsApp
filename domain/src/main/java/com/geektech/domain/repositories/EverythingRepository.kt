package com.geektech.domain.repositories

import com.geektech.domain.common.Resource
import com.geektech.domain.models.TopHeadlinesModel
import kotlinx.coroutines.flow.Flow

interface EverythingRepository {
    fun fetchEverything(page: Int): Flow<Resource<List<TopHeadlinesModel>>>

    fun fetchEverything2(page: Int): Flow<Resource<List<TopHeadlinesModel>>>

}