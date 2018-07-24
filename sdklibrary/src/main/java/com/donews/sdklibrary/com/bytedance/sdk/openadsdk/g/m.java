/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.g;
/*     */ 
/*     */ import android.util.Log;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class m
/*     */ {
/*  15 */   public static boolean a = false;
/*     */   
/*  17 */   static int b = 4;
/*     */   
/*     */   public static void a(int paramInt) {
/*  20 */     b = paramInt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean a()
/*     */   {
/*  28 */     return b <= 3;
/*     */   }
/*     */   
/*     */   public static void b() {
/*  32 */     a = true;
/*  33 */     a(3);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void a(String paramString1, String paramString2)
/*     */   {
/*  41 */     if (!a) {
/*  42 */       return;
/*     */     }
/*  44 */     if (paramString2 == null) {
/*  45 */       return;
/*     */     }
/*  47 */     if (b <= 2) {
/*  48 */       Log.v(paramString1, paramString2);
/*     */     }
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
/*     */   public static void a(String paramString)
/*     */   {
/*  63 */     if (!a) {
/*  64 */       return;
/*     */     }
/*  66 */     b("Logger", paramString);
/*     */   }
/*     */   
/*     */   public static void b(String paramString1, String paramString2) {
/*  70 */     if (!a) {
/*  71 */       return;
/*     */     }
/*  73 */     if (paramString2 == null) {
/*  74 */       return;
/*     */     }
/*  76 */     if (b <= 3) {
/*  77 */       Log.d(paramString1, paramString2);
/*     */     }
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
/*     */   public static void c(String paramString1, String paramString2)
/*     */   {
/*  99 */     if (!a) {
/* 100 */       return;
/*     */     }
/* 102 */     if (paramString2 == null) {
/* 103 */       return;
/*     */     }
/* 105 */     if (b <= 4) {
/* 106 */       Log.i(paramString1, paramString2);
/*     */     }
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
/*     */   public static void d(String paramString1, String paramString2)
/*     */   {
/* 128 */     if (!a) {
/* 129 */       return;
/*     */     }
/* 131 */     if (paramString2 == null) {
/* 132 */       return;
/*     */     }
/* 134 */     if (b <= 5) {
/* 135 */       Log.w(paramString1, paramString2);
/*     */     }
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
/*     */   public static void e(String paramString1, String paramString2)
/*     */   {
/* 157 */     if (!a) {
/* 158 */       return;
/*     */     }
/* 160 */     if (paramString2 == null) {
/* 161 */       return;
/*     */     }
/* 163 */     if (b <= 6)
/* 164 */       Log.e(paramString1, paramString2);
/*     */   }
/*     */   
/*     */   public static void a(String paramString1, String paramString2, Throwable paramThrowable) {
/* 168 */     if (!a) {
/* 169 */       return;
/*     */     }
/* 171 */     if ((paramString2 == null) && (paramThrowable == null)) {
/* 172 */       return;
/*     */     }
/* 174 */     if (b <= 6) {
/* 175 */       Log.e(paramString1, paramString2, paramThrowable);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\g\m.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */