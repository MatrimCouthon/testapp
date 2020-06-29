package com.ren.testapp.presentation.search

import android.os.Parcelable
import com.ren.testapp.domain.search.Meaning
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MeaningUi(
    val meaning: Meaning,
    val imageUrl: String
) : Parcelable