package com.android.halanvendordiscovery.utils

import android.content.Context
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.setDividerItemDecoration(context: Context, orientation: Int, resId: Int){
    val divider = DividerItemDecoration(context, orientation)
    AppCompatResources.getDrawable(context, resId)?.let {
        divider.setDrawable(it)
    }
    this.addItemDecoration(divider)
}