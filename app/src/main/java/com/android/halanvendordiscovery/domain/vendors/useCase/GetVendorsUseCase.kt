package com.android.halanvendordiscovery.domain.vendors.useCase

import com.android.halanvendordiscovery.domain.vendors.model.PagedList
import com.android.halanvendordiscovery.domain.vendors.model.VendorDomainModel
import com.android.halanvendordiscovery.domain.vendors.repo.VendorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetVendorsUseCase @Inject constructor(
    private val repository: VendorRepository,
) {

    suspend operator fun invoke(
        pageConfig: Int,
        categoryId: String?,
        searchKey: String?
    ): PagedList<VendorDomainModel> {
        return withContext(Dispatchers.Default) {
            val vendors = repository.getVendors(pageConfig, categoryId, searchKey)
            vendors
        }
    }
}