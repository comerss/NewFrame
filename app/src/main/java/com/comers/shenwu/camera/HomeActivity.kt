package com.comers.shenwu.camera

import android.webkit.DownloadListener
import android.webkit.WebView
import android.widget.LinearLayout
import com.comers.annotation.annotation.EventReceiver
import com.comers.baselibrary.base.BaseActivity
import com.comers.shenwu.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_splash.*


class HomeActivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun initView() {
//        var videoManager = VideoManager(this, "http://221.228.226.23/11/t/j/v/b/tjvbwspwhqdmgouolposcsfafpedmb/sh.yinyuetai.com/691201536EE4912BF7E4F1E2C67B8119.mp4")
//        videoManager.autoPlay = true
//        lyContainer.addView(videoManager.videoView, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT))
        WebView(this).setDownloadListener(object : DownloadListener {
            override fun onDownloadStart(url: String?, userAgent: String?, contentDisposition: String?, mimetype: String?, contentLength: Long) {

            }

        })
    }

    override fun initData() {

    }

    override fun initListener() {
        txReceive.setOnClickListener {
            toActivity(ClearActivity::class.java)
        }
    }


    //okBus
    @EventReceiver(from = [])
    fun onRefresh(str: String) {
        txReceive.text = str
    }

}
