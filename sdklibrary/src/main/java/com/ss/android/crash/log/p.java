/*    */ package com.ss.android.crash.log;
/*    */ 
/*    */ import java.util.concurrent.ExecutorService;
/*    */ import java.util.concurrent.Executors;
/*    */ 
/*    */ public class p
/*    */ {
/*    */   private static volatile p a;
/*    */   private static ExecutorService b;
/*    */   
/*    */   public static p a()
/*    */   {
/* 13 */     if (a == null) {
/* 14 */       synchronized (p.class) {
/* 15 */         if (a == null)
/* 16 */           a = new p();
/*    */       }
/*    */     }
/* 19 */     return a;
/*    */   }
/*    */   
/*    */   private p() {
/* 23 */     b = Executors.newSingleThreadExecutor();
/*    */   }
/*    */   
/*    */   public void a(Runnable paramRunnable) {
/* 27 */     if (b != null) {
/* 28 */       b.submit(paramRunnable);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\ss\android\crash\log\AdNativeListenerImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */