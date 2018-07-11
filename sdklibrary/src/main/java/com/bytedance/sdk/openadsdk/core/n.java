/*    */ package com.bytedance.sdk.openadsdk.core;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.bytedance.sdk.openadsdk.core.eeee.c;
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
/*    */ public class n
/*    */ {
/*    */   private static volatile com.bytedance.sdk.openadsdk.dddd.b<com.bytedance.sdk.openadsdk.dddd.a> a;
/*    */   private static volatile o<com.bytedance.sdk.openadsdk.dddd.a> b;
/*    */   private static volatile com.bytedance.sdk.openadsdk.ff.a c;
/*    */   private static Context d;
/*    */   private static volatile c e;
/*    */   
/*    */   public static Context a()
/*    */   {
/* 29 */     return d;
/*    */   }
/*    */   
/*    */   public static void a(Context paramContext) {
/* 33 */     d = paramContext.getApplicationContext();
/*    */   }
/*    */   
/*    */   public static com.bytedance.sdk.openadsdk.dddd.b<com.bytedance.sdk.openadsdk.dddd.a> b() {
/* 37 */     if (a == null) {
/* 38 */       synchronized (n.class) {
/* 39 */         if (a == null)
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/* 44 */           a = new com.bytedance.sdk.openadsdk.dddd.b(new com.bytedance.sdk.openadsdk.dddd.e(d), c(), f(), b(d));
/*    */         }
/*    */       }
/*    */     }
/* 48 */     return a;
/*    */   }
/*    */   
/*    */   public static o<com.bytedance.sdk.openadsdk.dddd.a> c() {
/* 52 */     if (b == null) {
/* 53 */       synchronized (n.class) {
/* 54 */         if (b == null) {
/* 55 */           b = new p(d);
/*    */         }
/*    */       }
/*    */     }
/* 59 */     return b;
/*    */   }
/*    */   
/*    */   public static com.bytedance.sdk.openadsdk.ff.a d() {
/* 63 */     if (c == null) {
/* 64 */       synchronized (com.bytedance.sdk.openadsdk.ff.a.class) {
/* 65 */         if (c == null) {
/* 66 */           c = new com.bytedance.sdk.openadsdk.ff.b(d, new com.bytedance.sdk.openadsdk.ff.e(d));
/*    */         }
/*    */       }
/*    */     }
/* 70 */     return c;
/*    */   }
/*    */   
/*    */   private static ffff.b f() {
/* 74 */     return f.b.a();
/*    */   }
/*    */   
/*    */   private static ffff.a b(Context paramContext) {
/* 78 */     new ffff.a()
/*    */     {
/*    */       public boolean a() {
/* 81 */         return com.bytedance.sdk.openadsdk.ggg.n.a(this.a);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public static c e() {
/* 87 */     if (e == null) {
/* 88 */       synchronized (c.class) {
/* 89 */         if (e == null) {
/* 90 */           e = new c();
/*    */         }
/*    */       }
/*    */     }
/* 94 */     return e;
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\mN.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */