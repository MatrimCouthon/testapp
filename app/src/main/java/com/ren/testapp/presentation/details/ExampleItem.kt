package com.ren.testapp.presentation.details

import com.ren.testapp.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_example.view.*

class ExampleItem(private val example: String) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) = with(viewHolder.itemView) {
        item_example_text.text = example
    }

    override fun getLayout() = R.layout.item_example
}