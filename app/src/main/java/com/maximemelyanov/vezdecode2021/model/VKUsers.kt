package com.maximemelyanov.vezdecode2021.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class VKUsers {

    @SerializedName("response")
    @Expose
    val response: List<VKUser>? = null

}