package com.ren.testapp.data.search

import com.ren.testapp.common.base.BaseTransformer
import com.ren.testapp.domain.search.Meaning
import javax.inject.Inject

class MeaningResponseTransformer @Inject constructor(
    private val transformer: TranslationResponseTransformer
) : BaseTransformer<MeaningResponse, Meaning> {
    override fun transform(data: MeaningResponse) = with(data) {
        Meaning(
            id,
            partOfSpeechCode,
            transformer.transform(translation),
            previewUrl,
            imageUrl,
            transcription,
            soundUrl
        )
    }
}