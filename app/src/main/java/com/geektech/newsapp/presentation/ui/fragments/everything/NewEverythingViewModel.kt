package com.geektech.newsapp.presentation.ui.fragments.everything

import com.geektech.newsapp.domain.usecases.FetchEverythingUseCases
import com.geektech.newsapp.presentation.base.BaseRequest
import com.geektech.newsapp.presentation.base.BaseViewModel
import com.geektech.newsapp.presentation.models.TopHeadlinesUI
import com.geektech.newsapp.presentation.models.toUI
import com.geektech.newsapp.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class NewEverythingViewModel @Inject constructor(
    private val fetchEverythingUseCases: FetchEverythingUseCases
) : BaseViewModel(), BaseRequest {

    private val _everythingState =
        MutableStateFlow<UIState<List<TopHeadlinesUI>>>(UIState.Loading())
    val everythingState: StateFlow<UIState<List<TopHeadlinesUI>>> = _everythingState
    override var page: Int = 1

    init {
        fetchNewsApp(1)
    }

    override fun fetchNewsApp(page: Int) {
        _everythingState.subscribeTo(
            { fetchEverythingUseCases(page) },
            { it.map { data -> data.toUI() } })
    }


}