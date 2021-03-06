package com.geektech.newsapp.presentation.ui.fragments.everything

import com.geektech.domain.usecases.FetchEveryThingUseCases2
import com.geektech.domain.usecases.FetchEverythingUseCases
import com.geektech.newsapp.base.BaseRequest
import com.geektech.newsapp.base.BaseViewModel
import com.geektech.newsapp.presentation.models.TopHeadlinesUI
import com.geektech.newsapp.presentation.models.toUI
import com.geektech.newsapp.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class NewEverythingViewModel @Inject constructor(
    private val fetchEverythingUseCases: FetchEverythingUseCases,
    private val fetchEverythingUseCases2: FetchEveryThingUseCases2
) : BaseViewModel(), BaseRequest {

    private val _everythingState =
        MutableStateFlow<UIState<List<TopHeadlinesUI>>>(UIState.Loading())
    val everythingState: StateFlow<UIState<List<TopHeadlinesUI>>> = _everythingState

    private val _everythingState2 =
        MutableStateFlow<UIState<List<TopHeadlinesUI>>>(UIState.Loading())
    val everythingState2: StateFlow<UIState<List<TopHeadlinesUI>>> = _everythingState2
    override var page: Int = 1
    override var q: String
        get() = TODO("Not yet implemented")
        set(value) {}

    init {
        fetchNewsApp(1)
        fetchNewsApp2(1)
    }

    override fun fetchNewsApp(page: Int) {
        _everythingState.subscribeTo(
            { fetchEverythingUseCases(page) },
            { it.map { data -> data.toUI() } })
    }

    override fun fetchNewsApp2(page: Int) {
        _everythingState2.subscribeTo(
            { fetchEverythingUseCases2(page) }, { it.map { data -> data.toUI() } }
        )
    }

    override fun searchNews(q: String) {
        TODO("Not yet implemented")
    }
}