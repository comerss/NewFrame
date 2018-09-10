package com.donews.sdk.zhike;

import android.content.Context;
import android.view.View;

import com.donews.sdk.base.SplashManager;
import com.donews.sdk.bean.EventTrack;
import com.donews.sdk.interfaces.AdvertiseSplash;
import com.donews.sdk.interfaces.InterfaceManager;
import com.donews.sdk.utils.HttpUtils;
import com.donews.sdk.view.NativeData;
import com.donews.sdk.view.SplashLayout;

import java.util.List;

/**
 * Created by 79653 on 2018/8/7.
 * 描述：
 */
public final class ZhiSplashHelper implements AdvertiseSplash {
    private InterfaceManager.OnSplashListener mSplashListener;
    private NativeData mNative;
    private Context mContext;
    private SplashLayout mSplashLayout;
    private AdvertiseInterationListener mInterationListener;
    String authKey = "";

    public ZhiSplashHelper(Context mContext, String authKey, InterfaceManager.OnSplashListener splashListener, NativeData nativ) {
        mSplashListener = splashListener;
        mNative = nativ;
        this.authKey = authKey;
        this.mContext = mContext;
        initView();
    }

    //处理需要返回的View以及View设置数据  和点击监听 并回调
    private void initView() {
        mSplashLayout = new SplashLayout(mContext);
        SplashManager splashManager = new SplashManager(mContext, mSplashLayout);
        splashManager.setAdType(3);
        mSplashLayout.addView(splashManager);
        if (mNative != null) {
            mSplashLayout.setData(mNative.getImpurls().get(0), mNative);
        }
        splashManager.setCallback(new SplashManager.SplashListener() {
            @Override
            public void onWindowFocusChanged(boolean paramBoolean) {

            }

            @Override
            public void onAttachedToWindow() {

            }

            @Override
            public void onDetachedFromWindow() {

            }

            @Override
            public void onShow(View paramView) {
                //TODO 需要做统计的地方
                doEvent(mNative);
                if (mInterationListener != null) {
                    mInterationListener.onAdvertiseShow(paramView, 0);
                }
                if (mSplashListener != null) {
                    mSplashListener.onLoadSplash(ZhiSplashHelper.this);
                }

            }
        });
        splashManager.setNeedCheckingShow(true);
    }

    private void doEvent(NativeData event) {
        if (event == null || event.getEventTracks() == null)
            return;
//        SHOW = 1,  //曝光监测CLICK = 2;  //点击监测
        List<EventTrack> eventTracks = event.getEventTracks();
        if (eventTracks != null && eventTracks.size() > 0) {
            for (int i = 0; i < eventTracks.size(); i++) {
                if (eventTracks.get(i).getEvent_type().equals("1")) {//
                    String notifyurl = eventTracks.get(i).getNotify_url();
                    HttpUtils.startHttpGet(notifyurl, null);
                    break;
                }
            }
        }
    }


    @Override
    public View getSplashView() {
        if (mSplashLayout == null) {
            initView();
        }

        return mSplashLayout;
    }

    @Override
    public int getInteractionType() {
        return 0;
    }

    @Override
    public void setInteractionListener(AdvertiseInterationListener advertiseInterationListener) {
        mInterationListener = advertiseInterationListener;
        if (mSplashLayout != null) {
            mSplashLayout.setOnInteractionListener(advertiseInterationListener);
        }
    }
}
