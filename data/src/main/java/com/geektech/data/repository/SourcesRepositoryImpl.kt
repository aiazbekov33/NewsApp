package com.geektech.data.repository

import com.geektech.data.modelsdto.toDomain
import com.geektech.data.network.apiservice.SourceApiService
import com.geektech.data.repository.base.BaseRepository
import com.geektech.domain.common.Resource
import com.geektech.domain.models.SourcesModel
import com.geektech.domain.repositories.SourcesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SourcesRepositoryImpl @Inject constructor(
    private val service: SourceApiService
) :
    BaseRepository(), SourcesRepository {

    override fun fetchSources(page: Int): Flow<Resource<List<SourcesModel>>> = doRequest {
        service.fetchSources("us", page).sources.map { it.toDomain() }
    }
}