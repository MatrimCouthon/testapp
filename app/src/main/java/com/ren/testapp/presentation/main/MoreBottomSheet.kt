package com.ren.testapp.presentation.main

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ren.testapp.R
import com.ren.testapp.common.utils.FragmentArgumentDelegate
import com.ren.testapp.common.utils.bottomsheet.BaseBottomSheetDialog
import com.ren.testapp.presentation.search.MeaningUi
import com.ren.testapp.presentation.search.SearchUi
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.dialog_more_word.view.*

class MoreBottomSheet : BaseBottomSheetDialog() {

    companion object {
        fun newInstance(search: SearchUi) = MoreBottomSheet().apply {
            this.search = search
        }
    }

    private var search: SearchUi by FragmentArgumentDelegate()
    private val dialogAdapter = GroupAdapter<GroupieViewHolder>()
    private lateinit var clickListener: MoreClickListener

    override fun getLayoutId() = R.layout.dialog_more_word

    override fun setupView(view: View) {
        super.setupView(view)
        initRv(view)
        populateAdapter(search)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        clickListener = when {
            parentFragment is MoreClickListener -> parentFragment as MoreClickListener
            context is MoreClickListener -> context
            else -> throw IllegalStateException("Either parentFragment or context must implement ItemClickListener")
        }
    }

    private fun populateAdapter(search: SearchUi) {
        dialogAdapter.clear()
        dialogAdapter.addAll(
            search.meanings.map {
                MainSingleItem(search.search.text, it) {
                    clickListener.onWordClick(search.search.text, it)
                }
            }
        )
    }

    private fun initRv(view: View) = with(view.dialogRv) {
        layoutManager = LinearLayoutManager(context)
        adapter = dialogAdapter
    }

    interface MoreClickListener {
        fun onWordClick(text: String, meaning: MeaningUi)
    }
}