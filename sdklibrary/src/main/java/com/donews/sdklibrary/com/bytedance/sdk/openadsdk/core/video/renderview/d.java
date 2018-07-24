/*    */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core.video.renderview;
/*    */ 
/*    */ import android.view.SurfaceHolder.Callback;
/*    */ 
/*    */ public class d implements SurfaceHolder.Callback
/*    */ {
/*    */   private java.lang.ref.WeakReference<SurfaceHolder.Callback> a;
/*    */   
/*    */   public d(SurfaceHolder.Callback paramCallback)
/*    */   {
/* 11 */     this.a = new java.lang.ref.WeakReference(paramCallback);
/*    */   }
/*    */   
/*    */   public SurfaceHolder.Callback a() {
/* 15 */     return (SurfaceHolder.Callback)this.a.get();
/*    */   }
/*    */   
/*    */   public void surfaceCreated(android.view.SurfaceHolder paramSurfaceHolder)
/*    */   {
/* 20 */     SurfaceHolder.Callback localCallback = (SurfaceHolder.Callback)this.a.get();
/* 21 */     if (localCallback != null) {
/* 22 */       localCallback.surfaceCreated(paramSurfaceHolder);
/*    */     }
/*    */   }
/*    */   
/*    */   public void surfaceChanged(android.view.SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
/*    */   {
/* 28 */     SurfaceHolder.Callback localCallback = (SurfaceHolder.Callback)this.a.get();
/* 29 */     if (localCallback != null) {
/* 30 */       localCallback.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
/*    */     }
/*    */   }
/*    */   
/*    */   public void surfaceDestroyed(android.view.SurfaceHolder paramSurfaceHolder)
/*    */   {
/* 36 */     SurfaceHolder.Callback localCallback = (SurfaceHolder.Callback)this.a.get();
/* 37 */     if (localCallback != null) {
/* 38 */       localCallback.surfaceDestroyed(paramSurfaceHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\video\renderview\d.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */