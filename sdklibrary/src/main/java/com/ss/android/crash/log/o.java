/*    */ package com.ss.android.crash.log;
/*    */ 
/*    */ import android.annotation.TargetApi;
/*    */ import android.app.ActivityManager.MemoryInfo;
/*    */ import android.os.Build.VERSION;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class o
/*    */ {
/*    */   static final a a;
/*    */   
/*    */   private static class a
/*    */   {
/* 21 */     public long a(ActivityManager.MemoryInfo paramMemoryInfo) { return 0L; }
/*    */   }
/*    */   
/*    */   @TargetApi(16)
/*    */   private static class b extends o.a {
/* 26 */     private b() { super(); }
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
/*    */     public long a(ActivityManager.MemoryInfo paramMemoryInfo)
/*    */     {
/* 40 */       return paramMemoryInfo.totalMem;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   static
/*    */   {
/* 48 */     if (Build.VERSION.SDK_INT >= 16) {
/* 49 */       a = new b(null);
/*    */     } else {
/* 51 */       a = new a(null);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static long a(ActivityManager.MemoryInfo paramMemoryInfo)
/*    */   {
/* 60 */     return a.a(paramMemoryInfo);
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\ss\android\crash\log\mO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */