package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public abstract interface TTFeedAd
{
  public abstract String getTitle();
  
  public abstract String getDescription();
  
  public abstract String getSource();
  
  public abstract TTImage getIcon();
  
  public abstract List<TTImage> getImageList();
  
  public abstract int getInteractionType();
  
  public abstract int getImageMode();
  
  public abstract TTAdDislike getDislikeDialog();
  
  public abstract DownloadStatusController getDownloadStatusController();
  
  public abstract void registerViewForInteraction(@NonNull ViewGroup paramViewGroup, @NonNull View paramView, AdInteractionListener paramAdInteractionListener);
  
  public abstract void registerViewForInteraction(@NonNull ViewGroup paramViewGroup, @NonNull List<View> paramList1, @Nullable List<View> paramList2, AdInteractionListener paramAdInteractionListener);
  
  public abstract void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener);
  
  public abstract void setActivityForDownloadApp(@NonNull Activity paramActivity);
  
  public abstract View getAdView(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract View getAdView();
  
  public static abstract interface AdInteractionListener
  {
    public abstract void onAdClicked(View paramView, TTFeedAd paramTTFeedAd);
    
    public abstract void onAdCreativeClick(View paramView, TTFeedAd paramTTFeedAd);
    
    public abstract void onAdShow(TTFeedAd paramTTFeedAd);
  }
}


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\TTFeedAd.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */