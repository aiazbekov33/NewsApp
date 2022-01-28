package com.geektech.domain.usecases

import com.geektech.domain.repositories.TopHeadlinesRepository
import javax.inject.Inject

class FetchTopHeadlinesUseCases @Inject constructor(
    private val repository: TopHeadlinesRepository
) {
    operator fun invoke(page:Int) = repository.fetchTopHeadlines(page)

}