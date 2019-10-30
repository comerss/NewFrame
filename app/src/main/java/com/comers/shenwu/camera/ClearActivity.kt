package com.comers.shenwu.camera

import com.comers.baselibrary.base.BaseActivity
import com.comers.baselibrary.http.HttpHelper
import com.comers.baselibrary.http.HttpResult
import com.comers.baselibrary.http.ICallBack
import com.comers.baselibrary.utils.PhoneInfoUtils
import com.comers.shenwu.R
import com.comers.shenwu.bus.OkBus
import kotlinx.android.synthetic.main.activity_clear.*

/**
 * Created by 79653 on 2018/9/14.
 * 描述：
 */
class ClearActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_clear
    }

    override fun initView() {
        btnClear.setOnClickListener {
            //            clear()
        OkBus.Instance.post("我是 一颗响当当 砸不匾 炒不爆 响当当的一颗铜豌豆")
        }
    }

    private fun clear() {
        var dpid = PhoneInfoUtils.getAndroidID(this)
        var url = "http://182.92.203.215:9001/v1/xingyou/app/resetOpenFre?dpid=${dpid}"
        HttpHelper.doPost(url)
                .add("iij", this)
                .execute(object : ICallBack<String>() {
                    override fun onSuccess(sResult: HttpResult<String>?, json: String?) {

                    }

                })
    }

    override fun initListener() {
    }

    override fun initData() {
    }
}