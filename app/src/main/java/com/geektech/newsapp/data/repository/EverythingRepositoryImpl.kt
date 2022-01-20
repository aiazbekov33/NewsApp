package com.geektech.newsapp.data.repository

import com.geektech.newsapp.data.repository.base.BaseRepository
import com.geektech.newsapp.common.Resource
import com.geektech.newsapp.data.dtos.modelsDto.toDomain
import com.geektech.newsapp.data.network.apiservice.EverythingApiService
import com.geektech.newsapp.domain.models.TopHeadlinesModel
import com.geektech.newsapp.domain.repository.EverythingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EverythingRepositoryImpl @Inject constructor(
    private val service: EverythingApiService
) : BaseRepository(), EverythingRepository {

    override fun fetchEverything(page:Int): Flow<Resource<List<TopHeadlinesModel>>> = doRequest {
            service.fetchEverything("bitcoin", page).articles.map { it.toDomain() }

    }
}