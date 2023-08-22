package com.android.halanvendordiscovery.domain.useCase

import com.android.halanvendordiscovery.domain.model.MerchantModel
import com.android.halanvendordiscovery.domain.repo.DetailsRepository
import javax.inject.Inject

class GetMerchantsUseCase @Inject constructor(private val repository: DetailsRepository) {
    suspend operator fun invoke(vendorId:String): List<MerchantModel> {
            return repository.getMerchants(vendorId)
    }
}