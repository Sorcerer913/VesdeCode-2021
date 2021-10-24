package com.maximemelyanov.vezdecode2021.presenter

import android.util.Log
import com.maximemelyanov.vezdecode2021.api.VKUserGet
import com.maximemelyanov.vezdecode2021.model.VKUsers
import com.maximemelyanov.vezdecode2021.ui.view.IMainView
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import moxy.InjectViewState
import moxy.MvpPresenter


@InjectViewState
class MainPresenter : MvpPresenter<IMainView?>() {

    fun getProfileInfo(user: Int){
        Log.d("MainActivity", "getProfileInfo: $user")
//        presenter.getProfileInfo(IntArray(VK.getUserId()))
        VK.execute(VKUserGet(user), object: VKApiCallback<VKUsers> {
            override fun success(result: VKUsers) {
                Log.d("MainActivity", "success: $result")
                viewState?.successAccount(result)
            }

            override fun fail(error: Exception) {
                Log.d("MainActivity", "fail: $error")
                error(error.toString())
            }
        })
    }

    fun getFriends(user: Int){
        Log.d("MainActivity", "getProfileInfo: $user")
//        presenter.getProfileInfo(IntArray(VK.getUserId()))
        VK.execute(VKUserGet(user), object: VKApiCallback<VKUsers> {
            override fun success(result: VKUsers) {
                Log.d("MainActivity", "success: $result")
                viewState?.successAccount(result)
            }

            override fun fail(error: Exception) {
                Log.d("MainActivity", "fail: $error")
                error(error.toString())
            }
        })
    }

    init {
        Log.d("MainPresenter", "init")
        getProfileInfo(user = VK.getUserId())
    }
}