/*    */ package com.bytedance.sdk.openadsdk.core;
/*    */ 
/*    */ import android.content.Context;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class d
/*    */   extends e
/*    */ {
/*    */   private static volatile d b;
/*    */   
/*    */   public static d a(Context paramContext)
/*    */   {
/* 15 */     if (b == null) {
/* 16 */       synchronized (d.class) {
/* 17 */         if (b == null) {
/* 18 */           b = new d(paramContext);
/*    */         }
/*    */       }
/*    */     }
/* 22 */     return b;
/*    */   }
/*    */   
/*    */   private d(Context paramContext) {
/* 26 */     super(paramContext);
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\d.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */