package com.android.consumerfinancehalan.data.mapper

import com.android.consumerfinancehalan.common.mapper.Mapper
import com.android.consumerfinancehalan.data.model.response.MerchantDto
import com.android.consumerfinancehalan.domain.model.MerchantModel

class MerchantDtoToModel: Mapper<MerchantDto,MerchantModel> {
    override fun mapTo(from: MerchantDto): MerchantModel {
        return MerchantModel(
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
}