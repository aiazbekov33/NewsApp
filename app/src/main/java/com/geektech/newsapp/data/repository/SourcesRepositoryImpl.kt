package com.geektech.newsapp.data.repository

import com.geektech.newsapp.data.repository.base.BaseRepository
import com.geektech.newsapp.common.Resource
import com.geektech.newsapp.data.dtos.modelsdto.toDomain
import com.geektech.newsapp.data.network.apiservice.SourceApiService
import com.geektech.newsapp.domain.models.SourcesModel
import com.geektech.newsapp.domain.repository.SourcesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SourcesRepositoryImpl @Inject constructor(
    private val service: SourceApiService
) :
    BaseRepository(), SourcesRepository {

    override fun fetchSources(page:Int): Flow<Resource<List<SourcesModel>>> = doRequest {
        service.fetchSources("us", 1).sources.map { it.toDomain() }
    }
}