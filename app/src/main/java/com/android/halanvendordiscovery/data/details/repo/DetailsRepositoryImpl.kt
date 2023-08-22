package com.android.halanvendordiscovery.data.details.repo

import com.android.halanvendordiscovery.data.details.mapper.toDomain
import com.android.halanvendordiscovery.data.details.service.DetailsService
import com.android.halanvendordiscovery.domain.details.repo.DetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailsRepositoryImpl @Inject constructor(private val service: DetailsService):
    DetailsRepository {
    override suspend fun getMerchants(vendorId: String) =
        withContext(Dispatchers.IO) {
                val merchantsResponse = service.getMerchants(vendorId)
                merchantsResponse.data?.merchants?.map { dto -> dto.toDomain() }.orEmpty()
        }
}