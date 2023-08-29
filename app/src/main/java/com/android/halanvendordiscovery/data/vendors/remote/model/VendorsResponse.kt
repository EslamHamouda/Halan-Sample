package com.android.consumerfinancehalan.data.remote.model

data class VendorsResponse(
    val status: Int,
    val message: String,
    val data: VendorsDto,
)