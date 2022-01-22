package com.geektech.newsapp.domain.usecases

import com.geektech.newsapp.domain.repository.SourcesRepository
import javax.inject.Inject

class FetchSourcesUseCases @Inject constructor(
    private val repository: SourcesRepository
) {

    operator fun invoke(page:Int) = repository.fetchSources(page)
}