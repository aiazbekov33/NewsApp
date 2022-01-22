package com.geektech.newsapp.presentation.base

interface BaseRequest {
    var page: Int
    fun fetchNewsApp(page: Int)
}