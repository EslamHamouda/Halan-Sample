package com.android.consumerfinancehalan.ui.adapter

import com.android.consumerfinancehalan.presentation.model.VendorUiModel

interface VendorClickListener {
    fun onVendorClick(vendor: VendorUiModel)
}