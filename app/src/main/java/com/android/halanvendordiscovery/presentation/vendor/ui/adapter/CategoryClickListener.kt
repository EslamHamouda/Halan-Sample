package com.android.consumerfinancehalan.ui.adapter

import com.android.consumerfinancehalan.presentation.model.CategoryUiModel

interface CategoryClickListener {
    fun onCategoryClick(category: CategoryUiModel)
}