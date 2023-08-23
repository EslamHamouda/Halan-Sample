package com.android.halanvendordiscovery.data.details.model

data class BaseResponse<T>(
    var status: Int?,
    var message: String?,
    var data: T?
)
