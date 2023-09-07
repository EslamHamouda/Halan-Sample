package com.android.consumerfinancehalan.presentation.model

data class VendorUiModel(
    val id: String,
    val nameEn: String,
    val nameAr: String,
    val address: String,
    val lat: Double,
    val long: Double,
    val phone: String,
    val hasPromotion: Boolean,
    val marketingName: String?,
)