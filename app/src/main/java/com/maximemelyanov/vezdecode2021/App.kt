package com.maximemelyanov.vezdecode2021

import android.app.Application
import android.content.Intent
import com.github.terrakok.cicerone.Cicerone
import com.maximemelyanov.vezdecode2021.ui.view.StartActivity
import com.vk.api.sdk.VK.addTokenExpiredHandler
import com.vk.api.sdk.VKTokenExpiredHandler

class App : Application() {

    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()

    companion object {
        internal lateinit var INSTANCE: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        addTokenExpiredHandler(tokenTracker)
        INSTANCE = this
    }

    private val tokenTracker: VKTokenExpiredHandler = object : VKTokenExpiredHandler {
        override fun onTokenExpired() {
            val intent = Intent(this@App, StartActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}