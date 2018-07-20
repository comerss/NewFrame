package com.donews.frame.camera

import android.util.Log
import android.widget.LinearLayout
import com.baidu.mobad.feeds.BaiduNative
import com.baidu.mobad.feeds.NativeErrorCode
import com.baidu.mobad.feeds.NativeResponse
import com.baidu.mobad.feeds.RequestParameters
import com.baidu.mobads.SplashAd
import com.baidu.mobads.SplashAdListener
import com.comers.baselibrary.retrofit.RxBaseActivity
import com.donews.frame.R
import com.donews.frame.sdk.FeedListActivity
import com.nontindu.Switch
import com.trello.rxlifecycle2.android.ActivityEvent
import io.reactivex.Observable
import java.util.concurrent.TimeUnit


/**
 * Created by 79653 on 2018/7/16.
 * 描述：
 */
class SplashActivity: RxBaseActivity() {
    override fun getLayoutId(): Int {
        return  R.layout.activity_splash
    }

    override fun initView() {
        Switch.setModAPPConfirmPolicy(true)
        Switch.setModCopyBuiltin(true)
//        Switch.setModStartActivity(true)
      var splashAd= SplashAd(this, LinearLayout(this), object :  SplashAdListener {
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

        }, "5846395", true)

        val baidu = BaiduNative(this, "5853714",
                object : BaiduNative.BaiduNativeNetworkListener {
                    override fun onNativeFail(arg0: NativeErrorCode) {
                        Log.i("FeedListActivity", "onNativeFail reason:" + arg0.name)
                    }

                    override fun onNativeLoad(arg0: List<NativeResponse>?) {
                        if (arg0 != null && arg0.size > 0) {
                            showToast("信息流陈宫 了")
                        }
                    }
                })
        /**
         * Step 2. 创建 requestParameters 对象，并将其传给 baidu.makeRequest 来请求广告
         */
        val requestParameters = RequestParameters.Builder()
                .downloadAppConfirmPolicy(RequestParameters.DOWNLOAD_APP_CONFIRM_ONLY_MOBILE)
                .build()
//        baidu.makeRequest(requestParameters)
    }

    override fun initListener() {
    }

    override fun initData() {
        var count=0
        Observable.interval(1,TimeUnit.SECONDS)
                .compose(bindUntilEvent(ActivityEvent.PAUSE))
                .subscribe {
                    count++
                    showToast("倒数中${6-count}")
                    if(count==5){
                        toActivity(FeedListActivity::class.java)
                        finish()
                    }
                }
       /* Observable.timer(5, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    toActivity(FeedListActivity::class.java)
                    finish()
//                    showToast("剩余时间$it}")
                }*/

    }
}