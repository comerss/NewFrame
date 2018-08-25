package com.donews.frame.camera

import android.view.View
import com.comers.baselibrary.base.BaseActivity
import com.donews.frame.R
import com.donews.sdk.base.LogUtils
import com.donews.sdk.bean.AdParams
import com.donews.sdk.interfaces.AdvertiseSplash
import com.donews.sdk.interfaces.InterfaceManager
import com.donews.sdk.manager.AdvertiseManager
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun initView() {
       getAd()
    }

    override fun initListener() {


    }

    override fun initData() {

    }

    private fun getAd() {
        val adParams = AdParams.Builder()  //
                .setAdPosition("6790158e2d9e3cca587027aadac943bb")// 开屏 广告位  //必填参数
                .setAdCount(1)
                .setContext(this)//必填参数
                .setImageAcceptedSize(1080, 1920)//必填参数
                .setSupportDeepLink(false)
                .build()
        AdvertiseManager.getInstance().loadSplash(adParams, object : InterfaceManager.OnSplashListener {
            override fun onLoadSplash(advertiseSplash: AdvertiseSplash) {
                lyContainer.addView(advertiseSplash.splashView)
                advertiseSplash.setInteractionListener(object : AdvertiseSplash.AdvertiseInterationListener {
                    override fun onAdvertiseClicked(view: View, time: Int) {
//                        doSkip = true
                        LogUtils.i("info", "开屏广告点击了")
                    }

                    override fun onAdvertiseShow(view: View, time: Int) {
                        LogUtils.i("info", "开屏广告展示了")
                    }

                    override fun onAdvertiseSkip() {
                        LogUtils.i("info", "开屏广告跳过了")
                        toMainActivity()
                    }

                    override fun onAdvertiseTimeOver() {
                        LogUtils.i("info", "开屏广告倒计时结束")
                        toMainActivity()
                    }
                })
            }

            override fun onTimeOut() {
                toMainActivity()
                LogUtils.i("info", "开屏广告请求超时了")
            }

            override fun onError(code: Int, msg: String) {
                toMainActivity()
                LogUtils.i("info", "开屏广告请求错误" + code + "_" + msg)
            }
        })
    }

    fun toMainActivity() {
//        val intent = Intent(this, FeedActivity::class.java)
//        startActivity(intent)
//        finish()
    }


}
