package com.comers.baselibrary.retrofit

import android.content.Context
import com.comers.baselibrary.base.BaseView
import com.comers.baselibrary.base.Presenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by 79653 on 2018/6/24.
 * 描述：
 */
 open class RxPresenter<T : BaseView>(context: Context,t:T) : Presenter<T> {
    var context:Context
    var mView: T? = null
    init {
        attachView(t)
        this.context=context
    }
     var mCompositeDisposable: CompositeDisposable? = null

     fun unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable!!.clear()
        }
    }

     fun addSubscribe(subscription: Disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = CompositeDisposable()
        }
        mCompositeDisposable!!.add(subscription)
    }

    override fun attachView(view: T) {
        this.mView = view
    }

    override fun detachView() {
        this.mView = null
        unSubscribe()
    }
}