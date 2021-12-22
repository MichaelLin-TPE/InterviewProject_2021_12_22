package com.money.a2021_12_22_interview_project.page2

import com.money.a2021_12_22_interview_project.api.UserDetail

interface Page2Vu {
    fun showView(data: UserDetail)
    fun closePage()
    fun goToBlogPage(url: String)
}