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

   /* fun <T> handleResult(): ObservableTransformer<HttpResult<T>, T> { //compose判断结果
       *//* return ObservableTransformer<Any, T> { httpResponseFlowable ->
            httpResponseFlowable.flatMap { tGankHttpResponse ->
                if (!tGankHttpResponse.getError()) {
                    createData(tGankHttpResponse.getResults())
                } else {
                    Flowable.error(ApiException("服务器返回error"))
                }
            }
        }*//*
    }*/
}