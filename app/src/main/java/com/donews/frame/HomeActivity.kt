package com.donews.frame

import com.donews.frame.camera.CameraActivity
import com.liangyibang.baselibrary.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun initView() {
    }

    override fun initListener() {
        toCamera.setOnClickListener {
            toActivity(CameraActivity::class.java)
        }
    }

    override fun initData() {
    }

}
