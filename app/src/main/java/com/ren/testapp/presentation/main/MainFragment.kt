package com.ren.testapp.presentation.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.ren.testapp.R
import com.ren.testapp.common.base.BaseFragment
import com.ren.testapp.common.ext.createViewModel
import com.ren.testapp.common.ext.observeValue
import com.ren.testapp.common.utils.DialogUtils
import com.ren.testapp.di.AppInjector
import com.ren.testapp.presentation.search.MeaningUi
import com.ren.testapp.presentation.search.SearchUi
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_main_search.*
import java.util.*
import kotlin.concurrent.schedule


class MainFragment : BaseFragment<MainViewModel>(), MoreBottomSheet.MoreClickListener {

    private val searchAdapter = GroupAdapter<GroupieViewHolder>()

    override fun getLayoutId() = R.layout.fragment_main_search

    override fun provideViewModel() = createViewModel {
        AppInjector.appComponent.mainViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRv()
        search.setIconifiedByDefault(false)
        search.queryHint = getString(R.string.default_search_hint)

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            var timer = Timer()

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                timer.cancel()
                val sleep = when (newText.length) {
                    1 -> 1000L
                    2, 3 -> 700L
                    4, 5 -> 500L
                    else -> 300L
                }
                timer = Timer()
                timer.schedule(sleep) {
                    if (newText.isNotEmpty()) {
                        viewModel.onSearchWord(newText)
                    }
                }
                return true
            }
        })

        search.setOnCloseListener {
            viewModel.onCloseClick()
            true
        }

        viewModel.state.observeValue(this) {
            populateAdapter(it.isLoading, it.words)
        }

        viewModel.error.observeValue(this) {
            showErrorMessage(getString(R.string.search_error))
        }
    }

    private fun populateAdapter(
        isLoading: Boolean,
        words: List<SearchUi>
    ) {
        searchAdapter.clear()
        when {
            !isLoading && words.isNullOrEmpty() -> searchAdapter.add(EmptyItem(R.string.default_search))
            isLoading && words.isNullOrEmpty() -> searchAdapter.add(EmptyItem(R.string.default_search_error))
            isLoading && !words.isNullOrEmpty() -> createItems(words)
        }
    }

    private fun createItems(words: List<SearchUi>) {
        searchAdapter.addAll(
            words.map { search ->
                if (search.isSingleItem) {
                    MainSingleItem(
                        search.search.text,
                        search.singleItem
                    ) {
                        viewModel.onOpenDetail(search.search.text, it)
                    }
                } else {
                    MainMoreItem(search) {
                        showDialog(MoreBottomSheet.newInstance(it), "TAG")
                    }
                }
            }
        )
    }

    private fun showErrorMessage(message: String) {
        DialogUtils.showError(view, message)
    }

    private fun initRv() = with(mainRv) {
        layoutManager = LinearLayoutManager(context)
        adapter = searchAdapter
    }

    override fun onWordClick(text: String, meaning: MeaningUi) {
        viewModel.onOpenDetail(text, meaning)
    }
}