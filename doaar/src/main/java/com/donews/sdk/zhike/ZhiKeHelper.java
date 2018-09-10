package com.donews.sdk.zhike;

import com.donews.sdk.interfaces.AdvertiseTask;
import com.donews.sdk.interfaces.InterfaceManager;
import com.donews.sdk.manager.DoSlot;
import com.donews.sdk.utils.URLUtils;

/**
 * Created by 79653 on 2018/8/7.
 * 描述：
 */
public class ZhiKeHelper implements AdvertiseTask {
    private static ZhiKeHelper mSingleton;
    private ZhiKeHelper(){}
    public static ZhiKeHelper getInstance() {
        if (mSingleton == null)
            synchronized (ZhiKeHelper.class) {
                if (mSingleton == null) {
                    mSingleton = new ZhiKeHelper();
                }
            }
        return mSingleton;
    }
    @Override
    public void loadSplash(DoSlot slot, InterfaceManager.OnSplashListener onSplashListener) {
        URLUtils.getGravitySplashAd(slot.getContext(),"",slot.getAppID(),slot.getAdvertiseId(),onSplashListener);
    }

    @Override
    public void loadFeed(DoSlot slot, InterfaceManager.OnFeedListener onFeedListener) {
        URLUtils.getNiuerNativeAd(slot.getContext(),"",slot.getAppID(),slot.getAdvertiseId(),"","",slot.getAdvertiseId(),6,onFeedListener);

    }
}
