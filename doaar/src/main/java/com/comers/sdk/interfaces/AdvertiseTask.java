package com.comers.sdk.interfaces;


import com.comers.sdk.manager.DoSlot;

/**
 * Created by 79653 on 2018/6/19.
 * 描述：广告的事物，所有的广告请求必须在这里注册，由不同的平台各自实现
 */
public interface AdvertiseTask {
    void loadSplash(DoSlot slot, InterfaceManager.OnSplashListener onSplashListener);
    void loadFeed(DoSlot slot, InterfaceManager.OnFeedListener onFeedListener);
}