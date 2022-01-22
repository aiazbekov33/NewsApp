package com.geektech.newsapp.presentation.ui.fragments.topheadlines

import androidx.lifecycle.viewModelScope
import com.geektech.newsapp.domain.usecases.FetchTopHeadlinesUseCases
import com.geektech.newsapp.domain.usecases.SearchNewsUseCases
import com.geektech.newsapp.presentation.base.BaseRequest
import com.geektech.newsapp.presentation.base.BaseViewModel
import com.geektech.newsapp.presentation.models.TopHeadlinesUI
import com.geektech.newsapp.presentation.models.toUI
import com.geektech.newsapp.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopHeadlinesViewModel @Inject constructor(
    private val fetchTopHeadlinesUseCases: FetchTopHeadlinesUseCases,
    private val searchNewsUseCases: SearchNewsUseCases
) : BaseViewModel(),BaseRequest {

    private val _topHeadlinesState =
        MutableStateFlow<UIState<List<TopHeadlinesUI>>>(UIState.Loading())
    val topHeadlinesState: StateFlow<UIState<List<TopHeadlinesUI>>> = _topHeadlinesState

    private val _searchNews = MutableStateFlow<UIState<List<TopHeadlinesUI>>>(UIState.Loading())
    val searchNews: StateFlow<UIState<List<TopHeadlinesUI>>> = _searchNews
    override var page: Int = 1
    override var q: String = ""

    init {
        fetchNewsApp(1)
    }
    override fun fetchNewsApp(page: Int) {
        _topHeadlinesState.subscribeTo(
            { fetchTopHeadlinesUseCases(page) },
            { it.map { data -> data.toUI() } })
    }

    override fun searchNews(q: String) {
        _searchNews.subscribeTo({
            searchNewsUseCases(q)
        },{it.map { data-> data.toUI() }})
    }

}


