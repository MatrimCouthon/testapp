package com.ren.testapp.presentation.main

import com.ren.testapp.R
import com.ren.testapp.common.ext.setDebounceOnClickListener
import com.ren.testapp.domain.search.Search
import com.ren.testapp.presentation.search.SearchUi
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_more_main.view.*

class MainMoreItem(
    private val searchUi: SearchUi,
    private val clickListener: (SearchUi) -> Unit
) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) = with(viewHolder) {
        itemView.item_more_count.text = searchUi.search.meanings.size.toString()
        itemView.item_more_name.text = searchUi.search.text

        itemView.setDebounceOnClickListener {
            clickListener(searchUi)
        }
    }

    override fun getLayout() = R.layout.item_more_main
}