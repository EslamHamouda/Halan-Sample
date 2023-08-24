package com.android.halanvendordiscovery.domain.details.repo

import com.android.halanvendordiscovery.domain.details.model.MerchantDomainModel

interface DetailsRepository {
    suspend fun getMerchants(vendorId:String): List<MerchantDomainModel>
}