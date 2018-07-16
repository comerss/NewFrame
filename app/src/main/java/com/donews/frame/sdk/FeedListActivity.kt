package com.donews.frame.sdk

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.baidu.mobad.feeds.BaiduNative
import com.baidu.mobad.feeds.BaiduNative.BaiduNativeNetworkListener
import com.baidu.mobad.feeds.NativeErrorCode
import com.baidu.mobad.feeds.NativeResponse
import com.baidu.mobad.feeds.RequestParameters
import com.baidu.mobads.SplashAd
import com.baidu.mobads.SplashAdListener
import com.comers.baselibrary.retrofit.RxBaseActivity
import com.donews.frame.R
import com.nontindu.Switch
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_feed.*
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.concurrent.TimeUnit


/**
 * Created by 79653 on 2018/7/16.
 * 描述：
 */
class FeedListActivity:RxBaseActivity() {
    lateinit var adapter: FeedAdapter
    override fun getLayoutId(): Int {
        return R.layout.activity_feed
    }

    override fun initView() {
        Switch.setModCopyBuiltin(true)
        Switch.setModStartActivity(true)
        Switch.setModAPPConfirmPolicy(true)
        Switch.setModVisible(true)
        Switch.setModAdViewShown(true)
        mRecyclerView.layoutManager=LinearLayoutManager(this)
        adapter= FeedAdapter(mContext, arrayListOf())
        mRecyclerView.adapter=adapter
    }

    override fun initListener() {
//        adapter.setOnItemChildClickListener { adapter, view, position ->
//            (adapter.getItem(position)as NativeResponse).handleClick(view)
//        }
        adapter.setOnItemClickListener{holder,view,postion->
            (adapter.getItem(postion)as NativeResponse).handleClick(view)

        }
    }

    override fun initData() {
        Observable.interval(Math.random().toLong()*10+15,TimeUnit.SECONDS)
                .subscribe {
                    showToast(it.toString())
                    getData()
                }
        Observable.interval(Math.random().toLong()*100+40,TimeUnit.SECONDS)
                .subscribe {
                    getSplash()
                }
    }

    private fun getSplash() {
        var splashAd = SplashAd(this, lyContainer, object : SplashAdListener {
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
    }

    private fun getData() {
        val baidu = BaiduNative(this, "5853714",
                object : BaiduNativeNetworkListener {
                    override fun onNativeFail(arg0: NativeErrorCode) {
                        Log.i("FeedListActivity", "onNativeFail reason:" + arg0.name)
                    }

                    override fun onNativeLoad(arg0: List<NativeResponse>?) {
                        if (arg0 != null && arg0.size > 0) {
                           showData(arg0)
                        }
                    }
                })
        /**
         * Step 2. 创建 requestParameters 对象，并将其传给 baidu.makeRequest 来请求广告
         */
        val requestParameters = RequestParameters.Builder()
                .downloadAppConfirmPolicy(RequestParameters.DOWNLOAD_APP_CONFIRM_ONLY_MOBILE)
                .build()
        baidu.makeRequest(requestParameters)
    }

    private fun showData(list: List<NativeResponse>) {
        adapter.addData(list)
        mRecyclerView.scrollToPosition(adapter.data.size-1)
    }
}