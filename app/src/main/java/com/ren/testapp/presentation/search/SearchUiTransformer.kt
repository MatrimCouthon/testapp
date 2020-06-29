package com.ren.testapp.presentation.search

import com.ren.testapp.common.base.BaseTransformer
import com.ren.testapp.domain.search.Meaning
import com.ren.testapp.domain.search.Search
import javax.inject.Inject

class SearchUiTransformer @Inject constructor(
    private val meaningUiTransformer: MeaningUiTransformer
) : BaseTransformer<Search, SearchUi> {
    override fun transform(data: Search) = with(data) {
        SearchUi(this, isSingleItem = checkCountItem(meanings),
            meanings = meanings.map {
                meaningUiTransformer.transform(it)
            },
            singleItem = meanings.firstOrNull()?.let {
                meaningUiTransformer.transform(it)
            })
    }

    private fun checkCountItem(meanings: List<Meaning>): Boolean {
        return meanings.size == 1
    }
}