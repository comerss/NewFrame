/*    */ package com.bytedance.sdk.openadsdk.ggg;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.net.ConnectivityManager;
/*    */ import android.net.NetworkInfo;
/*    */
/*    */ import android.telephony.TelephonyManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class n
/*    */ {
/*    */   public static boolean a(Context paramContext)
/*    */   {
/*    */     try
/*    */     {
/* 17 */       ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
/* 18 */       if (localConnectivityManager == null) {
/* 19 */         return false;
/*    */       }
/* 21 */       NetworkInfo[] arrayOfNetworkInfo = localConnectivityManager.getAllNetworkInfo();
/* 22 */       if (arrayOfNetworkInfo != null) {
/* 23 */         for (int i = 0; i < arrayOfNetworkInfo.length; i++) {
/* 24 */           if ((arrayOfNetworkInfo[i].getState() == NetworkInfo.State.CONNECTED) || (arrayOfNetworkInfo[i].getState() == NetworkInfo.State.CONNECTING)) {
/* 25 */             return true;
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     catch (Exception localException) {}
/*    */     
/*    */ 
/* 33 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static enum a
/*    */ {
/*    */      a(0),
    b(1),
    c(2),
    d(3),
    e(4),
    f(5);

    final int g;

    private a(int var3) {
        this.g = var3;
    }

    public int a() {
        return this.g;
    }
/*    */   }
/*    */   
/*    */   public static a b(Context paramContext)
/*    */   {
/*    */     try
/*    */     {
/* 57 */       ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
/*    */       
/* 59 */       NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
/* 60 */       if ((localNetworkInfo == null) || (!localNetworkInfo.isAvailable())) {
/* 61 */         return a.a;
/*    */       }
/* 63 */       int i = localNetworkInfo.getType();
/* 64 */       if (1 == i)
/* 65 */         return a.e;
/* 66 */       if (0 == i) {
/* 67 */         TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
/*    */         
/* 69 */         switch (localTelephonyManager.getNetworkType()) {
/*    */         case 3: 
/*    */         case 5: 
/*    */         case 6: 
/*    */         case 8: 
/*    */         case 9: 
/*    */         case 10: 
/*    */         case 12: 
/*    */         case 14: 
/*    */         case 15: 
/* 79 */           return a.d;
/*    */         case 13: 
/* 81 */           return a.f;
/*    */         }
/* 83 */         return a.b;
/*    */       }
/*    */       
/* 86 */       return a.b;
/*    */     }
/*    */     catch (Throwable localThrowable) {}
/* 89 */     return a.b;
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\ApiException\mN.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */