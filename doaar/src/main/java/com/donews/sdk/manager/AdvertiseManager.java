package com.donews.sdk.manager;

import android.app.Application;

import com.donews.sdk.base.LogUtils;
import com.donews.sdk.bean.AdParams;
import com.donews.sdk.interfaces.InterfaceManager;


/**
 * Created by 79653 on 2018/6/20.
 * 描述：
 */
public final class AdvertiseManager {
    private AdvertiseManager() {
    }

    private static AdvertiseManager mSingleton;
    private boolean isDebug = false;

    public static AdvertiseManager getInstance() {
        if (mSingleton == null)
            synchronized (AdvertiseManager.class) {
                if (mSingleton == null) {
                    mSingleton = new AdvertiseManager();
                }
            }
        return mSingleton;
    }

    public void setDebug(boolean isDebug) {
        this.isDebug = isDebug;
    }

    public boolean isDebug() {
        return isDebug;
    }

    public void loadFeeds(AdParams slot, final InterfaceManager.OnFeedListener splashListener) {
        if (slot == null || slot.getContext() == null || slot.getAdPosition() == null) {
            LogUtils.i("loadFeeds", "必填参数不可为空，请检查参数是否正确！");
            return;
        }
        if (AuthKeyManager.INSTANCE.mPositionMap.containsKey(slot.getAdPosition())) {
            TaskDeleget.INSTANCE.getAd(slot, splashListener);
        } else {
            TaskDeleget.INSTANCE.getPosition(slot, splashListener);
        }
    }

    public void loadSplash(AdParams slot, final InterfaceManager.OnSplashListener splashListener) {
        if (slot == null || slot.getContext() == null || slot.getAdPosition() == null) {
            LogUtils.i("loadSplash", "必填参数不可为空，请检查参数是否正确！");
            return;
        }
        if (AuthKeyManager.INSTANCE.mPositionMap.containsKey(slot.getAdPosition())) {
            TaskDeleget.INSTANCE.getAd(slot, splashListener);
        } else {
            TaskDeleget.INSTANCE.getPosition(slot, splashListener);
        }
    }

    public void init(Application application, String authKey, String authSecret) {
        TaskDeleget.INSTANCE.init(application,authKey,authSecret);
    }
}
