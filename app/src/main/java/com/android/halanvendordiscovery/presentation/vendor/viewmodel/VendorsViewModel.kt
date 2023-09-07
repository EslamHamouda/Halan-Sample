package com.android.halanvendordiscovery.presentation.vendor.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.consumerfinancehalan.presentation.model.CategoriesUiState
import com.android.consumerfinancehalan.presentation.model.CategoryUiModel
import com.android.consumerfinancehalan.presentation.model.VendorsUiState
import com.android.halanvendordiscovery.domain.vendors.model.VendorDomainModel
import com.android.halanvendordiscovery.domain.vendors.useCase.GetCategoriesUseCase
import com.android.halanvendordiscovery.domain.vendors.useCase.GetVendorsUseCase
import com.android.halanvendordiscovery.presentation.vendor.mappers.CategoryPresentationMapper
import com.android.halanvendordiscovery.presentation.vendor.mappers.VendorsPresentationMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class VendorsViewModel @Inject constructor(
    private val getVendors: GetVendorsUseCase,
    private val getCategories: GetCategoriesUseCase,
) : ViewModel() {

    private val _vendorsUiState = MutableStateFlow<VendorsUiState>(VendorsUiState.Initial)
    val vendorsUiState get() = _vendorsUiState.asStateFlow()
    private val _categoriesUiState = MutableStateFlow<CategoriesUiState>(CategoriesUiState.Initial)

    val categoriesUiState get() = _categoriesUiState.asStateFlow()

    private var canRequestAnotherVendorPage = true
    private var vendorsPage: Int = -1
    private var vendors: List<VendorDomainModel> = emptyList()
    private var categories: List<CategoryUiModel> = emptyList()

    fun fetchVendors(categoryID: String?, searchKey: String?) {
        if (canRequestAnotherVendorPage) {
            launchVendorsScope {
                updateVendorsUiState(VendorsUiState.Loading)
                val pagedList = getVendors(vendorsPage.inc(), categoryID, searchKey)
                vendorsPage = pagedList.page
                if (pagedList.value.isEmpty()) {
                    canRequestAnotherVendorPage = false
                } else {
                    vendors = vendors + pagedList.value
                    vendors.forEachIndexed { index, vendor ->
                    }
                    updateVendorsUiState(VendorsUiState.Success(vendors.map { vendorDomainModel ->
                        VendorsPresentationMapper.toVendorUiModel(
                            vendorDomainModel
                        )
                    }))
                }
            }
        }
    }

    fun searchVendors(categoryID: String?, searchKey: String?) {
        resetVendorsSettings()
        fetchVendors(categoryID, searchKey)
    }

    fun fetchCategories() {
        launchCategoriesScope {
            updateCategoriesUiState(CategoriesUiState.Loading)
            categories = getCategories().map { categoryDomainModel ->
                CategoryPresentationMapper.toCategoryUiModel(categoryDomainModel)
            }
            updateCategoriesUiState(CategoriesUiState.Success(categories))
        }
    }

    fun selectCategory(category: CategoryUiModel, searchKey: String?) {
        launchCategoriesScope {
            categories = categories.map {
                if (it.id == category.id) {
                    it.copy(isSelected = true)
                } else {
                    it.copy(isSelected = false)
                }
            }
            updateCategoriesUiState(CategoriesUiState.Success(categories))
            resetVendorsSettings()
            fetchVendors(category.id, searchKey)
        }
    }

    private fun resetVendorsSettings() {
        canRequestAnotherVendorPage = true
        vendorsPage = -1
        vendors = emptyList()
    }

    private suspend fun updateVendorsUiState(uiState: VendorsUiState) {
        withContext(Dispatchers.Main) {
            _vendorsUiState.emit(uiState)
        }
    }

    private suspend fun updateCategoriesUiState(uiState: CategoriesUiState) {
        withContext(Dispatchers.Main) {
            _categoriesUiState.emit(uiState)
        }
    }

    private fun launchVendorsScope(
        block: suspend CoroutineScope.() -> Unit
    ) {
        viewModelScope.launch {
            runCatching {
                block()
            }.onFailure {
                updateVendorsUiState(VendorsUiState.Error(it))
            }
        }
    }

    private fun launchCategoriesScope(
        block: suspend CoroutineScope.() -> Unit
    ) {
        viewModelScope.launch {
            runCatching {
                block()
            }.onFailure {
                updateCategoriesUiState(CategoriesUiState.Error(it))
            }
        }
    }
}