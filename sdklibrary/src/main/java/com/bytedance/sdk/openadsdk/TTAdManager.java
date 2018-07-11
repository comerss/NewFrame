package com.bytedance.sdk.openadsdk;

import android.content.Context;

public abstract interface TTAdManager
{
  public abstract TTAdManager setAppId(String paramString);
  
  public abstract TTAdManager setName(String paramString);
  
  public abstract TTAdManager setPaid(boolean paramBoolean);
  
  public abstract TTAdManager setGender(int paramInt);
  
  public abstract TTAdManager setAge(int paramInt);
  
  public abstract TTAdManager setKeywords(String paramString);
  
  public abstract TTAdManager setData(String paramString);
  
  public abstract TTAdManager setTitleBarTheme(int paramInt);
  
  public abstract TTAdManager setAllowShowNotifiFromSDK(boolean paramBoolean);
  
  public abstract TTAdManager openDebugMode();
  
  public abstract TTAdManager setAllowLandingPageShowWhenScreenLock(boolean paramBoolean);
  
  public abstract TTAdManager setGlobalAppDownloadListener(TTGlobalAppDownloadListener paramTTGlobalAppDownloadListener);
  
  public abstract TTGlobalAppDownloadController getGlobalAppDownloadController(Context paramContext);
  
  public abstract TTAdManager setDirectDownloadNetworkType(int... paramVarArgs);
  
  public abstract TTAdNative createAdNative(Context paramContext);
  
  public abstract void requestPermissionIfNecessary(Context paramContext);
}


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\TTAdManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */