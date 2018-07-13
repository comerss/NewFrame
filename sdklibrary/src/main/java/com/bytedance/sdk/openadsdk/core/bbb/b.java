/*     */ package com.bytedance.sdk.openadsdk.core.bbb;
/*     */ 
/*     */

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.androidquery.callback.AQuery2;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.ApiException;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.nibuguan.NativeData;
import com.bytedance.sdk.openadsdk.core.nibuguan.h;
import com.bytedance.sdk.openadsdk.core.AdNativeListener;
import com.bytedance.sdk.openadsdk.ggg.LogUtils;

import java.lang.ref.WeakReference;

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
/*     */ public class b
/*     */ {
/*  31 */   public static final String a = b.class.getSimpleName();
/*     */   private static volatile b b;
/*     */   private WeakReference<Context> c;
/*     */   private AdNativeListener d;
/*     */   private AdSlot e;
/*     */   private AQuery2 f;
/*     */   
/*     */   private b(Context paramContext) {
/*  39 */     this.c = new WeakReference(paramContext);
/*  40 */     this.d = n.c();
/*  41 */     this.f = new AQuery2(paramContext.getApplicationContext());
/*     */   }
/*     */   
/*     */ 
/*  45 */   private void b(Context paramContext) { this.c = new WeakReference(paramContext); }
/*     */   
/*     */   public static b asss(@NonNull Context paramContext) {
/*  48 */     if (b == null) {
/*  49 */       synchronized (b.class) {
/*  50 */         if (b == null) {
/*  51 */           b = new b(paramContext);
/*     */         }
/*     */       }
/*     */     } else {
/*  55 */       b.b(paramContext);
/*     */     }
/*  57 */     return b;
/*     */   }
/*     */
/*     */   void asss(final assssss parama) {
/*  61 */     this.d.getAds(this.e, null,1, new AdNativeListener.OnAdLoad()
/*     */     {
/*     */       public void onError(int paramAnonymousInt, String paramAnonymousString) {
/*  64 */         LogUtils.b(b.a, paramAnonymousString + "  " + paramAnonymousInt);
/*  65 */         if (parama != null) {
/*  66 */           parama.asa();
/*     */         }
/*     */       }

        @Override
        public void onSuccess(NativeData paramAnonymousa) {
            if ((paramAnonymousa.b() != null) && (!paramAnonymousa.b().isEmpty())) {
                         h localh = (h)paramAnonymousa.b().get(0);
                           if (localh.v()) {
                               asss(localh, parama);
                             } else {
                             LogUtils.b(b.a, "Banner广告解析失败/广告为空");
                                if (parama != null) {
                                     parama.asa();
                                    }
                               }
                        }
        }

        /*     */
/*     */
/*     */     });
/*     */   }
/*     */   
/*     */   public void asss(@NonNull AdSlot paramAdSlot, @NonNull final TTAdNative.BannerAdListener paramBannerAdListener) {
/*  88 */     this.e = paramAdSlot;
/*  89 */     this.d.getAds(paramAdSlot, null,1, new AdNativeListener.OnAdLoad()
/*     */     {
/*     */       public void onError(int paramAnonymousInt, String paramAnonymousString) {
/*  92 */         paramBannerAdListener.onError(paramAnonymousInt, paramAnonymousString);
/*  93 */         LogUtils.b(b.a, paramAnonymousString + " " + paramAnonymousInt);
/*     */       }
/*     */       
/*     */       public void onSuccess(NativeData paramAnonymousa)
/*     */       {
/*  98 */         if ((paramAnonymousa.b() != null) && (!paramAnonymousa.b().isEmpty())) {
/*  99 */           h localh = (h)paramAnonymousa.b().get(0);
/* 100 */           if (localh.v()) {
/* 101 */             assssss local1 = new assssss()
/*     */             {
/*     */               public void asa(@NonNull com.bytedance.sdk.openadsdk.core.bbb.a paramAnonymous2a) {
/* 104 */                 if (c.get() != null) {
/* 105 */                   TTBannerAdImpl locale = new TTBannerAdImpl((Context)c.get(), paramAnonymous2a);
/* 106 */                  paramBannerAdListener.onBannerAdLoad(locale);
/*     */                 }
/*     */               }
/*     */
/*     */               public void asa()
/*     */               {
/* 112 */                paramBannerAdListener.onError(-5, ApiException.a(-5));
/*     */               }
/*     */               
/* 115 */             };
/* 116 */             asss(localh, local1);
/*     */           } else {
/* 118 */             LogUtils.b(b.a, "Banner广告解析失败");
/* 119 */             paramBannerAdListener.onError(-4, ApiException.a(-4));
/*     */           }
/*     */         } else {
/* 122 */           LogUtils.b(b.a, "Banner广告解析失败/广告为空");
/* 123 */           paramBannerAdListener.onError(-4, ApiException.a(-4));
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private void asss(@NonNull final h paramh, @Nullable final assssss parama) {
/* 130 */     String str = ((com.bytedance.sdk.openadsdk.core.nibuguan.g)paramh.f().get(0)).a();
/*     */     
/* 132 */     this.f.ajax(str, Bitmap.class, new AjaxCallback()
/*     */     {
/*     */       public void callback(String paramAnonymousString, Bitmap paramAnonymousBitmap, AjaxStatus paramAnonymousAjaxStatus) {
/* 135 */         super.callback(paramAnonymousString, paramAnonymousBitmap, paramAnonymousAjaxStatus);
/* 136 */         if ((paramAnonymousAjaxStatus == null) || (paramAnonymousBitmap == null) || (paramAnonymousAjaxStatus.getCode() != 200)) {
/* 137 */           if (parama != null) {
/* 138 */             parama.asa();
/*     */           }
/*     */         }
/* 141 */         else if (parama != null) {
/* 142 */           parama.asa(new com.bytedance.sdk.openadsdk.core.bbb.a(paramAnonymousBitmap, paramh));
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static abstract interface assssss
/*     */   {
/*     */     public abstract void asa(@NonNull com.bytedance.sdk.openadsdk.core.bbb.a parama);
/*     */     
/*     */     public abstract void asa();
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\Result\Result.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */