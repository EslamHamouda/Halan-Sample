package com.android.halanvendordiscovery.di

import com.android.halanvendordiscovery.data.details.service.DetailsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun detailsService(retrofit: Retrofit): DetailsService =
        retrofit.create(DetailsService::class.java)
}