/*    */ package com.bytedance.sdk.openadsdk.ggg;
/*    */ 
/*    */ import android.webkit.WebView;
/*    */ 
/*    */ public class l
/*    */ {
/*    */   static final a a;
/*    */   
/*    */   private static class a
/*    */   {
/*    */     public void a(WebView paramWebView, String paramString)
/*    */     {
/* 13 */       if (paramWebView == null) {
/* 14 */         return;
/*    */       }
/*    */       try {
/* 17 */         paramWebView.loadUrl(paramString);
/*    */       } catch (Throwable localThrowable) {}
/*    */     }
/*    */   }
/*    */   
/*    */   @android.annotation.TargetApi(19)
/*    */   private static class b extends l.a {
/*    */     private b() {
/* 25 */       super();
/*    */     }
/*    */     
/*    */     public void a(WebView paramWebView, String paramString) {
/* 29 */       if (paramWebView == null) {
/* 30 */         return;
/*    */       }
/* 32 */       int i = 0;
/* 33 */       if ((paramString != null) && (paramString.startsWith("javascript:"))) {
/*    */         try {
/* 35 */           paramWebView.evaluateJavascript(paramString, null);
/* 36 */           i = 1;
/*    */         } catch (Throwable localThrowable1) {
/* 38 */           if ((localThrowable1 instanceof IllegalStateException))
/*    */           {
/* 40 */             i = 0;
/*    */           }
/*    */         }
/*    */       }
/*    */       
/*    */ 
/* 46 */       if (i == 0) {
/*    */         try {
/* 48 */           paramWebView.loadUrl(paramString);
/*    */         }
/*    */         catch (Throwable localThrowable2) {}
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   static
/*    */   {
/* 59 */     if (android.os.Build.VERSION.SDK_INT >= 19) {
/* 60 */       a = new b(null);
/*    */     } else {
/* 62 */       a = new a(null);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void a(WebView paramWebView, String paramString) {
/* 67 */     a.a(paramWebView, paramString);
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\g\l.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */