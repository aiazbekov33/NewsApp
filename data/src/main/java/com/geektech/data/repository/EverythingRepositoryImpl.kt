package com.geektech.data.repository

import com.geektech.data.modelsdto.toDomain
import com.geektech.data.network.apiservice.EverythingApiService
import com.geektech.data.repository.base.BaseRepository
import com.geektech.domain.repositories.EverythingRepository
import javax.inject.Inject

class EverythingRepositoryImpl @Inject constructor(
    private val service: EverythingApiService
) : BaseRepository(), EverythingRepository {

    override fun fetchEverything(page: Int) = doRequest {
        service.fetchEverything(
            "bitcoin",
            null,
            null,
            null,
            null,
            null,
            null, page
        ).articles.map { it.toDomain() }
    }

    override fun fetchEverything2(page: Int) = doRequest {
        service.fetchEverything2(
            "apple",
            null,
            null,
            null,
            null,
            null,
            null, page
        ).articles.map { it.toDomain() }
    }
}