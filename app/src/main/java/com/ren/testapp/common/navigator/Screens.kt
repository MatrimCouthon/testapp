package com.ren.testapp.common.navigator

import com.ren.testapp.presentation.details.WordDetailFragment
import com.ren.testapp.presentation.main.MainFragment
import com.ren.testapp.presentation.search.MeaningUi
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object MainFragmentScreen : SupportAppScreen() {
        override fun getFragment() = MainFragment()
    }

    class WordDetailsFragmentScreen(
        private val word: String,
        private val meaning: MeaningUi
    ) : SupportAppScreen() {
        override fun getFragment() = WordDetailFragment.newInstance(word, meaning)
    }
}