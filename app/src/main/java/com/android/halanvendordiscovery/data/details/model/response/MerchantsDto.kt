package com.android.halanvendordiscovery.data.details.model.response

import com.google.gson.annotations.SerializedName

data class MerchantsDto(
    var merchants: ArrayList<MerchantRemoteModel>?,
    var count: Int?
)