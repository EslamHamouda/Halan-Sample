package com.android.halanvendordiscovery.domain.vendors.useCase

import com.android.halanvendordiscovery.domain.vendors.model.CategoryDomainModel
import com.android.halanvendordiscovery.domain.vendors.repo.VendorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: VendorRepository,
) {
    suspend operator fun invoke(): List<CategoryDomainModel> {
        return withContext(Dispatchers.Default) {
            repository.getCategories()
        }
    }
}