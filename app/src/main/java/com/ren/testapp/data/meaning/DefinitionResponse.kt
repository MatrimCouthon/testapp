package com.ren.testapp.data.meaning

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DefinitionResponse(
    @Json(name = "text")
    val text: String,
    @Json(name = "soundUrl")
    val soundUrl: String
)