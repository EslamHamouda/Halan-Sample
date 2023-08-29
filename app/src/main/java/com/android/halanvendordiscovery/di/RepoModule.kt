package com.android.halanvendordiscovery.di

import com.android.halanvendordiscovery.data.details.repo.DetailsRepositoryImpl
import com.android.halanvendordiscovery.data.details.service.DetailsService
import com.android.halanvendordiscovery.domain.details.repo.DetailsRepository
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
}