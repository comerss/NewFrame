package com.donews.sdklibrary.com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.support.annotation.MainThread;

public abstract interface TTRewardVideoAd
{
  public abstract void setRewardAdInteractionListener(RewardAdInteractionListener paramRewardAdInteractionListener);
  
  public abstract void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener);
  
  public abstract int getInteractionType();
  
  @MainThread
  public abstract void showRewardVideoAd(Activity paramActivity);
  
  public abstract void setShowDownLoadBar(boolean paramBoolean);
  
  public static abstract interface RewardAdInteractionListener
  {
    public abstract void onAdShow();
    
    public abstract void onAdVideoBarClick();
    
    public abstract void onAdClose();
    
    public abstract void onVideoComplete();
    
    public abstract void onRewardVerify(boolean paramBoolean, int paramInt, String paramString);
  }
}


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\TTRewardVideoAd.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */