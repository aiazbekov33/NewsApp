package com.geektech.newsapp.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader("apiKey", "&apiKey=0ef15f73c03b4ca0a19a25cbdf3c43d2")
            .build()
        return chain.proceed(request)
    }
}