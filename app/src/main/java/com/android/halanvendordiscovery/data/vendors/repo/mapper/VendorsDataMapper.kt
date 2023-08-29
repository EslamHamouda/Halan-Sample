package com.android.consumerfinancehalan.data.repo.mapper

import com.android.consumerfinancehalan.data.remote.model.CategoryRemoteModel
import com.android.consumerfinancehalan.data.remote.model.VendorRemoteModel
import com.android.halanvendordiscovery.domain.vendors.model.CategoryDomainModel
import com.android.halanvendordiscovery.domain.vendors.model.VendorDomainModel

object VendorsDataMapper{
    fun toVendorDomainModel(from: VendorRemoteModel) = VendorDomainModel(
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