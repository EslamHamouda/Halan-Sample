package com.android.consumerfinancehalan.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.consumerfinancehalan.presentation.model.CategoryUiModel
import com.android.halanvendordiscovery.R
import com.android.halanvendordiscovery.databinding.CategoryItemBinding

class CategoryViewHolder(val binding: CategoryItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(categoryUiModel: CategoryUiModel, categoryClickListener: CategoryClickListener) {
        binding.apply {
            categoryName.text = categoryUiModel.nameAr
            categoryCard.setOnClickListener {
                categoryClickListener.onCategoryClick(categoryUiModel)
            }
        }
        if (categoryUiModel.isSelected) {
            binding.categoryCard.setBackgroundColor(binding.root.resources.getColor(R.color.active_category_card))
            binding.categoryCard.strokeColor =
                binding.root.resources.getColor(R.color.active_category_card_border)
        } else {
            binding.categoryCard.setBackgroundColor(binding.root.resources.getColor(R.color.inactive_category_card))
            binding.categoryCard.strokeColor = binding.root.resources.getColor(R.color.white)
        }
    }

    companion object {
        fun from(parent: ViewGroup): CategoryViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = CategoryItemBinding.inflate(layoutInflater, parent, false)
            return CategoryViewHolder(binding)
        }
    }

}