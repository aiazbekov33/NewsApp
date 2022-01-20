package com.geektech.newsapp.presentation.ui.fragments.topheadlines

import com.geektech.newsapp.domain.usecases.FetchTopHeadlinesUseCases
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
class TopHeadlinesViewModel @Inject constructor(
    private val fetchTopHeadlinesUseCases: FetchTopHeadlinesUseCases
) : BaseViewModel(),BaseRequest {

    private val _topHeadlinesState =
        MutableStateFlow<UIState<List<TopHeadlinesUI>>>(UIState.Loading())
    val topHeadlinesState: StateFlow<UIState<List<TopHeadlinesUI>>> = _topHeadlinesState
    override var page: Int = 1

    init {
        fetchNewsApp(1)
    }
    override fun fetchNewsApp(page: Int) {
        _topHeadlinesState.subscribeTo(
            { fetchTopHeadlinesUseCases(page) },
            { it.map { data -> data.toUI() } })
    }
}


