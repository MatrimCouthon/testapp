package com.ren.testapp.presentation.main

import androidx.annotation.StringRes
import com.ren.testapp.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_no_words.view.*

class EmptyItem(
    @StringRes private val emptyMsg: Int
) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) = with(viewHolder.itemView) {
        itemEmptyMsg.text = context.getString(emptyMsg)
    }

    override fun getLayout() = R.layout.item_no_words

}