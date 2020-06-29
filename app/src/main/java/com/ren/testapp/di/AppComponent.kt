package com.ren.testapp.di

import com.ren.testapp.presentation.LaunchActivity
import com.ren.testapp.presentation.LaunchViewModel
import com.ren.testapp.presentation.details.WordDetailViewModel
import com.ren.testapp.presentation.main.MainViewModel
import dagger.Component
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Scope

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope

@AppScope
@Component(
    modules = [AppModule::class, NavigateModule::class], dependencies = [CoreComponent::class]
)
interface AppComponent {
    fun inject(launchActivity: LaunchActivity)
    val launchViewModel: LaunchViewModel
    val mainViewModel: MainViewModel
    val wordDetailViewModel: WordDetailViewModel

    //Cicerone
    val router: Router
    val navigatorHolder: NavigatorHolder
}