package com.android.consumerfinancehalan.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.android.consumerfinancehalan.presentation.model.VendorUiModel

class VendorDiffCallbacks : DiffUtil.ItemCallback<VendorUiModel>() {

    override fun areItemsTheSame(oldItem: VendorUiModel, newItem: VendorUiModel): Boolean {
        return (oldItem.id == newItem.id)
    }

    override fun areContentsTheSame(oldItem: VendorUiModel, newItem: VendorUiModel): Boolean {
        return oldItem == newItem
    }
}
