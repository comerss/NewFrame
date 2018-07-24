package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core;

import android.graphics.Bitmap;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.d.a;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.f.b.a;
import com.bytedance.sdk.openadsdk.d.g;
import java.util.List;
import org.json.JSONObject;

public abstract interface o<T>
{
  public abstract void a(AdSlot paramAdSlot, int paramInt, a parama);
  
  public abstract g a(List<T> paramList);
  
  public abstract void a(h paramh);
  
  public abstract void a(JSONObject paramJSONObject, b paramb);
  
  public abstract void a(int paramInt, String paramString1, String paramString2, Bitmap paramBitmap);
  
  public abstract void a(String paramString1, String paramString2, b.a parama);
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, String paramString);
    
    public abstract void a(a parama);
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, String paramString);
    
    public abstract void a(p.c paramc);
  }
}


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\o.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */