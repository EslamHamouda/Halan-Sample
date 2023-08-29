package com.android.consumerfinancehalan.data.remote.service

import com.android.consumerfinancehalan.data.remote.model.CategoryResponse
import com.android.consumerfinancehalan.data.remote.model.VendorsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface VendorsService {

    @GET("vendors")
    suspend fun getVendors(
        @Query("from") pageNumber: Int,
        @Query("userId") categoryId: String?,
        @Query("searchKey") searchKey: String?,

        ): VendorsResponse

    @GET("getvendorcategory")
    suspend fun getCategories(): CategoryResponse

}