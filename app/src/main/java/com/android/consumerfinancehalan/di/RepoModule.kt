package com.android.consumerfinancehalan.di

import com.android.consumerfinancehalan.data.repo.DetailsRepositoryImpl
import com.android.consumerfinancehalan.data.repo.SearchRepositoryImpl
import com.android.consumerfinancehalan.data.service.ApiService
import com.android.consumerfinancehalan.domain.repo.DetailsRepository
import com.android.consumerfinancehalan.domain.repo.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun provideSearchRepository(service: ApiService): SearchRepository {
        return SearchRepositoryImpl(service)
    }
    @Provides
    fun provideDetailsRepository(service: ApiService): DetailsRepository {
        return DetailsRepositoryImpl(service)
    }
}