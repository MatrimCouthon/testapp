package com.ren.testapp.domain.search

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Translation(
    val text: String?,
    val note: String?
): Parcelable