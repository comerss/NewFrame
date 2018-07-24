package com.donews.sdklibrary.com.bytedance.sdk.openadsdk;

import android.view.View;

public abstract interface TTBannerAd
{
  public abstract View getBannerView();
  
  public abstract void setBannerInteractionListener(AdInteractionListener paramAdInteractionListener);
  
  public abstract void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener);
  
  public abstract int getInteractionType();
  
  public abstract void setShowDislikeIcon(TTAdDislike.DislikeInteractionCallback paramDislikeInteractionCallback);
  
  public abstract TTAdDislike getDislikeDialog(TTAdDislike.DislikeInteractionCallback paramDislikeInteractionCallback);
  
  public abstract void setSlideIntervalTime(int paramInt);
  
  public static abstract interface AdInteractionListener
  {
    public abstract void onAdClicked(View paramView, int paramInt);
    
    public abstract void onAdShow(View paramView, int paramInt);
  }
}


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\TTBannerAd.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */