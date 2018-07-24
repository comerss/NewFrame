/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core.f;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.graphics.drawable.Drawable;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import android.support.annotation.MainThread;
/*     */ import android.support.annotation.NonNull;
/*     */ import com.bytedance.sdk.openadsdk.AdSlot;
/*     */ import com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener;
/*     */ import com.bytedance.sdk.openadsdk.core.d.i;
/*     */ import com.bytedance.sdk.openadsdk.core.n;
/*     */ import com.bytedance.sdk.openadsdk.core.o;
/*     */ import com.bytedance.sdk.openadsdk.core.o.a;
/*     */ import com.bytedance.sdk.openadsdk.d.c;
/*     */ import com.bytedance.sdk.openadsdk.g.h.a;
/*     */ import com.bytedance.sdk.openadsdk.g.m;
/*     */ import com.bytedance.sdk.openadsdk.g.t;
/*     */ import com.bytedance.sdk.openadsdk.g.t.a;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.List;
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
/*     */   implements t.a
/*     */ {
/*     */   private static volatile b a;
/*     */   private AdSlot b;
/*     */   private WeakReference<TTAdNative.SplashAdListener> c;
/*     */   private o d;
/*     */   private Context e;
/*     */   private t f;
/*     */   private volatile boolean g;
/*     */   private long h;
/*     */   private long i;
/*     */   
/*     */   private b(Context paramContext)
/*     */   {
/*  56 */     this.d = n.c();
/*  57 */     if (paramContext != null) {
/*  58 */       this.e = paramContext.getApplicationContext();
/*     */     }
/*  60 */     this.f = new t(Looper.myLooper(), this);
/*     */   }
/*     */   
/*     */   public static b a(Context paramContext) {
/*  64 */     if (a == null) {
/*  65 */       synchronized (b.class) {
/*  66 */         if (a == null) {
/*  67 */           a = new b(paramContext);
/*     */         }
/*     */       }
/*     */     }
/*  71 */     return a;
/*     */   }
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
/*     */   public void a(AdSlot paramAdSlot, @NonNull TTAdNative.SplashAdListener paramSplashAdListener, int paramInt)
/*     */   {
/*  97 */     this.b = paramAdSlot;
/*  98 */     this.c = new WeakReference(paramSplashAdListener);
/*  99 */     this.g = false;
/* 100 */     paramInt = paramInt <= 0 ? 800 : paramInt;
/* 101 */     this.f.sendEmptyMessageDelayed(2, paramInt);
/* 102 */     c();
/*     */   }
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
/*     */   private void a(AdSlot paramAdSlot, final TTAdNative.SplashAdListener paramSplashAdListener, final boolean paramBoolean1, final boolean paramBoolean2)
/*     */   {
/* 116 */     int j = paramBoolean2 ? 4 : 3;
/* 117 */     this.h = System.currentTimeMillis();
/* 118 */     this.d.a(paramAdSlot, j, new o.a()
/*     */     {
/*     */       public void a(int paramAnonymousInt, String paramAnonymousString)
/*     */       {
/* 122 */         if (!paramBoolean2) {
/* 123 */           paramSplashAdListener.onError(paramAnonymousInt, paramAnonymousString);
/* 124 */           b.this.a();
/*     */         }
/* 126 */         m.b("SplashAdLoadManager", paramAnonymousString + paramAnonymousInt);
/*     */       }
/*     */       
/*     */       public void a(final com.bytedance.sdk.openadsdk.core.d.a paramAnonymousa)
/*     */       {
/* 131 */         if ((paramAnonymousa != null) && (paramAnonymousa.b() != null) && (!paramAnonymousa.b().isEmpty())) {
/* 132 */           final com.bytedance.sdk.openadsdk.core.d.h localh = (com.bytedance.sdk.openadsdk.core.d.h)paramAnonymousa.b().get(0);
/* 133 */           if (localh.v()) {
/* 134 */             c.a(localh, "splash_ad", "load_ad_duration", 
/* 135 */               System.currentTimeMillis() - b.a(b.this));
/* 136 */             b.a(b.this, 0L);
/* 137 */             String str = ((com.bytedance.sdk.openadsdk.core.d.g)localh.f().get(0)).a();
/* 138 */             b.b(b.this, System.currentTimeMillis());
/* 139 */             com.bytedance.sdk.openadsdk.g.h.a(b.b(b.this), str, new h.a()
/*     */             {
/*     */               @MainThread
/*     */               public void a(@NonNull byte[] paramAnonymous2ArrayOfByte)
/*     */               {
/* 144 */                 c.a(localh, "splash_ad", "download_creative_duration", 
/*     */                 
/* 146 */                   System.currentTimeMillis() - b.c(b.this));
/* 147 */                 b.b(b.this, 0L);
/* 148 */                 if ((b.1.this.c) || (b.d(b.this)))
/*     */                 {
/* 150 */                   m.b("SplashAdLoadManager", "加载的广告缓存到本地");
/* 151 */                   a.a(b.b(b.this)).a(new i(paramAnonymousa, localh, paramAnonymous2ArrayOfByte));
/*     */                 } else {
/* 153 */                   b.a(b.this, true);
/* 154 */                   int i = ((com.bytedance.sdk.openadsdk.core.d.g)localh.f().get(0)).b();
/* 155 */                   Drawable localDrawable = com.bytedance.sdk.openadsdk.g.h.a(paramAnonymous2ArrayOfByte, i);
/* 156 */                   if (localDrawable != null) {
/* 157 */                     d locald = new d(b.b(b.this), localh);
/* 158 */                     locald.a(localDrawable);
/* 159 */                     b.1.this.b.onSplashAdLoad(locald);
/* 160 */                     m.b("SplashAdLoadManager", "从网络加载成功并回调出去");
/*     */                   } else {
/* 162 */                     b.1.this.b.onError(-7, com.bytedance.sdk.openadsdk.core.g.a(-7));
/* 163 */                     m.b("SplashAdLoadManager", "图片加载失败");
/*     */                   }
/* 165 */                   b.this.a();
/*     */                 }
/*     */               }
/*     */               
/*     */               @MainThread
/*     */               public void a()
/*     */               {
/* 172 */                 if (!b.1.this.a) {
/* 173 */                   b.1.this.b.onError(-7, com.bytedance.sdk.openadsdk.core.g.a(-7));
/* 174 */                   b.this.a();
/*     */                 }
/* 176 */                 m.b("SplashAdLoadManager", "图片加载失败");
/*     */               }
/*     */             });
/*     */           } else {
/* 180 */             if (!paramBoolean2) {
/* 181 */               paramSplashAdListener.onError(-3, com.bytedance.sdk.openadsdk.core.g.a(-3));
/* 182 */               b.this.a();
/*     */             }
/* 184 */             m.b("SplashAdLoadManager", "网络请求的广告解析失败");
/*     */           }
/*     */         } else {
/* 187 */           if (!paramBoolean2) {
/* 188 */             paramSplashAdListener.onError(-3, com.bytedance.sdk.openadsdk.core.g.a(-3));
/* 189 */             b.this.a();
/*     */           }
/* 191 */           m.b("SplashAdLoadManager", "网络请求的广告解析失败");
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void c()
/*     */   {
/* 201 */     final TTAdNative.SplashAdListener localSplashAdListener = this.c == null ? null : (TTAdNative.SplashAdListener)this.c.get();
/* 202 */     if (localSplashAdListener == null) {
/* 203 */       return;
/*     */     }
/*     */     
/* 206 */     a locala = a.a(this.e);
/* 207 */     if (!locala.a()) {
/* 208 */       m.b("SplashAdLoadManager", "缓存中没有开屏广告");
/* 209 */       a(this.b, localSplashAdListener, false, false);
/* 210 */       return;
/*     */     }
/*     */     
/*     */ 
/* 214 */     if (locala.b()) {
/* 215 */       locala.c();
/* 216 */       m.b("SplashAdLoadManager", "缓存过期");
/* 217 */       a(this.b, localSplashAdListener, false, false);
/* 218 */       return;
/*     */     }
/*     */     
/* 221 */     locala.a(new a.a()
/*     */     {
/*     */       public void a(@NonNull i paramAnonymousi)
/*     */       {
/* 225 */         if ((paramAnonymousi.a() != null) && (paramAnonymousi.a().v()) && (paramAnonymousi.b() != null) && (paramAnonymousi.b().length != 0)) {
/* 226 */           int i = ((com.bytedance.sdk.openadsdk.core.d.g)paramAnonymousi.a().f().get(0)).b();
/* 227 */           final Drawable localDrawable = com.bytedance.sdk.openadsdk.g.h.a(paramAnonymousi.b(), i);
/* 228 */           if (localDrawable != null) {
/* 229 */             paramAnonymousi.a().b(true);
/* 230 */             final d locald = new d(b.b(b.this), paramAnonymousi.a());
/* 231 */             n.c()
/* 232 */               .a(paramAnonymousi.a().l(), paramAnonymousi.a().o(), new a()
/*     */               {
/*     */                 public void a(boolean paramAnonymous2Boolean) {
/* 235 */                   if ((paramAnonymous2Boolean) || (!b.d(b.this))) {
/* 236 */                     b.a(b.this, true);
/* 237 */                     locald.a(localDrawable);
/* 238 */                     b.2.this.a.onSplashAdLoad(locald);
/* 239 */                     b.this.a();
/* 240 */                     m.b("SplashAdLoadManager", "缓存广告获取成功");
/*     */                   } else {
/* 242 */                     m.b("SplashAdLoadManager", "缓存广告不在投放期");
/* 243 */                     b.a(b.this, b.e(b.this), b.2.this.a, false, false);
/*     */                   }
/*     */                 }
/*     */               });
/*     */           } else {
/* 248 */             m.b("SplashAdLoadManager", "缓存广告图片素材解析出错");
/* 249 */             b.a(b.this, b.e(b.this), localSplashAdListener, false, false);
/*     */           }
/*     */         } else {
/* 252 */           m.b("SplashAdLoadManager", "缓存广告素材解析出错");
/* 253 */           b.a(b.this, b.e(b.this), localSplashAdListener, false, false);
/*     */         }
/*     */       }
/*     */       
/*     */       public void a()
/*     */       {
/* 259 */         m.b("SplashAdLoadManager", "缓存广告对象解析出错");
/* 260 */         b.a(b.this, b.e(b.this), localSplashAdListener, false, false);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void a()
/*     */   {
/* 269 */     a(this.b, null, true, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void b()
/*     */   {
/* 276 */     TTAdNative.SplashAdListener localSplashAdListener = (TTAdNative.SplashAdListener)this.c.get();
/* 277 */     if (localSplashAdListener == null) {
/* 278 */       return;
/*     */     }
/* 280 */     localSplashAdListener.onTimeout();
/*     */   }
/*     */   
/*     */   public void a(Message paramMessage)
/*     */   {
/* 285 */     if (paramMessage.what == 1) {
/* 286 */       if (!this.g)
/*     */       {
/* 288 */         this.g = true;
/* 289 */         c();
/* 290 */         m.b("SplashAdLoadManager", "尝试从缓存中取");
/*     */       }
/*     */       else {
/* 293 */         a();
/* 294 */         m.b("SplashAdLoadManager", "开始预加载");
/*     */       }
/* 296 */       this.f.removeCallbacksAndMessages(null);
/*     */     }
/*     */     
/* 299 */     if ((paramMessage.what == 2) && 
/* 300 */       (!this.g)) {
/* 301 */       this.g = true;
/* 302 */       b();
/* 303 */       this.f.removeCallbacksAndMessages(null);
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract interface a
/*     */   {
/*     */     public abstract void a(boolean paramBoolean);
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\f\b.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */