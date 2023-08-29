package com.android.consumerfinancehalan.data.repo

import com.android.consumerfinancehalan.data.remote.service.VendorsService
import com.android.consumerfinancehalan.data.repo.mapper.VendorsDataMapper
import com.android.halanvendordiscovery.data.vendors.repo.mapper.CategoryDataMapper
import com.android.halanvendordiscovery.domain.vendors.model.CategoryDomainModel
import com.android.halanvendordiscovery.domain.vendors.model.Page
import com.android.halanvendordiscovery.domain.vendors.model.PagedList
import com.android.halanvendordiscovery.domain.vendors.model.VendorDomainModel
import com.android.halanvendordiscovery.domain.vendors.repo.VendorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class VendorsRepositoryImpl @Inject constructor(
    private val service: VendorsService,
) : VendorRepository {

    override suspend fun getVendors(
        pageConfig: Page,
        categoryId: String?,
        searchKey: String?
    ): PagedList<VendorDomainModel> {
        return withContext(Dispatchers.IO) {
            val vendorsRemoteModels = service.getVendors(
                pageNumber = pageConfig.number,
                categoryId = categoryId,
                searchKey = searchKey,
            )
            val vendors =
                vendorsRemoteModels.data.vendors.map { vendorRemoteModel ->
                    VendorsDataMapper.toVendorDomainModel(
                        vendorRemoteModel
                    )
                }
            PagedList(
                value = vendors,
                page = pageConfig,
            )
        }
    }

    override suspend fun getCategories(): List<CategoryDomainModel> {
        return withContext(Dispatchers.IO) {
            val categoryRemoteModels = service.getCategories()
            categoryRemoteModels.data.map { categoryRemoteModel ->
                CategoryDataMapper.toCategoryDomainModel(
                    categoryRemoteModel
                )
            }
        }
    }
}
