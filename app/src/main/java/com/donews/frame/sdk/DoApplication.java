package com.donews.frame.sdk;

import com.baidu.mobads.AdSettings;
import com.baidu.mobads.AdView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdManagerFactory;
import com.comers.baselibrary.base.GlobalApplication;

/**
 * Created by 79653 on 2018/7/5.
 * 描述：
 */
public class DoApplication extends GlobalApplication {
   static TTAdManager manager;
    @Override
    public void onCreate() {
        super.onCreate();
         manager= TTAdManagerFactory.getInstance(this)
                .setAppId("5001622")//申请到的应用ID
                .setName("引力资讯-android_android")
                .setTitleBarTheme(TTAdConstant.TITLE_BAR_THEME_DARK)
                .setAllowShowNotifiFromSDK(true)
                .setAllowLandingPageShowWhenScreenLock(true)
                .setDirectDownloadNetworkType(TTAdConstant.NETWORK_STATE_WIFI, TTAdConstant.NETWORK_STATE_3G);
//        BaiduManager.init(this);
        AdView.setAppSid(this,"b792a33a");
        AdSettings.setSupportHttps(true);
    }
    public static TTAdManager getManage(){
        return manager;
    }
}
