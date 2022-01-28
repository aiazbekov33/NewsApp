package com.geektech.newsapp.extensions

import androidx.recyclerview.widget.RecyclerView
import com.geektech.newsapp.base.BaseRequest

fun RecyclerView.scrollListenNextPage(viewModel: BaseRequest) {
    this.addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                viewModel.page++
                viewModel.fetchNewsApp(viewModel.page)
            }
        }
    })

}