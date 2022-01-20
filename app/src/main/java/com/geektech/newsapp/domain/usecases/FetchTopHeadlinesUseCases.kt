package com.geektech.newsapp.domain.usecases

import com.geektech.newsapp.domain.repository.TopHeadlinesRepository
import javax.inject.Inject

class FetchTopHeadlinesUseCases @Inject constructor(
    private val repository: TopHeadlinesRepository
) {
    operator fun invoke(page:Int) = repository.fetchTopHeadlines(page)

}