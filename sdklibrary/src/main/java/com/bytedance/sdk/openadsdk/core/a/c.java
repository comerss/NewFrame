/*    */ package com.bytedance.sdk.openadsdk.core.a;
/*    */ 
/*    */

import android.content.Context;

import com.bytedance.sdk.openadsdk.ccccc.DownLoadListenerImpl;
import com.bytedance.sdk.openadsdk.core.nibuguan.NativeAdData;
import com.bytedance.sdk.openadsdk.dddd.AdEvent;

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
/*    */   implements DownLoadListenerImpl.b
/*    */ {
/*    */   private Context c;
/*    */   protected NativeAdData a;
/*    */   protected String b;
/*    */   
/*    */   public c(Context paramContext, NativeAdData paramh, String paramString)
/*    */   {
/* 23 */     this.c = paramContext.getApplicationContext();
/* 24 */     this.a = paramh;
/* 25 */     this.b = paramString;
/*    */   }
/*    */   
/*    */   public void a()
/*    */   {
/* 30 */     AdEvent.a(this.c, this.a, this.b, "click_start");
/*    */   }
/*    */   
/*    */   public void b()
/*    */   {
/* 35 */     AdEvent.b(this.c, this.a, this.b, "click_pause");
/*    */   }
/*    */   
/*    */   public void c()
/*    */   {
/* 40 */     AdEvent.c(this.c, this.a, this.b, "click_continue");
/*    */   }
/*    */   
/*    */   public void d()
/*    */   {
/* 45 */     AdEvent.h(this.c, this.a, this.b, "click_open");
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\SslHepler\cdsss.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */