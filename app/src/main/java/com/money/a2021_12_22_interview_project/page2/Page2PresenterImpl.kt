package com.money.a2021_12_22_interview_project.page2

import android.util.Log
import com.money.a2021_12_22_interview_project.api.ApiManager
import com.money.a2021_12_22_interview_project.api.UserDetail
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class Page2PresenterImpl(mView:Page2Vu) : Page2Presenter {

    private val mView = mView

    private val disposable = CompositeDisposable()

    override fun onActivityStart(login: String) {

        ApiManager.getRequestApi().getUserDetail(login)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<UserDetail>{
                override fun onSubscribe(d: Disposable) {

                    disposable.add(d)
                }

                override fun onNext(data: UserDetail) {
                    Log.i("Michael","取得USER DETAIL : ${data.name}")
                    mView.showView(data)
                }

                override fun onError(e: Throwable) {
                    Log.i("Michael","取得USER DETAIL ERROR : $e")
                }

                override fun onComplete() {
                    Log.i("Michael","取得USER DETAIL onComplete")
                }

            })

    }

    override fun onActivityDestroy() {
        disposable.clear()
    }

    override fun onBackButtonClickListener() {
        mView.closePage()
    }

    override fun onBlogUrlClickListener(url: String) {
        mView.goToBlogPage(url)
    }


}