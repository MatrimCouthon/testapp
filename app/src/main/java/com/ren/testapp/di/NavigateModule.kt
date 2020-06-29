package com.ren.testapp.di

import com.ren.testapp.common.navigator.ScreensNavigator
import com.ren.testapp.common.navigator.ScreensNavigatorImpl
import com.ren.testapp.di.AppScope
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

@Module
class NavigateModule {

    @Provides
    @AppScope
    fun provideNavigationScreens(router: Router) : ScreensNavigator {
        return ScreensNavigatorImpl(router)
    }

    @Provides
    @AppScope
    fun provideCicerone(): Cicerone<Router> = Cicerone.create()

    @Provides
    fun provideCiceroneRouter(cicerone: Cicerone<Router>): Router = cicerone.router

    @Provides
    fun provideCiceroneNavigator(cicerone: Cicerone<Router>): NavigatorHolder =
        cicerone.navigatorHolder

}