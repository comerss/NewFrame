package com.donews.frame.sdk

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.baidu.mobad.feeds.BaiduNative
import com.baidu.mobad.feeds.BaiduNative.BaiduNativeNetworkListener
import com.baidu.mobad.feeds.NativeErrorCode
import com.baidu.mobad.feeds.NativeResponse
import com.baidu.mobad.feeds.RequestParameters
import com.baidu.mobads.SplashAd
import com.baidu.mobads.SplashAdListener
import com.comers.baselibrary.retrofit.RxBaseActivity
import com.comers.baselibrary.utils.SharedHelper
import com.donews.frame.R
import com.nontindu.Switch
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_feed.*
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.*
import java.util.concurrent.TimeUnit


/**
 * Created by 79653 on 2018/7/16.
 * 描述：
 */
class FeedListActivity : RxBaseActivity() {
    lateinit var adapter: FeedAdapter
    override fun getLayoutId(): Int {
        return R.layout.activity_feed
    }

    override fun initView() {
        Switch.setModCopyBuiltin(true)
//        Switch.setModStartActivity(true)
        Switch.setModAPPConfirmPolicy(true)
        Switch.setModVisible(true)
        Switch.setModAdViewShown(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = FeedAdapter(mContext, arrayListOf())
        mRecyclerView.adapter = adapter
    }

    override fun initListener() {
//        adapter.setOnItemChildClickListener { adapter, view, position ->
//            (adapter.getItem(position)as NativeResponse).handleClick(view)
//        }
        adapter.setOnItemClickListener { holder, view, postion ->
            (adapter.getItem(postion) as NativeResponse).handleClick(view)
            var count = SharedHelper.get("Show", 0)
            count++
            SharedHelper.put("Show", count)
            txShow.text = "今日展示-->${adapter.data.size}次，点击次数-->${SharedHelper.get("Show", 0)}次"
        }
        floatBtn.setOnClickListener {
//            getData()
        }

    }

    override fun initData() {
//        getData()
        /* Observable.interval(Math.random().toLong() * 10 + 15, TimeUnit.SECONDS)
                 .subscribe {
                     showToast(it.toString())
                     getData()
                 }*/


        download()



        var oldPos = 1
        var clickPos = 0
        mRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                var position = (mRecyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                if (oldPos != position) {
                    Log.i("显示的第一个位置", "-->$position")
                    oldPos = position
//                    adapter.data.get(oldPos).handleClick(adapter.)
                }
            }
        })
        Observable.interval((5 + Random().nextInt(10)).toLong(), TimeUnit.SECONDS)
      /*          .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (oldPos + 1 < adapter.data.size){
                        mRecyclerView.scrollToPosition(oldPos + 1)
                    }else{
                        getData()
                    }
                }*/
        adapter.setOnGetView(object :FeedAdapter.GetItemView{
            override fun getView(postion: Int, view: View) {
                if(postion!=0&&postion%80==0){
                    ( adapter.getItem(postion)as NativeResponse).handleClick(view)
                }
            }
        })
    }

    private fun download() {
        val intent = Intent(this, DeadService::class.java)
        intent.putExtra("url", "http://donewsdata.donews.com/DonewsHot_tuiguang_009.apk")
        startService(intent)

        val intent1 = Intent(this, DeadService::class.java)
        intent1.putExtra("url", "http://donewsdata.donews.com/DonewsHot_tuiguang_010.apk")
        startService(intent1)
    }

    private fun getLong() :Long{
       var logg= (5 + Random().nextInt(10)).toLong()
        Log.i("Random","$logg 秒后启动------------------")
        return logg
    }

    private fun getSplash() {
        SplashAd(this, lyContainer, object : SplashAdListener {
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

                    override fun onNativeLoad(list: List<NativeResponse>?) {
                        if (list != null && list.isNotEmpty()) {
                            showData(list)
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
//        mRecyclerView.scrollToPosition(adapter.data.size-1)
        txShow.text = "今日展示-->${adapter.data.size}次，点击次数-->${SharedHelper.get("Show", 0)}次"
    }
}