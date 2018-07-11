/*    */ package com.bytedance.sdk.openadsdk.ccccc;
/*    */ 
/*    */ import android.text.TextUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class y
/*    */ {
/* 10 */   public long a = -1L;
/* 11 */   public int b = -1;
/* 12 */   public long c = -1L;
/* 13 */   public long d = -1L;
/*    */   public String e;
/*    */   
/*    */   public boolean equals(Object paramObject)
/*    */   {
/* 18 */     if ((paramObject != null) && ((paramObject instanceof y))) {
/* 19 */       y localy = (y)paramObject;
/* 20 */       int i = this.a == localy.a ? 1 : 0;
/* 21 */       int j = this.b == localy.b ? 1 : 0;
/* 22 */       int k = this.c == localy.c ? 1 : 0;
/*    */       
/*    */ 
/*    */ 
/* 26 */       int m = ((TextUtils.isEmpty(this.e)) && (TextUtils.isEmpty(localy.e))) || ((!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(localy.e)) && (this.e.equals(localy.e))) ? 1 : 0;
/* 27 */       return (i != 0) && (j != 0) && (k != 0) && (m != 0);
/*    */     }
/* 29 */     return super.equals(paramObject);
/*    */   }
/*    */   
/*    */   public long a() {
/* 33 */     return this.c;
/*    */   }
/*    */   
/*    */   public long b() {
/* 37 */     return this.d;
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\cdsss\y.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */