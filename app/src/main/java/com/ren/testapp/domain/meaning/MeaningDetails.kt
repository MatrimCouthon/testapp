package com.ren.testapp.domain.meaning

import com.ren.testapp.domain.search.Translation

data class MeaningDetails(
    val id: Int,
    val text: String,
    val transcription: String,
    val translation: Translation,
    val definition: Definition,
    val examples: List<Examples>,
    val alternativeTranslations: List<AlternativeTranslations>
)