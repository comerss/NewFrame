/*     */ package com.bytedance.sdk.openadsdk.core;
/*     */ 
/*     */ import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.ccccc.DownLoadListenerImpl;
import com.bytedance.sdk.openadsdk.core.a.AdClickListenerImpl;
import com.bytedance.sdk.openadsdk.core.a.AdClickListerReal;
import com.bytedance.sdk.openadsdk.core.nibuguan.NativeAdData;
import com.bytedance.sdk.openadsdk.dddd.AdEvent;
import com.bytedance.sdk.openadsdk.ggg.ToolUtils;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class FeedAdManager
/*     */ {
/*     */   private NativeAdData b;
/*     */   private DownLoadListenerImpl mDownLoadListener;
/*     */   private a d;
/*     */   protected Context mContext;
/*     */   private TTFeedAd mTTFeedAd;
/*     */   
/*     */   FeedAdManager(Context paramContext, TTFeedAd paramTTFeedAd, NativeAdData paramh)
/*     */   {
/*  42 */     this.mTTFeedAd = paramTTFeedAd;
/*  43 */     this.b = paramh;
/*  44 */     this.mContext = paramContext;
/*     */     
/*  46 */     if (this.b.c() == 4) {
/*  47 */       this.d = new a();
/*  48 */       this.mDownLoadListener = new DownLoadListenerImpl(this.mContext, this.b, "embeded_ad");
/*     */       
/*  50 */       this.mDownLoadListener.a(new com.bytedance.sdk.openadsdk.core.a.c(this.mContext, this.b, "embeded_ad"));
/*     */     }
/*     */   }
/*     */   
/*     */   void a(@NonNull Activity paramActivity) {
/*  55 */     if (this.mDownLoadListener != null) {
/*  56 */       this.mDownLoadListener.a(paramActivity);
/*     */     }
/*     */   }
/*     */   
/*     */   DownLoadListenerImpl a() {
/*  61 */     return this.mDownLoadListener;
/*     */   }
/*     */   
/*     */   void registerViewForInteraction(@NonNull ViewGroup paramViewGroup, List<View> paramList1, @Nullable List<View> paramList2, final TTFeedAd.AdInteractionListener paramAdInteractionListener)
/*     */   {
/*  66 */     if (this.mDownLoadListener != null) {
/*  67 */       this.mDownLoadListener.e();
/*     */     }
/*  69 */     AdEvent.a(this.b);
/*  70 */     SplashManager splashManager = a(paramViewGroup);
/*  71 */     if (splashManager == null) {
/*  72 */       splashManager = new SplashManager(this.mContext, paramViewGroup);
/*  73 */       paramViewGroup.addView(splashManager);
/*     */     }
/*  75 */     splashManager.a();
/*  76 */     splashManager.setRefClickViews(paramList1);
/*  77 */     splashManager.setRefCreativeViews(paramList2);
/*     */
/*     */ 
/*  80 */     AdClickListenerImpl adClickListener = new AdClickListenerImpl(this.mContext, this.b, "embeded_ad", 1);
/*  81 */     adClickListener.a(paramViewGroup);
/*  82 */     adClickListener.setTTFeedAd(this.mTTFeedAd);
/*  83 */     adClickListener.setOnClickLister(new AdClickListenerImpl.OnClick()
/*     */     {
/*     */       public void onClick(View paramAnonymousView, int paramAnonymousInt) {
/*  86 */         if (paramAdInteractionListener != null) {
/*  87 */           paramAdInteractionListener.onAdClicked(paramAnonymousView, mTTFeedAd);
/*     */         }
/*     */         
/*     */       }
/*     */       
/*  92 */     });
/*  93 */     AdClickListerReal locala = new AdClickListerReal(this.mContext, this.b, "embeded_ad", 1);
/*  94 */     locala.a(paramViewGroup);
/*  95 */     locala.setDownLoadListener(this.mDownLoadListener);
/*  96 */     locala.setOnClickLister(new AdClickListenerImpl.OnClick()
/*     */     {
/*     */       public void onClick(View paramAnonymousView, int paramAnonymousInt) {
/*  99 */         if (paramAdInteractionListener != null) {
/* 100 */           paramAdInteractionListener.onAdCreativeClick(paramAnonymousView, mTTFeedAd);
/*     */         }
/*     */         
/*     */       }
/* 104 */     });
/* 105 */     splashManager.onClick(paramList1, adClickListener);
/* 106 */     splashManager.onClick(paramList2, locala);
/*     */     
/* 108 */     splashManager.setCallback(new SplashManager.SplashListener()
/*     */     {
/*     */       public void onWindowFocusChanged(boolean paramAnonymousBoolean) {
/* 111 */         if (mDownLoadListener != null) {
/* 112 */           if (paramAnonymousBoolean) {
/* 113 */           mDownLoadListener.e();
/*     */           } else {
/* 115 */           mDownLoadListener.f();
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       public void onAttachedToWindow() {}
/*     */       
/*     */ 
/*     */       public void onDetachedFromWindow() {}
/*     */       
/*     */ 
/*     */       public void onShow(View paramAnonymousView)
/*     */       {
/* 130 */         AdEvent.show(mContext, b, "embeded_ad");
/* 131 */         if (paramAdInteractionListener != null) {
/* 132 */           paramAdInteractionListener.onAdShow(mTTFeedAd);
/*     */         }
/* 134 */         if (b.t()) {
/* 135 */           ToolUtils.a(b, paramAnonymousView);
/*     */         }
/*     */       }
/* 138 */     });
/* 139 */     splashManager.setNeedCheckingShow(true);
/*     */   }
/*     */   
/*     */   private SplashManager a(ViewGroup paramViewGroup)
/*     */   {
/* 144 */     for (int i = 0; i < paramViewGroup.getChildCount(); i++) {
/* 145 */       View localView = paramViewGroup.getChildAt(i);
/* 146 */       if ((localView instanceof SplashManager)) {
/* 147 */         return (SplashManager)localView;
/*     */       }
/*     */     }
/* 150 */     return null;
/*     */   }
/*     */   
/*     */   void a(TTAppDownloadListener paramTTAppDownloadListener)
/*     */   {
/* 155 */     if (this.mDownLoadListener != null) {
/* 156 */       if (this.d == null) {
/* 157 */         this.d = new a();
/*     */       }
/* 159 */       this.d.a(paramTTAppDownloadListener);
/* 160 */       this.mDownLoadListener.a(paramTTAppDownloadListener);
/*     */     }
/*     */   }
/*     */   
/*     */   private class a implements TTAppDownloadListener { private a() {}
/*     */     
/* 166 */     private List<WeakReference<TTAppDownloadListener>> b = new LinkedList();
/*     */     
/*     */     void a(TTAppDownloadListener paramTTAppDownloadListener) {
/* 169 */       this.b.add(new WeakReference(paramTTAppDownloadListener));
/*     */     }
/*     */     
/*     */     public void onIdle()
/*     */     {
/* 174 */       Iterator localIterator = this.b.iterator();
/* 175 */       while (localIterator.hasNext()) {
/* 176 */         WeakReference localWeakReference = (WeakReference)localIterator.next();
/* 177 */         TTAppDownloadListener localTTAppDownloadListener = (TTAppDownloadListener)localWeakReference.get();
/* 178 */         if (localTTAppDownloadListener == null) {
/* 179 */           localIterator.remove();
/*     */         } else {
/* 181 */           localTTAppDownloadListener.onIdle();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     public void onDownloadActive(long paramLong1, long paramLong2, String paramString1, String paramString2)
/*     */     {
/* 188 */       Iterator localIterator = this.b.iterator();
/* 189 */       while (localIterator.hasNext()) {
/* 190 */         WeakReference localWeakReference = (WeakReference)localIterator.next();
/* 191 */         TTAppDownloadListener localTTAppDownloadListener = (TTAppDownloadListener)localWeakReference.get();
/* 192 */         if (localTTAppDownloadListener == null) {
/* 193 */           localIterator.remove();
/*     */         } else {
/* 195 */           localTTAppDownloadListener.onDownloadActive(paramLong1, paramLong2, paramString1, paramString2);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     public void onDownloadPaused(long paramLong1, long paramLong2, String paramString1, String paramString2)
/*     */     {
/* 202 */       Iterator localIterator = this.b.iterator();
/* 203 */       while (localIterator.hasNext()) {
/* 204 */         WeakReference localWeakReference = (WeakReference)localIterator.next();
/* 205 */         TTAppDownloadListener localTTAppDownloadListener = (TTAppDownloadListener)localWeakReference.get();
/* 206 */         if (localTTAppDownloadListener == null) {
/* 207 */           localIterator.remove();
/*     */         } else {
/* 209 */           localTTAppDownloadListener.onDownloadPaused(paramLong1, paramLong2, paramString1, paramString2);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     public void onDownloadFailed(long paramLong1, long paramLong2, String paramString1, String paramString2)
/*     */     {
/* 216 */       Iterator localIterator = this.b.iterator();
/* 217 */       while (localIterator.hasNext()) {
/* 218 */         WeakReference localWeakReference = (WeakReference)localIterator.next();
/* 219 */         TTAppDownloadListener localTTAppDownloadListener = (TTAppDownloadListener)localWeakReference.get();
/* 220 */         if (localTTAppDownloadListener == null) {
/* 221 */           localIterator.remove();
/*     */         } else {
/* 223 */           localTTAppDownloadListener.onDownloadFailed(paramLong1, paramLong2, paramString1, paramString2);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     public void onInstalled(String paramString1, String paramString2)
/*     */     {
/* 230 */       Iterator localIterator = this.b.iterator();
/* 231 */       while (localIterator.hasNext()) {
/* 232 */         WeakReference localWeakReference = (WeakReference)localIterator.next();
/* 233 */         if (localWeakReference.get() == null) {
/* 234 */           localIterator.remove();
/*     */         } else {
/* 236 */           ((TTAppDownloadListener)localWeakReference.get()).onInstalled(paramString1, paramString2);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     public void onDownloadFinished(long paramLong, String paramString1, String paramString2)
/*     */     {
/* 243 */       Iterator localIterator = this.b.iterator();
/* 244 */       while (localIterator.hasNext()) {
/* 245 */         WeakReference localWeakReference = (WeakReference)localIterator.next();
/* 246 */         TTAppDownloadListener localTTAppDownloadListener = (TTAppDownloadListener)localWeakReference.get();
/* 247 */         if (localTTAppDownloadListener == null) {
/* 248 */           localIterator.remove();
/*     */         } else {
/* 250 */           localTTAppDownloadListener.onDownloadFinished(paramLong, paramString1, paramString2);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\mM.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */