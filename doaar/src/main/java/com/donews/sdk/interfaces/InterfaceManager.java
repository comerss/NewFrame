package com.donews.sdk.interfaces;

import java.util.List;

/**
 * Created by 79653 on 2018/6/19.
 * 描述：几种不同的广高接口管理类
 */
public interface InterfaceManager {
    //开屏广告
    interface OnSplashListener extends Advertisement {
        void onLoadSplash(AdvertiseSplash advertiseSplash);
        void onTimeOut();
    }
    //信息流广告
    interface OnFeedListener extends Advertisement {
        void onLoadFeed(List<AdvertiseFeed> advertiseFeed);
    }
}