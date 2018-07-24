/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core.b;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.graphics.Bitmap;
/*     */ import android.support.annotation.NonNull;
/*     */ import android.support.annotation.Nullable;
/*     */ import com.androidquery.callback.AQuery2;
/*     */ import com.androidquery.callback.AjaxCallback;
/*     */ import com.androidquery.callback.AjaxStatus;
/*     */ import com.bytedance.sdk.openadsdk.AdSlot;
/*     */ import com.bytedance.sdk.openadsdk.TTAdNative.BannerAdListener;
/*     */ import com.bytedance.sdk.openadsdk.core.d.h;
/*     */ import com.bytedance.sdk.openadsdk.core.n;
/*     */ import com.bytedance.sdk.openadsdk.core.o;
/*     */ import com.bytedance.sdk.openadsdk.core.o.a;
/*     */ import com.bytedance.sdk.openadsdk.g.m;
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
/*     */ public class b
/*     */ {
/*  31 */   public static final String a = b.class.getSimpleName();
/*     */   private static volatile b b;
/*     */   private WeakReference<Context> c;
/*     */   private o d;
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
/*     */   public static b a(@NonNull Context paramContext) {
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
/*     */   void a(final a parama) {
/*  61 */     this.d.a(this.e, 1, new o.a()
/*     */     {
/*     */       public void a(int paramAnonymousInt, String paramAnonymousString) {
/*  64 */         m.b(b.a, paramAnonymousString + "  " + paramAnonymousInt);
/*  65 */         if (parama != null) {
/*  66 */           parama.a();
/*     */         }
/*     */       }
/*     */       
/*     */       public void a(com.bytedance.sdk.openadsdk.core.d.a paramAnonymousa)
/*     */       {
/*  72 */         if ((paramAnonymousa.b() != null) && (!paramAnonymousa.b().isEmpty())) {
/*  73 */           h localh = (h)paramAnonymousa.b().get(0);
/*  74 */           if (localh.v()) {
/*  75 */             b.a(b.this, localh, parama);
/*     */           } else {
/*  77 */             m.b(b.a, "Banner广告解析失败/广告为空");
/*  78 */             if (parama != null) {
/*  79 */               parama.a();
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public void a(@NonNull AdSlot paramAdSlot, @NonNull final TTAdNative.BannerAdListener paramBannerAdListener) {
/*  88 */     this.e = paramAdSlot;
/*  89 */     this.d.a(paramAdSlot, 1, new o.a()
/*     */     {
/*     */       public void a(int paramAnonymousInt, String paramAnonymousString) {
/*  92 */         paramBannerAdListener.onError(paramAnonymousInt, paramAnonymousString);
/*  93 */         m.b(b.a, paramAnonymousString + " " + paramAnonymousInt);
/*     */       }
/*     */       
/*     */       public void a(com.bytedance.sdk.openadsdk.core.d.a paramAnonymousa)
/*     */       {
/*  98 */         if ((paramAnonymousa.b() != null) && (!paramAnonymousa.b().isEmpty())) {
/*  99 */           h localh = (h)paramAnonymousa.b().get(0);
/* 100 */           if (localh.v()) {
/* 101 */             b.a local1 = new a()
/*     */             {
/*     */               public void a(@NonNull a paramAnonymous2a) {
/* 104 */                 if (b.a(b.this).get() != null) {
/* 105 */                   e locale = new e((Context)b.a(b.this).get(), paramAnonymous2a);
/* 106 */                   b.2.this.a.onBannerAdLoad(locale);
/*     */                 }
/*     */               }
/*     */               
/*     */               public void a()
/*     */               {
/* 112 */                 b.2.this.a.onError(-5, com.bytedance.sdk.openadsdk.core.g.a(-5));
/*     */               }
/*     */               
/* 115 */             };
/* 116 */             b.a(b.this, localh, local1);
/*     */           } else {
/* 118 */             m.b(b.a, "Banner广告解析失败");
/* 119 */             paramBannerAdListener.onError(-4, com.bytedance.sdk.openadsdk.core.g.a(-4));
/*     */           }
/*     */         } else {
/* 122 */           m.b(b.a, "Banner广告解析失败/广告为空");
/* 123 */           paramBannerAdListener.onError(-4, com.bytedance.sdk.openadsdk.core.g.a(-4));
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private void a(@NonNull final h paramh, @Nullable final a parama) {
/* 130 */     String str = ((com.bytedance.sdk.openadsdk.core.d.g)paramh.f().get(0)).a();
/*     */     
/* 132 */     this.f.ajax(str, Bitmap.class, new AjaxCallback()
/*     */     {
/*     */       public void a(String paramAnonymousString, Bitmap paramAnonymousBitmap, AjaxStatus paramAnonymousAjaxStatus) {
/* 135 */         super.callback(paramAnonymousString, paramAnonymousBitmap, paramAnonymousAjaxStatus);
/* 136 */         if ((paramAnonymousAjaxStatus == null) || (paramAnonymousBitmap == null) || (paramAnonymousAjaxStatus.getCode() != 200)) {
/* 137 */           if (parama != null) {
/* 138 */             parama.a();
/*     */           }
/*     */         }
/* 141 */         else if (parama != null) {
/* 142 */           parama.a(new a(paramAnonymousBitmap, paramh));
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static abstract interface a
/*     */   {
/*     */     public abstract void a(@NonNull a parama);
/*     */     
/*     */     public abstract void a();
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\b\b.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */