/*    */ package com.donews.sdklibrary.com.ss.android.crash.log;
/*    */ 
/*    */ import android.os.Handler;
/*    */ import android.os.Looper;
/*    */ import android.os.Message;
/*    */ 
/*    */ public final class b
/*    */   extends Handler
/*    */ {
/*    */   private final c a;
/*    */   
/*    */   public b(c paramc, Looper paramLooper)
/*    */   {
/* 14 */     super(paramLooper);
/* 15 */     this.a = paramc;
/*    */   }
/*    */   
/*    */   public void handleMessage(Message paramMessage)
/*    */   {
/* 20 */     switch (paramMessage.what) {
/*    */     case 200: 
/* 22 */       String str = (String)paramMessage.obj;
/* 23 */       this.a.b(200, str);
/* 24 */       break;
/*    */     
/*    */     case 100: 
/* 27 */       this.a.b(100, null);
/*    */     }
/*    */     
/*    */     
/* 31 */     super.handleMessage(paramMessage);
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\ss\android\crash\log\b.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */