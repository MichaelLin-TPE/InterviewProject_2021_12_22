package com.money.a2021_12_22_interview_project.page1

interface MainPresenter {

    /**
     * 程式起始點
     */
    fun onActivityStart()

    /**
     * Activity關掉的時候需要做的事情
     */
    fun onActivityDestroy()
    /**
     * Activity背影的時候需要做的事情
     */
    fun onActivityPause()
}