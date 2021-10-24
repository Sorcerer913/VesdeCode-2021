package com.maximemelyanov.vezdecode2021.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Counters {
    @SerializedName("albums")
    @Expose
    var albums = 0

    @SerializedName("audios")
    @Expose
    var audios = 0

    @SerializedName("followers")
    @Expose
    var followers = 0

    @SerializedName("friends")
    @Expose
    var friends = 0

    @SerializedName("gifts")
    @Expose
    var gifts = 0

    @SerializedName("online_friends")
    @Expose
    var onlineFriends = 0

    @SerializedName("pages")
    @Expose
    var pages = 0

    @SerializedName("photos")
    @Expose
    var photos = 0

    @SerializedName("subscriptions")
    @Expose
    var subscriptions = 0

    @SerializedName("user_photos")
    @Expose
    var userPhotos = 0

    @SerializedName("videos")
    @Expose
    var videos = 0

    @SerializedName("new_photo_tags")
    @Expose
    var newPhotoTags = 0

    @SerializedName("new_recognition_tags")
    @Expose
    var newRecognitionTags = 0

    @SerializedName("clips_followers")
    @Expose
    var clipsFollowers = 0

    @SerializedName("groups")
    @Expose
    var groups = 0
}