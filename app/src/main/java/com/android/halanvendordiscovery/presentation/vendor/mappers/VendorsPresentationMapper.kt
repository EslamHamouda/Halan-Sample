package com.android.halanvendordiscovery.presentation.vendor.mappers

import com.android.consumerfinancehalan.presentation.model.VendorUiModel
import com.android.halanvendordiscovery.domain.vendors.model.VendorDomainModel

object VendorsPresentationMapper {
    fun toVendorUiModel(from: VendorDomainModel) = VendorUiModel(
        id = from.id,
        nameEn = from.nameEn,
        nameAr = from.nameAr,
        address = from.address,
        lat =  from.lat,
        long = from.long,
        phone = from.phone,
        hasPromotion = from.hasPromotion,
        marketingName = from.marketingName,
    )
}