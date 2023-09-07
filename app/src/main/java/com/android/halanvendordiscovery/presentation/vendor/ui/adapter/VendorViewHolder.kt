package com.android.consumerfinancehalan.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.consumerfinancehalan.presentation.model.VendorUiModel
import com.android.halanvendordiscovery.databinding.VendorsItemBinding

class VendorViewHolder(val binding: VendorsItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(uiModel: VendorUiModel, vendorClickListener: VendorClickListener) {
        binding.vendorTitleText.text = uiModel.nameAr
        binding.vendorDetailsText.text = uiModel.address
        binding.root.setOnClickListener {
            vendorClickListener.onVendorClick(uiModel)
        }
    }

    companion object {
        fun from(parent: ViewGroup): VendorViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = VendorsItemBinding.inflate(layoutInflater, parent, false)
            return VendorViewHolder(binding)
        }
    }
}
