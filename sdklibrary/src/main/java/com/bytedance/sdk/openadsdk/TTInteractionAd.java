package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.support.annotation.MainThread;

public abstract interface TTInteractionAd
{
  public abstract void setAdInteractionListener(AdInteractionListener paramAdInteractionListener);
  
  public abstract void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener);
  
  public abstract int getInteractionType();
  
  @MainThread
  public abstract void showInteractionAd(Activity paramActivity);
  
  public static abstract interface AdInteractionListener
  {
    public abstract void onAdClicked();
    
    public abstract void onAdShow();
    
    public abstract void onAdDismiss();
  }
}


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\TTInteractionAd.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */