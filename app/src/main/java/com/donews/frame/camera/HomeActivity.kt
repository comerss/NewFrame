package com.donews.frame.camera

import com.comers.baselibrary.base.BaseActivity
import com.donews.frame.R
import io.reactivex.Observable


class HomeActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun initView() {
    }

    override fun initListener() {
        Observable.just("000").doOnNext {

        }.subscribe {

        }
    }

    override fun initData() {

    }


    fun toMainActivity() {
//        val intent = Intent(this, FeedActivity::class.java)
//        startActivity(intent)
//        finish()
    }


}
