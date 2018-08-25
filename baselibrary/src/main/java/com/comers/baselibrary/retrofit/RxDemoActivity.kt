package com.comers.baselibrary.retrofit

/**
 * Created by 79653 on 2018/6/24.
 * 描述：
 */
class RxDemoActivity : RxMvpActivity<HomePresenter>(),HomeView {
    override fun getData() {

    }

    override fun createPresenter(): HomePresenter {
        return HomePresenter(this,this)
    }

    override fun getLayoutId(): Int {
        return 1234
    }

    override fun initView() {

    }

    override fun initListener() {
    }

    override fun initData() {
    }
}