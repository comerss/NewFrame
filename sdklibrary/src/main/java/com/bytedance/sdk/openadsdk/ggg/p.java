/*     */ package com.bytedance.sdk.openadsdk.ggg;
/*     */ 
/*     */ import android.os.Build;
/*     */
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
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
/*     */ public class p
/*     */ {
/*  32 */   private static final CharSequence a = "sony";
/*  33 */   private static final CharSequence b = "amigo";
/*  34 */   private static final CharSequence c = "funtouch";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String a()
/*     */   {
/*  42 */     if (ToolUtils.c()) {
/*  43 */       return j();
/*     */     }
/*     */     
/*  46 */     if (ToolUtils.d()) {
/*  47 */       return l();
/*     */     }
/*     */     
/*  50 */     if (m()) {
/*  51 */       return n();
/*     */     }
/*     */     
/*  54 */     String str = k();
/*  55 */     if (!StringUtils.isEmpty(str)) {
/*  56 */       return str;
/*     */     }
/*     */     
/*  59 */     if (e()) {
/*  60 */       return d();
/*     */     }
/*     */     
/*     */ 
/*  64 */     if (f()) {
/*  65 */       return g();
/*     */     }
/*     */     
/*  68 */     if (c()) {
/*  69 */       return b();
/*     */     }
/*     */     
/*     */ 
/*  73 */     str = h();
/*  74 */     if (!StringUtils.isEmpty(str)) {
/*  75 */       return str;
/*     */     }
/*     */     
/*  78 */     return Build.DISPLAY;
/*     */   }
/*     */   
/*     */   public static String b() {
/*  82 */     return a("ro.build.uiversion") + "_" + Build.DISPLAY;
/*     */   }
/*     */   
/*     */   public static boolean c() {
/*  86 */     String str = Build.MANUFACTURER + Build.BRAND;
/*  87 */     if (StringUtils.isEmpty(str))
/*  88 */       return false;
/*  89 */     str = str.toLowerCase();
/*  90 */     return (str.contains("360")) || (str.contains("qiku"));
/*     */   }
/*     */   
/*     */   public static String d() {
/*  94 */     return 
/*  95 */       a("ro.vivo.os.build.display.id") + "_" + a("ro.vivo.product.version");
/*     */   }
/*     */   
/*     */   public static boolean e() {
/*  99 */     String str = a("ro.vivo.os.build.display.id");
/* 100 */     return (!StringUtils.isEmpty(str)) &&
/* 101 */       (str.toLowerCase().contains(c));
/*     */   }
/*     */   
/*     */   public static boolean f() {
/* 105 */     return (!StringUtils.isEmpty(Build.DISPLAY)) &&
/* 106 */       (Build.DISPLAY.toLowerCase().contains(b));
/*     */   }
/*     */   
/*     */   public static String g()
/*     */   {
/* 111 */     return Build.DISPLAY + "_" + a("ro.gn.sv.version");
/*     */   }
/*     */   
/*     */   public static String h()
/*     */   {
/* 116 */     if (i()) {
/* 117 */       return 
/* 118 */         "eui_" + a("ro.letv.release.version") + "_" + Build.DISPLAY;
/*     */     }
/* 120 */     return "";
/*     */   }
/*     */   
/*     */   public static boolean i() {
/* 124 */     return !StringUtils.isEmpty(a("ro.letv.release.version"));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String j()
/*     */   {
/* 133 */     if (ToolUtils.c()) {
/* 134 */       return "miui_" + a("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
/*     */     }
/*     */     
/* 137 */     return "";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String k()
/*     */   {
/* 144 */     String str = ToolUtils.b();
/* 145 */     if ((str != null) && (str.toLowerCase().contains("emotionui"))) {
/* 146 */       return str + "_" + Build.DISPLAY;
/*     */     }
/* 148 */     return "";
/*     */   }
/*     */   
/*     */   public static String l() {
/* 152 */     String str = Build.DISPLAY;
/* 153 */     if ((str != null) && (str.toLowerCase().contains("flyme"))) {
/* 154 */       return str;
/*     */     }
/* 156 */     return "";
/*     */   }
/*     */   
/*     */   public static boolean m() {
/* 160 */     String str = Build.MANUFACTURER;
/* 161 */     if (!StringUtils.isEmpty(str)) {
/* 162 */       return str.toLowerCase().contains("oppo");
/*     */     }
/* 164 */     return false;
/*     */   }
/*     */   
/*     */   public static String n() {
/* 168 */     if (m()) {
/* 169 */       return "coloros_" + a("ro.build.version.opporom") + "_" + Build.DISPLAY;
/*     */     }
/*     */     
/* 172 */     return "";
/*     */   }
/*     */   
/*     */   private static String a(String paramString) {
/* 176 */    String str1 = "";
/* 177 */     BufferedReader localBufferedReader = null;
/*     */     try {
/* 179 */       Process localProcess = Runtime.getRuntime().exec("getprop " + paramString);
/*     */       
/* 181 */       localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()), 1024);
/* 182 */       str1 = localBufferedReader.readLine();
/* 183 */       localProcess.destroy();
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
/* 196 */       return str1;
/*     */     }
/*     */     catch (Throwable localThrowable)
/*     */     {
/* 185 */       LogUtils.a("ToolUtils", "Unable to read sysprop " + paramString, localThrowable);
/* 186 */       return str1;
/*     */     } finally {
/* 188 */       if (localBufferedReader != null) {
/*     */         try {
/* 190 */           localBufferedReader.close();
/*     */         } catch (IOException localIOException3) {
/* 192 */           LogUtils.a("ToolUtils", "Exception while closing InputStream", localIOException3);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\ApiException\AdNativeListenerImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */