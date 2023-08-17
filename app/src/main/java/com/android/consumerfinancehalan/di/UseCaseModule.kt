package com.android.consumerfinancehalan.di

import com.android.consumerfinancehalan.domain.repo.DetailsRepository
import com.android.consumerfinancehalan.domain.useCase.GetMerchantsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetMerchantsUseCase(repository: DetailsRepository): GetMerchantsUseCase {
        return GetMerchantsUseCase(repository)
    }
}