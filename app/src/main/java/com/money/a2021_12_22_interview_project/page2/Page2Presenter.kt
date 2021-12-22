package com.money.a2021_12_22_interview_project.page2

interface Page2Presenter {
    fun onActivityStart(login: String)
    fun onActivityDestroy()
    fun onBackButtonClickListener()
    fun onBlogUrlClickListener(url: String)
}