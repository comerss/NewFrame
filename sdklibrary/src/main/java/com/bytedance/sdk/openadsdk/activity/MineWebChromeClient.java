/*    */ package com.bytedance.sdk.openadsdk.activity;
/*    */ 
/*    */ import android.net.Uri;
/*    */ import android.support.annotation.NonNull;
/*    */ import android.webkit.ConsoleMessage;
/*    */ import android.webkit.WebChromeClient;
/*    */ import com.bytedance.sdk.openadsdk.core.v;
/*    */ import com.bytedance.sdk.openadsdk.ggg.StringUtils;
import com.bytedance.sdk.openadsdk.ggg.j;
/*    */

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MineWebChromeClient
/*    */   extends WebChromeClient
/*    */ {
/* 18 */   private static final String a = WebChromeClient.class.getSimpleName();
/*    */   private v b;
/*    */   
/*    */   public MineWebChromeClient(v paramv) {
/* 22 */     this.b = paramv;
/*    */   }
/*    */   
/*    */   public void onConsoleMessage(String paramString1, int paramInt, String paramString2)
/*    */   {
/* 27 */     if (!StringUtils.isEmpty(paramString1)) {
/* 28 */       a(paramString1);
/*    */     }
/* 30 */     super.onConsoleMessage(paramString1, paramInt, paramString2);
/*    */   }
/*    */   
/*    */   public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
/*    */   {
/* 35 */     if ((paramConsoleMessage != null) && (!StringUtils.isEmpty(paramConsoleMessage.message()))) {
/* 36 */       boolean bool = a(paramConsoleMessage.message());
/* 37 */       if (bool) {
/* 38 */         return true;
/*    */       }
/*    */     }
/* 41 */     return super.onConsoleMessage(paramConsoleMessage);
/*    */   }
/*    */   
/*    */   private boolean a(@NonNull String paramString) {
/*    */     try {
/* 46 */       Uri localUri = Uri.parse(paramString);
/* 47 */       String str = localUri.getScheme().toLowerCase();
/* 48 */       if ("bytedance".equals(str)) {
/* 49 */         j.a(localUri, this.b);
/* 50 */         return true;
/*    */       }
/*    */     }
/*    */     catch (Exception localException) {}
/* 54 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\activity\SslHepler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */