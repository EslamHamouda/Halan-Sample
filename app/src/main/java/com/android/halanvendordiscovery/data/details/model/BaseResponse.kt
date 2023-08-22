package com.android.halanvendordiscovery.data.details.model

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("status") var status: Int? = 0,
    @SerializedName("message") var message: String? = "",
    @SerializedName("data") var data: T? = null
)
