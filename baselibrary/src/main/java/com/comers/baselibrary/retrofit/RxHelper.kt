package com.comers.baselibrary.retrofit

import com.comers.baselibrary.http.HttpResult
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by 79653 on 2018/6/24.
 *Rxjava的工具类 一些功能的抽取
 */
object RxHelper {
    fun <T> schedulersTransformer(): ObservableTransformer<T, T> {    //compose简化线程
        return ObservableTransformer { observable ->
            observable.subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> handleResult(): ObservableTransformer<HttpResult<T>, T> {
        return ObservableTransformer { upstream ->
            upstream.flatMap {
                if(it.success){
                    createData(it.data)
                }else{
                    Observable.error(HttpException(it.msg,it.code))
                }
            }
        }
    }

    private fun <T> createData(t: T): Observable<T> {
        return Observable.create { subscriber ->
            try {
                subscriber.onNext(t)
                subscriber.onComplete()
            } catch (e: Exception) {
                subscriber.onError(e)
            }
        }
    }
}