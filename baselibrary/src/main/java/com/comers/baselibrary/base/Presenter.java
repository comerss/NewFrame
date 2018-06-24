package com.comers.baselibrary.base;

/**
 * Created by code5 on 2017/3/28.
 */
public interface Presenter<V extends BaseView> {

    void attachView(V view);

    void detachView();

}

