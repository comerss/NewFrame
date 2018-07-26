package com.donews.frame.camera

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.common.eventbus.EventBus

/**
 * Created by 79653 on 2018/6/7.
 * 描述：
 */

class KotlinActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//       initData(2,getData(2))
    }

    private fun initData(data:Int,method:(data:Int)->String) {
        method(data)
//        showToast(getData)
//        EventBus.getDefault().register(this)
        EventBus().unregister(this)
        org.greenrobot.eventbus.EventBus.getDefault().unregister(this)
    }
    fun getData(data:Int) {
         "ddd"
    }
}