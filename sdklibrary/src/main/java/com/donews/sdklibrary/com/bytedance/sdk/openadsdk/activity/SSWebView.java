/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.activity;
/*     */ 
/*     */ import android.annotation.TargetApi;
/*     */ import android.content.Context;
/*     */ import android.util.AttributeSet;
/*     */ import android.view.MotionEvent;
/*     */ import android.webkit.DownloadListener;
/*     */ import android.webkit.WebChromeClient;
/*     */ import android.webkit.WebView;
/*     */ import android.webkit.WebViewClient;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSWebView
/*     */   extends WebView
/*     */ {
/*     */   public SSWebView(Context paramContext)
/*     */   {
/*  21 */     super(paramContext);
/*     */   }
/*     */   
/*     */   public SSWebView(Context paramContext, AttributeSet paramAttributeSet) {
/*  25 */     super(paramContext, paramAttributeSet);
/*     */   }
/*     */   
/*     */   public SSWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
/*  29 */     super(paramContext, paramAttributeSet, paramInt);
/*     */   }
/*     */   
/*     */ 
/*     */   public void setNetworkAvailable(boolean paramBoolean)
/*     */   {
/*     */     try
/*     */     {
/*  37 */       super.setNetworkAvailable(paramBoolean);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   @TargetApi(19)
/*     */   public void loadUrl(String paramString, Map<String, String> paramMap)
/*     */   {
/*     */     try
/*     */     {
/*  47 */       super.loadUrl(paramString, paramMap);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public void loadUrl(String paramString)
/*     */   {
/*     */     try {
/*  55 */       super.loadUrl(paramString);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public void postUrl(String paramString, byte[] paramArrayOfByte)
/*     */   {
/*     */     try {
/*  63 */       super.postUrl(paramString, paramArrayOfByte);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public void loadData(String paramString1, String paramString2, String paramString3)
/*     */   {
/*     */     try {
/*  71 */       super.loadData(paramString1, paramString2, paramString3);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
/*     */   {
/*     */     try
/*     */     {
/*  80 */       super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public void stopLoading()
/*     */   {
/*     */     try {
/*  88 */       super.stopLoading();
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public void reload()
/*     */   {
/*     */     try {
/*  96 */       super.reload();
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public boolean canGoBack()
/*     */   {
/*     */     try {
/* 104 */       return super.canGoBack();
/*     */     } catch (Exception localException) {}
/* 106 */     return false;
/*     */   }
/*     */   
/*     */   public void goBack()
/*     */   {
/*     */     try
/*     */     {
/* 113 */       super.goBack();
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public boolean canGoForward()
/*     */   {
/*     */     try {
/* 121 */       return super.canGoForward();
/*     */     } catch (Exception localException) {}
/* 123 */     return false;
/*     */   }
/*     */   
/*     */   public void goForward()
/*     */   {
/*     */     try
/*     */     {
/* 130 */       super.goForward();
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public boolean canGoBackOrForward(int paramInt)
/*     */   {
/*     */     try {
/* 138 */       return super.canGoBackOrForward(paramInt);
/*     */     } catch (Exception localException) {}
/* 140 */     return false;
/*     */   }
/*     */   
/*     */   public void goBackOrForward(int paramInt)
/*     */   {
/*     */     try
/*     */     {
/* 147 */       super.goBackOrForward(paramInt);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public String getUrl()
/*     */   {
/*     */     try {
/* 155 */       return super.getUrl();
/*     */     }
/*     */     catch (Exception localException) {}
/* 158 */     return null;
/*     */   }
/*     */   
/*     */   public String getOriginalUrl()
/*     */   {
/*     */     try
/*     */     {
/* 165 */       Object localObject = super.getOriginalUrl();
/* 166 */       String str; if ((localObject != null) && (((String)localObject).startsWith("data:text/html"))) {
/* 167 */         str = super.getUrl();
/* 168 */         if ((str == null) || (!str.startsWith("file://"))) {} }
/* 169 */       return str;
/*     */     }
/*     */     catch (Exception localException) {}
/*     */     
/*     */ 
/*     */ 
/* 175 */     return null;
/*     */   }
/*     */   
/*     */   public int getProgress()
/*     */   {
/*     */     try {
/* 181 */       return super.getProgress();
/*     */     } catch (Exception localException) {}
/* 183 */     return 100;
/*     */   }
/*     */   
/*     */   public int getContentHeight()
/*     */   {
/*     */     try
/*     */     {
/* 190 */       return super.getContentHeight();
/*     */     } catch (Exception localException) {}
/* 192 */     return 1;
/*     */   }
/*     */   
/*     */   public void clearCache(boolean paramBoolean)
/*     */   {
/*     */     try
/*     */     {
/* 199 */       super.clearCache(paramBoolean);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public void clearFormData()
/*     */   {
/*     */     try {
/* 207 */       super.clearFormData();
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public void clearHistory()
/*     */   {
/*     */     try {
/* 215 */       super.clearHistory();
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public void setWebViewClient(WebViewClient paramWebViewClient)
/*     */   {
/*     */     try {
/* 223 */       super.setWebViewClient(paramWebViewClient);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public void setDownloadListener(DownloadListener paramDownloadListener)
/*     */   {
/*     */     try {
/* 231 */       super.setDownloadListener(paramDownloadListener);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public void setWebChromeClient(WebChromeClient paramWebChromeClient)
/*     */   {
/*     */     try {
/* 239 */       super.setWebChromeClient(paramWebChromeClient);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public void setBackgroundColor(int paramInt)
/*     */   {
/*     */     try {
/* 247 */       super.setBackgroundColor(paramInt);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public void computeScroll()
/*     */   {
/*     */     try {
/* 255 */       super.computeScroll();
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public boolean onTouchEvent(MotionEvent paramMotionEvent)
/*     */   {
/*     */     try {
/* 263 */       return super.onTouchEvent(paramMotionEvent);
/*     */     } catch (Throwable localThrowable) {}
/* 265 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\activity\SSWebView.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */