package com.geektech.domain.usecases

import com.geektech.domain.repositories.TopHeadlinesRepository
import javax.inject.Inject

class SearchNewsUseCases @Inject constructor(private val repository: TopHeadlinesRepository) {

    operator fun invoke(q: String) = repository.searchNews(q)
}