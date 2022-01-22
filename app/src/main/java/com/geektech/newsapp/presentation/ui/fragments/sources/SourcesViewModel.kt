package com.geektech.newsapp.presentation.ui.fragments.sources

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.geektech.newsapp.presentation.base.BaseViewModel
import com.geektech.newsapp.domain.models.SourcesModel
import com.geektech.newsapp.domain.usecases.FetchSourcesUseCases
import com.geektech.newsapp.presentation.base.BaseRequest
import com.geektech.newsapp.presentation.models.SourcesUI
import com.geektech.newsapp.presentation.models.toUI
import com.geektech.newsapp.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SourcesViewModel @Inject constructor(
    private val sourcesUseCases: FetchSourcesUseCases
) : BaseViewModel(),BaseRequest {

    private val _sourcesState = MutableStateFlow<UIState<List<SourcesUI>>>(UIState.Loading())
    val sourcesState: StateFlow<UIState<List<SourcesUI>>> = _sourcesState
    override var page: Int = 1
    override var q: String
        get() = TODO("Not yet implemented")
        set(value) {}

    init {
        fetchNewsApp(1)
    }

    override fun fetchNewsApp(page: Int) {
        _sourcesState.subscribeTo(
            { sourcesUseCases(page) },
            { it.map { data -> data.toUI() } }
        )
    }

    override fun searchNews(q: String) {
        TODO("Not yet implemented")
    }

}
