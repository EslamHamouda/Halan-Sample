package com.android.consumerfinancehalan.ui.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.consumerfinancehalan.presentation.model.CategoryUiModel

class CategoryRecyclerAdapter
    (
    private var currentList: List<CategoryUiModel>,
    private val categoryClickListener: CategoryClickListener
) :
    RecyclerView.Adapter<CategoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(currentList[position], categoryClickListener)
    }


    override fun getItemCount(): Int {
        return currentList.size
    }

    @SuppressLint("NotifyDatasetChanged")
    fun updateList(newList: List<CategoryUiModel>) {
        currentList = newList
        notifyDataSetChanged()
    }


}