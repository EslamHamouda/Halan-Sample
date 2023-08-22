package com.android.halanvendordiscovery.domain.details.repo

import com.android.halanvendordiscovery.domain.details.model.MerchantModel

interface DetailsRepository {
    suspend fun getMerchants(vendorId:String): List<MerchantModel>
}