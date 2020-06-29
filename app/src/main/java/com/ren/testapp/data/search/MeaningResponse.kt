package com.ren.testapp.data.search

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MeaningResponse(
    @Json(name = "id")
    val id: Int,
    @Json(name = "partOfSpeechCode")
    val partOfSpeechCode: String,
    @Json(name = "translation")
    val translation: TranslationResponse,
    @Json(name = "previewUrl")
    val previewUrl: String,
    @Json(name = "imageUrl")
    val imageUrl: String,
    @Json(name = "transcription")
    val transcription: String,
    @Json(name = "soundUrl")
    val soundUrl: String
)