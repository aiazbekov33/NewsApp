package com.geektech.newsapp.base

interface BaseRequest {
    var page: Int
    var q: String
    fun fetchNewsApp(page: Int)
    fun fetchNewsApp2(page: Int)
    fun searchNews(q: String)
}