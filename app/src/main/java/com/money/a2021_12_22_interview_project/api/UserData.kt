package com.money.a2021_12_22_interview_project.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class UserData : Serializable{

    @SerializedName("avatar_url")
    var avatarUrl:String = ""
    @SerializedName("login")
    var login:String = ""
    @SerializedName("id")
    var id = ""
    @SerializedName("node_id")
    var nodeId = ""
    @SerializedName("gravatar_id")
    var gravatarId = ""
    @SerializedName("url")
    var url = ""
    @SerializedName("html_url")
    var htmlUrl = ""
    @SerializedName("followers_url")
    var followersUrl = ""
    @SerializedName("following_url")
    var followingUrl = ""
    @SerializedName("gists_url")
    var gistsUrl = ""
    @SerializedName("starred_url")
    var starredUrl = ""
    @SerializedName("subscriptions_url")
    var subscriptionsUrl = ""
    @SerializedName("organizations_url")
    var organizationsUrl = ""
    @SerializedName("repos_url")
    var reposUrl = ""
    @SerializedName("events_url")
    var eventsUrl = ""
    @SerializedName("received_events_url")
    var receivedEventsUrl = ""
    @SerializedName("type")
    var type = ""
    @SerializedName("site_admin")
    var siteAdmin = false



}