package com.donews.frame.camera

import com.baidu.mobads.SplashAd
import com.baidu.mobads.SplashAdListener
import com.comers.baselibrary.retrofit.RxBaseActivity
import com.donews.frame.R
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * Created by 79653 on 2018/7/16.
 * 描述：
 */
class SplashActivity: RxBaseActivity() {
    override fun getLayoutId(): Int {
        return  R.layout.activity_splash
    }

    override fun initView() {
        SplashAd(this, lyContainer, object :SplashAdListener{
            override fun onAdFailed(p0: String?) {
                showToast(p0)
            }

            override fun onAdDismissed() {
                showToast("不可见了")
            }

            override fun onAdClick() {
                showToast("点击了")
            }

            override fun onAdPresent() {
                showToast("广告可见了")
            }

        }, "5846395",
                true)
    }

    override fun initListener() {
    }

    override fun initData() {
        /*Observable.timer(5,TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    toActivity(SdkActivity::class.java)
                    showToast("剩余时间$it}")
                }*/

    }
}