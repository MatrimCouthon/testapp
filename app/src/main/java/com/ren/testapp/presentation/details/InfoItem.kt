package com.ren.testapp.presentation.details

import androidx.recyclerview.widget.LinearLayoutManager
import com.ren.testapp.R
import com.ren.testapp.domain.meaning.MeaningDetails
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_info.view.*

class InfoItem(
    private val meaningDetails: MeaningDetails
) : Item() {

    private val exampleAdapter = GroupAdapter<GroupieViewHolder>().apply {
        addAll(meaningDetails.examples.map {
            ExampleItem(it.text)
        })
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) = with(viewHolder) {
        itemView.item_info_translate.text = meaningDetails.text
        itemView.item_info_transcript.text = meaningDetails.transcription
        itemView.item_info_desc.text = meaningDetails.definition.text

        with(itemView.item_info_exampleRv) {
            adapter = exampleAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun getLayout() = R.layout.item_info

}