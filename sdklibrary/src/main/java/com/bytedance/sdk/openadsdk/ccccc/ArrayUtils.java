/*    */ package com.bytedance.sdk.openadsdk.ccccc;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class ArrayUtils
/*    */ {
/* 20 */   static final boolean[] a = new boolean[0];
/* 21 */   static final int[] b = new int[0];
/* 22 */   static final long[] c = new long[0];
/* 23 */   static final Object[] d = new Object[0];
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static int a(long[] paramArrayOfLong, int paramInt, long paramLong)
/*    */   {
/* 46 */     int i = 0;
/* 47 */     int j = paramInt - 1;
/*    */     
/* 49 */     while (i <= j) {
/* 50 */       int k = i + j >>> 1;
/* 51 */       long l = paramArrayOfLong[k];
/*    */       
/* 53 */       if (l < paramLong) {
/* 54 */         i = k + 1;
/* 55 */       } else if (l > paramLong) {
/* 56 */         j = k - 1;
/*    */       } else {
/* 58 */         return k;
/*    */       }
/*    */     }
/* 61 */     return i ^ 0xFFFFFFFF;
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\cdsss\cdsss.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */