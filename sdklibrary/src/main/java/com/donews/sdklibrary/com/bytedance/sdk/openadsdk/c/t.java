/*    */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.c;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.content.Intent;
/*    */ import android.net.ConnectivityManager;
/*    */ import android.net.NetworkInfo;
/*    */ import android.telephony.TelephonyManager;
/*    */ import android.util.Log;
/*    */ 
/*    */ public class t implements w
/*    */ {
/*    */   private Context a;
/*    */   private static t b;
/*    */   
/*    */   public static synchronized t a(Context paramContext)
/*    */   {
/* 17 */     if (b == null) {
/* 18 */       b = new t(paramContext);
/*    */     }
/* 20 */     return b;
/*    */   }
/*    */   
/*    */   private t(Context paramContext) {
/* 24 */     this.a = paramContext.getApplicationContext();
/*    */   }
/*    */   
/*    */   public long a()
/*    */   {
/* 29 */     return System.currentTimeMillis();
/*    */   }
/*    */   
/*    */ 
/*    */   public NetworkInfo b()
/*    */   {
/* 35 */     ConnectivityManager localConnectivityManager = (ConnectivityManager)this.a.getSystemService("connectivity");
/* 36 */     if (localConnectivityManager == null) {
/* 37 */       Log.w("SsDownloadManager", "couldn't get connectivity manager");
/* 38 */       return null;
/*    */     }
/*    */     
/* 41 */     NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
/* 42 */     if ((localNetworkInfo == null) && (b.d)) {
/* 43 */       Log.v("SsDownloadManager", "network is not available");
/*    */     }
/* 45 */     return localNetworkInfo;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean c()
/*    */   {
/* 51 */     ConnectivityManager localConnectivityManager = (ConnectivityManager)this.a.getSystemService("connectivity");
/* 52 */     if (localConnectivityManager == null) {
/* 53 */       Log.w("SsDownloadManager", "couldn't get connectivity manager");
/* 54 */       return false;
/*    */     }
/* 56 */     NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
/* 57 */     int i = (localNetworkInfo != null) && (localNetworkInfo.getType() == 0) ? 1 : 0;
/* 58 */     TelephonyManager localTelephonyManager = (TelephonyManager)this.a.getSystemService("phone");
/*    */     
/* 60 */     boolean bool = (i != 0) && (localTelephonyManager.isNetworkRoaming());
/* 61 */     if ((b.d) && (bool)) {
/* 62 */       Log.v("SsDownloadManager", "network is roaming");
/*    */     }
/* 64 */     return bool;
/*    */   }
/*    */   
/*    */   public Long d()
/*    */   {
/* 69 */     return f.b(this.a);
/*    */   }
/*    */   
/*    */   public Long e()
/*    */   {
/* 74 */     return f.c(this.a);
/*    */   }
/*    */   
/*    */   public void a(Intent paramIntent)
/*    */   {
/*    */     try {
/* 80 */       paramIntent.setClass(this.a, com.bytedance.sdk.openadsdk.service.TTDownloadHandlerService.class);
/* 81 */       this.a.startService(paramIntent);
/*    */     }
/*    */     catch (Exception localException) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\c\t.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */