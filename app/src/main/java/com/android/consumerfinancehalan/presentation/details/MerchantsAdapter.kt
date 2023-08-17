package com.android.consumerfinancehalan.presentation.details

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.android.consumerfinancehalan.databinding.ListItemMerchantBinding
import com.android.consumerfinancehalan.domain.model.MerchantModel

class MerchantsAdapter(
   private val list: List<MerchantModel>

) : RecyclerView.Adapter<MerchantsAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ListItemMerchantBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(item: MerchantModel) {
            binding.tvMerchantName.text=item.arabicName
            binding.tvMerchantAddress.text=item.address
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ListItemMerchantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}