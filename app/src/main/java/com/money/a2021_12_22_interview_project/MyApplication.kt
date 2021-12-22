package com.money.a2021_12_22_interview_project

import android.app.Application
import android.content.Context
import com.money.a2021_12_22_interview_project.tool.ImageLoaderManager

class MyApplication : Application() {

    lateinit var instance : Application

    override fun onCreate() {
        super.onCreate()
        instance = this
        //初始化 ImageLoader
        ImageLoaderManager.init(this)
    }

}