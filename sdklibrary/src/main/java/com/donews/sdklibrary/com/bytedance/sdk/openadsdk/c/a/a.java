/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.c.a;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.SystemClock;
/*     */ import android.support.annotation.NonNull;
/*     */ import com.bytedance.sdk.openadsdk.TTGlobalAppDownloadListener;
/*     */ import com.bytedance.sdk.openadsdk.c.g;
/*     */ import com.bytedance.sdk.openadsdk.core.d.e;
/*     */ import com.bytedance.sdk.openadsdk.d.c;
/*     */ import com.bytedance.sdk.openadsdk.g.r;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
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
/*     */ public class a
/*     */   implements b
/*     */ {
/*     */   private Context a;
/*     */   
/*     */   public a(@NonNull Context paramContext)
/*     */   {
/*  31 */     this.a = paramContext.getApplicationContext();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void a(long paramLong, int paramInt, String paramString)
/*     */   {
/*  41 */     e locale = g.a(this.a).a(paramLong);
/*  42 */     if ((locale == null) || (!locale.c())) {
/*  43 */       return;
/*     */     }
/*     */     
/*  46 */     switch (paramInt)
/*     */     {
/*     */ 
/*     */     case 1: 
/*  50 */       this.b.submit(new a(paramString, paramLong, locale));
/*  51 */       c.d(this.a, locale.a(), locale.b(), "download_finish");
/*  52 */       break;
/*     */     
/*     */     case 3: 
/*     */       break;
/*     */     
/*     */     case 2: 
/*  58 */       c.h(this.a, locale.a(), locale.b(), "click_open");
/*     */       
/*  60 */       g.a(this.a).b(paramLong);
/*  61 */       break;
/*     */     }
/*     */     
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void a(String paramString, long paramLong, e parame)
/*     */   {
/*  94 */     g.a(this.a).b(paramLong);
/*  95 */     c.e(this.a, parame.a(), parame.b(), "install_finish");
/*     */     
/*  97 */     TTGlobalAppDownloadListener localTTGlobalAppDownloadListener = com.bytedance.sdk.openadsdk.core.h.a().l();
/*  98 */     if (localTTGlobalAppDownloadListener != null) {
/*  99 */       com.bytedance.sdk.openadsdk.core.d.b localb = parame.a().m();
/* 100 */       String str = localb == null ? null : localb.b();
/* 101 */       localTTGlobalAppDownloadListener.onInstalled(paramString, str, paramLong, 200);
/*     */     }
/*     */   }
/*     */   
/* 105 */   private ExecutorService b = Executors.newCachedThreadPool();
/*     */   
/*     */ 
/*     */   private class a
/*     */     implements Runnable
/*     */   {
/*     */     private final String b;
/*     */     
/*     */     private final long c;
/*     */     private final e d;
/*     */     
/*     */     public a(String paramString, long paramLong, e parame)
/*     */     {
/* 118 */       this.b = paramString;
/* 119 */       this.c = paramLong;
/* 120 */       this.d = parame;
/*     */     }
/*     */     
/*     */     public void run()
/*     */     {
/* 125 */       if ((this.b == null) || (this.c <= 0L) || (this.d == null)) {
/* 126 */         return;
/*     */       }
/* 128 */       int i = 30;
/* 129 */       SystemClock.sleep(10000L);
/* 130 */       while (i > 0) {
/* 131 */         if (r.b(a.a(a.this), this.b)) {
/* 132 */           a.a(a.this, this.b, this.c, this.d);
/* 133 */           break;
/*     */         }
/* 135 */         i--;
/* 136 */         SystemClock.sleep(10000L);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\c\a\a.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */