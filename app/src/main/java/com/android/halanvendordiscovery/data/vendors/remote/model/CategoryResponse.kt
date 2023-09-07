package com.android.consumerfinancehalan.data.remote.model

data class CategoryResponse(
    val status: Int,
    val message: String,
    val data: List<CategoryRemoteModel>,
)
