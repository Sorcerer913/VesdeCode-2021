package com.maximemelyanov.vezdecode2021

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class LocalCiceroneHolder {
    private val containers = HashMap<String, Cicerone<Router>>()

    fun getCicerone(containerTag: String): Cicerone<Router> =
        containers.getOrPut(containerTag) {
            Cicerone.Companion.create()
        }
}