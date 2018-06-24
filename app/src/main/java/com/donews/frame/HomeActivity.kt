package com.donews.frame

import com.donews.frame.camera.CameraActivity
import com.comers.baselibrary.base.BaseActivity
import com.comers.baselibrary.http.HttpHelper
import com.comers.baselibrary.http.HttpResult
import com.comers.baselibrary.http.ICallBack
import com.comers.market.base.Data
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
                .baseUrl("jfdiiii")
                .execute("{}",object :ICallBack<Data>(){
                    override fun onSuccess(sResult: HttpResult<Data>?, json: String?) {

                    }
                })
    }

}
