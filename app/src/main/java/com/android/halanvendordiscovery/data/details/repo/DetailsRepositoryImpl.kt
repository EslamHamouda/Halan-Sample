package com.android.halanvendordiscovery.data.details.repo

import com.android.halanvendordiscovery.data.details.mapper.MerchantRemoteDomainMapper
import com.android.halanvendordiscovery.data.details.service.DetailsService
import com.android.halanvendordiscovery.domain.details.model.MerchantDomainModel
import com.android.halanvendordiscovery.domain.details.repo.DetailsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailsRepositoryImpl @Inject constructor(private val service: DetailsService):
    DetailsRepository {
    override suspend fun getMerchants(vendorId: String): List<MerchantDomainModel> {
        val merchantsResponse = service.getMerchants(vendorId)
        return merchantsResponse.data?.merchants?.map { dto -> MerchantRemoteDomainMapper.toDomain(dto) }
            .orEmpty()
    }
}