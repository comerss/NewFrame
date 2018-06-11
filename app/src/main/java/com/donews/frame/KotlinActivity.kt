package com.donews.frame

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.rxkotlin.subscribeBy

/**
 * Created by 79653 on 2018/6/7.
 * 描述：
 */

class KotlinActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
    }

    private fun initData() {
        Observable.create(ObservableOnSubscribe<Any> {
            it.onNext(5)
            it.onNext(4)
            it.onNext(3)
            it.onNext(2)
            it.onComplete()
        }).subscribeBy {

        }
    }
}