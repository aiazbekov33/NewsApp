package com.geektech.newsapp.base

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toolbar
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.geektech.newsapp.presentation.state.UIState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

abstract class BaseFragment<Binding : ViewBinding, ViewModel : BaseViewModel>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    protected abstract val binding: Binding
    protected abstract val viewModel: ViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
        setupRequests()
        checkRecycler()
        setupObserves()
        setupDarkNight()
        setupLanguage()
        mySearchView()
    }

    open fun checkRecycler(){}

    open fun mySearchView() {
    }

    open fun initialize() {
    }


    open fun setupListeners() {
    }

    open fun setupRequests() {
    }

    open fun setupObserves() {
    }

    open fun swipeRefresh() {

    }

    open fun setupDarkNight() {

    }

    open fun setupLanguage() {
    }

    protected fun <T> StateFlow<UIState<T>>.subscribe(
        state: Lifecycle.State = Lifecycle.State.STARTED,
        action: (UIState<T>) -> Unit,
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(state) {
                this@subscribe.collectLatest {
                    action(it)
                }
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.e("TAG", "onStart: " )
    }

    override fun onResume() {
        super.onResume()
        Log.e("TAG", "onResume: " )
    }

    override fun onPause() {
        super.onPause()
        Log.e("TAG", "onPause: " )
    }

    override fun onStop() {
        super.onStop()
        Log.e("TAG", "onStop: " )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("TAG", "onDestroyView: " )

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "onDestroy: " )
    }
}