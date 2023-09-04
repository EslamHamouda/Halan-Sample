package com.android.consumerfinancehalan.presentation.model

sealed class VendorsUiState {

    object Initial : VendorsUiState()

    object Loading : VendorsUiState()

    class Success(
        val vendors: List<VendorUiModel>,
    ) : VendorsUiState()

    class Error(val throwable: Throwable) : VendorsUiState()
}