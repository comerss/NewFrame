package com.bytedance.sdk.openadsdk;

public  interface TTAdDislike
{
    void showDislikeDialog();
  
    void setDislikeInteractionCallback(DislikeInteractionCallback paramDislikeInteractionCallback);
  
  interface DislikeInteractionCallback
  {
      void onSelected(int paramInt, String paramString);
    
      void onCancel();
  }
}


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\TTAdDislike.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */