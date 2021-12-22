package com.money.a2021_12_22_interview_project.page1

import com.money.a2021_12_22_interview_project.api.ApiManager
import com.money.a2021_12_22_interview_project.api.UserData
import io.reactivex.Observer
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.runners.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MainPresenterImplTest {

    @Mock
    private lateinit var mView : MainVu

    private lateinit var presenter : MainPresenter

    @Before
    fun setUp(){

        MockitoAnnotations.initMocks(this)
        mView = Mockito.mock(MainVu::class.java)
        presenter = MainPresenterImpl(mView)
        RxAndroidPlugins.setInitMainThreadSchedulerHandler {
            Schedulers.trampoline()
        }
    }

    @Test
    fun testOnActivityStart() {
        presenter.onActivityStart()

    }
    @Test
    fun testOnActivityDestroy() {
        presenter.onActivityDestroy()
    }
    @Test
    fun testOnActivityPause() {
        presenter.onActivityPause()
        mView.clearRecyclerView()
    }

    @Test
    fun onUserItemClickListener(){
        val data = UserData()
        presenter.onUserItemClickListener(data)
        verify(mView).intentToPage2(data)
    }

}