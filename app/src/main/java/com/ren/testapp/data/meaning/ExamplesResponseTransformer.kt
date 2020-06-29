package com.ren.testapp.data.meaning

import com.ren.testapp.common.base.BaseTransformer
import com.ren.testapp.domain.meaning.Examples
import javax.inject.Inject

class ExamplesResponseTransformer @Inject constructor() :
    BaseTransformer<ExamplesResponse, Examples> {
    override fun transform(data: ExamplesResponse) = with(data) {
        Examples(text, soundUrl)
    }
}