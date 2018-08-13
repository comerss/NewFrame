/*     */ package com.bytedance.sdk.openadsdk.core.bbb;
/*     */ 
/*     */ import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTBannerAd;
import com.bytedance.sdk.openadsdk.b.TTAdDislikeImpl;
import com.bytedance.sdk.openadsdk.ccccc.DownLoadListenerImpl;
import com.bytedance.sdk.openadsdk.core.SplashManager;
import com.bytedance.sdk.openadsdk.core.a.AdClickListenerImpl;
import com.bytedance.sdk.openadsdk.core.a.AdClickListerReal;
import com.bytedance.sdk.openadsdk.core.nibuguan.NativeAdData;
import com.bytedance.sdk.openadsdk.dddd.AdEvent;
import com.bytedance.sdk.openadsdk.ggg.LogUtils;
import com.bytedance.sdk.openadsdk.ggg.MineHandler;
import com.bytedance.sdk.openadsdk.ggg.ToolUtils;

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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TTBannerAdImpl
/*     */   implements TTBannerAd, MineHandler.OnResult
/*     */ {
/*     */   private TTBannerLayout a;
/*     */   private com.bytedance.sdk.openadsdk.core.bbb.a b;
/*     */   private Context c;
/*     */   private MineHandler d;
/*     */   private int e;
/*     */   private NativeAdData f;
/*     */   private TTBannerAd.AdInteractionListener g;
/*     */   private TTAppDownloadListener h;
/*     */   private TTAdDislikeImpl i;
/*     */   private b j;
/*     */   private DownLoadListenerImpl k;
/*  53 */   private String l = "banner_ad";
/*     */   
/*     */   public TTBannerAdImpl(Context paramContext, com.bytedance.sdk.openadsdk.core.bbb.a parama)
/*     */   {
/*  57 */     this.c = paramContext;
/*  58 */     this.b = parama;
/*  59 */     this.f = parama.b();
/*  60 */     this.a = new TTBannerLayout(paramContext);
/*  61 */     this.j = com.bytedance.sdk.openadsdk.core.bbb.b.asss(this.c);
/*  62 */     a(this.a.b(), parama);
/*  63 */     a();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void a()
/*     */   {
/*  70 */     SplashManager localf = new SplashManager(this.c, this.a);
/*  71 */     this.a.addView(localf);
/*  72 */     localf.setCallback(new SplashManager.SplashListener()
/*     */     {
/*     */       public void onWindowFocusChanged(boolean paramAnonymousBoolean) {
/*  75 */         if (paramAnonymousBoolean) {
/*  76 */           onAttachedToWindow();
/*  77 */           LogUtils.b("TTBannerAd", "获得焦点，开始计时");
/*     */         } else {
/*  79 */           LogUtils.b("TTBannerAd", "失去焦点，停止计时");
/*  80 */           onDetachedFromWindow();
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
/*  94 */         onAttachedToWindow();
/*  95 */         LogUtils.b("TTBannerAd", "BANNER SHOW");
/*     */       }
/*  97 */     });
/*  98 */     localf.setNeedCheckingShow(true);
/*     */   }
/*     */   
/*     */   public View getBannerView()
/*     */   {
/* 103 */     return this.a;
/*     */   }
/*     */   
/*     */   public void setBannerInteractionListener(TTBannerAd.AdInteractionListener paramAdInteractionListener)
/*     */   {
/* 108 */     this.g = paramAdInteractionListener;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener)
/*     */   {
/* 114 */     this.h = paramTTAppDownloadListener;
/*     */     
/* 116 */     if (this.k != null) {
/* 117 */       this.k.a(this.h);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getInteractionType()
/*     */   {
/* 123 */     if (this.f == null) {
/* 124 */       return -1;
/*     */     }
/* 126 */     return this.f.c();
/*     */   }
/*     */   
/*     */   public TTAdDislike getDislikeDialog(TTAdDislike.DislikeInteractionCallback paramDislikeInteractionCallback)
/*     */   {
/* 131 */     if (paramDislikeInteractionCallback == null) {
/* 132 */       return null;
/*     */     }
/* 134 */     b(paramDislikeInteractionCallback);
/* 135 */     return this.i;
/*     */   }
/*     */   
/*     */   public void setShowDislikeIcon(TTAdDislike.DislikeInteractionCallback paramDislikeInteractionCallback)
/*     */   {
/* 140 */     if (paramDislikeInteractionCallback == null) {
/* 141 */       return;
/*     */     }
/* 143 */     a(paramDislikeInteractionCallback);
/*     */   }
/*     */   
/*     */   public void setSlideIntervalTime(int paramInt)
/*     */   {
/* 148 */     if (paramInt <= 0) {
/* 149 */       return;
/*     */     }
/* 151 */     this.l = "slide_banner_ad";
/* 152 */     a(this.a.b(), this.b);
/*     */     
/* 154 */     this.a.a();
/* 155 */     this.a.a(1000);
/* 156 */     if (paramInt < 30000) {
/* 157 */       paramInt = 30000;
/* 158 */     } else if (paramInt > 120000) {
/* 159 */       paramInt = 120000;
/*     */     }
/* 161 */     this.e = paramInt;
/* 162 */     this.d = new MineHandler(Looper.getMainLooper(), this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void a(TTAdDislike.DislikeInteractionCallback paramDislikeInteractionCallback)
/*     */   {
/* 170 */     b(paramDislikeInteractionCallback);
/* 171 */     this.a.a(this.i);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void b(TTAdDislike.DislikeInteractionCallback paramDislikeInteractionCallback)
/*     */   {
/* 178 */     if (this.i == null) {
/* 179 */       this.i = new TTAdDislikeImpl(this.c, this.f);
/*     */     }
/* 181 */     this.i.setDislikeInteractionCallback(paramDislikeInteractionCallback);
/*     */   }
/*     */   
/*     */   public void doResult(Message paramMessage)
/*     */   {
/* 186 */     if (paramMessage.what == 1) {
/* 187 */       b();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void b()
/*     */   {
/* 195 */     this.j.asss(new com.bytedance.sdk.openadsdk.core.bbb.b.assssss()
/*     */     {
/*     */       public void asa(@NonNull com.bytedance.sdk.openadsdk.core.bbb.a paramAnonymousa) {
/* 198 */         a( paramAnonymousa);
/* 199 */         a.e();
/* 200 */         asa();
/*     */       }
/*     */       
/*     */       public void asa()
/*     */       {
/* 205 */         a();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private void c() {
/* 211 */     if (this.d != null) {
/* 212 */       this.d.removeCallbacksAndMessages(null);
/* 213 */       this.d.sendEmptyMessageDelayed(1, this.e);
/*     */     }
/*     */   }
/*     */   
/*     */   private void d() {
/* 218 */     if (this.d != null) {
/* 219 */       this.d.removeCallbacksAndMessages(null);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void a(@NonNull com.bytedance.sdk.openadsdk.core.bbb.a parama)
/*     */   {
/* 227 */     if ((this.a.c() != null) && (!this.a.f())) {
/* 228 */       a(this.a.c(), parama);
/*     */     }
/*     */   }
/*     */   
/*     */   private DownLoadListenerImpl a(NativeAdData paramh) {
/* 233 */     if (paramh.c() == 4) {
/* 234 */       return new DownLoadListenerImpl(this.c, paramh, this.l);
/*     */     }
/* 236 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void a(@NonNull c paramc, @NonNull com.bytedance.sdk.openadsdk.core.bbb.a parama)
/*     */   {
/* 243 */     paramc.a(parama.a());
/* 244 */     final NativeAdData localh = parama.b();
/* 245 */     this.f = localh;
/* 246 */     this.i = new TTAdDislikeImpl(this.c, this.f);
/* 247 */     paramc.a(localh);
/* 248 */     this.k = a(localh);
/* 249 */     AdEvent.a(localh);
/* 250 */     SplashManager localf = a(paramc);
/* 251 */     if (localf == null) {
/* 252 */       localf = new SplashManager(this.c, paramc);
/* 253 */       paramc.addView(localf);
/*     */     }
/* 255 */     localf.setCallback(new SplashManager.SplashListener()
/*     */     {
/*     */       public void onWindowFocusChanged(boolean paramAnonymousBoolean) {
/* 258 */         if (k != null) {
/* 259 */           if (paramAnonymousBoolean) {
/* 260 */             k.e();
/*     */           } else {
/* 262 */            k.f();
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       public void onAttachedToWindow() {}
/*     */       
/*     */ 
/*     */ 
/*     */       public void onDetachedFromWindow() {}
/*     */       
/*     */ 
/*     */ 
/*     */       public void onShow(View paramAnonymousView)
/*     */       {
/* 279 */         AdEvent.show(c, localh, l);
/* 280 */         if (g != null) {
/* 281 */           g.onAdShow(paramAnonymousView, localh.c());
/*     */         }
/* 283 */         if (localh.t()) {
/* 284 */           ToolUtils.a(localh, paramAnonymousView);
/*     */         }
/*     */         
/*     */       }
/*     */       
/* 289 */     });
/* 290 */      AdClickListerReal locala = new AdClickListerReal(this.c, localh, this.l, 2);
/* 291 */     locala.a(paramc);
/* 292 */     locala.b(this.a.d());
/* 293 */     locala.a(this.k);
/* 294 */     locala.setOnClickLister(new AdClickListenerImpl.OnClick()
/*     */     {
/*     */       public void onClick(View paramAnonymousView, int paramAnonymousInt) {
/* 297 */         if (g != null) {
/* 298 */          g.onAdClicked(paramAnonymousView, paramAnonymousInt);
/*     */         }
/*     */         
/*     */       }
/* 302 */     });
/* 303 */     paramc.setOnClickListener(locala);
/* 304 */     paramc.setOnTouchListener(locala);
/* 305 */     if (this.k != null) {
/* 306 */       this.k.a(new com.bytedance.sdk.openadsdk.core.a.c(this.c, localh, this.l));
/* 307 */       this.k.a(this.h);
/*     */     }
/* 309 */     localf.setNeedCheckingShow(!AdEvent.b(localh));
/*     */   }
/*     */   
/*     */   private SplashManager a(ViewGroup paramViewGroup)
/*     */   {
/* 314 */     for (int m = 0; m < paramViewGroup.getChildCount(); m++) {
/* 315 */       View localView = paramViewGroup.getChildAt(m);
/* 316 */       if ((localView instanceof SplashManager)) {
/* 317 */         return (SplashManager)localView;
/*     */       }
/*     */     }
/* 320 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\result\TTBannerAdImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */