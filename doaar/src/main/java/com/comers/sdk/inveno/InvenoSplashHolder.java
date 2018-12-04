package com.comers.sdk.inveno;

import android.content.Context;
import android.view.View;

import com.comers.sdk.interfaces.AdvertiseSplash;
import com.comers.sdk.interfaces.InterfaceManager;
import com.comers.sdk.view.NativeData;
import com.comers.sdk.view.SplashLayout;


/**
 * Created by 79653 on 2018/6/19.
 * 描述：处理开屏广告 接口数据和回调类
 */
public class InvenoSplashHolder implements AdvertiseSplash {
    private InterfaceManager.OnSplashListener mSplashListener;
    private NativeData mNative;
    private Context mContext;
    private SplashLayout mSplashLayout;

    public InvenoSplashHolder(Context mContext, InterfaceManager.OnSplashListener splashListener,NativeData nativ) {
        mSplashListener = splashListener;
        mNative = nativ;
        this.mContext = mContext;
        initView();
    }

    //处理需要返回的View以及View设置数据  和点击监听 并回调
    private void initView() {
        mSplashLayout = new SplashLayout(mContext);
        if (mNative != null) {
            mSplashLayout.setData(mNative.getImpurls().get(0),mNative);
        }
        mSplashListener.onLoadSplash(this);
    }


    @Override
    public View getSplashView() {
        if (mSplashLayout == null)
            initView();
        return mSplashLayout;
    }

    @Override
    public int getInteractionType() {
        return 0;
    }

    @Override
    public void setInteractionListener(AdvertiseInterationListener advertiseInterationListener) {
        if (mSplashLayout != null)
            mSplashLayout.setOnInteractionListener(advertiseInterationListener);
    }
}
