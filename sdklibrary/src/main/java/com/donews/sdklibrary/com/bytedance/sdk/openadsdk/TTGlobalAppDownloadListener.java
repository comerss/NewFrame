package com.donews.sdklibrary.com.bytedance.sdk.openadsdk;

public abstract interface TTGlobalAppDownloadListener
{
  public abstract void onDownloadActive(TTAppDownloadInfo paramTTAppDownloadInfo);
  
  public abstract void onDownloadPaused(TTAppDownloadInfo paramTTAppDownloadInfo);
  
  public abstract void onDownloadFinished(TTAppDownloadInfo paramTTAppDownloadInfo);
  
  public abstract void onInstalled(String paramString1, String paramString2, long paramLong, int paramInt);
  
  public abstract void onDownloadFailed(TTAppDownloadInfo paramTTAppDownloadInfo);
}


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\TTGlobalAppDownloadListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */