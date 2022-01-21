package com.geektech.newsapp.domain.repository

import com.geektech.newsapp.common.Resource
import com.geektech.newsapp.domain.models.SourcesModel
import kotlinx.coroutines.flow.Flow

interface SourcesRepository {
    fun fetchSources(page:Int): Flow<Resource<List<SourcesModel>>>
}