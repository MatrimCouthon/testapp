package com.ren.testapp.data.meaning

import com.ren.testapp.data.search.TranslationResponse
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MeaningDetailsResponse(
    @Json(name = "id")
    val id: Int,
    @Json(name = "text")
    val text: String,
    @Json(name = "transcription")
    val transcription: String,
    @Json(name = "translation")
    val translation: TranslationResponse,
    @Json(name = "definition")
    val definition: DefinitionResponse,
    @Json(name = "examples")
    val examples: List<ExamplesResponse>,
    @Json(name = "alternativeTranslations")
    val alternativeTranslations: List<AlternativeTranslationsResponse>
)