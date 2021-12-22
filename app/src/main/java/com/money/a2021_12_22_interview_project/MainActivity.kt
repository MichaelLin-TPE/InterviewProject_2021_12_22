package com.money.a2021_12_22_interview_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.money.a2021_12_22_interview_project.api.UserData

class MainActivity : AppCompatActivity() ,MainVu{

    private lateinit var presenter : MainPresenter

    private lateinit var recyclerView: RecyclerView

    private val adapter = MainAdapter()

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
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.onActivityStart()
    }

    override fun onPause() {
        super.onPause()
        presenter.onActivityPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onActivityDestroy()
    }

    override fun showUserList(list: ArrayList<UserData>) {
        adapter.setDataArray(list)
        recyclerView.adapter = adapter

        adapter.setOnUserItemClickListener{ data->
            Log.i("Michael","Click User Data")
            val it = Intent(this,Page2Activity::class.java)
            it.putExtra("data",data)
            startActivity(it)
            overridePendingTransition(R.anim.fadein,R.anim.fadeout)

        }


    }

    override fun clearRecyclerView() {
        adapter.setDataArray(ArrayList())
        adapter.notifyDataSetChanged()
    }

}