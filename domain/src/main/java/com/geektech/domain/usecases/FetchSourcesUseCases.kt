package com.geektech.domain.usecases

import com.geektech.domain.repositories.SourcesRepository
import javax.inject.Inject

class FetchSourcesUseCases @Inject constructor(
    private val repository: SourcesRepository
) {

    operator fun invoke(page:Int) = repository.fetchSources(page)
}