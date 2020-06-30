package com.ren.testapp.presentation.main

import com.bumptech.glide.Glide
import com.ren.testapp.R
import com.ren.testapp.common.ext.setDebounceOnClickListener
import com.ren.testapp.presentation.search.MeaningUi
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_single_main.view.*

class MainSingleItem(
    private val originalWord: String,
    private val meaningUi: MeaningUi?,
    private val clickListener: (MeaningUi) -> Unit
) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) = with(viewHolder) {
        Glide.with(itemView.item_single_image)
            .load(meaningUi?.previewImageUrl)
            .placeholder(R.drawable.ic_book)
            .into(itemView.item_single_image)

        itemView.item_original_name.text = originalWord
        itemView.item_translate_name.text = meaningUi?.meaning?.translation?.text

        itemView.setDebounceOnClickListener {
            meaningUi?.let { meaning -> clickListener(meaning) }
        }
    }

    override fun getLayout() = R.layout.item_single_main
}


