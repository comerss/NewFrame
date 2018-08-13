/*     */ package com.bytedance.sdk.openadsdk.core;
/*     */ 
/*     */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;

import com.androidquery.callback.AQuery2;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.ccccc.DownLoadListenerImpl;
import com.bytedance.sdk.openadsdk.core.nibuguan.NativeAdData;
import com.bytedance.sdk.openadsdk.dddd.AdEvent;

import java.io.File;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class y
/*     */   implements TTRewardVideoAd
/*     */ {
/*     */   private Context b;
/*     */   private NativeAdData c;
/*     */   private AdSlot d;
/*     */   private TTRewardVideoAd.RewardAdInteractionListener e;
/*     */   private DownLoadListenerImpl f;
/*  36 */   private boolean g = true;
/*     */   
/*     */   AQuery2 a;
/*     */   
/*     */   private boolean h;
/*     */   
/*     */   private TTAdNative.RewardVideoAdListener i;
/*     */   
/*     */   y(Context paramContext, NativeAdData paramh, AdSlot paramAdSlot, TTAdNative.RewardVideoAdListener paramRewardVideoAdListener)
/*     */   {
/*  46 */     this.b = paramContext;
/*  47 */     this.c = paramh;
/*  48 */     this.d = paramAdSlot;
/*  49 */     this.i = paramRewardVideoAdListener;
/*     */   }
/*     */   
/*     */   public void a() {
/*  53 */     AdEvent.a(this.c);
/*  54 */     if (getInteractionType() == 4) {
/*  55 */       this.f = new DownLoadListenerImpl(this.b, this.c, "embeded_ad");
/*     */     }
/*  57 */     this.a = new AQuery2(this.b);
/*  58 */     this.a.download(this.c.a().d(), a(this.b, "/reward_video_cache/", "tt_reward_video_cache"), new AjaxCallback()
/*     */     {
/*     */       public void callback(String paramAnonymousString, File paramAnonymousFile, AjaxStatus paramAnonymousAjaxStatus)
/*     */       {
/*  62 */         super.callback(paramAnonymousString, paramAnonymousFile, paramAnonymousAjaxStatus);
/*  63 */         if ((paramAnonymousAjaxStatus.getCode() == 200) && (paramAnonymousFile != null)) {
/*  64 */           h=true;
/*  65 */           if (i != null) {
/*  66 */             i.onRewardVideoCached();
/*     */           }
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private File a(Context paramContext, String paramString1, String paramString2) {
/*  74 */            return com.bytedance.sdk.openadsdk.ggg.f.a(paramContext, paramString1, paramString2);

    /*     */   }
/*     */   
/*     */   public void setRewardAdInteractionListener(TTRewardVideoAd.RewardAdInteractionListener paramRewardAdInteractionListener)
/*     */   {
/*  79 */     this.e = paramRewardAdInteractionListener;
/*     */   }
/*     */   
/*     */   public void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener)
/*     */   {
/*  84 */     if (this.f != null) {
/*  85 */       this.f.a(paramTTAppDownloadListener);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getInteractionType()
/*     */   {
/*  91 */     if (this.c == null) {
/*  92 */       return -1;
/*     */     }
/*  94 */     return this.c.c();
/*     */   }
/*     */   
/*     */   public void setShowDownLoadBar(boolean paramBoolean)
/*     */   {
/*  99 */     this.g = paramBoolean;
/*     */   }
/*     */   
/*     */   public void showRewardVideoAd(Activity paramActivity)
/*     */   {
/* 104 */     if (paramActivity.isFinishing()) {
/* 105 */       return;
/*     */     }
/* 107 */     if (Looper.getMainLooper() != Looper.myLooper()) {
/* 108 */       throw new IllegalStateException("不能在子线程调用 TTRewardVideoAd.showRewardVideoAd");
/*     */     }
/* 110 */     Intent localIntent = null;
/* 111 */     localIntent = new Intent(paramActivity, TTRewardVideoActivity.class);
/* 112 */     localIntent.putExtra("reward_name", this.d.getRewardName());
/* 113 */     localIntent.putExtra("reward_amount", this.d.getRewardAmount());
/* 114 */     localIntent.putExtra("media_extra", this.d.getMediaExtra());
/* 115 */     localIntent.putExtra("user_id", this.d.getUserID());
/* 116 */     localIntent.putExtra("show_download_bar", this.g);
/* 117 */     localIntent.putExtra("orientation", this.d.getOrientation());
/* 118 */     if (this.h) {
/* 119 */       localIntent.putExtra("video_cache_url", a(this.b, "/reward_video_cache/", "tt_reward_video_cache").toString());
/*     */     }
/*     */     
/* 122 */     s.a().f();
/* 123 */     s.a().a(this.c);
/* 124 */     s.a().a(this.e);
/* 125 */     s.a().a(this.f);
/*     */     
/* 127 */     paramActivity.startActivity(localIntent);
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\y.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */