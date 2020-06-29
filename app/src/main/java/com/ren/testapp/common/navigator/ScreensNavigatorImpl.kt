package com.ren.testapp.common.navigator

import com.ren.testapp.presentation.search.MeaningUi
import ru.terrakok.cicerone.Router

class ScreensNavigatorImpl constructor(
    private val router: Router
) : ScreensNavigator {
    override fun navigateBack() = router.exit()
    override fun navigateToSearch() = router.newRootScreen(Screens.MainFragmentScreen)
    override fun navigateToDetails(word: String, meaning: MeaningUi) =
        router.navigateTo(Screens.WordDetailsFragmentScreen(word, meaning))
}