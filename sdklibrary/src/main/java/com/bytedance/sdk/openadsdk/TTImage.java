/*    */ package com.bytedance.sdk.openadsdk;
/*    */ 
/*    */ 
/*    */ public class TTImage
/*    */ {
/*    */   private int a;
/*    */   
/*    */   private int b;
/*    */   private String c;
/*    */   
/*    */   public TTImage(int paramInt1, int paramInt2, String paramString)
/*    */   {
/* 13 */     this.a = paramInt1;
/* 14 */     this.b = paramInt2;
/* 15 */     this.c = paramString;
/*    */   }
/*    */   
/*    */   public int getHeight() {
/* 19 */     return this.a;
/*    */   }
/*    */   
/*    */   public int getWidth() {
/* 23 */     return this.b;
/*    */   }
/*    */   
/*    */   public String getImageUrl() {
/* 27 */     return this.c;
/*    */   }
/*    */   
/*    */   public boolean isValid() {
/* 31 */     return (this.a > 0) && (this.b > 0) && (this.c != null) && (this.c.length() > 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\TTImage.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */