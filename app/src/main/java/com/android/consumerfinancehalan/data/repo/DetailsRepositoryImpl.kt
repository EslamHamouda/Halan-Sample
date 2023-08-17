package com.android.consumerfinancehalan.data.repo

import com.android.consumerfinancehalan.data.service.ApiService
import com.android.consumerfinancehalan.domain.repo.DetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailsRepositoryImpl @Inject constructor(private val service: ApiService): DetailsRepository {
    override suspend fun getMerchants(vendorId: String) =
        withContext(Dispatchers.IO) {
            service.getMerchants(vendorId)
        }
}