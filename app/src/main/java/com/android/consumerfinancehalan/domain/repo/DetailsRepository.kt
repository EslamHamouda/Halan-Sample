package com.android.consumerfinancehalan.domain.repo

import com.android.consumerfinancehalan.data.model.BaseResponse
import com.android.consumerfinancehalan.data.model.response.GetMerchantsResponse
import com.android.consumerfinancehalan.domain.model.MerchantModel

interface DetailsRepository {
    suspend fun getMerchants(vendorId:String): BaseResponse<List<MerchantModel>>
}