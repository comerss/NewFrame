package com.donews.frame

import com.donews.frame.camera.CameraActivity
import com.liangyibang.baselibrary.base.BaseActivity
import com.liangyibang.baselibrary.http.HttpHelper
import com.liangyibang.baselibrary.http.HttpResult
import com.liangyibang.baselibrary.http.ICallBack
import com.liangyibang.market.base.Data
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
        HttpHelper.doPost("")
                .add(null,null)
                .execute("{}",object :ICallBack<Data>(){
                    override fun onSuccess(sResult: HttpResult<Data>?, json: String?) {

                    }
                })
    }

}
