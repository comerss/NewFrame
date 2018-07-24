/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core.d;
/*     */ 
/*     */ import android.support.annotation.NonNull;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */ {
/*     */   private int[] a;
/*     */   private int[] b;
/*     */   private int[] c;
/*     */   private int[] d;
/*     */   private int e;
/*     */   private int f;
/*     */   private int g;
/*     */   private int h;
/*     */   private long i;
/*     */   private long j;
/*     */   
/*     */   private c(@NonNull a parama)
/*     */   {
/*  27 */     this.a = a.a(parama);
/*  28 */     this.b = a.b(parama);
/*  29 */     this.d = a.c(parama);
/*  30 */     this.c = a.d(parama);
/*  31 */     this.e = a.e(parama);
/*  32 */     this.f = a.f(parama);
/*  33 */     this.g = a.g(parama);
/*  34 */     this.h = a.h(parama);
/*  35 */     this.i = a.i(parama);
/*  36 */     this.j = a.j(parama);
/*     */   }
/*     */   
/*     */   public JSONObject a()
/*     */   {
/*  41 */     JSONObject localJSONObject = new JSONObject();
/*     */     try {
/*  43 */       if ((this.a != null) && (this.a.length == 2))
/*     */       {
/*  45 */         localJSONObject.putOpt("ad_x", Integer.valueOf(this.a[0])).putOpt("ad_y", Integer.valueOf(this.a[1]));
/*     */       }
/*  47 */       if ((this.b != null) && (this.b.length == 2))
/*     */       {
/*  49 */         localJSONObject.putOpt("width", Integer.valueOf(this.b[0])).putOpt("height", Integer.valueOf(this.b[1]));
/*     */       }
/*  51 */       if ((this.c != null) && (this.c.length == 2))
/*     */       {
/*  53 */         localJSONObject.putOpt("button_x", Integer.valueOf(this.c[0])).putOpt("button_y", Integer.valueOf(this.c[1]));
/*     */       }
/*  55 */       if ((this.d != null) && (this.d.length == 2))
/*     */       {
/*  57 */         localJSONObject.putOpt("button_width", Integer.valueOf(this.d[0])).putOpt("button_height", Integer.valueOf(this.d[1]));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  64 */       localJSONObject.putOpt("down_x", Integer.valueOf(this.e)).putOpt("down_y", Integer.valueOf(this.f)).putOpt("up_x", Integer.valueOf(this.g)).putOpt("up_y", Integer.valueOf(this.h)).putOpt("down_time", Long.valueOf(this.i)).putOpt("up_time", Long.valueOf(this.j));
/*     */     }
/*     */     catch (Exception localException) {}
/*  67 */     return localJSONObject;
/*     */   }
/*     */   
/*     */   public static class a
/*     */   {
/*     */     private long a;
/*     */     private long b;
/*     */     private int c;
/*     */     private int d;
/*     */     private int e;
/*     */     private int f;
/*     */     private int[] g;
/*     */     private int[] h;
/*     */     private int[] i;
/*     */     private int[] j;
/*     */     
/*     */     public a a(long paramLong)
/*     */     {
/*  85 */       this.a = paramLong;
/*  86 */       return this;
/*     */     }
/*     */     
/*     */     public a b(long paramLong) {
/*  90 */       this.b = paramLong;
/*  91 */       return this;
/*     */     }
/*     */     
/*     */     public a a(int paramInt) {
/*  95 */       this.c = paramInt;
/*  96 */       return this;
/*     */     }
/*     */     
/*     */     public a b(int paramInt) {
/* 100 */       this.d = paramInt;
/* 101 */       return this;
/*     */     }
/*     */     
/*     */     public a c(int paramInt) {
/* 105 */       this.e = paramInt;
/* 106 */       return this;
/*     */     }
/*     */     
/*     */     public a d(int paramInt) {
/* 110 */       this.f = paramInt;
/* 111 */       return this;
/*     */     }
/*     */     
/*     */     public a a(int[] paramArrayOfInt) {
/* 115 */       this.g = paramArrayOfInt;
/* 116 */       return this;
/*     */     }
/*     */     
/*     */     public a b(int[] paramArrayOfInt) {
/* 120 */       this.h = paramArrayOfInt;
/* 121 */       return this;
/*     */     }
/*     */     
/*     */     public a c(int[] paramArrayOfInt) {
/* 125 */       this.i = paramArrayOfInt;
/* 126 */       return this;
/*     */     }
/*     */     
/*     */     public a d(int[] paramArrayOfInt) {
/* 130 */       this.j = paramArrayOfInt;
/* 131 */       return this;
/*     */     }
/*     */     
/*     */     public c a() {
/* 135 */       return new c(this, null);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\d\c.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */