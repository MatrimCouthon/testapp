package com.ren.testapp.domain.meaning

import com.ren.testapp.domain.search.Translation

data class AlternativeTranslations (
	val text : String,
	val translation : Translation
)