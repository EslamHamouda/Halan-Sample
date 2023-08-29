package com.android.halanvendordiscovery.presentation.details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.halanvendordiscovery.domain.details.useCase.GetMerchantsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val getMerchantsUseCase: GetMerchantsUseCase) :
    ViewModel() {

    private val _getMerchantsResponse: MutableStateFlow<DetailsStates> =
        MutableStateFlow(DetailsStates.Loading(true))
    val getMerchantsResponse: StateFlow<DetailsStates>
        get() = _getMerchantsResponse

    fun getMerchants(vendorId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = getMerchantsUseCase(vendorId)
                withContext(Dispatchers.Main) {
                    _getMerchantsResponse.value = DetailsStates.Loading(false)
                }
                _getMerchantsResponse.value = DetailsStates.Success(result)
            } catch (throwable: Throwable) {
                withContext(Dispatchers.Main) {
                    _getMerchantsResponse.value = DetailsStates.Loading(false)
                }
                _getMerchantsResponse.value = DetailsStates.Failure(throwable)
            }
        }
    }
}