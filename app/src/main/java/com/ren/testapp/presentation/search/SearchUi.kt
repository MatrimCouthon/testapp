package com.ren.testapp.presentation.search

import android.os.Parcelable
import com.ren.testapp.domain.search.Search
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchUi(
    val search: Search,
    val isSingleItem: Boolean,
    val singleItem: MeaningUi?,
    val meanings: List<MeaningUi>
) : Parcelable