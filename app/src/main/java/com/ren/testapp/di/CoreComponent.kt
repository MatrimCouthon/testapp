package com.ren.testapp.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.ren.testapp.common.base.BaseFragment
import com.ren.testapp.common.base.BaseViewModel
import com.ren.testapp.di.CoreModule
import com.squareup.moshi.Moshi
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(
    modules = [CoreModule::class]
)
interface CoreComponent {
    fun inject(app: Application)
    fun inject(baseFragment: BaseFragment<BaseViewModel>)

    val context: Context
    val moshi: Moshi
    val retrofit: Retrofit
    val prefs: SharedPreferences
}