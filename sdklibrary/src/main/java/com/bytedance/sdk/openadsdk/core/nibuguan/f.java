/*    */ package com.bytedance.sdk.openadsdk.core.nibuguan;
/*    */ 
/*    */ import com.bytedance.sdk.openadsdk.ggg.StringUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class f
/*    */ {
/*    */   private String a;
/*    */   private String b;
/*    */   private boolean c;
/*    */   
/*    */   public String a()
/*    */   {
/* 16 */     return this.a;
/*    */   }
/*    */   
/*    */   public void a(String paramString) {
/* 20 */     this.a = paramString;
/*    */   }
/*    */   
/*    */   public String b() {
/* 24 */     return this.b;
/*    */   }
/*    */   
/*    */   public void b(String paramString) {
/* 28 */     this.b = paramString;
/*    */   }
/*    */   
/*    */   public boolean c() {
/* 32 */     return this.c;
/*    */   }
/*    */   
/*    */   public void a(boolean paramBoolean) {
/* 36 */     this.c = paramBoolean;
/*    */   }
/*    */   
/*    */   public boolean d() {
/* 40 */     return (!StringUtils.isEmpty(this.a)) && (!StringUtils.isEmpty(this.b));
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 45 */     return "mId: " + this.a + ", mName: " + this.b + ", is_selected: " + this.c;
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\LocationUtils\doErrorHelper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */