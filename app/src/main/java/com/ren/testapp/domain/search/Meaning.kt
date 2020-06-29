package com.ren.testapp.domain.search

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Meaning(
    val id: Int,
    val partOfSpeechCode: String,
    val translation: Translation,
    val previewUrl: String,
    val imageUrl: String,
    val transcription: String,
    val soundUrl: String
) : Parcelable