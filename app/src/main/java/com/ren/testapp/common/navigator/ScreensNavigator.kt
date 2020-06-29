package com.ren.testapp.common.navigator

import com.ren.testapp.presentation.search.MeaningUi

interface ScreensNavigator {
    fun navigateBack()
    fun navigateToSearch()
    fun navigateToDetails(word: String, meaning: MeaningUi)
}