package com.geektech.domain.usecases

import com.geektech.domain.repositories.EverythingRepository
import javax.inject.Inject

class FetchEverythingUseCases @Inject constructor(
    private val repository: EverythingRepository
) {

    operator fun invoke(page: Int) = repository.fetchEverything(page)
}