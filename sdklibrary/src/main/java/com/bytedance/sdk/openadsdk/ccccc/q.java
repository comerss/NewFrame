/*     */ package com.bytedance.sdk.openadsdk.ccccc;
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
/*     */   private long[] mLongs;
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
/*     */   private long[] mB;
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
/*     */   private int mInt;
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
/*  64 */       this.mLongs = ArrayUtils.c;
/*  65 */       this.mB = ArrayUtils.c;
/*     */     } else {
    if(mLongs !=null){
        paramInt = (int) mLongs[paramInt];
        /*  68 */       this.mLongs = new long[paramInt];
        /*  69 */       this.mB = new long[paramInt];
    }
/*  67 */
/*     */     }
/*  71 */     this.mInt = 0;
/*     */   }
/*     */   
/*     */   public q a()
/*     */   {
/*  76 */     q localq = null;
/*     */     try {
/*  78 */       localq = (q)super.clone();
/*  79 */       localq.mLongs = ((long[])this.mLongs.clone());
/*  80 */       localq.mB = ((long[])this.mB.clone());
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
/* 100 */     int i = ArrayUtils.a(this.mLongs, this.mInt, paramLong1);
/*     */     
/* 102 */     if (i < 0) {
/* 103 */       return paramLong2;
/*     */     }
/* 105 */     return this.mB[i];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void b(long paramLong)
/*     */   {
/* 113 */     int i = ArrayUtils.a(this.mLongs, this.mInt, paramLong);
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
/* 124 */     System.arraycopy(this.mLongs, paramInt + 1, this.mLongs, paramInt, this.mInt - (paramInt + 1));
/* 125 */     System.arraycopy(this.mB, paramInt + 1, this.mB, paramInt, this.mInt - (paramInt + 1));
/* 126 */     this.mInt -= 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void b(long paramLong1, long paramLong2)
/*     */   {
/* 135 */     int i = ArrayUtils.a(this.mLongs, this.mInt, paramLong1);
/*     */     
/* 137 */     if (i >= 0) {
/* 138 */       this.mB[i] = paramLong2;
/*     */     } else {
/* 140 */       i ^= 0xFFFFFFFF;
/*     */       
/* 142 */       if (this.mInt >= this.mLongs.length) {
/* 143 */         d(this.mInt + 1);
/*     */       }
/*     */       
/* 146 */       if (this.mInt - i != 0) {
/* 147 */         System.arraycopy(this.mLongs, i, this.mLongs, i + 1, this.mInt - i);
/* 148 */         System.arraycopy(this.mB, i, this.mB, i + 1, this.mInt - i);
/*     */       }
/*     */       
/* 151 */       this.mLongs[i] = paramLong1;
/* 152 */       this.mB[i] = paramLong2;
/* 153 */       this.mInt += 1;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int b()
/*     */   {
/* 162 */     return this.mInt;
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
/* 176 */     return this.mLongs[paramInt];
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
/* 191 */     return this.mB[paramInt];
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
/* 247 */     int i = com.bytedance.sdk.openadsdk.ccccc.a.b(paramInt);
/*     */     
/* 249 */     long[] arrayOfLong1 = new long[i];

/* 250 */     long[] arrayOfLong2 = new long[i];
/*     */     
/* 252 */     System.arraycopy(this.mLongs, 0, arrayOfLong1, 0, this.mLongs.length);
/* 253 */     System.arraycopy(this.mB, 0, arrayOfLong2, 0, this.mB.length);
/*     */     
/* 255 */     this.mLongs = arrayOfLong1;
/* 256 */     this.mB = arrayOfLong2;
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
/* 270 */     StringBuilder localStringBuilder = new StringBuilder(this.mInt * 28);
/* 271 */     localStringBuilder.append('{');
/* 272 */     for (int i = 0; i < this.mInt; i++) {
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


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\cdsss\StringUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */