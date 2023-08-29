package com.android.halanvendordiscovery.presentation.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.halanvendordiscovery.databinding.ListItemMerchantBinding
import com.android.halanvendordiscovery.domain.details.model.MerchantDomainModel

class MerchantsAdapter(
    private val list: List<MerchantDomainModel>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<MerchantsAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ListItemMerchantBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MerchantDomainModel) {
            binding.tvMerchantName.text = item.arabicName
            binding.tvMerchantAddress.text = item.address
            binding.ivPhone.setOnClickListener {
                listener.onPhoneClick(item.phoneNumber)
            }
            binding.ivMap.setOnClickListener {
                listener.onLocationClick(item.latitude, item.longitude)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ListItemMerchantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnItemClickListener {
        fun onLocationClick(latitude: Double, longitude: Double)
        fun onPhoneClick(phone: String)
    }
}