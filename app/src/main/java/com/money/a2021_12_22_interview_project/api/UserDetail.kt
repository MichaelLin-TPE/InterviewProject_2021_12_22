package com.money.a2021_12_22_interview_project.api

import com.google.gson.annotations.SerializedName

class UserDetail {

    @SerializedName("login")
    var login = ""
    @SerializedName("avatar_url")
    var avatarUrl = ""
    @SerializedName("bio")
    var bio = ""
    @SerializedName("location")
    var location = ""
    @SerializedName("blog")
    var blogUrl = ""

    @SerializedName("name")
    var name = ""
    @SerializedName("site_admin")
    var siteAdmin = false

}