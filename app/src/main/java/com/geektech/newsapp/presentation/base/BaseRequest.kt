package com.geektech.newsapp.presentation.base

interface BaseRequest {
    var page: Int
    var q: String
    fun fetchNewsApp(page: Int)
    fun searchNews(q: String)
}