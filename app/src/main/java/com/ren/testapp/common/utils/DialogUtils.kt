package com.ren.testapp.common.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar

object DialogUtils {

    fun showError(
        contentView: View?,
        message: String,
        actionText: String? = null,
        action: View.OnClickListener? = null
    ) = contentView?.let { view ->
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).apply {
            if (actionText != null && action != null) {
                setAction(actionText, action)
            }
            show()
        }
    }
}