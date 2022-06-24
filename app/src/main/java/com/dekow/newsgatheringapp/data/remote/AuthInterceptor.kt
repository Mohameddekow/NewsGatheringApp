package com.dekow.newsgatheringapp.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("api-key", "05f35298-d1c4-471a-8f7f-cc379945384a")
            .build()

        return chain.proceed(request)
    }
}