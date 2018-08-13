/*    */ package com.bytedance.sdk.openadsdk.core.nibuguan;
/*    */ 
/*    */ import com.bytedance.sdk.openadsdk.ggg.StringUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class e
/*    */ {
/*    */   private String a;
/*    */   private NativeAdData b;
/*    */   
/*    */   public e(NativeAdData paramh, String paramString)
/*    */   {
/* 14 */     this.b = paramh;
/* 15 */     this.a = paramString;
/*    */   }
/*    */   
/*    */   public NativeAdData a() {
/* 19 */     return this.b;
/*    */   }
/*    */   
/*    */   public String b() {
/* 23 */     return this.a;
/*    */   }
/*    */   
/*    */   public boolean c() {
/* 27 */     return (this.b != null) && (!StringUtils.isEmpty(this.a));
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\LocationUtils\TTBannerAdImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */