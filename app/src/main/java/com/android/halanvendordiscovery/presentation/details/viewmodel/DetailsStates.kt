package com.android.halanvendordiscovery.presentation.details.viewmodel

import com.android.halanvendordiscovery.domain.details.model.MerchantModel

sealed class DetailsStates{
    data class Success(val value: List<MerchantModel>?): DetailsStates()
    data class Failure(val throwable: Throwable): DetailsStates()
    data class Loading(val isLoading: Boolean): DetailsStates()
}