package com.android.halanvendordiscovery.domain.vendors.repo

import com.android.halanvendordiscovery.domain.vendors.model.Category
import com.android.halanvendordiscovery.domain.vendors.model.Page
import com.android.halanvendordiscovery.domain.vendors.model.PagedList
import com.android.halanvendordiscovery.domain.vendors.model.Vendor

interface VendorRepository {

    suspend fun getVendors(
        pageConfig: Page,
        categoryId: String? = null,
        searchKey: String? = null
    ): PagedList<Vendor>

    suspend fun getCategories(): List<Category>
}