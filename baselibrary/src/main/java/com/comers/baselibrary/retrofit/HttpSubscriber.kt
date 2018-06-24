package com.comers.baselibrary.retrofit

import io.reactivex.Observer
import io.reactivex.disposables.Disposable


/**
 * Created by 79653 on 2018/6/24.
 * 描述：
 */
open class HttpSubscriber<T>:Observer<T> {
    override fun onSubscribe(d: Disposable) {
    }
    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable) {
    }

    override fun onComplete() {

    }

}