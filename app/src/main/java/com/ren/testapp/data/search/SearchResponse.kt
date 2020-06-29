package com.ren.testapp.data.search

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResponse(
    @Json(name = "id")
    val id: Int,
    @Json(name = "text")
    val text: String,
    @Json(name = "meanings")
    val meanings: List<MeaningResponse>
)