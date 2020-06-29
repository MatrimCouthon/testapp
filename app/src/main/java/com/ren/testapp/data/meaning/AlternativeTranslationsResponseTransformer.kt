package com.ren.testapp.data.meaning

import com.ren.testapp.common.base.BaseTransformer
import com.ren.testapp.data.search.TranslationResponseTransformer
import com.ren.testapp.domain.meaning.AlternativeTranslations
import javax.inject.Inject

class AlternativeTranslationsResponseTransformer @Inject constructor(
    private val translationResponseTransformer: TranslationResponseTransformer
) : BaseTransformer<AlternativeTranslationsResponse, AlternativeTranslations> {
    override fun transform(data: AlternativeTranslationsResponse) = with(data) {
        AlternativeTranslations(text, translationResponseTransformer.transform(translation))
    }
}