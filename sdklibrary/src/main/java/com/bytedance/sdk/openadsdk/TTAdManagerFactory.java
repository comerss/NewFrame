/*    */ package com.bytedance.sdk.openadsdk;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.bytedance.sdk.openadsdk.core.X509Helper;
/*    */ import com.bytedance.sdk.openadsdk.core.TTAdManagerImpl;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TTAdManagerFactory
/*    */ {
/* 13 */   private static TTAdManager a = new TTAdManagerImpl();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static TTAdManager getInstance(Context paramContext)
/*    */   {
/* 20 */     X509Helper.a(paramContext);
/* 21 */     return a;
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\TTAdManagerFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */