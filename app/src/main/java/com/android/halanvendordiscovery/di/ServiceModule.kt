package com.android.halanvendordiscovery.di

import com.android.consumerfinancehalan.data.remote.service.VendorsService
import com.android.halanvendordiscovery.data.details.service.DetailsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    fun detailsService(retrofit: Retrofit): DetailsService =
        retrofit.create(DetailsService::class.java)

    @Provides
    fun vendorsService(retrofit: Retrofit): VendorsService =
        retrofit.create(VendorsService::class.java)
}