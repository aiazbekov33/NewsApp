package com.geektech.newsapp.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geektech.domain.common.Resource
import com.geektech.newsapp.presentation.state.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <T, S> MutableStateFlow<UIState<S>>.subscribeTo(
        request: () -> Flow<Resource<T>>,
        mappedData: (T) -> S,
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            request().collect {
                when (it) {
                    is Resource.Loading -> {
                        this@subscribeTo.value = UIState.Loading()
                    }
                    is Resource.Error -> it.message?.let { error ->
                        this@subscribeTo.value = UIState.Error(error)
                    }
                    is Resource.Success -> it.data?.let { data ->
                        this@subscribeTo.value = UIState.Success(mappedData(data))
                    }
                }
            }
        }
    }

}