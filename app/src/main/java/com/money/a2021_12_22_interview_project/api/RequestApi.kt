package com.money.a2021_12_22_interview_project.api

import io.reactivex.Observer
import retrofit2.http.GET

interface RequestApi {

    @GET("users?since=0&per_page=65")
    fun getAllUser() : Observer<ArrayList<UserData>>
}