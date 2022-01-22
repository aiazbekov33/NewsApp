package com.geektech.newsapp.domain.usecases

import com.geektech.newsapp.domain.repository.EverythingRepository
import javax.inject.Inject

class FetchEveryThingUseCases2 @Inject constructor(
    private val repository2: EverythingRepository
) {

    operator fun invoke(page: Int) = repository2.fetchEverything2(page)
}