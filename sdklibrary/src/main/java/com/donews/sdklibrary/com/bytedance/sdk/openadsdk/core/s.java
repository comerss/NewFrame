/*    */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core;
/*    */ 
/*    */ import android.support.annotation.MainThread;
/*    */ import android.support.annotation.NonNull;
/*    */ import com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener;
/*    */ import com.bytedance.sdk.openadsdk.c.x;
/*    */ import com.bytedance.sdk.openadsdk.core.d.h;
/*    */ import com.bytedance.sdk.openadsdk.core.video.a.c;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class s
/*    */ {
/*    */   private static s a;
/*    */   private c b;
/*    */   private h c;
/*    */   private TTRewardVideoAd.RewardAdInteractionListener d;
/*    */   private x e;
/*    */   
/*    */   @MainThread
/*    */   public static s a()
/*    */   {
/* 29 */     if (a == null) {
/* 30 */       a = new s();
/*    */     }
/* 32 */     return a;
/*    */   }
/*    */   
/*    */   @NonNull
/*    */   public c b() {
/* 37 */     return this.b;
/*    */   }
/*    */   
/*    */   public void a(c paramc) {
/* 41 */     this.b = paramc;
/*    */   }
/*    */   
/*    */   @NonNull
/*    */   public h c() {
/* 46 */     return this.c;
/*    */   }
/*    */   
/*    */   public void a(h paramh) {
/* 50 */     this.c = paramh;
/*    */   }
/*    */   
/*    */   public TTRewardVideoAd.RewardAdInteractionListener d() {
/* 54 */     return this.d;
/*    */   }
/*    */   
/*    */   public void a(TTRewardVideoAd.RewardAdInteractionListener paramRewardAdInteractionListener) {
/* 58 */     this.d = paramRewardAdInteractionListener;
/*    */   }
/*    */   
/*    */   public x e() {
/* 62 */     return this.e;
/*    */   }
/*    */   
/*    */   public void a(x paramx) {
/* 66 */     this.e = paramx;
/*    */   }
/*    */   
/*    */   public void f() {
/* 70 */     this.b = null;
/* 71 */     this.c = null;
/* 72 */     this.d = null;
/* 73 */     this.e = null;
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\s.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */