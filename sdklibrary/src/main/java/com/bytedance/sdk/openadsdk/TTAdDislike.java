package com.bytedance.sdk.openadsdk;

public abstract interface TTAdDislike
{
  public abstract void showDislikeDialog();
  
  public abstract void setDislikeInteractionCallback(DislikeInteractionCallback paramDislikeInteractionCallback);
  
  public static abstract interface DislikeInteractionCallback
  {
    public abstract void onSelected(int paramInt, String paramString);
    
    public abstract void onCancel();
  }
}


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\TTAdDislike.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */