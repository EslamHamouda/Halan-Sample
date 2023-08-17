package com.android.consumerfinancehalan.data.model.response

import com.google.gson.annotations.SerializedName

data class GetMerchantsResponse(
    @SerializedName("merchants" ) var merchants : ArrayList<MerchantDto> = arrayListOf(),
    @SerializedName("count"     ) var count     : Int?                 = null
)
