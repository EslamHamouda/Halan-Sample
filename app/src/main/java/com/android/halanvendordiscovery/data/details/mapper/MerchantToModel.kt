package com.android.halanvendordiscovery.data.details.mapper

import com.android.halanvendordiscovery.data.details.model.response.Merchant
import com.android.halanvendordiscovery.domain.details.model.MerchantModel

fun Merchant.toDomain() = MerchantModel(
    name = name,
    arabicName = arabicName,
    address = address,
    longitude = longitude,
    latitude = latitude,
    phoneNumber = phoneNumber,
    vendorName = vendor?.name,
    vendorArabicName = vendor?.arabicName
)