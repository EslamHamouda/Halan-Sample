package com.android.consumerfinancehalan.presentation.model

data class CategoryUiModel(
    val id: String,
    val nameEn: String?,
    val nameAr: String?,
    val isSelected: Boolean = false,
)
