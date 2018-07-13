/*    */ package com.bytedance.sdk.openadsdk.dddd;
/*    */ 
/*    */ import android.os.Handler;
/*    */ import android.os.Message;
/*    */ import android.support.annotation.NonNull;
/*    */ import com.bytedance.sdk.openadsdk.core.AdNativeListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class b<T>
/*    */ {
/*    */   private HandleInitEvent<T> a;
/*    */   private Handler b;
/*    */   private boolean c;
/*    */   
/*    */   public b(d<T> paramd, AdNativeListener<T> paramo, HandleInitEvent.b paramb, HandleInitEvent.a parama)
/*    */   {
/* 24 */     this.a = new HandleInitEvent(paramd, paramo, paramb, parama);
/*    */   }
/*    */   
/*    */   public void a() {
/* 28 */     this.a.start();
/* 29 */     this.b = new Handler(this.a.getLooper(), this.a);
/* 30 */     this.c = true;
/* 31 */     Message localMessage = this.b.obtainMessage();
/* 32 */     localMessage.what = 5;
/* 33 */     this.b.sendMessage(localMessage);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void a(@NonNull T paramT)
/*    */   {
/* 42 */     if (!this.c)
/*    */     {
/* 44 */       return;
/*    */     }
/* 46 */     Message localMessage = this.b.obtainMessage();
/* 47 */     localMessage.what = 1;
/* 48 */     localMessage.obj = paramT;
/* 49 */     this.b.sendMessage(localMessage);
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\LocationUtils\result.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */