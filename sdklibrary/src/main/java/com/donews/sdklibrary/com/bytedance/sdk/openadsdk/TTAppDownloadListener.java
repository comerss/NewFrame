package com.donews.sdklibrary.com.bytedance.sdk.openadsdk;

public abstract interface TTAppDownloadListener
{
  public abstract void onIdle();
  
  public abstract void onDownloadActive(long paramLong1, long paramLong2, String paramString1, String paramString2);
  
  public abstract void onDownloadPaused(long paramLong1, long paramLong2, String paramString1, String paramString2);
  
  public abstract void onDownloadFailed(long paramLong1, long paramLong2, String paramString1, String paramString2);
  
  public abstract void onDownloadFinished(long paramLong, String paramString1, String paramString2);
  
  public abstract void onInstalled(String paramString1, String paramString2);
}


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\TTAppDownloadListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */