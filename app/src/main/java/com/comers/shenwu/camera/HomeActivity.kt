package com.comers.shenwu.camera

import android.widget.LinearLayout
import com.comers.baselibrary.base.BaseActivity
import com.comers.shenwu.R
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun initView() {
        var videoManager = VideoManager(this, "http://221.228.226.23/11/t/j/v/b/tjvbwspwhqdmgouolposcsfafpedmb/sh.yinyuetai.com/691201536EE4912BF7E4F1E2C67B8119.mp4")
        videoManager.autoPlay = true
        lyContainer.addView(videoManager.videoView, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT))
    }

    override fun initData() {

    }

    override fun initListener() {

    }


}
