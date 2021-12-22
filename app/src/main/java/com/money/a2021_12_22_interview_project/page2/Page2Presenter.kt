package com.money.a2021_12_22_interview_project.page2

interface Page2Presenter {
    /**
     * 程式起始點
     */
    fun onActivityStart(login: String)

    /**
     * Activity Destroy 時要做的事情
     */
    fun onActivityDestroy()

    /**
     * 點擊BACK ICON
     */
    fun onBackButtonClickListener()

    /**
     * 點擊BlogURL
     */
    fun onBlogUrlClickListener(url: String)
}