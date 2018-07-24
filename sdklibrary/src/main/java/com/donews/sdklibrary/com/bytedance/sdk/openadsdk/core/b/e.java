/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core.b;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import android.support.annotation.NonNull;
/*     */ import android.view.View;
/*     */ import android.view.ViewGroup;
/*     */ import com.bytedance.sdk.openadsdk.TTAdDislike;
/*     */ import com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback;
/*     */ import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
/*     */ import com.bytedance.sdk.openadsdk.TTBannerAd;
/*     */ import com.bytedance.sdk.openadsdk.TTBannerAd.AdInteractionListener;
/*     */ import com.bytedance.sdk.openadsdk.c.x;
/*     */ import com.bytedance.sdk.openadsdk.core.d.h;
/*     */ import com.bytedance.sdk.openadsdk.core.f;
/*     */ import com.bytedance.sdk.openadsdk.core.f.a;
/*     */ import com.bytedance.sdk.openadsdk.g.m;
/*     */ import com.bytedance.sdk.openadsdk.g.r;
/*     */ import com.bytedance.sdk.openadsdk.g.t;
/*     */ import com.bytedance.sdk.openadsdk.g.t.a;
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
/*     */ public class e
/*     */   implements TTBannerAd, t.a
/*     */ {
/*     */   private d a;
/*     */   private a b;
/*     */   private Context c;
/*     */   private t d;
/*     */   private int e;
/*     */   private h f;
/*     */   private TTBannerAd.AdInteractionListener g;
/*     */   private TTAppDownloadListener h;
/*     */   private com.bytedance.sdk.openadsdk.b.b i;
/*     */   private b j;
/*     */   private x k;
/*  53 */   private String l = "banner_ad";
/*     */   
/*     */   public e(Context paramContext, a parama)
/*     */   {
/*  57 */     this.c = paramContext;
/*  58 */     this.b = parama;
/*  59 */     this.f = parama.b();
/*  60 */     this.a = new d(paramContext);
/*  61 */     this.j = b.a(this.c);
/*  62 */     a(this.a.b(), parama);
/*  63 */     a();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void a()
/*     */   {
/*  70 */     f localf = new f(this.c, this.a);
/*  71 */     this.a.addView(localf);
/*  72 */     localf.setCallback(new f.a()
/*     */     {
/*     */       public void a(boolean paramAnonymousBoolean) {
/*  75 */         if (paramAnonymousBoolean) {
/*  76 */           e.a(e.this);
/*  77 */           m.b("TTBannerAd", "获得焦点，开始计时");
/*     */         } else {
/*  79 */           m.b("TTBannerAd", "失去焦点，停止计时");
/*  80 */           e.b(e.this);
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
/*     */       public void a(View paramAnonymousView)
/*     */       {
/*  94 */         e.a(e.this);
/*  95 */         m.b("TTBannerAd", "BANNER SHOW");
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
/* 162 */     this.d = new t(Looper.getMainLooper(), this);
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
/* 179 */       this.i = new com.bytedance.sdk.openadsdk.b.b(this.c, this.f);
/*     */     }
/* 181 */     this.i.setDislikeInteractionCallback(paramDislikeInteractionCallback);
/*     */   }
/*     */   
/*     */   public void a(Message paramMessage)
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
/* 195 */     this.j.a(new b.a()
/*     */     {
/*     */       public void a(@NonNull a paramAnonymousa) {
/* 198 */         e.a(e.this, paramAnonymousa);
/* 199 */         e.c(e.this).e();
/* 200 */         e.a(e.this);
/*     */       }
/*     */       
/*     */       public void a()
/*     */       {
/* 205 */         e.a(e.this);
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
/*     */   private void a(@NonNull a parama)
/*     */   {
/* 227 */     if ((this.a.c() != null) && (!this.a.f())) {
/* 228 */       a(this.a.c(), parama);
/*     */     }
/*     */   }
/*     */   
/*     */   private x a(h paramh) {
/* 233 */     if (paramh.c() == 4) {
/* 234 */       return new x(this.c, paramh, this.l);
/*     */     }
/* 236 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void a(@NonNull c paramc, @NonNull a parama)
/*     */   {
/* 243 */     paramc.a(parama.a());
/* 244 */     final h localh = parama.b();
/* 245 */     this.f = localh;
/* 246 */     this.i = new com.bytedance.sdk.openadsdk.b.b(this.c, this.f);
/* 247 */     paramc.a(localh);
/* 248 */     this.k = a(localh);
/* 249 */     com.bytedance.sdk.openadsdk.d.c.a(localh);
/* 250 */     f localf = a(paramc);
/* 251 */     if (localf == null) {
/* 252 */       localf = new f(this.c, paramc);
/* 253 */       paramc.addView(localf);
/*     */     }
/* 255 */     localf.setCallback(new f.a()
/*     */     {
/*     */       public void a(boolean paramAnonymousBoolean) {
/* 258 */         if (e.d(e.this) != null) {
/* 259 */           if (paramAnonymousBoolean) {
/* 260 */             e.d(e.this).e();
/*     */           } else {
/* 262 */             e.d(e.this).f();
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       public void a() {}
/*     */       
/*     */ 
/*     */ 
/*     */       public void b() {}
/*     */       
/*     */ 
/*     */ 
/*     */       public void a(View paramAnonymousView)
/*     */       {
/* 279 */         com.bytedance.sdk.openadsdk.d.c.a(e.e(e.this), localh, e.f(e.this));
/* 280 */         if (e.g(e.this) != null) {
/* 281 */           e.g(e.this).onAdShow(paramAnonymousView, localh.c());
/*     */         }
/* 283 */         if (localh.t()) {
/* 284 */           r.a(localh, paramAnonymousView);
/*     */         }
/*     */         
/*     */       }
/*     */       
/* 289 */     });
/* 290 */     com.bytedance.sdk.openadsdk.core.a.a locala = new com.bytedance.sdk.openadsdk.core.a.a(this.c, localh, this.l, 2);
/* 291 */     locala.a(paramc);
/* 292 */     locala.b(this.a.d());
/* 293 */     locala.a(this.k);
/* 294 */     locala.a(new com.bytedance.sdk.openadsdk.core.a.b.a()
/*     */     {
/*     */       public void a(View paramAnonymousView, int paramAnonymousInt) {
/* 297 */         if (e.g(e.this) != null) {
/* 298 */           e.g(e.this).onAdClicked(paramAnonymousView, paramAnonymousInt);
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
/* 309 */     localf.setNeedCheckingShow(!com.bytedance.sdk.openadsdk.d.c.b(localh));
/*     */   }
/*     */   
/*     */   private f a(ViewGroup paramViewGroup)
/*     */   {
/* 314 */     for (int m = 0; m < paramViewGroup.getChildCount(); m++) {
/* 315 */       View localView = paramViewGroup.getChildAt(m);
/* 316 */       if ((localView instanceof f)) {
/* 317 */         return (f)localView;
/*     */       }
/*     */     }
/* 320 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\b\e.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */