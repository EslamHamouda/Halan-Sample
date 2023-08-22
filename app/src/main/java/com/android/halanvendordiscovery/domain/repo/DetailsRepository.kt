package com.android.halanvendordiscovery.domain.repo

import com.android.halanvendordiscovery.domain.model.MerchantModel

interface DetailsRepository {
    suspend fun getMerchants(vendorId:String): List<MerchantModel>
}