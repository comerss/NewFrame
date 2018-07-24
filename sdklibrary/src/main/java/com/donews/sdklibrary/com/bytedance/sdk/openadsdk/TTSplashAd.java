package com.donews.sdklibrary.com.bytedance.sdk.openadsdk;

import android.support.annotation.NonNull;
import android.view.View;

public abstract interface TTSplashAd
{
  @NonNull
  public abstract View getSplashView();
  
  public abstract int getInteractionType();
  
  public abstract void setSplashInteractionListener(AdInteractionListener paramAdInteractionListener);
  
  public abstract void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener);
  
  public abstract void setNotAllowSdkCountdown();
  
  public static abstract interface AdInteractionListener
  {
    public abstract void onAdClicked(View paramView, int paramInt);
    
    public abstract void onAdShow(View paramView, int paramInt);
    
    public abstract void onAdSkip();
    
    public abstract void onAdTimeOver();
  }
}


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\TTSplashAd.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */