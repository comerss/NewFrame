/*    */ package com.bytedance.sdk.openadsdk.activity;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.content.Intent;
/*    */ import android.net.Uri;
/*    */ import android.util.Log;
/*    */ import android.webkit.WebChromeClient;
/*    */ import android.webkit.WebResourceRequest;
/*    */ import android.webkit.WebResourceResponse;
/*    */ import android.webkit.WebView;
/*    */ import android.webkit.WebViewClient;
/*    */ import com.bytedance.sdk.openadsdk.core.n;
/*    */ import com.bytedance.sdk.openadsdk.core.v;
/*    */ import com.bytedance.sdk.openadsdk.ggg.LogUtils;
import com.bytedance.sdk.openadsdk.ggg.PhoneUtils;
import com.bytedance.sdk.openadsdk.ggg.j;
/*    */ import com.bytedance.sdk.openadsdk.ggg.l;
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
/*    */ public class MineWebViewClient
/*    */   extends WebViewClient
/*    */ {
/* 29 */   private static final String a = WebChromeClient.class.getSimpleName();
/*    */   private v b;
/*    */   private Context c;
/*    */   private String d;
/*    */   
/*    */   public MineWebViewClient(Context paramContext, v paramv, String paramString) {
/* 35 */     this.c = paramContext;
/* 36 */     this.b = paramv;
/* 37 */     this.d = paramString;
/*    */   }
/*    */   
/*    */   public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
/*    */   {
/* 42 */     return super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
/*    */   }
/*    */   
/*    */   public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
/*    */   {
/* 47 */     return super.shouldInterceptRequest(paramWebView, paramString);
/*    */   }
/*    */   
/*    */   public void onLoadResource(WebView paramWebView, String paramString)
/*    */   {
/* 52 */     super.onLoadResource(paramWebView, paramString);
/*    */   }
/*    */   
/*    */   public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
/*    */   {
/* 57 */     LogUtils.b(a, "shouldOverrideUrlLoading " + paramString);
/*    */     try
/*    */     {
/* 60 */       Uri localUri = Uri.parse(paramString);
/* 61 */       String str = localUri.getScheme().toLowerCase();
/* 62 */       if ("bytedance".equals(str)) {
/* 63 */         j.a(localUri, this.b);
/* 64 */         return true;
/*    */       }
/* 66 */       if (!PhoneUtils.isAccess(paramString)) {
/* 67 */         Intent localIntent = new Intent("android.intent.action.VIEW");
/* 68 */         localIntent.setData(localUri);
/* 69 */         localIntent.addFlags(268435456);
/* 70 */         this.c.startActivity(localIntent);
/* 71 */         return true;
/*    */       }
/*    */     } catch (Exception localException) {
/* 74 */       Log.w(a, "shouldOverrideUrlLoading" + localException);
/*    */     }
/* 76 */     return super.shouldOverrideUrlLoading(paramWebView, paramString);
/*    */   }
/*    */   
/*    */   public void onPageFinished(WebView paramWebView, String paramString)
/*    */   {
/* 81 */     if (LogUtils.a()) {
/* 82 */       LogUtils.a(a, "onPageFinished " + paramString);
/*    */     }
/* 84 */     if (paramWebView != null) {
/* 85 */       String str1 = n.e().b();
/* 86 */       String str2 = com.bytedance.sdk.openadsdk.core.q.a(str1, this.d);
/* 87 */       if (!com.bytedance.sdk.openadsdk.ggg.q.a(str2)) {
/* 88 */         l.a(paramWebView, str2);
/*    */       }
/*    */     }
/* 91 */     super.onPageFinished(paramWebView, paramString);
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\activity\result.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */