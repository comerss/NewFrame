package com.donews.sdk.baidu;

import android.content.Context;
import android.view.View;

import com.baidu.mobads.AdSettings;
import com.baidu.mobads.AdView;
import com.donews.sdk.interfaces.AdvertiseSplash;
import com.donews.sdk.interfaces.AdvertiseTask;
import com.donews.sdk.interfaces.InterfaceManager;
import com.donews.sdk.manager.DoSlot;
import com.donews.sdk.manager.DonewsAgent;
import com.donews.sdk.manager.EventNameManager;

/**
 * Created by 79653 on 2018/6/20.
 * 描述：百度广告
 */
public final class BaiduHelper implements AdvertiseTask {
    private BaiduHelper() {
    }

    private static BaiduHelper mSingleton;

    public static BaiduHelper getInstance() {
        if (mSingleton == null)
            synchronized (BaiduHelper.class) {
                if (mSingleton == null) {
                    mSingleton = new BaiduHelper();
                }
            }
        return mSingleton;
    }
    boolean isInitialized=false;
    public void init(Context context, String appID) {
        AdView.setAppSid(context, appID);
        AdSettings.setSupportHttps(true);
        isInitialized=true;
    }
    public boolean isInitialized(){
        return isInitialized;
    }
    @Override
    public void loadSplash(final DoSlot slot, final InterfaceManager.OnSplashListener onSplashListener) {

        final BaiduSplashHolder holder = new BaiduSplashHolder();
        holder.init(slot, onSplashListener);
        AdvertiseSplash splash = new AdvertiseSplash() {
            @Override
            public View getSplashView() {
                DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.success(slot.getAppID(), slot.getAdvertiseId()), slot.getAdvertiseId());

                return holder.getView();
            }

            @Override
            public int getInteractionType() {
                return 0;
            }

            @Override
            public void setInteractionListener(AdvertiseInterationListener advertiseInterationListener) {
                holder.setHolderInterface(advertiseInterationListener);
            }
        };
        if (holder.isSuccess())
            onSplashListener.onLoadSplash(splash);
    }

    @Override
    public void loadFeed(DoSlot slot, InterfaceManager.OnFeedListener onFeedListener) {
        BaiduFeedHolder holder = new BaiduFeedHolder();
        holder.init(slot, onFeedListener);

    }
}
