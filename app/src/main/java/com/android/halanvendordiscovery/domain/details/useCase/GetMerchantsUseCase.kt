package com.android.halanvendordiscovery.domain.details.useCase

import com.android.halanvendordiscovery.domain.details.model.MerchantDomainModel
import com.android.halanvendordiscovery.domain.details.repo.DetailsRepository
import javax.inject.Inject

class GetMerchantsUseCase @Inject constructor(private val repository: DetailsRepository) {
    suspend operator fun invoke(vendorId:String): List<MerchantDomainModel> {
            return repository.getMerchants(vendorId)
    }
}