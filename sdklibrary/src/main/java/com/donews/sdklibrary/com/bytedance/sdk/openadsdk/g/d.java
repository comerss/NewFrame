/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.g;
/*     */ 
/*     */ import android.annotation.SuppressLint;
/*     */ import android.content.Context;
/*     */ import android.content.res.Configuration;
/*     */ import android.content.res.Resources;
/*     */ import android.os.Build;
/*     */ import android.os.Build.VERSION;
/*     */ import android.os.SystemClock;
/*     */ import android.support.annotation.NonNull;
/*     */ import android.text.TextUtils;
/*     */ import android.util.DisplayMetrics;
/*     */ import com.bytedance.sdk.openadsdk.core.i;
/*     */ import java.net.Inet4Address;
/*     */ import java.net.InetAddress;
/*     */ import java.net.NetworkInterface;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Locale;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class d
/*     */ {
/*  31 */   private static boolean a = false;
/*  32 */   private static boolean b = false;
/*     */   
/*     */   public static boolean a() {
/*  35 */     if (!b) {
/*     */       try {
/*  37 */         Class localClass = Class.forName("miui.os.Build");
/*  38 */         if (localClass != null) {
/*  39 */           a = true;
/*     */         }
/*     */       }
/*     */       catch (Exception localException) {}
/*     */       
/*  44 */       b = true;
/*     */     }
/*  46 */     return a;
/*     */   }
/*     */   
/*     */   @NonNull
/*     */   public static String b() {
/*  51 */     String str = a("wlan0");
/*  52 */     if (TextUtils.isEmpty(str)) {
/*  53 */       str = a("eth0");
/*     */     }
/*  55 */     if (TextUtils.isEmpty(str)) {
/*  56 */       str = "DU:MM:YA:DD:RE:SS";
/*     */     }
/*  58 */     return str;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SuppressLint({"NewApi"})
/*     */   private static String a(String paramString)
/*     */   {
/*     */     try
/*     */     {
/*  72 */       ArrayList localArrayList = Collections.list(NetworkInterface.getNetworkInterfaces());
/*  73 */       for (NetworkInterface localNetworkInterface : localArrayList)
/*  74 */         if ((paramString == null) || 
/*  75 */           (localNetworkInterface.getName().equalsIgnoreCase(paramString)))
/*     */         {
/*     */ 
/*  78 */           byte[] arrayOfByte = localNetworkInterface.getHardwareAddress();
/*  79 */           if (arrayOfByte == null)
/*  80 */             return "";
/*  81 */           StringBuilder localStringBuilder = new StringBuilder();
/*  82 */           for (int i = 0; i < arrayOfByte.length; i++)
/*  83 */             localStringBuilder.append(String.format("%02X:", new Object[] { Byte.valueOf(arrayOfByte[i]) }));
/*  84 */           if (localStringBuilder.length() > 0)
/*  85 */             localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
/*  86 */           return localStringBuilder.toString();
/*     */         }
/*     */     } catch (Exception localException) {
/*  89 */       return "";
/*     */     }
/*  91 */     return "";
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
/*     */   public static String a(boolean paramBoolean)
/*     */   {
/*     */     try
/*     */     {
/* 107 */       ArrayList localArrayList1 = Collections.list(NetworkInterface.getNetworkInterfaces());
/* 108 */       for (NetworkInterface localNetworkInterface : localArrayList1) {
/* 109 */         ArrayList localArrayList2 = Collections.list(localNetworkInterface.getInetAddresses());
/* 110 */         for (InetAddress localInetAddress : localArrayList2) {
/* 111 */           if (!localInetAddress.isLoopbackAddress()) {
/* 112 */             boolean bool = localInetAddress instanceof Inet4Address;
/* 113 */             String str = localInetAddress.getHostAddress().toUpperCase();
/* 114 */             if (paramBoolean) {
/* 115 */               if (bool) {
/* 116 */                 return str;
/*     */               }
/* 118 */             } else if (!bool) {
/* 119 */               int i = str.indexOf('%');
/*     */               
/* 121 */               return i < 0 ? str : str.substring(0, i);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception localException) {}
/*     */     
/* 129 */     return "";
/*     */   }
/*     */   
/*     */   public static boolean a(Context paramContext) {
/* 133 */     return (paramContext.getResources().getConfiguration().screenLayout & 0xF) >= 3;
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
/*     */   public static boolean b(Context paramContext)
/*     */   {
/* 153 */     int i = paramContext.getResources().getConfiguration().uiMode;
/* 154 */     if ((i & 0xF) == 4) {
/* 155 */       return true;
/*     */     }
/* 157 */     return false;
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
/*     */   public static int c(Context paramContext)
/*     */   {
/* 170 */     if (b(paramContext))
/* 171 */       return 3;
/* 172 */     if (a(paramContext)) {
/* 173 */       return 2;
/*     */     }
/* 175 */     return 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static JSONObject d(Context paramContext)
/*     */   {
/* 185 */     JSONObject localJSONObject = new JSONObject();
/*     */     try {
/* 187 */       localJSONObject.put("imei", i.d(paramContext));
/* 188 */       localJSONObject.put("android_id", i.c(paramContext));
/* 189 */       localJSONObject.put("uuid", i.e(paramContext));
/* 190 */       localJSONObject.put("ssid", i.g(paramContext));
/* 191 */       localJSONObject.put("wifi_mac", i.i(paramContext));
/* 192 */       localJSONObject.put("imsi", i.f(paramContext));
/* 193 */       localJSONObject.put("power_on_time", SystemClock.elapsedRealtime() + "");
/* 194 */       localJSONObject.put("rom_version", i.h(paramContext));
/* 195 */       localJSONObject.put("sys_compiling_time", i.b(paramContext));
/* 196 */       localJSONObject.put("type", c(paramContext));
/* 197 */       localJSONObject.put("os", 1);
/* 198 */       localJSONObject.put("os_version", VERSION.SDK_INT + "");
/* 199 */       localJSONObject.put("vendor", Build.MANUFACTURER);
/* 200 */       localJSONObject.put("model", Build.MODEL);
/* 201 */       localJSONObject.put("language", Locale.getDefault().getLanguage());
/* 202 */       localJSONObject.put("conn_type", c.a(paramContext));
/* 203 */       localJSONObject.put("mac", b());
/* 204 */       DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
/* 205 */       localJSONObject.put("screen_width", localDisplayMetrics.widthPixels);
/* 206 */       localJSONObject.put("screen_height", localDisplayMetrics.heightPixels);
/*     */     }
/*     */     catch (JSONException localJSONException) {}
/* 209 */     return localJSONObject;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\g\d.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */