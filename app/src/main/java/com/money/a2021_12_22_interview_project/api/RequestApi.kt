package com.money.a2021_12_22_interview_project.api

import io.reactivex.Observable

import retrofit2.http.GET

interface RequestApi {

    @GET("users?since=0&per_page=100")
    fun getAllUser() : Observable<ArrayList<UserData>>
}