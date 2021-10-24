package com.maximemelyanov.vezdecode2021.dagger.module

import com.maximemelyanov.vezdecode2021.LocalCiceroneHolder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object LocalNavigatorModule {
    @Provides
    @Singleton
    fun provideLocalNavigationHolder(): LocalCiceroneHolder = LocalCiceroneHolder()
}