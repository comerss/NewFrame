package com.bytedance.sdk.openadsdk;

import android.content.Context;

public  interface TTAdManager
{
    TTAdManager setAppId(String paramString);
  
    TTAdManager setName(String paramString);
  
    TTAdManager setPaid(boolean paramBoolean);
  
    TTAdManager setGender(int paramInt);
  
    TTAdManager setAge(int paramInt);
  
    TTAdManager setKeywords(String paramString);
  
    TTAdManager setData(String paramString);
  
    TTAdManager setTitleBarTheme(int paramInt);
  
    TTAdManager setAllowShowNotifiFromSDK(boolean paramBoolean);
  
    TTAdManager openDebugMode();
  
    TTAdManager setAllowLandingPageShowWhenScreenLock(boolean paramBoolean);
  
    TTAdManager setGlobalAppDownloadListener(TTGlobalAppDownloadListener paramTTGlobalAppDownloadListener);
  
    TTGlobalAppDownloadController getGlobalAppDownloadController(Context paramContext);
  
    TTAdManager setDirectDownloadNetworkType(int... paramVarArgs);
  
    TTAdNative createAdNative(Context paramContext);
  
    void requestPermissionIfNecessary(Context paramContext);
}


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\TTAdManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */