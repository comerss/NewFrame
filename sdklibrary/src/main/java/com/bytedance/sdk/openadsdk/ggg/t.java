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
/*    */ public class t
/*    */   extends Handler
/*    */ {
/*    */   WeakReference<a> a;
/*    */   
/*    */   public t(a parama)
/*    */   {
/* 18 */     this.a = new WeakReference(parama);
/*    */   }
/*    */   
/*    */   public t(Looper paramLooper, a parama) {
/* 22 */     super(paramLooper);
/* 23 */     this.a = new WeakReference(parama);
/*    */   }
/*    */   
/*    */   public void handleMessage(Message paramMessage)
/*    */   {
/* 28 */     a locala = (a)this.a.get();
/* 29 */     if ((locala != null) && (paramMessage != null)) {
/* 30 */       locala.a(paramMessage);
/*    */     }
/*    */   }
/*    */   
/*    */   public static abstract interface a
/*    */   {
/*    */     public abstract void a(Message paramMessage);
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\g\t.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */