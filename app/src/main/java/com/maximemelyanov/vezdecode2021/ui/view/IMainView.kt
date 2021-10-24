package com.maximemelyanov.vezdecode2021.ui.view

import com.maximemelyanov.vezdecode2021.model.VKUsers
import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface IMainView : MvpView {
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun loading()

    @StateStrategyType(SingleStateStrategy::class)
    fun successAccount(user: VKUsers)

    @StateStrategyType(SingleStateStrategy::class)
    fun successFriends(friends: List<VKUsers>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun error(error_msg: String)
}
