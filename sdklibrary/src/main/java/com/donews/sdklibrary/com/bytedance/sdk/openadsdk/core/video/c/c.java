package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core.video.c;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.IOException;

public abstract interface c
{
  public abstract void a(SurfaceHolder paramSurfaceHolder);
  
  public abstract void a(String paramString)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;
  
  public abstract void f()
    throws IllegalStateException;
  
  public abstract void g()
    throws IllegalStateException;
  
  public abstract void h()
    throws IllegalStateException;
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(long paramLong)
    throws IllegalStateException;
  
  public abstract long i();
  
  public abstract long j();
  
  public abstract void k();
  
  public abstract void l();
  
  public abstract void a(float paramFloat1, float paramFloat2);
  
  public abstract void a(e parame);
  
  public abstract void a(b paramb);
  
  public abstract void a(a parama);
  
  public abstract void a(f paramf);
  
  public abstract void a(c paramc);
  
  public abstract void a(d paramd);
  
  @Deprecated
  public abstract void a(Context paramContext, int paramInt);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void a(Surface paramSurface);
  
  public static abstract interface d
  {
    public abstract boolean b(c paramc, int paramInt1, int paramInt2);
  }
  
  public static abstract interface c
  {
    public abstract boolean a(c paramc, int paramInt1, int paramInt2);
  }
  
  public static abstract interface g
  {
    public abstract void a(c paramc, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  public static abstract interface f
  {
    public abstract void c(c paramc);
  }
  
  public static abstract interface a
  {
    public abstract void a(c paramc, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void a(c paramc);
  }
  
  public static abstract interface e
  {
    public abstract void b(c paramc);
  }
}


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\video\c\c.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */