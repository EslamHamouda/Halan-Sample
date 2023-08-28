package com.android.halanvendordiscovery.domain.vendors.model

data class VendorDomainModel(
    val id: String,
    val nameEn: String,
    val nameAr: String,
    val address: String,
    val lat: Double,
    val long: Double,
    val phone: String,
    val hasPromotion: Boolean,
    val marketingName: String,
)
