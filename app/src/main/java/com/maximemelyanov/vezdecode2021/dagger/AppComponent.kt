package com.maximemelyanov.vezdecode2021.dagger

import com.maximemelyanov.vezdecode2021.ui.view.StartActivity
import com.maximemelyanov.vezdecode2021.dagger.module.LocalNavigatorModule
import com.maximemelyanov.vezdecode2021.dagger.module.NavigationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NavigationModule::class,
    LocalNavigatorModule::class]
)

interface AppComponent {

    fun inject(activity: StartActivity)
}