/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.c;
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
/*     */ class q
/*     */   implements Cloneable
/*     */ {
/*     */   private long[] a;
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
/*     */   private long[] b;
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
/*     */   private int c;
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
/*     */   public q()
/*     */   {
/*  52 */     this(10);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public q(int paramInt)
/*     */   {
/*  63 */     if (paramInt == 0) {
/*  64 */       this.a = c.c;
/*  65 */       this.b = c.c;
/*     */     } else {
/*  67 */       paramInt = a.b(paramInt);
/*  68 */       this.a = new long[paramInt];
/*  69 */       this.b = new long[paramInt];
/*     */     }
/*  71 */     this.c = 0;
/*     */   }
/*     */   
/*     */   public q a()
/*     */   {
/*  76 */     q localq = null;
/*     */     try {
/*  78 */       localq = (q)super.clone();
/*  79 */       localq.a = ((long[])this.a.clone());
/*  80 */       localq.b = ((long[])this.b.clone());
/*     */     }
/*     */     catch (CloneNotSupportedException localCloneNotSupportedException) {}
/*     */     
/*  84 */     return localq;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public long a(long paramLong)
/*     */   {
/*  92 */     return a(paramLong, 0L);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public long a(long paramLong1, long paramLong2)
/*     */   {
/* 100 */     int i = c.a(this.a, this.c, paramLong1);
/*     */     
/* 102 */     if (i < 0) {
/* 103 */       return paramLong2;
/*     */     }
/* 105 */     return this.b[i];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void b(long paramLong)
/*     */   {
/* 113 */     int i = c.a(this.a, this.c, paramLong);
/*     */     
/* 115 */     if (i >= 0) {
/* 116 */       a(i);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void a(int paramInt)
/*     */   {
/* 124 */     System.arraycopy(this.a, paramInt + 1, this.a, paramInt, this.c - (paramInt + 1));
/* 125 */     System.arraycopy(this.b, paramInt + 1, this.b, paramInt, this.c - (paramInt + 1));
/* 126 */     this.c -= 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void b(long paramLong1, long paramLong2)
/*     */   {
/* 135 */     int i = c.a(this.a, this.c, paramLong1);
/*     */     
/* 137 */     if (i >= 0) {
/* 138 */       this.b[i] = paramLong2;
/*     */     } else {
/* 140 */       i ^= 0xFFFFFFFF;
/*     */       
/* 142 */       if (this.c >= this.a.length) {
/* 143 */         d(this.c + 1);
/*     */       }
/*     */       
/* 146 */       if (this.c - i != 0) {
/* 147 */         System.arraycopy(this.a, i, this.a, i + 1, this.c - i);
/* 148 */         System.arraycopy(this.b, i, this.b, i + 1, this.c - i);
/*     */       }
/*     */       
/* 151 */       this.a[i] = paramLong1;
/* 152 */       this.b[i] = paramLong2;
/* 153 */       this.c += 1;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int b()
/*     */   {
/* 162 */     return this.c;
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
/*     */   public long b(int paramInt)
/*     */   {
/* 176 */     return this.a[paramInt];
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
/*     */   public long c(int paramInt)
/*     */   {
/* 191 */     return this.b[paramInt];
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
/*     */   private void d(int paramInt)
/*     */   {
/* 247 */     int i = a.b(paramInt);
/*     */     
/* 249 */     long[] arrayOfLong1 = new long[i];
/* 250 */     long[] arrayOfLong2 = new long[i];
/*     */     
/* 252 */     System.arraycopy(this.a, 0, arrayOfLong1, 0, this.a.length);
/* 253 */     System.arraycopy(this.b, 0, arrayOfLong2, 0, this.b.length);
/*     */     
/* 255 */     this.a = arrayOfLong1;
/* 256 */     this.b = arrayOfLong2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/* 266 */     if (b() <= 0) {
/* 267 */       return "{}";
/*     */     }
/*     */     
/* 270 */     StringBuilder localStringBuilder = new StringBuilder(this.c * 28);
/* 271 */     localStringBuilder.append('{');
/* 272 */     for (int i = 0; i < this.c; i++) {
/* 273 */       if (i > 0) {
/* 274 */         localStringBuilder.append(", ");
/*     */       }
/* 276 */       long l1 = b(i);
/* 277 */       localStringBuilder.append(l1);
/* 278 */       localStringBuilder.append('=');
/* 279 */       long l2 = c(i);
/* 280 */       localStringBuilder.append(l2);
/*     */     }
/* 282 */     localStringBuilder.append('}');
/* 283 */     return localStringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\c\q.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */