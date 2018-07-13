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
import com.bytedance.sdk.openadsdk.core.nibuguan.h;
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
/*     */ class m
/*     */ {
/*     */   private h b;
/*     */   private DownLoadListenerImpl c;
/*     */   private a d;
/*     */   protected Context a;
/*     */   private TTFeedAd e;
/*     */   
/*     */   m(Context paramContext, TTFeedAd paramTTFeedAd, h paramh)
/*     */   {
/*  42 */     this.e = paramTTFeedAd;
/*  43 */     this.b = paramh;
/*  44 */     this.a = paramContext;
/*     */     
/*  46 */     if (this.b.c() == 4) {
/*  47 */       this.d = new a();
/*  48 */       this.c = new DownLoadListenerImpl(this.a, this.b, "embeded_ad");
/*     */       
/*  50 */       this.c.a(new com.bytedance.sdk.openadsdk.core.a.c(this.a, this.b, "embeded_ad"));
/*     */     }
/*     */   }
/*     */   
/*     */   void a(@NonNull Activity paramActivity) {
/*  55 */     if (this.c != null) {
/*  56 */       this.c.a(paramActivity);
/*     */     }
/*     */   }
/*     */   
/*     */   DownLoadListenerImpl a() {
/*  61 */     return this.c;
/*     */   }
/*     */   
/*     */   void a(@NonNull ViewGroup paramViewGroup, List<View> paramList1, @Nullable List<View> paramList2, final TTFeedAd.AdInteractionListener paramAdInteractionListener)
/*     */   {
/*  66 */     if (this.c != null) {
/*  67 */       this.c.e();
/*     */     }
/*  69 */     AdEvent.a(this.b);
/*  70 */     SplashManager localf = a(paramViewGroup);
/*  71 */     if (localf == null) {
/*  72 */       localf = new SplashManager(this.a, paramViewGroup);
/*  73 */       paramViewGroup.addView(localf);
/*     */     }
/*  75 */     localf.a();
/*  76 */     localf.setRefClickViews(paramList1);
/*  77 */     localf.setRefCreativeViews(paramList2);
/*     */
/*     */ 
/*  80 */     AdClickListenerImpl localb = new AdClickListenerImpl(this.a, this.b, "embeded_ad", 1);
/*  81 */     localb.a(paramViewGroup);
/*  82 */     localb.a(this.e);
/*  83 */     localb.a(new AdClickListenerImpl.OnClick()
/*     */     {
/*     */       public void onClick(View paramAnonymousView, int paramAnonymousInt) {
/*  86 */         if (paramAdInteractionListener != null) {
/*  87 */           paramAdInteractionListener.onAdClicked(paramAnonymousView,e);
/*     */         }
/*     */         
/*     */       }
/*     */       
/*  92 */     });
/*  93 */     com.bytedance.sdk.openadsdk.core.a.a locala = new com.bytedance.sdk.openadsdk.core.a.a(this.a, this.b, "embeded_ad", 1);
/*  94 */     locala.a(paramViewGroup);
/*  95 */     locala.a(this.c);
/*  96 */     locala.a(new AdClickListenerImpl.OnClick()
/*     */     {
/*     */       public void onClick(View paramAnonymousView, int paramAnonymousInt) {
/*  99 */         if (paramAdInteractionListener != null) {
/* 100 */           paramAdInteractionListener.onAdCreativeClick(paramAnonymousView, e);
/*     */         }
/*     */         
/*     */       }
/* 104 */     });
/* 105 */     localf.a(paramList1, localb);
/* 106 */     localf.a(paramList2, locala);
/*     */     
/* 108 */     localf.setCallback(new SplashManager.SplashListener()
/*     */     {
/*     */       public void a(boolean paramAnonymousBoolean) {
/* 111 */         if (c!= null) {
/* 112 */           if (paramAnonymousBoolean) {
/* 113 */           c.e();
/*     */           } else {
/* 115 */           c.f();
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       public void a() {}
/*     */       
/*     */ 
/*     */       public void b() {}
/*     */       
/*     */ 
/*     */       public void onShow(View paramAnonymousView)
/*     */       {
/* 130 */         AdEvent.show(a, b, "embeded_ad");
/* 131 */         if (paramAdInteractionListener != null) {
/* 132 */           paramAdInteractionListener.onAdShow(e);
/*     */         }
/* 134 */         if (b.t()) {
/* 135 */           ToolUtils.a(b, paramAnonymousView);
/*     */         }
/*     */       }
/* 138 */     });
/* 139 */     localf.setNeedCheckingShow(true);
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
/* 155 */     if (this.c != null) {
/* 156 */       if (this.d == null) {
/* 157 */         this.d = new a();
/*     */       }
/* 159 */       this.d.a(paramTTAppDownloadListener);
/* 160 */       this.c.a(paramTTAppDownloadListener);
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