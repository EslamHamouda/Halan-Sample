package com.android.consumerfinancehalan.data.repo

import com.android.consumerfinancehalan.data.service.ApiService
import com.android.consumerfinancehalan.domain.repo.DetailsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailsRepositoryImpl @Inject constructor(service: ApiService): DetailsRepository {
}