package com.android.consumerfinancehalan.domain.model

import com.google.gson.annotations.SerializedName

data class MerchantModel(
    val name            : String?   = null,
    val arabicName      : String?   = null,
    val address         : String?   = null,
    val longitude       : Double?   = null,
    val latitude        : Double?   = null,
    val phoneNumber     : String?   = null,
    val vendorName      : String?   = null,
    val vendorArabicName: String?   = null,
)
