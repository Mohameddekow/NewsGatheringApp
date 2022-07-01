package com.dekow.newsgatheringapp.data.di

import com.dekow.newsgatheringapp.commons.Constants.BASE_URL
import com.dekow.newsgatheringapp.BuildConfig
import com.dekow.newsgatheringapp.data.remote.AuthInterceptor
import com.dekow.newsgatheringapp.data.remote.GuardiansNewsApi
import com.dekow.newsgatheringapp.domain.repository.NewsRepository
import com.dekow.newsgatheringapp.domain.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    private val authInterceptor = OkHttpClient.Builder().apply {
        addInterceptor(AuthInterceptor())
    }.build()

    @Provides
    @Singleton
    fun provideGuardiansNewsApi(): GuardiansNewsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(authInterceptor)
            .build()
            .create(GuardiansNewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository( guardiansNewsApi: GuardiansNewsApi): NewsRepository{
        return NewsRepositoryImpl(guardiansNewsApi)
    }
}