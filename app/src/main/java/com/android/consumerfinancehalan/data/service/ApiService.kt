package com.android.consumerfinancehalan.data.service

import com.android.consumerfinancehalan.data.model.BaseResponse
import com.android.consumerfinancehalan.data.model.response.GetMerchantsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("vendors/{vendorId}/merchants")
    suspend fun getMerchants(@Path("vendorId") vendorId:String): BaseResponse<GetMerchantsResponse>
}