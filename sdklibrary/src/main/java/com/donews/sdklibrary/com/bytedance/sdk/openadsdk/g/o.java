/*    */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.g;
/*    */ 
/*    */ import android.app.Activity;
/*    */ import android.content.Context;
/*    */ import android.text.TextUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class o
/*    */ {
/*    */   public static void a(Object paramObject, String paramString)
/*    */   {
/* 13 */     if (paramObject == null) {
/* 14 */       b(paramString);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void a(String paramString1, String paramString2) {
/* 19 */     if (TextUtils.isEmpty(paramString1)) {
/* 20 */       b(paramString2);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void a(boolean paramBoolean, String paramString) {
/* 25 */     if (!paramBoolean) {
/* 26 */       b(paramString);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void a(String paramString) {
/* 31 */     b(paramString);
/*    */   }
/*    */   
/*    */   public static void a(Context paramContext, String paramString) {
/* 35 */     if (!(paramContext instanceof Activity)) {
/* 36 */       b(paramString);
/*    */     }
/*    */   }
/*    */   
/*    */   private static void b(String paramString)
/*    */   {
/* 42 */     throw new IllegalArgumentException(paramString);
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\g\o.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */