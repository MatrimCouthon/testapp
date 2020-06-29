package com.ren.testapp.presentation

import com.ren.testapp.common.base.BaseViewModel
import com.ren.testapp.common.navigator.ScreensNavigator
import javax.inject.Inject

class LaunchViewModel @Inject constructor(
    private val screensNavigator: ScreensNavigator
) : BaseViewModel(screensNavigator) {

    fun onOpenStartScreen() {
        screensNavigator.navigateToSearch()
    }
}