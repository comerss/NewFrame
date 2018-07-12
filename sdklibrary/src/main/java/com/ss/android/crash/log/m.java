/*    */ package com.ss.android.crash.log;
/*    */ 
/*    */

import android.os.Debug;
/*    */ 
/*    */ public class m
/*    */ {
/*    */   static final a a;
/*    */   
/*    */   private static class a
/*    */   {
/*    */     public int a(Debug.MemoryInfo paramMemoryInfo) {
/* 12 */       return -1;
/*    */     }
/*    */     
/*    */     public int b(Debug.MemoryInfo paramMemoryInfo) {
/* 16 */       return -1;
/*    */     }
/*    */     
/*    */ 
/* 20 */     public int c(Debug.MemoryInfo paramMemoryInfo) { return -1; }
/*    */   }
/*    */   
/*    */   @android.annotation.TargetApi(19)
/*    */   private static class b extends m.a {
/* 25 */     private b() { super(); }
/*    */     
/*    */     public int a(Debug.MemoryInfo paramMemoryInfo)
/*    */     {
/* 29 */       return paramMemoryInfo.getTotalPrivateClean();
/*    */     }
/*    */     
/*    */     public int b(Debug.MemoryInfo paramMemoryInfo)
/*    */     {
/* 34 */       return paramMemoryInfo.getTotalSharedClean();
/*    */     }
/*    */     
/*    */     public int c(Debug.MemoryInfo paramMemoryInfo)
/*    */     {
/* 39 */       return paramMemoryInfo.getTotalSwappablePss();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   static
/*    */   {
/* 46 */     if (android.os.Build.VERSION.SDK_INT >= 19) {
/* 47 */       a = new b();
/*    */     } else {
/* 49 */       a = new a();
/*    */     }
/*    */   }
/*    */   
/*    */   public static int a(Debug.MemoryInfo paramMemoryInfo) {
/* 54 */     return a.a(paramMemoryInfo);
/*    */   }
/*    */   
/*    */   public static int b(Debug.MemoryInfo paramMemoryInfo) {
/* 58 */     return a.b(paramMemoryInfo);
/*    */   }
/*    */   
/*    */   public static int c(Debug.MemoryInfo paramMemoryInfo) {
/* 62 */     return a.c(paramMemoryInfo);
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\ss\android\crash\log\mM.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */