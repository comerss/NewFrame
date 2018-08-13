/*    */ package com.bytedance.sdk.openadsdk.core;
/*    */ 
/*    */

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.ccccc.DownLoadListenerImpl;
import com.bytedance.sdk.openadsdk.core.nibuguan.NativeAdData;
import com.bytedance.sdk.openadsdk.core.video.a.c;

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
/*    */ public class s
/*    */ {
/*    */   private static s a;
/*    */   private c b;
/*    */   private NativeAdData c;
/*    */   private TTRewardVideoAd.RewardAdInteractionListener d;
/*    */   private DownLoadListenerImpl e;
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
/*    */   public NativeAdData c() {
/* 46 */     return this.c;
/*    */   }
/*    */   
/*    */   public void a(NativeAdData paramh) {
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
/*    */   public DownLoadListenerImpl e() {
/* 62 */     return this.e;
/*    */   }
/*    */   
/*    */   public void a(DownLoadListenerImpl paramx) {
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


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\ViewWather.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */