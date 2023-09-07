package com.android.consumerfinancehalan.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.android.consumerfinancehalan.presentation.model.VendorUiModel
import com.android.halanvendordiscovery.R

class VendorsRecyclerAdapter(
    private val vendorClickListener: VendorClickListener
) : ListAdapter<VendorUiModel, VendorViewHolder>(VendorDiffCallbacks()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VendorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.vendors_item, parent, false)
        return VendorViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: VendorViewHolder, position: Int) {
        val uiModel = getItem(position)
        holder.bind(uiModel, vendorClickListener)
    }

    override fun submitList(list: List<VendorUiModel>?) {
        super.submitList(list)
    }
}

