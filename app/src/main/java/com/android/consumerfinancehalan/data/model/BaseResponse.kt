package com.android.consumerfinancehalan.data.model

import com.google.gson.annotations.SerializedName

open class BaseResponse<T>(
    @SerializedName("status") var status: Int? = 0,
    @SerializedName("message") var message: String? = "",
    @SerializedName("data") var data: T? = null
)
