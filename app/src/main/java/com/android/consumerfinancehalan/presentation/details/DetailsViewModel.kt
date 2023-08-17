package com.android.consumerfinancehalan.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.consumerfinancehalan.data.model.BaseResponse
import com.android.consumerfinancehalan.domain.model.MerchantModel
import com.android.consumerfinancehalan.domain.useCase.GetMerchantsUseCase
import com.android.consumerfinancehalan.utils.ApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val getMerchantsUseCase: GetMerchantsUseCase,): ViewModel() {

    private val _getMerchantsResponse: MutableStateFlow<ApiResponse<BaseResponse<List<MerchantModel>>>> =
        MutableStateFlow(ApiResponse.Success(null))
    val getMerchantsResponse: StateFlow<ApiResponse<BaseResponse<List<MerchantModel>>>>
        get() = _getMerchantsResponse

    fun getMerchants(vendorId:String) {
        _getMerchantsResponse.value=ApiResponse.Loading(true)
        viewModelScope.launch {
            when (val result = getMerchantsUseCase(vendorId)) {
                is ApiResponse.Success -> {
                    _getMerchantsResponse.value=ApiResponse.Loading(false)
                    _getMerchantsResponse.value = ApiResponse.Success(result.value)
                }
                is ApiResponse.Failure -> {
                    _getMerchantsResponse.value=ApiResponse.Loading(false)
                    _getMerchantsResponse.value = ApiResponse.Failure(result.throwable)
                }
                else -> {}
            }
        }
    }

}