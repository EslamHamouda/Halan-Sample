package com.android.halanvendordiscovery.data.details.service

import com.android.halanvendordiscovery.data.details.model.BaseResponse
import com.android.halanvendordiscovery.data.details.model.response.MerchantDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailsService {
    @GET("vendors/{vendorId}/merchants")
    suspend fun getMerchants(@Path("vendorId") vendorId:String): BaseResponse<MerchantDetailsResponse>
}