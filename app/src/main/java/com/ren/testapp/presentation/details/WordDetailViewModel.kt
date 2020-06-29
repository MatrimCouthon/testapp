package com.ren.testapp.presentation.details

import androidx.lifecycle.MutableLiveData
import com.ren.testapp.common.base.BaseViewModel
import com.ren.testapp.common.ext.applySchedulers
import com.ren.testapp.common.ext.isNonInitialized
import com.ren.testapp.common.ext.nonNullValue
import com.ren.testapp.common.navigator.ScreensNavigator
import com.ren.testapp.common.utils.SingleLiveEvent
import com.ren.testapp.domain.meaning.LoadDetailsUseCase
import com.ren.testapp.domain.meaning.MeaningDetails
import timber.log.Timber
import javax.inject.Inject

class WordDetailViewModel @Inject constructor(
    screensNavigator: ScreensNavigator,
    private val loadDetailsUseCase: LoadDetailsUseCase
) : BaseViewModel(screensNavigator) {

    val state = MutableLiveData<State>()
    val error = SingleLiveEvent<Unit>()

    init {
        if (state.isNonInitialized()) {
            state.value = State(isLoading = false)
        }
    }

    fun loadData(id: Int) {
        loadDetailsUseCase.loadDetails(id)
            .applySchedulers()
            .subscribe(
                {
                    state.value = state.nonNullValue.copy(isLoading = true, meaningDetails = it)
                },
                {
                    state.value = state.nonNullValue.copy(isLoading = true)
                    error.call()
                    Timber.e(it)
                }
            )
            .addDisposable()
    }

    data class State(
        val isLoading: Boolean,
        val meaningDetails: MeaningDetails? = null
    )
}