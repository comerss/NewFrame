/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.c;
/*     */ 
/*     */ import java.io.PrintWriter;
/*     */ import java.io.Writer;
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
/*     */ public class p
/*     */   extends PrintWriter
/*     */ {
/*     */   private final String a;
/*     */   private final int b;
/*  35 */   private StringBuilder c = new StringBuilder();
/*     */   
/*     */ 
/*     */ 
/*     */   private char[] d;
/*     */   
/*     */ 
/*     */   private int e;
/*     */   
/*     */ 
/*  45 */   private boolean f = true;
/*     */   
/*     */   public p(Writer paramWriter, String paramString) {
/*  48 */     this(paramWriter, paramString, -1);
/*     */   }
/*     */   
/*     */   public p(Writer paramWriter, String paramString, int paramInt) {
/*  52 */     super(paramWriter);
/*  53 */     this.a = paramString;
/*  54 */     this.b = paramInt;
/*     */   }
/*     */   
/*     */   public void a() {
/*  58 */     this.c.append(this.a);
/*  59 */     this.d = null;
/*     */   }
/*     */   
/*     */   public void b() {
/*  63 */     this.c.delete(0, this.a.length());
/*  64 */     this.d = null;
/*     */   }
/*     */   
/*     */   public void a(String paramString, Object paramObject) {
/*  68 */     print(paramString + "=" + String.valueOf(paramObject) + " ");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
/*     */   {
/*  77 */     int i = this.c.length();
/*  78 */     int j = paramInt1 + paramInt2;
/*  79 */     int k = paramInt1;
/*  80 */     int m = paramInt1;
/*     */     
/*     */ 
/*  83 */     while (m < j) {
/*  84 */       int n = paramArrayOfChar[(m++)];
/*  85 */       this.e += 1;
/*  86 */       if (n == 10) {
/*  87 */         c();
/*  88 */         super.write(paramArrayOfChar, k, m - k);
/*  89 */         k = m;
/*  90 */         this.f = true;
/*  91 */         this.e = 0;
/*     */       }
/*     */       
/*     */ 
/*  95 */       if ((this.b > 0) && (this.e >= this.b - i)) {
/*  96 */         if (!this.f)
/*     */         {
/*  98 */           super.write(10);
/*  99 */           this.f = true;
/* 100 */           this.e = (m - k);
/*     */         }
/*     */         else {
/* 103 */           c();
/* 104 */           super.write(paramArrayOfChar, k, m - k);
/* 105 */           super.write(10);
/* 106 */           this.f = true;
/* 107 */           k = m;
/* 108 */           this.e = 0;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 113 */     if (k != m) {
/* 114 */       c();
/* 115 */       super.write(paramArrayOfChar, k, m - k);
/*     */     }
/*     */   }
/*     */   
/*     */   private void c() {
/* 120 */     if (this.f) {
/* 121 */       this.f = false;
/* 122 */       if (this.c.length() != 0) {
/* 123 */         if (this.d == null) {
/* 124 */           this.d = this.c.toString().toCharArray();
/*     */         }
/* 126 */         super.write(this.d, 0, this.d.length);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\c\p.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */