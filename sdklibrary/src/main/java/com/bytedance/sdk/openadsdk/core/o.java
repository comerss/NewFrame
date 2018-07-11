package com.bytedance.sdk.openadsdk.core;

import android.graphics.Bitmap;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.nibuguan.h;
import com.bytedance.sdk.openadsdk.dddd.g;

import org.json.JSONObject;

import java.util.List;

public abstract interface o<T>
{
  public abstract void a(AdSlot paramAdSlot,com.bytedance.sdk.openadsdk.core.nibuguan.i var, int paramInt, o.a parama);
  
  public abstract g a(List<T> paramList);
  
  public abstract void a(h paramh);
  
  public abstract void a(JSONObject paramJSONObject, b paramb);
  
  public abstract void a(int paramInt, String paramString1, String paramString2, Bitmap paramBitmap);
  
  public abstract void a(String paramString1, String paramString2, com.bytedance.sdk.openadsdk.core.ffff.b.a parama);

  public static abstract interface a
  {
    public abstract void a(int paramInt, String paramString);
    
    public abstract void a(com.bytedance.sdk.openadsdk.core.nibuguan.a parama);
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, String paramString);
    
    public abstract void a(p.cdsss paramc);
  }
}


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\o.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */