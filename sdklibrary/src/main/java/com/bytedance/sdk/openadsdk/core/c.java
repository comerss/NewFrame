/*    */ package com.bytedance.sdk.openadsdk.core;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.content.SharedPreferences;
/*    */ import android.content.SharedPreferences.Editor;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class c
/*    */ {
/* 27 */   private static volatile c a = null;
/*    */   
/* 29 */   private SharedPreferences b = null;
/*    */   
/*    */   private c(Context paramContext) {
/* 32 */     this.b = paramContext.getSharedPreferences("ttopenadsdk", 0);
/*    */   }
/*    */   
/*    */   public static c a(Context paramContext) {
/* 36 */     if (null == a) {
/* 37 */       synchronized (c.class) {
/* 38 */         if (null == a) {
/* 39 */           a = new c(paramContext);
/*    */         }
/*    */       }
/*    */     }
/* 43 */     return a;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void a(String paramString1, String paramString2)
/*    */   {
/* 51 */     this.b.edit().putString(paramString1, paramString2).apply();
/*    */   }
/*    */   
/*    */   public String b(String paramString1, String paramString2) {
/* 55 */     return this.b.getString(paramString1, paramString2);
/*    */   }
/*    */   
/*    */   public void a(String paramString, int paramInt) {
/* 59 */     this.b.edit().putInt(paramString, paramInt).apply();
/*    */   }
/*    */   
/*    */   public int b(String paramString, int paramInt) {
/* 63 */     return this.b.getInt(paramString, paramInt);
/*    */   }
/*    */   
/*    */   public void a(String paramString, boolean paramBoolean) {
/* 67 */     this.b.edit().putBoolean(paramString, paramBoolean).apply();
/*    */   }
/*    */   
/*    */   public boolean b(String paramString, boolean paramBoolean) {
/* 71 */     return this.b.getBoolean(paramString, paramBoolean);
/*    */   }
/*    */   
/*    */   public void a(String paramString, long paramLong) {
/* 75 */     this.b.edit().putLong(paramString, paramLong).apply();
/*    */   }
/*    */   
/*    */   public Long b(String paramString, long paramLong) {
/* 79 */     return Long.valueOf(this.b.getLong(paramString, paramLong));
/*    */   }
/*    */   
/*    */   public void a(String paramString, float paramFloat) {
/* 83 */     this.b.edit().putFloat(paramString, paramFloat).apply();
/*    */   }
/*    */   
/*    */   public float b(String paramString, float paramFloat) {
/* 87 */     return this.b.getFloat(paramString, paramFloat);
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\c.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */