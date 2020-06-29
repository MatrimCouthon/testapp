package com.ren.testapp.common.base

import androidx.lifecycle.ViewModel
import com.ren.testapp.common.navigator.ScreensNavigator
import com.ren.testapp.common.utils.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel(private val screensNavigator: ScreensNavigator) : ViewModel() {

    protected val disposables = CompositeDisposable()

    val errorEvent = SingleLiveEvent<String>()
    val noInternetErrorEvent = SingleLiveEvent<String>()

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }

    protected fun Disposable.addDisposable() {
        disposables.add(this)
    }

    open fun onBackClick() {
        screensNavigator.navigateBack()
    }
}
