package com.comers.sdk.inveno;


import com.comers.sdk.interfaces.AdvertiseTask;
import com.comers.sdk.interfaces.InterfaceManager;
import com.comers.sdk.manager.DoSlot;

/**
 * Created by 79653 on 2018/6/19.
 * 描述：
 */
public final class InvenoHelper implements AdvertiseTask {
    private InvenoHelper() {
    }

    private static  InvenoHelper mSingleton;

    public static InvenoHelper getInstance() {
        if (mSingleton == null)
            synchronized (InvenoHelper.class) {
                if (mSingleton == null) {
                    mSingleton = new InvenoHelper();
                }
            }
        return mSingleton;
    }

    @Override
    public void loadSplash(DoSlot slot, InterfaceManager.OnSplashListener onSplashListener) {
        AdRequest.getInvenoAd(slot.getContext(), slot.getAdvertiseId(),AdRequest.ADTYPE.OPENING,slot.getWidth(),slot.getHeight(),onSplashListener);
    }

    @Override
    public void loadFeed( DoSlot slot,  InterfaceManager.OnFeedListener onFeedListener) {
        AdRequest.getInvenoAd(slot.getContext(), slot.getAdvertiseId(),AdRequest.ADTYPE.OPENING,slot.getWidth(),slot.getHeight(),onFeedListener);
    }
}
