package com.donews.frame.camera

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

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
    }
    fun getData(data:Int) {
         "ddd"
    }
}