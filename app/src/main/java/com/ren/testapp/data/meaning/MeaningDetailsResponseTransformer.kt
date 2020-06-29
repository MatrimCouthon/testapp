package com.ren.testapp.data.meaning

import com.ren.testapp.common.base.BaseTransformer
import com.ren.testapp.data.search.TranslationResponseTransformer
import com.ren.testapp.domain.meaning.MeaningDetails
import javax.inject.Inject

class MeaningDetailsResponseTransformer @Inject constructor(
    private val translationResponseTransformer: TranslationResponseTransformer,
    private val detailsResponseTransformer: DefinitionResponseTransformer,
    private val examplesResponseTransformer: ExamplesResponseTransformer,
    private val alternativeTranslationsResponseTransformer: AlternativeTranslationsResponseTransformer
) : BaseTransformer<MeaningDetailsResponse, MeaningDetails> {

    override fun transform(data: MeaningDetailsResponse) = with(data) {
        MeaningDetails(
            id,
            text,
            transcription,
            translationResponseTransformer.transform(translation),
            detailsResponseTransformer.transform(definition),
            examples.map {
                examplesResponseTransformer.transform(it)
            },
            alternativeTranslations.map {
                alternativeTranslationsResponseTransformer.transform(it)
            }
        )
    }
}