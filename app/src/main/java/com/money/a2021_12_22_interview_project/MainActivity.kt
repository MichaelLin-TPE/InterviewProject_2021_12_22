package com.money.a2021_12_22_interview_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() ,MainVu{

    private lateinit var presenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initPresenter()
    }

    private fun initPresenter() {
        presenter = MainPresenterImpl(this)
    }

    private fun initView() {

    }

    override fun onStart() {
        super.onStart()
        presenter.onActivityStart()
    }

}