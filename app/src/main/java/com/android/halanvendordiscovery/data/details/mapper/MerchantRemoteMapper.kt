package com.android.halanvendordiscovery.data.details.mapper

import com.android.halanvendordiscovery.data.details.model.response.MerchantRemoteModel
import com.android.halanvendordiscovery.domain.details.model.MerchantDomainModel

object MerchantRemoteMapper{
    fun toDomain(from:MerchantRemoteModel) = MerchantDomainModel(
        name = from.name,
        arabicName = from.arabicName,
        address = from.address,
        longitude = from.longitude,
        latitude = from.latitude,
        phoneNumber = from.phoneNumber,
        vendorName = from.vendor?.name,
        vendorArabicName = from.vendor?.arabicName
    )
}