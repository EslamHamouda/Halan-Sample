package com.android.halanvendordiscovery.data.details.model.response

data class VendorRemoteModel(
    var id: String,
    var address: String?,
    var governorate: String?,
    var name: String?,
    var arabicName: String?,
    var marketingName: String?,
    var phoneNumber: String?,
    var description: String?,
    var lat: Double?,
    var long: Double?,
    var displayedOnApp: Boolean?
)
