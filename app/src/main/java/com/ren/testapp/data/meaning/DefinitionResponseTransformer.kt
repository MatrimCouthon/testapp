package com.ren.testapp.data.meaning

import com.ren.testapp.common.base.BaseTransformer
import com.ren.testapp.domain.meaning.Definition
import javax.inject.Inject

class DefinitionResponseTransformer @Inject constructor() :
    BaseTransformer<DefinitionResponse, Definition> {
    override fun transform(data: DefinitionResponse) = with(data) {
        Definition(text, soundUrl)
    }
}