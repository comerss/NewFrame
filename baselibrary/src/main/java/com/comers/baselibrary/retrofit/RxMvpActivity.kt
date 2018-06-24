package com.comers.baselibrary.retrofit

import android.os.Bundle

/**
 * Created by code5 on 2017/3/28.
 */
abstract class RxMvpActivity<P : RxPresenter<*>> : RxBaseActivity() {
    var mPresenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        mPresenter = createPresenter()
        super.onCreate(savedInstanceState)
    }

    abstract fun createPresenter(): P

    override fun onDestroy() {
        super.onDestroy()
            mPresenter?.detachView()
    }
}
