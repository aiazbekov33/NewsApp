package com.geektech.newsapp.domain.usecases

import com.geektech.newsapp.domain.repository.TopHeadlinesRepository
import javax.inject.Inject

class SearchNewsUseCases @Inject constructor(private val repository: TopHeadlinesRepository) {

    operator fun invoke(q: String) = repository.searchNews(q)
}