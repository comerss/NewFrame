package com.comers.baselibrary.retrofit

import io.reactivex.Observer
import io.reactivex.disposables.Disposable


/**
 * Created by 79653 on 2018/6/24.
 * 描述：
 */
open abstract class HttpSubscriber<T>:Observer<T> {
    override fun onSubscribe(d: Disposable) {
    }
    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(e: Throwable) {
        onFail(e.message)
    }

    override fun onComplete() {



    }

    abstract fun onSuccess(t:T)
    fun  onFail(msg:String?,code:Int = 1000){

    }
}