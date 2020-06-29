package com.ren.testapp.domain.search

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Search(
    val id: Int,
    val text: String,
    val meanings: List<Meaning>
) : Parcelable