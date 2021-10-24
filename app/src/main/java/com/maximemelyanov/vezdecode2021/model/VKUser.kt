package com.maximemelyanov.vezdecode2021.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class VKUser {
    @SerializedName("first_name")
    @Expose
    var firstName: String? = null

    @SerializedName("id")
    @Expose
    var id = 0

    @SerializedName("last_name")
    @Expose
    var lastName: String? = null

    @SerializedName("can_access_closed")
    @Expose
    var isCanAccessClosed = false

    @SerializedName("is_closed")
    @Expose
    var isIsClosed = false
        private set

    @SerializedName("photo_200")
    @Expose
    var photo_200: String? = null

    @SerializedName("counters")
    @Expose
    var counters: Counters? = null

    fun setIsClosed(isClosed: Boolean) {
        isIsClosed = isClosed
    }
}