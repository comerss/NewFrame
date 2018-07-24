/*    */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.bytedance.sdk.openadsdk.core.k;
/*    */ import com.bytedance.sdk.openadsdk.core.t;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TTAdManagerFactory
/*    */ {
/* 13 */   private static TTAdManager a = new t();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static TTAdManager getInstance(Context paramContext)
/*    */   {
/* 20 */     k.a(paramContext);
/* 21 */     return a;
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\TTAdManagerFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */