package com.android.halanvendordiscovery.presentation.details.adapter

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.halanvendordiscovery.databinding.ListItemMerchantBinding
import com.android.halanvendordiscovery.domain.details.model.MerchantDomainModel

class MerchantsAdapter(
   private val list: List<MerchantDomainModel>

) : RecyclerView.Adapter<MerchantsAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ListItemMerchantBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(item: MerchantDomainModel) {
            binding.tvMerchantName.text=item.arabicName
            binding.tvMerchantAddress.text=item.address
            binding.ivPhone.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("tel:${item.phoneNumber}")
                startActivity(binding.root.context,intent,null)
            }
            binding.ivMap.setOnClickListener {
                val uri = "geo:${item.latitude}, ${item.longitude}?q=${item.latitude},${item.longitude}"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                startActivity(binding.root.context, intent, null)
            }
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