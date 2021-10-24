package com.maximemelyanov.vezdecode2021.ui.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maximemelyanov.vezdecode2021.R
import com.maximemelyanov.vezdecode2021.api.VKUserGet
import com.maximemelyanov.vezdecode2021.api.VKUsersGet
import com.maximemelyanov.vezdecode2021.model.VKUser
import com.maximemelyanov.vezdecode2021.model.VKUsers
import com.maximemelyanov.vezdecode2021.presenter.MainPresenter
import com.maximemelyanov.vezdecode2021.ui.recyclerview.CustomRecyclerViewAdapter
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import java.util.*


class MainActivity : MvpAppCompatActivity(), IMainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun provideMainPresenter(): MainPresenter {
        return MainPresenter()
    }

    lateinit var accountImage : ImageView
    lateinit var accountName : TextView
    lateinit var friendsCount : TextView
    lateinit var friends : RecyclerView

    val friendList: LinkedList<VKUser> = LinkedList<VKUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup()
    }

    private fun setup(){

        accountImage = findViewById(R.id.account_image)

        accountName = findViewById(R.id.account_name)

        friendsCount = findViewById(R.id.friend_count_text_view)

        friends = findViewById(R.id.friends_recycler_view)

        val userId = VK.getUserId()

        friends.adapter = CustomRecyclerViewAdapter(this, friendList)

        getAccountInfo(userId)

        getFriends(userId)


    }

    fun getAccountInfo(userId: Int){
        Log.d("MainActivity", "getProfileInfo: $userId")
//        presenter.getProfileInfo(IntArray(VK.getUserId()))
        VK.execute(VKUserGet(userId), object: VKApiCallback<VKUsers> {
            override fun success(result: VKUsers) {
                Log.d("MainActivity", "success: $result")
                successAccount(result)
//                getFriends(result.response?.get(0).)
            }

            override fun fail(error: Exception) {
                Log.d("MainActivity", "fail: $error")
                kotlin.error(error.toString())
            }
        })
    }

    fun getFriends(userId: Int){
//        Log.d("MainActivity", "getProfileInfo: $userId")
////        presenter.getProfileInfo(IntArray(VK.getUserId()))
//        VK.execute(VKUsersGet(userId), object: VKApiCallback<VKUsers> {
//            override fun success(result: VKUsers) {
//                Log.d("MainActivity", "success: $result")
//                successAccount(result)
//            }
//
//            override fun fail(error: Exception) {
//                Log.d("MainActivity", "fail: $error")
//                kotlin.error(error.toString())
//            }
//        })
    }

    override fun loading() {

    }

    @SuppressLint("SetTextI18n")
    override fun successAccount(user: VKUsers) {
        val glide = Glide.with(accountImage)
        glide.load(user.response?.get(0)?.photo_200).into(accountImage)

        accountName.text = user.response?.get(0)?.firstName + " " + user.response?.get(0)?.lastName

        friendsCount.text = friendsCount.text.toString() + user.response?.get(0)?.counters?.friends

    }

    override fun successFriends(friends: List<VKUsers>) {

    }

    override fun error(error: String) {

    }

}