/*    */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.c;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class a
/*    */ {
/* 30 */   private static Object[] a = new Object[0];
/*    */   
/* 32 */   private static Object[] b = new Object[73];
/*    */   
/*    */ 
/*    */   public static int a(int paramInt)
/*    */   {
/* 37 */     for (int i = 4; i < 32; i++) {
/* 38 */       if (paramInt <= (1 << i) - 12)
/* 39 */         return (1 << i) - 12;
/*    */     }
/* 41 */     return paramInt;
/*    */   }
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int b(int paramInt)
/*    */   {
/* 69 */     return a(paramInt * 8) / 8;
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\c\a.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */