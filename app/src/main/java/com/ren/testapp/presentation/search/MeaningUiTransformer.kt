package com.ren.testapp.presentation.search

import com.ren.testapp.common.base.BaseTransformer
import com.ren.testapp.domain.search.Meaning
import javax.inject.Inject

class MeaningUiTransformer @Inject constructor() : BaseTransformer<Meaning, MeaningUi> {

    private val BASE_URL = "https://d2zkmv5t5kao9.cloudfront.net/images/"

    override fun transform(data: Meaning) = with(data) {
        MeaningUi(data, createImageUrl(previewUrl))
    }

    private fun createImageUrl(url: String?): String {
        val idWi = url!!.split("/").lastOrNull()
        val id = idWi!!.split("?").firstOrNull()
        return StringBuilder().append(BASE_URL).append(id).toString()
    }
}