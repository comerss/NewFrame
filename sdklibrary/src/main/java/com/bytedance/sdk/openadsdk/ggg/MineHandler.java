/*    */ package com.bytedance.sdk.openadsdk.ggg;
/*    */ 
/*    */ import android.os.Handler;
/*    */ import android.os.Looper;
/*    */ import android.os.Message;
/*    */ import java.lang.ref.WeakReference;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MineHandler
/*    */   extends Handler
/*    */ {
/*    */   WeakReference<OnResult> a;
/*    */   
/*    */   public MineHandler(OnResult parama)
/*    */   {
/* 18 */     this.a = new WeakReference(parama);
/*    */   }
/*    */   
/*    */   public MineHandler(Looper paramLooper, OnResult parama) {
/* 22 */     super(paramLooper);
/* 23 */     this.a = new WeakReference(parama);
/*    */   }
/*    */   
/*    */   public void handleMessage(Message paramMessage)
/*    */   {
/* 28 */     OnResult locala = (OnResult)this.a.get();
/* 29 */     if ((locala != null) && (paramMessage != null)) {
/* 30 */       locala.doResult(paramMessage);
/*    */     }
/*    */   }
/*    */   
/*    */   public static abstract interface OnResult
/*    */   {
/*    */     public abstract void doResult(Message paramMessage);
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\ApiException\MineHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */