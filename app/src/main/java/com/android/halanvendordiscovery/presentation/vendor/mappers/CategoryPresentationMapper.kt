package com.android.halanvendordiscovery.presentation.vendor.mappers

import com.android.consumerfinancehalan.data.remote.model.CategoryRemoteModel
import com.android.consumerfinancehalan.presentation.model.CategoryUiModel
import com.android.halanvendordiscovery.domain.vendors.model.CategoryDomainModel

object CategoryPresentationMapper{
    fun toCategoryUiModel(from: CategoryDomainModel) = CategoryUiModel(
        id = from.id,
        nameAr = from?.nameAr,
        nameEn = from?.nameEn,
        )
}