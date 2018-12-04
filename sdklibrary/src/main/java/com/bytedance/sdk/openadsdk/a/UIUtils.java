/*    */ package com.bytedance.sdk.openadsdk.a;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.bytedance.sdk.openadsdk.core.h;
/*    */ import com.bytedance.sdk.openadsdk.core.i;
/*    */ import com.bytedance.sdk.openadsdk.core.n;
/*    */ import com.bytedance.sdk.openadsdk.ggg.PhoneUtils;
/*    */ import com.bytedance.sdk.openadsdk.ggg.ToolUtils;
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
/*    */ public class UIUtils
/*    */ {
/*    */   public static String a()
/*    */   {
/* 28 */     return "open_news";
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String getVersionCode()
/*    */   {
/* 36 */     return "34";
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String getVersionName()
/*    */   {
/* 44 */     return "1.9.0";
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String d()
/*    */   {
/* 52 */     return ToolUtils.b(n.a());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String e()
/*    */   {
/* 60 */     return h.a().c();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String f()
/*    */   {
/* 68 */     Context localContext = n.a();
/* 69 */     return PhoneUtils.netState(localContext);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String a(Context paramContext)
/*    */   {
/* 78 */     return i.a(paramContext);
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\SslHepler\SslHepler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */