package com.money.a2021_12_22_interview_project.page1

import com.money.a2021_12_22_interview_project.api.UserData

interface MainVu {
    fun showUserList(list: ArrayList<UserData>)
    fun clearRecyclerView()
    fun intentToPage2(data: UserData)
}