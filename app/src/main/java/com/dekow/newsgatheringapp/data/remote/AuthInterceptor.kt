package com.dekow.newsgatheringapp.data.remote

import com.dekow.newsgatheringapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(): Interceptor {

    private val guardiansApiKey: String = BuildConfig.GUARDIANS_API_KEY //get the key from the gradle


    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("api-key", guardiansApiKey)
            .build()

        return chain.proceed(request)
    }
}