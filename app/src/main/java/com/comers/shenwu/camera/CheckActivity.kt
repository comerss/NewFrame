package com.comers.shenwu.camera

import android.os.Handler
import android.os.Message

import com.comers.baselibrary.base.BaseActivity

/**
 * Created by 79653 on 2018/11/21.
 * 描述：
 */
class CheckActivity : BaseActivity() {
    internal var mHandler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
        }
    }

    override fun getLayoutId(): Int {
        return 0
    }

    override fun initView() {

    }

    override fun initListener() {

    }

    override fun initData() {

    }
}
