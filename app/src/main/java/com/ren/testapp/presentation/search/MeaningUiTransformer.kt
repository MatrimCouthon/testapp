package com.ren.testapp.presentation.search

import com.ren.testapp.common.base.BaseTransformer
import com.ren.testapp.domain.search.Meaning
import javax.inject.Inject

class MeaningUiTransformer @Inject constructor() : BaseTransformer<Meaning, MeaningUi> {

    private val BASE_URL = "https:"

    override fun transform(data: Meaning) = with(data) {
        MeaningUi(data, createImageUrl(previewUrl), createImageUrl(imageUrl))
    }

    private fun createImageUrl(url: String?) =
        StringBuilder().append(BASE_URL).append(url).toString()
}