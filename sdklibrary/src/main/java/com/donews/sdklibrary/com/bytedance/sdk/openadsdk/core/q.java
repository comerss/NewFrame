/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core;
/*     */ 
/*     */ import android.annotation.SuppressLint;
/*     */ import android.content.Context;
/*     */ import android.webkit.WebSettings;
/*     */ import android.webkit.WebView;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class q
/*     */ {
/*     */   private WeakReference<Context> a;
/*     */   
/*     */   public static q a(Context paramContext)
/*     */   {
/*  35 */     return new q(paramContext);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  41 */   private boolean b = true;
/*     */   
/*     */ 
/*  44 */   private boolean c = true;
/*     */   
/*     */ 
/*  47 */   private boolean d = true;
/*     */   
/*     */ 
/*  50 */   private boolean e = true;
/*     */   
/*     */ 
/*  53 */   private boolean f = true;
/*     */   
/*     */ 
/*  56 */   private boolean g = true;
/*     */   
/*     */ 
/*  59 */   private boolean h = true;
/*     */   
/*     */   private q(Context paramContext) {
/*  62 */     this.a = new WeakReference(paramContext);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public q a(boolean paramBoolean)
/*     */   {
/*  71 */     this.h = paramBoolean;
/*  72 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SuppressLint({"SetJavaScriptEnabled"})
/*     */   public void a(WebView paramWebView)
/*     */   {
/*  80 */     if ((paramWebView == null) || (this.a.get() == null)) {
/*  81 */       return;
/*     */     }
/*  83 */     WebSettings localWebSettings = paramWebView.getSettings();
/*  84 */     if (localWebSettings == null) {
/*  85 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  90 */       localWebSettings.setJavaScriptEnabled(true);
/*     */     } catch (Exception localException) {
/*  92 */       localException.printStackTrace();
/*     */     }
/*     */     try {
/*  95 */       if (this.c) {
/*  96 */         localWebSettings.setSupportZoom(true);
/*  97 */         localWebSettings.setBuiltInZoomControls(true);
/*     */       } else {
/*  99 */         localWebSettings.setSupportZoom(false);
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable1) {
/* 103 */       localThrowable1.printStackTrace();
/*     */     }
/*     */     
/* 106 */     localWebSettings.setLoadWithOverviewMode(true);
/* 107 */     localWebSettings.setUseWideViewPort(this.d);
/* 108 */     localWebSettings.setDomStorageEnabled(this.e);
/* 109 */     localWebSettings.setAllowFileAccess(this.f);
/* 110 */     localWebSettings.setBlockNetworkImage(!this.g);
/* 111 */     if (!this.h) {
/*     */       try {
/* 113 */         paramWebView.setLayerType(1, null);
/*     */       } catch (Throwable localThrowable2) {
/* 115 */         localThrowable2.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static String a(String paramString1, String paramString2)
/*     */   {
/* 123 */     if ((com.bytedance.sdk.openadsdk.g.q.a(paramString1)) || (com.bytedance.sdk.openadsdk.g.q.a(paramString2)) || ("0".equals(paramString2)) || (!paramString1.contains("{{ad_id}}"))) {
/* 124 */       return null;
/*     */     }
/* 126 */     paramString1 = paramString1.replace("{{ad_id}}", paramString2);
/* 127 */     String str = "javascript:(function () {    var JS_ACTLOG_URL = '" + paramString1 + "';    var head = document.getElementsByTagName('head')[0];    var script = document.createElement('script');    script.type = 'text/javascript';    script.src = JS_ACTLOG_URL;    head.appendChild(script);})();";
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 136 */     return str;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 158 */   private static Set<String> i = new LinkedHashSet();
/*     */   
/* 160 */   static { i.add("device_id");
/* 161 */     i.add("ac");
/* 162 */     i.add("channel");
/* 163 */     i.add("aid");
/* 164 */     i.add("device_platform");
/* 165 */     i.add("device_type");
/* 166 */     i.add("os_api");
/* 167 */     i.add("update_version_code");
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\q.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */