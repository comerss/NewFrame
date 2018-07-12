/*    */ package com.bytedance.sdk.openadsdk.core.nibuguan;
/*    */ 
/*    */ import com.bytedance.sdk.openadsdk.TTImage;
/*    */ import com.bytedance.sdk.openadsdk.ggg.q;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class g
/*    */ {
/*    */   private String a;
/*    */   private int b;
/*    */   private int c;
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
/*    */   public int b() {
/* 24 */     return this.b;
/*    */   }
/*    */   
/*    */   public void a(int paramInt) {
/* 28 */     this.b = paramInt;
/*    */   }
/*    */   
/*    */   public int c() {
/* 32 */     return this.c;
/*    */   }
/*    */   
/*    */   public void b(int paramInt) {
/* 36 */     this.c = paramInt;
/*    */   }
/*    */   
/*    */   public boolean d() {
/* 40 */     return (!q.a(this.a)) && (this.b > 0) && (this.c > 0);
/*    */   }
/*    */   
/*    */   public static TTImage a(g paramg) {
/* 44 */     if ((paramg == null) || (!paramg.d())) {
/* 45 */       return null;
/*    */     }
/* 47 */     return new TTImage(paramg.c(), paramg.b(), paramg.a());
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\LocationUtils\ApiException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */