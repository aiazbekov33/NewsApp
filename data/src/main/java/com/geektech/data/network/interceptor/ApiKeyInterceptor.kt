package com.geektech.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader("apiKey", "&apiKey=c08ab6a617d0486d8677c0ba7bcb18bc")
            .build()
        return chain.proceed(request)
    }
}