package com.ren.testapp.di

import com.ren.testapp.data.ServiceImpl
import com.ren.testapp.domain.Service
import com.ren.testapp.domain.meaning.LoadDetailsUseCase
import com.ren.testapp.domain.meaning.LoadDetailsUseCaseImpl
import com.ren.testapp.domain.search.LoadWordUseCase
import com.ren.testapp.domain.search.LoadWordUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module(includes = [AppModule.BindsModule::class])
class AppModule {

    @Provides
    fun api(retrofit: Retrofit): ServiceImpl.Api = retrofit.create()

    @Module
    abstract inner class BindsModule {
        @Binds
        abstract fun service(arg: ServiceImpl): Service

        @Binds
        abstract fun loadWordUseCase(arg: LoadWordUseCaseImpl): LoadWordUseCase

        @Binds
        abstract fun loadDetailsUseCase(arg: LoadDetailsUseCaseImpl): LoadDetailsUseCase
    }
}