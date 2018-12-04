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
/*     */ class TTRewardVideoAdImpl
/*     */   implements TTRewardVideoAd
/*     */ {
/*     */   private Context mContext;
/*     */   private NativeAdData mNativeAdData;
/*     */   private AdSlot mAdSlot;
/*     */   private TTRewardVideoAd.RewardAdInteractionListener mInteractionListener;
/*     */   private DownLoadListenerImpl mLoadListener;
/*  36 */   private boolean g = true;
/*     */   
/*     */   AQuery2 mAQuery2;
/*     */   
/*     */   private boolean h;
/*     */   
/*     */   private TTAdNative.RewardVideoAdListener mAdListener;
/*     */   
/*     */   TTRewardVideoAdImpl(Context paramContext, NativeAdData paramh, AdSlot paramAdSlot, TTAdNative.RewardVideoAdListener paramRewardVideoAdListener)
/*     */   {
/*  46 */     this.mContext = paramContext;
/*  47 */     this.mNativeAdData = paramh;
/*  48 */     this.mAdSlot = paramAdSlot;
/*  49 */     this.mAdListener = paramRewardVideoAdListener;
/*     */   }
/*     */   
/*     */   public void a() {
/*  53 */     AdEvent.addEventData(this.mNativeAdData);
/*  54 */     if (getInteractionType() == 4) {
/*  55 */       this.mLoadListener = new DownLoadListenerImpl(this.mContext, this.mNativeAdData, "embeded_ad");
/*     */     }
/*  57 */     this.mAQuery2 = new AQuery2(this.mContext);
/*  58 */     this.mAQuery2.download(this.mNativeAdData.a().d(), a(this.mContext, "/reward_video_cache/", "tt_reward_video_cache"), new AjaxCallback()
/*     */     {
/*     */       public void callback(String paramAnonymousString, File paramAnonymousFile, AjaxStatus paramAnonymousAjaxStatus)
/*     */       {
/*  62 */         super.callback(paramAnonymousString, paramAnonymousFile, paramAnonymousAjaxStatus);
/*  63 */         if ((paramAnonymousAjaxStatus.getCode() == 200) && (paramAnonymousFile != null)) {
/*  64 */           h=true;
/*  65 */           if (mAdListener != null) {
/*  66 */             mAdListener.onRewardVideoCached();
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
/*  79 */     this.mInteractionListener = paramRewardAdInteractionListener;
/*     */   }
/*     */   
/*     */   public void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener)
/*     */   {
/*  84 */     if (this.mLoadListener != null) {
/*  85 */       this.mLoadListener.a(paramTTAppDownloadListener);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getInteractionType()
/*     */   {
/*  91 */     if (this.mNativeAdData == null) {
/*  92 */       return -1;
/*     */     }
/*  94 */     return this.mNativeAdData.c();
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
/* 112 */     localIntent.putExtra("reward_name", this.mAdSlot.getRewardName());
/* 113 */     localIntent.putExtra("reward_amount", this.mAdSlot.getRewardAmount());
/* 114 */     localIntent.putExtra("media_extra", this.mAdSlot.getMediaExtra());
/* 115 */     localIntent.putExtra("user_id", this.mAdSlot.getUserID());
/* 116 */     localIntent.putExtra("show_download_bar", this.g);
/* 117 */     localIntent.putExtra("orientation", this.mAdSlot.getOrientation());
/* 118 */     if (this.h) {
/* 119 */       localIntent.putExtra("video_cache_url", a(this.mContext, "/reward_video_cache/", "tt_reward_video_cache").toString());
/*     */     }
/*     */     
/* 122 */     s.a().f();
/* 123 */     s.a().a(this.mNativeAdData);
/* 124 */     s.a().a(this.mInteractionListener);
/* 125 */     s.a().a(this.mLoadListener);
/*     */     
/* 127 */     paramActivity.startActivity(localIntent);
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\TTRewardVideoAdImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */