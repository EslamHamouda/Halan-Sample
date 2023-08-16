package com.android.consumerfinancehalan.utils

sealed class ApiResponse<out T>{
    data class Success<out R>(val value: R?): ApiResponse<R>()
    data class Failure(val throwable: Throwable): ApiResponse<Nothing>()
    data class Loading(val isLoading: Boolean): ApiResponse<Nothing>()

}
