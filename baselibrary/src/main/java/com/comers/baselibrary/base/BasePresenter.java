package com.comers.baselibrary.base;

import android.content.Context;

import com.comers.baselibrary.utils.ToastUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by code5 on 2017/3/28.
 */
public class BasePresenter<V extends BaseView> implements Presenter<V> {
    protected V mView;
    public Map<String, Object> mObjectMap = new HashMap();
    String token = "";
    public Context mContext;

    public BasePresenter(V mView, Context context) {
        mContext = context;
        attachView(mView);
    }

    @Override
    public void attachView(V view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    public void showToast(String text) {
        ToastUtils.showToast(text);
    }
}
