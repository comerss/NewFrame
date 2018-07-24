package com.donews.sdklibrary.com.bytedance.sdk.openadsdk;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import java.util.List;

public abstract interface TTAdNative
{
  public abstract void loadFeedAd(AdSlot paramAdSlot, @NonNull FeedAdListener paramFeedAdListener);
  
  public abstract void loadBannerAd(AdSlot paramAdSlot, @NonNull BannerAdListener paramBannerAdListener);
  
  public abstract void loadInteractionAd(AdSlot paramAdSlot, @NonNull InteractionAdListener paramInteractionAdListener);
  
  public abstract void loadSplashAd(AdSlot paramAdSlot, @NonNull SplashAdListener paramSplashAdListener, int paramInt);
  
  public abstract void loadSplashAd(AdSlot paramAdSlot, @NonNull SplashAdListener paramSplashAdListener);
  
  public abstract void loadRewardVideoAd(AdSlot paramAdSlot, @NonNull RewardVideoAdListener paramRewardVideoAdListener);
  
  public static abstract interface RewardVideoAdListener
  {
    @MainThread
    public abstract void onError(int paramInt, String paramString);
    
    @MainThread
    public abstract void onRewardVideoAdLoad(TTRewardVideoAd paramTTRewardVideoAd);
    
    public abstract void onRewardVideoCached();
  }
  
  public static abstract interface SplashAdListener
  {
    @MainThread
    public abstract void onError(int paramInt, String paramString);
    
    public abstract void onTimeout();
    
    @MainThread
    public abstract void onSplashAdLoad(TTSplashAd paramTTSplashAd);
  }
  
  public static abstract interface InteractionAdListener
  {
    @MainThread
    public abstract void onError(int paramInt, String paramString);
    
    @MainThread
    public abstract void onInteractionAdLoad(TTInteractionAd paramTTInteractionAd);
  }
  
  public static abstract interface BannerAdListener
  {
    @MainThread
    public abstract void onError(int paramInt, String paramString);
    
    @MainThread
    public abstract void onBannerAdLoad(TTBannerAd paramTTBannerAd);
  }
  
  public static abstract interface FeedAdListener
  {
    @MainThread
    public abstract void onError(int paramInt, String paramString);
    
    @MainThread
    public abstract void onFeedAdLoad(List<TTFeedAd> paramList);
  }
}


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\TTAdNative.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */