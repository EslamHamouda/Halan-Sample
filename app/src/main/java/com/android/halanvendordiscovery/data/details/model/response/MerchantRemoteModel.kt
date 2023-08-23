package com.android.halanvendordiscovery.data.details.model.response

import com.google.gson.annotations.SerializedName

data class MerchantRemoteModel(
    var id: String,
    var name: String?,
    var arabicName: String?,
    var creationDate: Int?,
    var status: Int?,
    var address: String?,
    var governorate: String?,
    var longitude: Double?,
    var latitude: Double?,
    var phoneNumber: String?,
    var branchHeadName: String?,
    var branchHeadPhone: String?,
    var categories: String?,
    var merchantId: String?,
    var vendor: VendorRemoteModel?,
    var location: VendorRemoteModel?
)
