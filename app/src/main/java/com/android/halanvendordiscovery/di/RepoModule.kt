package com.android.halanvendordiscovery.di

import com.android.consumerfinancehalan.data.remote.service.VendorsService
import com.android.consumerfinancehalan.data.repo.VendorsRepositoryImpl
import com.android.halanvendordiscovery.data.details.repo.DetailsRepositoryImpl
import com.android.halanvendordiscovery.data.details.service.DetailsService
import com.android.halanvendordiscovery.domain.details.repo.DetailsRepository
import com.android.halanvendordiscovery.domain.vendors.repo.VendorRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun provideDetailsRepository(service: DetailsService): DetailsRepository {
        return DetailsRepositoryImpl(service)
    }

    @Provides
    fun provideVendorRepository(service: VendorsService): VendorRepository {
        return VendorsRepositoryImpl(service)
    }
}