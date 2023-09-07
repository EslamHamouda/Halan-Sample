package com.android.halanvendordiscovery.domain.vendors.repo

import com.android.halanvendordiscovery.domain.vendors.model.CategoryDomainModel
import com.android.halanvendordiscovery.domain.vendors.model.Page
import com.android.halanvendordiscovery.domain.vendors.model.PagedList
import com.android.halanvendordiscovery.domain.vendors.model.VendorDomainModel

interface VendorRepository {

    suspend fun getVendors(
        pageConfig: Page,
        categoryId: String? = null,
        searchKey: String? = null
    ): PagedList<VendorDomainModel>

    suspend fun getCategories(): List<CategoryDomainModel>
}