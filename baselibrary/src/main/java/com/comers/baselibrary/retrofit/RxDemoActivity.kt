package com.comers.baselibrary.retrofit

import com.comers.baselibrary.http.HttpResult
import com.comers.market.base.Data
import com.trello.rxlifecycle2.android.ActivityEvent

/**
 * Created by 79653 on 2018/6/24.
 * 描述：
 */
class RxDemoActivity : RxMvpActivity<HomePresenter>(),HomeView {
    override fun createPresenter(): HomePresenter {
        return HomePresenter(this,this)
    }

    override fun getLayoutId(): Int {
        return 1234
    }

    override fun initView() {
        RetrofitHelper.create().getData().compose(bindUntilEvent(ActivityEvent.DESTROY))
                .compose(RxHelper.schedulersTransformer())
                .subscribe(object : HttpSubscriber<HttpResult<Data>>(){
                    override fun onSuccess(t: HttpResult<Data>) {
                        //TODO异常处理
                    }

                })
    }

    override fun initListener() {
    }

    override fun initData() {
    }
}