package com.geektech.newsapp.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader("apiKey", "&apiKey=4633cbf21ce74b59850d9c56f1cbc60f")
            .build()
        return chain.proceed(request)
    }
}