package com.comers.shenwu.camera

import com.comers.baselibrary.base.BaseActivity
import com.comers.shenwu.R
import kotlinx.android.synthetic.main.activity_camera.*

/**
 * Created by 79653 on 2018/6/7.
 * 描述：
 */

class KotlinActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_camera
    }

    override fun initView() {
        btnCamera.setOnClickListener {

        }
        var list = mutableListOf<String>()
        list.add("")
        var listss = listOf<String>()
        list.forEachIndexed { index, s ->
            if (s.isNullOrEmpty()) {
                s.isNullOrBlank()
            }
        }

    }

    override fun initListener() {

    }

    override fun initData() {
    }


}