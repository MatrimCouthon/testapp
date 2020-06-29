package com.ren.testapp.presentation.main

import androidx.lifecycle.MutableLiveData
import com.ren.testapp.common.base.BaseViewModel
import com.ren.testapp.common.ext.applySchedulers
import com.ren.testapp.common.ext.isNonInitialized
import com.ren.testapp.common.ext.nonNullValue
import com.ren.testapp.common.navigator.ScreensNavigator
import com.ren.testapp.common.utils.SingleLiveEvent
import com.ren.testapp.domain.search.LoadWordUseCase
import com.ren.testapp.presentation.search.MeaningUi
import com.ren.testapp.presentation.search.SearchUi
import com.ren.testapp.presentation.search.SearchUiTransformer
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val screensNavigator: ScreensNavigator,
    private val loadWordUseCase: LoadWordUseCase,
    private val searchUiTransformer: SearchUiTransformer
) : BaseViewModel(screensNavigator) {

    val state = MutableLiveData<State>()
    val error = SingleLiveEvent<Unit>()

    init {
        if (state.isNonInitialized()) {
            state.value = State(isLoading = false)
        }
    }

    fun onSearchWord(query: String) {
        loadWordUseCase.loadWords(query)
            .delay(400, TimeUnit.MILLISECONDS)
            .map {
                it.map { search ->
                    searchUiTransformer.transform(search)
                }
            }
            .applySchedulers()
            .subscribe(
                {
                    state.value = state.nonNullValue.copy(isLoading = true, words = it)
                },
                {
                    error.call()
                    state.value = state.nonNullValue.copy(isLoading = true)
                })
            .addDisposable()
    }

    fun onOpenDetail(text: String, meaning: MeaningUi) {
        screensNavigator.navigateToDetails(text, meaning)
    }

    fun onCloseClick() {
        state.value = state.nonNullValue.copy(isLoading = false, words = emptyList())
    }

    data class State(
        val isLoading: Boolean,
        val words: List<SearchUi> = emptyList()
    )
}