package com.money.a2021_12_22_interview_project.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {

    companion object{

        private const val BASE_URL = "https://api.github.com/"

        private val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

        private val retrofit = retrofitBuilder.build()

        private val requestApi = retrofit.create(RequestApi::class.java)

        fun getRequestApi():RequestApi = requestApi

    }


}