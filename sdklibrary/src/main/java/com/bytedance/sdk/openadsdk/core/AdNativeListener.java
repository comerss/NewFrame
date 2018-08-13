package com.bytedance.sdk.openadsdk.core;

import android.graphics.Bitmap;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.ffff.SplashAdLoadManager;
import com.bytedance.sdk.openadsdk.core.nibuguan.NativeData;
import com.bytedance.sdk.openadsdk.core.nibuguan.NativeAdData;
import com.bytedance.sdk.openadsdk.dddd.g;

import org.json.JSONObject;

import java.util.List;

public abstract interface AdNativeListener<T>
{
  public abstract void getAds(AdSlot paramAdSlot, com.bytedance.sdk.openadsdk.core.nibuguan.i var, int paramInt, OnAdLoad parama);
  
  public abstract g a(List<T> paramList);
  
  public abstract void a(NativeAdData paramh);
  void a(JSONObject var1);

  public abstract void a(JSONObject paramJSONObject, b paramb);
  
  public abstract void a(int paramInt, String paramString1, String paramString2, Bitmap paramBitmap);
  
  public abstract void a(String paramString1, String paramString2, SplashAdLoadManager.a parama);

  public static abstract interface OnAdLoad
  {
    public abstract void onError(int paramInt, String paramString);
    
    public abstract void onSuccess(NativeData parama);
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, String paramString);
    
    public abstract void a(AdNativeListenerImpl.cdsss paramc);
  }
}


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\AdNativeListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */