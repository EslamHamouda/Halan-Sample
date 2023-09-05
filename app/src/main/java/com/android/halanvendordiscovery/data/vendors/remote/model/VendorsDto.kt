package com.android.consumerfinancehalan.data.remote.model

data class VendorsDto(
    val vendors: List<VendorRemoteModel>,
    val count: Int?,
)