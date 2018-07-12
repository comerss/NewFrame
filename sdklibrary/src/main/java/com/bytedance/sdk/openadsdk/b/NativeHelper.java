/*    */ package com.bytedance.sdk.openadsdk.b;
/*    */ 
/*    */ import android.support.annotation.NonNull;
/*    */ import com.bytedance.sdk.openadsdk.core.AdNativeListener;
import com.bytedance.sdk.openadsdk.core.nibuguan.h;
/*    */ import com.bytedance.sdk.openadsdk.core.n;
/*    */

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NativeHelper
/*    */ {
/*    */   private static volatile NativeHelper a;
/*    */   private AdNativeListener<com.bytedance.sdk.openadsdk.dddd.a> b;
/*    */   
/*    */   private NativeHelper()
/*    */   {
/* 19 */     this.b = n.c();
/*    */   }
/*    */   
/*    */   public static NativeHelper a() {
/* 23 */     if (a == null) {
/* 24 */       synchronized (NativeHelper.class) {
/* 25 */         if (a == null) {
/* 26 */           a = new NativeHelper();
/*    */         }
/*    */       }
/*    */     }
/* 30 */     return a;
/*    */   }
/*    */   
/*    */   public void a(@NonNull h paramh) {
/* 34 */     this.b.a(paramh);
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\result\SslHepler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */