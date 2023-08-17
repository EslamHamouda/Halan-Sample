package com.android.consumerfinancehalan.utils

import android.app.Activity
import android.view.View
import android.widget.ProgressBar
import com.google.android.material.snackbar.Snackbar

fun ProgressBar.hideProgressBar() {
    this.visibility = View.GONE
}

fun ProgressBar.showProgressBar() {
    this.visibility = View.VISIBLE
}

fun showSnackBar(msg: String, activity: Activity) {
    activity.view()?.let {
        Snackbar.make(it, msg, Snackbar.LENGTH_LONG)
            .show()
    }
}

fun Activity.view(): View? =
    findViewById(android.R.id.content)
