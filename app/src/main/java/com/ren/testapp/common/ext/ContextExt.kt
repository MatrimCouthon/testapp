package com.ren.testapp.common.ext

import android.content.Context
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.util.DisplayMetrics
import androidx.annotation.*
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

fun Context.getColorCompat(@ColorRes colorId: Int) = ContextCompat.getColor(this, colorId)

fun Context.getDrawableCompat(@DrawableRes drawableId: Int): Drawable =
    AppCompatResources.getDrawable(this, drawableId)!!

fun Context.dpToPx(dp: Int): Int {
    return dp * (resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
}

fun Context.getFont(@FontRes fontRes: Int) = ResourcesCompat.getFont(this, fontRes)

fun Context.getQuantityText(@PluralsRes id: Int, quantity: Int) = resources.getQuantityString(
    id,
    quantity,
    quantity
)

fun Context.getColoredDrawableCompat(@DrawableRes drawableRes: Int, @ColorInt color: Int): Drawable {
    return this.getDrawableCompat(drawableRes).apply {
        if (VERSION.SDK_INT >= VERSION_CODES.Q) {
            colorFilter = BlendModeColorFilter(color, BlendMode.SRC_IN)
        } else {
            @Suppress("DEPRECATION")
            setColorFilter(color, PorterDuff.Mode.SRC_IN)
        }
    }
}