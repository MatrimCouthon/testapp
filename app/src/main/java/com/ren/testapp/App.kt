package com.ren.testapp

import androidx.multidex.MultiDexApplication
import com.ren.testapp.di.AppInjector
import com.ren.testapp.di.CoreModule
import com.ren.testapp.di.DaggerAppComponent
import com.ren.testapp.di.DaggerCoreComponent
import timber.log.Timber

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        initDagger()
        initTimber()
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun initDagger() {
        val coreComponent = DaggerCoreComponent.builder()
            .coreModule(CoreModule(this))
            .build()

        coreComponent.inject(this)

        val appComponent = DaggerAppComponent.builder()
            .coreComponent(coreComponent)
            .build()

        AppInjector.coreComponent = coreComponent
        AppInjector.appComponent = appComponent
    }
}