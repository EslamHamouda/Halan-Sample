package com.android.halanvendordiscovery.data.vendors.repo.mapper

import com.android.consumerfinancehalan.data.remote.model.CategoryRemoteModel
import com.android.halanvendordiscovery.domain.vendors.model.CategoryDomainModel

object CategoryDataMapper {
    fun toCategoryDomainModel(from: CategoryRemoteModel) = CategoryDomainModel(
        id = from.id,
        nameAr = from.nameAr,
        nameEn = from.nameEn
    )
}