package com.maximemelyanov.vezdecode2021.api

import android.util.Log
import com.google.gson.Gson
import com.maximemelyanov.vezdecode2021.model.VKUsers
import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.VKApiResponseParser
import com.vk.api.sdk.VKMethodCall
import com.vk.api.sdk.exceptions.VKApiIllegalResponseException
import com.vk.api.sdk.internal.ApiCommand
import moxy.InjectViewState
import org.json.JSONException

@InjectViewState
class VKUserGet(private val uid: Int): ApiCommand<VKUsers>() {
    override fun onExecute(manager: VKApiManager): VKUsers {

        val result: VKUsers
        val call = VKMethodCall.Builder()
            .method("users.get")
            .args("user_ids", uid)
            .args("fields", "photo_200,first_name,last_name,counters")
            .version(manager.config.version)
            .build()
        result = manager.execute(call, ResponseApiParser())
        return result
    }

    private class ResponseApiParser : VKApiResponseParser<VKUsers> {
        override fun parse(response: String): VKUsers? {
            Log.d("ResponseApiParser", "parse: $response")
            try {
                val user = Gson().fromJson(response, VKUsers::class.java)
                return user
            } catch (ex: JSONException) {
                throw VKApiIllegalResponseException(ex)
//                return null
            }
        }
    }
}