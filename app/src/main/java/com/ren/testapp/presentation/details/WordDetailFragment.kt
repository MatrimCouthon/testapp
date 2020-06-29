package com.ren.testapp.presentation.details

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.ren.testapp.R
import com.ren.testapp.common.base.BaseFragment
import com.ren.testapp.common.ext.createViewModel
import com.ren.testapp.common.ext.observeValue
import com.ren.testapp.common.utils.DialogUtils
import com.ren.testapp.common.utils.FragmentArgumentDelegate
import com.ren.testapp.di.AppInjector
import com.ren.testapp.domain.meaning.MeaningDetails
import com.ren.testapp.presentation.main.EmptyItem
import com.ren.testapp.presentation.search.MeaningUi
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_details.*

class WordDetailFragment : BaseFragment<WordDetailViewModel>() {

    companion object {
        fun newInstance(originalWord: String, meaningUi: MeaningUi) = WordDetailFragment()
            .apply {
                this.meaningUi = meaningUi
                this.originalWord = originalWord
            }
    }

    private val detailsAdapter = GroupAdapter<GroupieViewHolder>()
    private var meaningUi: MeaningUi by FragmentArgumentDelegate()
    private var originalWord: String by FragmentArgumentDelegate()

    override fun getLayoutId() = R.layout.fragment_details

    override fun provideViewModel() = createViewModel {
        AppInjector.appComponent.wordDetailViewModel
    }.apply {
        loadData(meaningUi.meaning.id)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.title = originalWord
        Glide.with(detailsImage)
            .load(meaningUi.imageUrl)
            .placeholder(R.drawable.ic_book)
            .into(detailsImage)
        initRv()

        viewModel.state.observeValue(this) {
            populateAdapter(it.meaningDetails)
        }

        viewModel.error.observeValue(this) {
            showErrorMessage(getString(R.string.search_error))
        }
    }

    private fun populateAdapter(meaningDetails: MeaningDetails?) {
        detailsAdapter.clear()
        if (meaningDetails == null) {
            EmptyItem(R.string.app_name)
        } else {
            detailsAdapter.add(InfoItem(meaningDetails))
            detailsAdapter.add(AlternativeTranslationsItem(meaningDetails))
        }
    }

    private fun showErrorMessage(message: String) {
        DialogUtils.showError(view, message)
    }

    private fun initRv() = with(detailsRv) {
        layoutManager = LinearLayoutManager(context)
        adapter = detailsAdapter
    }
}