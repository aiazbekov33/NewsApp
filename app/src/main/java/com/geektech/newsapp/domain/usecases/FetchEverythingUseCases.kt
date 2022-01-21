package com.geektech.newsapp.domain.usecases

import com.geektech.newsapp.domain.repository.EverythingRepository
import javax.inject.Inject

class FetchEverythingUseCases @Inject constructor(
    private val repository: EverythingRepository
) {

    operator fun invoke(page: Int) = repository.fetchEverything(page)
}