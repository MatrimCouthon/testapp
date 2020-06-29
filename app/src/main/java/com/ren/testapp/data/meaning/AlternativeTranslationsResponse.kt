package com.ren.testapp.data.meaning

import com.ren.testapp.data.search.TranslationResponse
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlternativeTranslationsResponse(
    @Json(name = "text")
    val text: String,
    @Json(name = "translation")
    val translation: TranslationResponse
)