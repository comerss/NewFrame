/*    */ package com.bytedance.sdk.openadsdk.ggg;
/*    */ 
/*    */ import android.net.Uri;
/*    */
/*    */ import android.webkit.WebView;
/*    */ import com.bytedance.sdk.openadsdk.core.TTAndroidObject;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WebViewHelper
/*    */ {
/*    */   public static void a(Uri paramUri, TTAndroidObject paramv)
/*    */   {
/* 17 */     if ((paramv != null) && (paramv.a(paramUri))) {
/*    */       try {
/* 19 */         paramv.b(paramUri);
/*    */       } catch (Exception localException) {
/* 21 */         LogUtils.d("WebView", "TTAndroidObj handleUri exception: " + localException);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public static String a(WebView paramWebView, int paramInt) {
/* 27 */     if (paramWebView == null) {
/* 28 */       return "";
/*    */     }
/* 30 */     String str = paramWebView.getSettings().getUserAgentString();
/* 31 */     if (StringUtils.isEmpty(str)) {
/* 32 */       return "";
/*    */     }
/* 34 */     StringBuilder localStringBuilder = new StringBuilder(str);
/* 35 */     localStringBuilder.append(" NewsArticle").append(" NewsArticle_u_s/").append(paramInt);
/* 36 */     return localStringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\ApiException\mTTFeedAd.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */