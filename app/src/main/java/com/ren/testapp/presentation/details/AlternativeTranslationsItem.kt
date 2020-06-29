package com.ren.testapp.presentation.details

import androidx.recyclerview.widget.LinearLayoutManager
import com.ren.testapp.R
import com.ren.testapp.domain.meaning.MeaningDetails
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_alternative.view.*

class AlternativeTranslationsItem(
    private val meaningDetails: MeaningDetails
) : Item() {

    private val alternativeAdapter = GroupAdapter<GroupieViewHolder>().apply {
        addAll(meaningDetails.alternativeTranslations.map {
            AlternativeItem(it)
        })
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) = with(viewHolder) {
        with(itemView.item_alternativeRv) {
            adapter = alternativeAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun getLayout() = R.layout.item_alternative
}