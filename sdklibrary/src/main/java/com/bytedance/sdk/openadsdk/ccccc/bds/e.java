/*     */ package com.bytedance.sdk.openadsdk.ccccc.bds;
/*     */ 
/*     */ import android.os.Handler;
/*     */ import android.os.Looper;
/*     */ import android.support.annotation.NonNull;
/*     */ import android.util.Log;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
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
/*     */ public abstract class e
/*     */ {
/*  24 */   private static final String a = e.class.getSimpleName();
/*  25 */   private final Set<String> b = new HashSet(1);
/*  26 */   private Looper c = Looper.getMainLooper();
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
/*     */   public abstract void a();
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
/*     */   public abstract void a(String paramString);
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
/*     */   public synchronized boolean b(String paramString)
/*     */   {
/*  83 */     Log.d(a, "Permission not found: " + paramString);
/*  84 */     return true;
/*     */   }
/*     */   
/*     */   protected final synchronized boolean a(@NonNull String paramString, int paramInt)
/*     */   {
/*  89 */     if (paramInt == 0) {
/*  90 */       return a(paramString, com.bytedance.sdk.openadsdk.ccccc.bds.c.a);
/*     */     }
/*  92 */     return a(paramString, com.bytedance.sdk.openadsdk.ccccc.bds.c.b);
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
/*     */   protected final synchronized boolean a(@NonNull final String paramString, c paramc)
/*     */   {
/* 110 */     this.b.remove(paramString);
/* 111 */     if (paramc == com.bytedance.sdk.openadsdk.ccccc.bds.c.a) {
/* 112 */       if (this.b.isEmpty()) {
/* 113 */         new Handler(this.c).post(new Runnable()
/*     */         {
/*     */           public void run() {
/* 116 */             e.this.a();
/*     */           }
/* 118 */         });
/* 119 */         return true;
/*     */       }
/* 121 */     } else { if (paramc == com.bytedance.sdk.openadsdk.ccccc.bds.c.b) {
/* 122 */         new Handler(this.c).post(new Runnable()
/*     */         {
/*     */           public void run() {
/* 125 */             e.this.a(paramString);
/*     */           }
/* 127 */         });
/* 128 */         return true; }
/* 129 */       if (paramc == com.bytedance.sdk.openadsdk.ccccc.bds.c.c)
/* 130 */         if (b(paramString)) {
/* 131 */           if (this.b.isEmpty()) {
/* 132 */             new Handler(this.c).post(new Runnable()
/*     */             {
/*     */               public void run() {
/* 135 */                 e.this.a();
/*     */               }
/* 137 */             });
/* 138 */             return true;
/*     */           }
/*     */         } else {
/* 141 */           new Handler(this.c).post(new Runnable()
/*     */           {
/*     */             public void run() {
/* 144 */               e.this.a(paramString);
/*     */             }
/* 146 */           });
/* 147 */           return true;
/*     */         }
/*     */     }
/* 150 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected final synchronized void a(@NonNull String[] paramArrayOfString)
/*     */   {
/* 162 */     Collections.addAll(this.b, paramArrayOfString);
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\cdsss\result\TTBannerAdImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */