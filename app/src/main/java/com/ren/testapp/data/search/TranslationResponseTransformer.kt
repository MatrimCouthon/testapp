package com.ren.testapp.data.search

import com.ren.testapp.common.base.BaseTransformer
import com.ren.testapp.domain.search.Translation
import javax.inject.Inject

class TranslationResponseTransformer @Inject constructor() :
    BaseTransformer<TranslationResponse, Translation> {
    override fun transform(data: TranslationResponse) = with(data) {
        Translation(text, note)
    }
}