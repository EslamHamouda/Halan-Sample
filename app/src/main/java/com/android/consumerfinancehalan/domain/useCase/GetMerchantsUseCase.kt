package com.android.consumerfinancehalan.domain.useCase

import android.util.Log
import com.android.consumerfinancehalan.data.mapper.MerchantDtoToModel
import com.android.consumerfinancehalan.data.model.BaseResponse
import com.android.consumerfinancehalan.domain.model.MerchantModel
import com.android.consumerfinancehalan.domain.repo.DetailsRepository
import com.android.consumerfinancehalan.utils.ApiResponse
import javax.inject.Inject

class GetMerchantsUseCase @Inject constructor(private val repository: DetailsRepository) {
    suspend operator fun invoke(vendorId:String): ApiResponse<BaseResponse<List<MerchantModel>>> {
        return try {
            val responseDTO = repository.getMerchants(vendorId)
            val merchantModelList = responseDTO.data?.merchants?.map { dto->
                MerchantDtoToModel().mapTo(dto)
            }
            val responseModel=BaseResponse(
                status = responseDTO.status,
                message = responseDTO.message,
                data = merchantModelList
            )
            ApiResponse.Success(responseModel)
        } catch (throwable: Throwable) {
            ApiResponse.Failure(throwable)
        }
    }
}