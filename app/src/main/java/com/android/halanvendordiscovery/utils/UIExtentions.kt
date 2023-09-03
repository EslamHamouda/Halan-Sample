package com.android.halanvendordiscovery.utils

import android.app.Activity
import android.view.View
import android.widget.ProgressBar
import com.google.android.material.snackbar.Snackbar

fun ProgressBar.isShowProgressBar(visible:Boolean) {
    if(visible){
        this.visibility = View.VISIBLE
    }
    else{
        this.visibility = View.GONE
    }
}

fun showSnackBar(msg: String, activity: Activity) {
    activity.view()?.let {
        Snackbar.make(it, msg, Snackbar.LENGTH_LONG)
            .show()
    }
}

fun Activity.view(): View? =
    findViewById(android.R.id.content)
