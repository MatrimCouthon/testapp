package com.ren.testapp.data.search

import com.ren.testapp.common.base.BaseTransformer
import com.ren.testapp.domain.search.Search
import javax.inject.Inject

class SearchResponseTransformer @Inject constructor(
    private val meaningResponseTransformer: MeaningResponseTransformer
) : BaseTransformer<SearchResponse, Search> {
    override fun transform(data: SearchResponse) = with(data) {
        Search(id, text, meanings.map {
            meaningResponseTransformer.transform(it)
        })
    }
}