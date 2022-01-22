package com.geektech.newsapp.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader("apiKey", "&apiKey=8d897801c99d40dda2e5bdd665453eeb")
            .build()
        return chain.proceed(request)
    }
}