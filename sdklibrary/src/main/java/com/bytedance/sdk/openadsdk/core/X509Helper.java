/*     */ package com.bytedance.sdk.openadsdk.core;
/*     */ 
/*     */ import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;

import com.androidquery.callback.AjaxCallback;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdManagerFactory;
import com.bytedance.sdk.openadsdk.core.eeee.bee;
import com.bytedance.sdk.openadsdk.ggg.PhoneUtils;
import com.bytedance.sdk.openadsdk.ggg.p;
import com.ss.android.crash.log.h;
import com.ss.android.crash.log.j;

import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

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
/*     */ public class X509Helper
/*     */ {
/*  36 */   private static boolean a = false;
/*     */   
/*     */   public static void a(Context paramContext) {
/*  39 */     if (!a) {
/*  40 */       synchronized (TTAdManagerFactory.class) {
/*  41 */         if (!a) {
/*  42 */           b(paramContext);
/*  43 */           a = true;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static void b(Context paramContext) {
/*  50 */     n.a(paramContext.getApplicationContext());
/*  51 */     a();
/*  52 */     b();
/*  53 */     c(paramContext);
/*  54 */     n.b().a();
/*  55 */     d(paramContext);
/*     */     
/*  57 */     String str = i.a(paramContext);
/*  58 */     if (!TextUtils.isEmpty(str)) {
/*  59 */       n.d().a(str);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void a() {
/*  64 */     new bee(n.e()).a();
/*     */   }
/*     */   
/*     */   private static void c(Context paramContext) {
/*  68 */     SharedHepler localc = SharedHepler.getInstance(paramContext);
/*  69 */     localc.a("uuid", UUID.randomUUID().toString());
/*     */   }
/*     */   
/*     */   private static void b() {
/*  73 */     X509HostnameVerifier localX509HostnameVerifier = SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
/*  74 */     SchemeRegistry localSchemeRegistry = new SchemeRegistry();
/*  75 */     SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
/*  76 */     localSSLSocketFactory.setHostnameVerifier((X509HostnameVerifier)localX509HostnameVerifier);
/*  77 */     localSchemeRegistry.register(new Scheme("https", localSSLSocketFactory, 443));
/*  78 */     AjaxCallback.setSSF(localSSLSocketFactory);
/*     */   }
/*     */   
/*     */   private static void d(final Context paramContext) {
/*  82 */     j.a((Application)paramContext.getApplicationContext()).a(new j.a()
/*     */     {
/*     */       public Map<String, Object> a() {
/*  85 */         HashMap localHashMap = new HashMap();
/*  86 */         String str1 = i.a(paramContext);
/*  87 */         if (!TextUtils.isEmpty(str1)) {
/*  88 */           localHashMap.put("device_id", str1);
/*     */         }
/*  90 */         localHashMap.put("ac", PhoneUtils.netState(paramContext));
/*  91 */         localHashMap.put("aid", Integer.valueOf(1181));
/*  92 */         localHashMap.put("app_name", "openadsdk");
/*  93 */         localHashMap.put("version_code", Integer.valueOf(1));
/*  94 */         localHashMap.put("update_version_code", Integer.valueOf(1900));
/*  95 */         localHashMap.put("version_name", "1");
/*  96 */         localHashMap.put("device_platform", "android");
/*  97 */         localHashMap.put("device_type", Build.MODEL);
/*  98 */         localHashMap.put("device_mode", Build.MODEL);
/*  99 */         localHashMap.put("rom", p.a());
/* 100 */         localHashMap.put("cpu_abi", Build.CPU_ABI);
/* 101 */         localHashMap.put("device_brand", Build.BRAND);
/* 102 */         localHashMap.put("language", Locale.getDefault().getLanguage());
/* 103 */         localHashMap.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
/*     */         try {
/* 105 */           String str2 = Build.VERSION.RELEASE;
/* 106 */           if ((str2 != null) && (str2.length() > 10))
/* 107 */             str2 = str2.substring(0, 10);
/* 108 */           localHashMap.put("os_version", str2);
/*     */         }
/*     */         catch (Exception localException) {}
/*     */         
/* 112 */         localHashMap.put("openudid", i.c(paramContext));
/* 113 */         localHashMap.put("dpi", paramContext.getApplicationContext().getResources().getDisplayMetrics().densityDpi + "");
/* 114 */         DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
/* 115 */         localHashMap.put("resolution", localDisplayMetrics.widthPixels + "*" + localDisplayMetrics.heightPixels);
/* 116 */         return localHashMap; } }, true, false, false);
/*     */     
/*     */ 
/* 119 */     h.a(new h.a()
/*     */     {
/*     */       public boolean a(Throwable paramAnonymousThrowable) {
/* 122 */         String str = AdSlot.class.getPackage().getName();
/* 123 */         StackTraceElement[] arrayOfStackTraceElement1 = paramAnonymousThrowable.getStackTrace();
/* 124 */         for (StackTraceElement localStackTraceElement : arrayOfStackTraceElement1) {
/* 125 */           boolean bool = localStackTraceElement.getClassName().contains(str);
/* 126 */           if (bool) {
/* 127 */             return false;
/*     */           }
/*     */         }
/* 130 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\LogUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */