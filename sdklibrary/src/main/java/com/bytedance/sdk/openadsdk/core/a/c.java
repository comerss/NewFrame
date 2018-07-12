/*    */ package com.bytedance.sdk.openadsdk.core.a;
/*    */ 
/*    */

import android.content.Context;

import com.bytedance.sdk.openadsdk.ccccc.x;
import com.bytedance.sdk.openadsdk.core.nibuguan.h;

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
/*    */ public class c
/*    */   implements x.b
/*    */ {
/*    */   private Context c;
/*    */   protected h a;
/*    */   protected String b;
/*    */   
/*    */   public c(Context paramContext, h paramh, String paramString)
/*    */   {
/* 23 */     this.c = paramContext.getApplicationContext();
/* 24 */     this.a = paramh;
/* 25 */     this.b = paramString;
/*    */   }
/*    */   
/*    */   public void a()
/*    */   {
/* 30 */     com.bytedance.sdk.openadsdk.dddd.c.a(this.c, this.a, this.b, "click_start");
/*    */   }
/*    */   
/*    */   public void b()
/*    */   {
/* 35 */     com.bytedance.sdk.openadsdk.dddd.c.b(this.c, this.a, this.b, "click_pause");
/*    */   }
/*    */   
/*    */   public void c()
/*    */   {
/* 40 */     com.bytedance.sdk.openadsdk.dddd.c.c(this.c, this.a, this.b, "click_continue");
/*    */   }
/*    */   
/*    */   public void d()
/*    */   {
/* 45 */     com.bytedance.sdk.openadsdk.dddd.c.h(this.c, this.a, this.b, "click_open");
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\SslHepler\cdsss.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */