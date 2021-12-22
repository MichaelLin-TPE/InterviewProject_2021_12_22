package com.money.a2021_12_22_interview_project.page2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.money.a2021_12_22_interview_project.R
import com.money.a2021_12_22_interview_project.api.UserDetail
import com.money.a2021_12_22_interview_project.tool.ImageLoaderManager

class Page2Activity : AppCompatActivity(),Page2Vu {


    private lateinit var tvName:TextView

    private lateinit var tvLogin:TextView

    private lateinit var tvStatus:TextView

    private lateinit var tvLocation:TextView

    private lateinit var tvBlog:TextView

    private lateinit var ivPhoto:ImageView

    private lateinit var tvBio:TextView

    private lateinit var presenter: Page2Presenter

    private lateinit var ivBack : ImageView

    private var login = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)



        intent.extras.let {
            login = it?.getString("login","").toString()
        }

        Log.i("Michael","取得Login : $login")
        initView()
        initPresenter()

    }

    override fun onStart() {
        super.onStart()
        presenter.onActivityStart(login)
    }

    private fun initPresenter() {
        presenter = Page2PresenterImpl(this)
    }

    private fun initView() {

        tvName = findViewById(R.id.tv_name)
        tvLogin = findViewById(R.id.user_name)
        tvStatus = findViewById(R.id.tv_status)
        tvLocation = findViewById(R.id.tv_location)
        tvBlog = findViewById(R.id.tv_blog)
        ivPhoto = findViewById(R.id.user_photo)
        tvBio = findViewById(R.id.user_bio)
        ivBack = findViewById(R.id.btn_back)

        ivBack.setOnClickListener {
            presenter.onBackButtonClickListener()
        }

        tvBlog.setOnClickListener {
            presenter.onBlogUrlClickListener(tvBlog.text.toString())
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onActivityDestroy()
    }

    override fun showView(data: UserDetail) {
        tvName.text = data.name
        tvLogin.text = data.login
        tvStatus.visibility = if (data.siteAdmin) View.VISIBLE else View.GONE
        tvLocation.text = data.location
        tvBlog.text = data.blogUrl
        ImageLoaderManager.setPhotoUrl(data.avatarUrl,ivPhoto)
        if (data.bio.isNullOrEmpty()){
            tvBio.visibility = View.GONE
            return
        }
        tvBio.text = data.bio
    }

    override fun closePage() {
        finish()
    }

    override fun goToBlogPage(url: String) {
        val it = Intent(Intent.ACTION_VIEW)
        it.data = Uri.parse(url)
        startActivity(it)
    }
}