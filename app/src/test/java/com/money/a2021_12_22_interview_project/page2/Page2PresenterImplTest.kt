package com.money.a2021_12_22_interview_project.page2

import com.money.a2021_12_22_interview_project.page1.MainPresenterImpl
import com.money.a2021_12_22_interview_project.page1.MainVu
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class Page2PresenterImplTest {

    private lateinit var mView : Page2Vu

    private lateinit var presenter : Page2Presenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mView = Mockito.mock(Page2Vu::class.java)
        presenter = Page2PresenterImpl(mView)
        RxAndroidPlugins.setInitMainThreadSchedulerHandler {
            Schedulers.trampoline()
        }
    }
    @Test
    fun testOnActivityStart() {
        presenter.onActivityStart("XXX")
    }
    @Test
    fun testOnActivityDestroy() {
        presenter.onActivityDestroy()
    }
    @Test
    fun testOnBackButtonClickListener() {
        presenter.onBackButtonClickListener()
        verify(mView).closePage()
    }
    @Test
    fun testOnBlogUrlClickListener() {
        presenter.onBlogUrlClickListener("XXXX")
        verify(mView).goToBlogPage("XXXX")
    }
}