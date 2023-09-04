package com.android.consumerfinancehalan.presentation.model

sealed class CategoriesUiState {

    object Initial : CategoriesUiState()

    object Loading : CategoriesUiState()

    class Success(
        val categories: List<CategoryUiModel>,
    ) : CategoriesUiState()

    class Error(val throwable: Throwable) : CategoriesUiState()
}