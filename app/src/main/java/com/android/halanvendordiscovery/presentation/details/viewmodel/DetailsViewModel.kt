package com.android.halanvendordiscovery.presentation.details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.halanvendordiscovery.domain.details.useCase.GetMerchantsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val getMerchantsUseCase: GetMerchantsUseCase) :
    ViewModel() {

    private val _getMerchantsResponse: MutableStateFlow<DetailsStates> =
        MutableStateFlow(DetailsStates.Success(null))
    val getMerchantsResponse: StateFlow<DetailsStates>
        get() = _getMerchantsResponse

    fun getMerchants(vendorId: String) {
        _getMerchantsResponse.value = DetailsStates.Loading(true)
        viewModelScope.launch {
            try {
                val result = getMerchantsUseCase(vendorId)
                _getMerchantsResponse.value = DetailsStates.Loading(false)
                _getMerchantsResponse.value = DetailsStates.Success(result)
            } catch (throwable: Throwable) {
                _getMerchantsResponse.value = DetailsStates.Loading(false)
                _getMerchantsResponse.value = DetailsStates.Failure(throwable)
            }
        }
    }

}