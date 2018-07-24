/*    */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.bytedance.sdk.openadsdk.core.e.c;
/*    */ import com.bytedance.sdk.openadsdk.d.f.a;
/*    */ import com.bytedance.sdk.openadsdk.d.f.b;
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
/*    */   private static volatile com.bytedance.sdk.openadsdk.d.b<com.bytedance.sdk.openadsdk.d.a> a;
/*    */   private static volatile o<com.bytedance.sdk.openadsdk.d.a> b;
/*    */   private static volatile com.bytedance.sdk.openadsdk.f.a c;
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
/*    */   public static com.bytedance.sdk.openadsdk.d.b<com.bytedance.sdk.openadsdk.d.a> b() {
/* 37 */     if (a == null) {
/* 38 */       synchronized (n.class) {
/* 39 */         if (a == null)
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/* 44 */           a = new com.bytedance.sdk.openadsdk.d.b(new com.bytedance.sdk.openadsdk.d.e(d), c(), f(), b(d));
/*    */         }
/*    */       }
/*    */     }
/* 48 */     return a;
/*    */   }
/*    */   
/*    */   public static o<com.bytedance.sdk.openadsdk.d.a> c() {
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
/*    */   public static com.bytedance.sdk.openadsdk.f.a d() {
/* 63 */     if (c == null) {
/* 64 */       synchronized (com.bytedance.sdk.openadsdk.f.a.class) {
/* 65 */         if (c == null) {
/* 66 */           c = new com.bytedance.sdk.openadsdk.f.b(d, new com.bytedance.sdk.openadsdk.f.e(d));
/*    */         }
/*    */       }
/*    */     }
/* 70 */     return c;
/*    */   }
/*    */   
/*    */   private static f.b f() {
/* 74 */     return f.b.a();
/*    */   }
/*    */   
/*    */   private static f.a b(Context paramContext) {
/* 78 */     new f.a()
/*    */     {
/*    */       public boolean a() {
/* 81 */         return com.bytedance.sdk.openadsdk.g.n.a(this.a);
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


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\n.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */