package com.geektech.domain.repositories

import com.geektech.domain.common.Resource
import com.geektech.domain.models.SourcesModel
import kotlinx.coroutines.flow.Flow

interface SourcesRepository {
    fun fetchSources(page: Int): Flow<Resource<List<SourcesModel>>>
}