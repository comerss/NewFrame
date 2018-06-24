package com.comers.baselibrary.retrofit

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by 79653 on 2018/6/24.
 * 描述：
 */
object RxHelper {
    fun <T> schedulersTransformer(): ObservableTransformer<T, T> {    //compose简化线程
        return ObservableTransformer { observable ->
            observable.subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }
}