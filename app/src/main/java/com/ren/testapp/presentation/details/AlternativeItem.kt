package com.ren.testapp.presentation.details

import com.ren.testapp.R
import com.ren.testapp.domain.meaning.AlternativeTranslations
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_alternative_translations.view.*

class AlternativeItem(
    private val alternativeTranslations: AlternativeTranslations
) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) = with(viewHolder.itemView) {
        item_alternative_translations_original_name.text = alternativeTranslations.text
        item_alternative_translations_translate_name.text = alternativeTranslations.translation.text
    }

    override fun getLayout() = R.layout.item_alternative_translations
}