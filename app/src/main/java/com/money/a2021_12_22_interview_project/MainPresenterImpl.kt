package com.money.a2021_12_22_interview_project

import android.util.Log
import com.money.a2021_12_22_interview_project.api.ApiManager
import com.money.a2021_12_22_interview_project.api.UserData
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainPresenterImpl(mainVu: MainVu) : MainPresenter {

    private var mView : MainVu = mainVu

    private val disposable = CompositeDisposable()

    override fun onActivityStart() {


        ApiManager.getRequestApi().getAllUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ArrayList<UserData>>{
                override fun onSubscribe(d: Disposable) {
                    disposable.add(d)
                }

                override fun onNext(list: ArrayList<UserData>) {

                    Log.i("Michael","取得User List size : ${list.size}")
                    mView.showUserList(list)
                }

                override fun onError(e: Throwable) {
                    Log.i("Michael","取得User List Error")
                }

                override fun onComplete() {
                    Log.i("Michael","取得User List Success")
                }

            })



    }

    override fun onActivityDestroy() {
        disposable.clear()
    }

    override fun onActivityPause() {
        mView.clearRecyclerView()
    }


}