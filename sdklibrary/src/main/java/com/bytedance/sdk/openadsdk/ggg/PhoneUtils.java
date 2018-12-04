/*     */ package com.bytedance.sdk.openadsdk.ggg;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.net.ConnectivityManager;
/*     */ import android.net.NetworkInfo;
/*     */ import android.telephony.TelephonyManager;
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
/*     */ public class PhoneUtils
/*     */ {
/*     */   public static int isWifi(Context paramContext)
/*     */   {
/*  25 */     int i = 0;
/*     */     try
/*     */     {
/*  28 */       ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
/*  29 */       NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
/*     */       
/*  31 */       if ((localNetworkInfo != null) && (localNetworkInfo.isConnected())) {
/*  32 */         String str = localNetworkInfo.getTypeName();
/*     */         
/*  34 */         if (str.equalsIgnoreCase("WIFI")) {
/*  35 */           i = 1;
/*  36 */         } else if (str.equalsIgnoreCase("MOBILE")) {
/*  37 */           TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
/*  38 */           switch (localTelephonyManager.getNetworkType()) {
/*     */           case 1: 
/*     */           case 2: 
/*     */           case 4: 
/*     */           case 7: 
/*     */           case 11: 
/*  44 */             i = 2;
/*  45 */             break;
/*     */           case 3: 
/*     */           case 5: 
/*     */           case 6: 
/*     */           case 8: 
/*     */           case 9: 
/*     */           case 10: 
/*     */           case 12: 
/*     */           case 14: 
/*     */           case 15: 
/*  55 */             i = 3;
/*  56 */             break;
/*     */           case 13: 
/*  58 */             i = 4;
/*  59 */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/*  66 */         i = 0;
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/*  70 */     return i;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String netState(Context paramContext)
/*     */   {
/*  80 */     int i = isWifi(paramContext);
/*     */     String str;
/*  82 */     switch (i) {
/*     */     case 1: 
/*  84 */       str = "wifi";
/*  85 */       break;
/*     */     case 2: 
/*  87 */       str = "2g";
/*  88 */       break;
/*     */     case 3: 
/*  90 */       str = "3g";
/*  91 */       break;
/*     */     case 4: 
/*  93 */       str = "4g";
/*  94 */       break;
/*     */     default: 
/*  96 */       str = "mobile";
/*     */     }
/*     */     
/*  99 */     return str;
/*     */   }
/*     */   
/*     */   public static boolean isAccess(String paramString) {
/* 103 */     if (StringUtils.isEmpty(paramString)) {
/* 104 */       return false;
/*     */     }
/* 106 */     return (paramString.startsWith("http://")) || (paramString.startsWith("https://"));
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\ApiException\VideoManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */