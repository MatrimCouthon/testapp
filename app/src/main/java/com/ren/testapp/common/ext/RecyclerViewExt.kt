package com.ren.testapp.common.ext

import androidx.core.view.ViewCompat
import androidx.core.view.doOnPreDraw
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper

fun SnapHelper.getSnapPosition(recyclerView: RecyclerView): Int {
    val layoutManager = recyclerView.layoutManager ?: return RecyclerView.NO_POSITION
    val snapView = findSnapView(layoutManager) ?: return RecyclerView.NO_POSITION
    return layoutManager.getPosition(snapView)
}

fun RecyclerView.removeAllItemDecorations() {
    while (itemDecorationCount > 0) {
        removeItemDecorationAt(0)
    }
}

fun RecyclerView.animateAppearance(duration: Long = 300, translation: Float = 500f) {
    translationY = translation
    alpha = 0f
    doOnPreDraw {
        ViewCompat.animate(this)
            .translationYBy(-translation)
            .alpha(1f)
            .setDuration(duration)
            .start()
    }
}