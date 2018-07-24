/*    */ package com.donews.sdklibrary.com.ss.android.crash.log;
/*    */ 
/*    */ import android.content.Context;
/*    */ 
/*    */ 
/*    */ public class g
/*    */ {
/*    */   private static volatile g a;
/*    */   private final c b;
/*    */   
/*    */   public static g a(Context paramContext)
/*    */   {
/* 13 */     if (a == null) {
/* 14 */       synchronized (g.class) {
/* 15 */         if (a == null) {
/* 16 */           a = new g(paramContext);
/*    */         }
/*    */       }
/*    */     }
/* 20 */     return a;
/*    */   }
/*    */   
/*    */   private g(Context paramContext) {
/* 24 */     if (paramContext == null)
/* 25 */       throw new IllegalArgumentException("context is not be null");
/* 26 */     this.b = new c(paramContext);
/*    */   }
/*    */   
/*    */   public void a() {
/* 30 */     this.b.a();
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\ss\android\crash\log\g.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */