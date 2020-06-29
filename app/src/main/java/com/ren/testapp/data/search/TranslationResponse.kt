package com.ren.testapp.data.search

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TranslationResponse(
    @Json(name = "text")
    val text: String?,
    @Json(name = "note")
    val note: String?
)