package com.maximemelyanov.vezdecode2021.ui.view

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.maximemelyanov.vezdecode2021.R
import com.vk.api.sdk.VK
import com.vk.api.sdk.VK.login
import com.vk.api.sdk.VK.onActivityResult
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKScope
import java.util.ArrayList

class StartActivity : AppCompatActivity() {

    companion object{
        private val TAG = "MainActivity"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
    }

    override fun onStart() {
        super.onStart()

        // Пока без кнопочки
        if(VK.isLoggedIn()){
            updateUI(null)
        }else {
            actionVkSignin(null)
        }
    }

    fun actionVkSignin(view: View?) {
        if (isNetworkAvailable(this)) {
            val arrayList = ArrayList<VKScope>(2)
            arrayList.add(VKScope.WALL)
            arrayList.add(VKScope.PHOTOS)
            login(this, arrayList)
        } else {
            Log.i(TAG, "No internet connection")
            Toast.makeText(this@StartActivity, R.string.no_internet, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val callback: VKAuthCallback = object : VKAuthCallback {
            override fun onLogin(token: VKAccessToken) {
                updateUI(token)
            }

            override fun onLoginFailed(errorCode: Int) {
                Toast.makeText(this@StartActivity, "Ошибка " + errorCode + ". " + getString(R.string.login_failed), Toast.LENGTH_SHORT).show()
            }
        }
        data?.let { onActivityResult(requestCode, resultCode, it, callback) }
    }

    private fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo!!
            .isConnected
    }

    private fun updateUI(vkAccessToken: VKAccessToken?){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}