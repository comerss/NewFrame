/*     */ package com.bytedance.sdk.openadsdk.ggg;
/*     */ 
/*     */ import android.annotation.SuppressLint;
import android.content.Context;
/*     */ import android.location.Location;
/*     */ import android.location.LocationListener;
/*     */ import android.location.LocationManager;
/*     */ import android.os.Bundle;
/*     */ import android.os.Handler;
/*     */ import android.os.Looper;
/*     */ import android.support.annotation.Nullable;
/*     */ import android.text.TextUtils;
/*     */ import com.bytedance.sdk.openadsdk.core.SharedHepler;
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
/*     */ public class b
/*     */ {
/*     */   @Nullable
/*     */   public static a a(Context paramContext)
/*     */   {
/*  32 */     a locala = c(paramContext);
/*  33 */     if (locala == null) {
/*  34 */       locala = d(paramContext);
/*     */     }
/*  36 */     else if (b(paramContext)) {
/*  37 */       d(paramContext);
/*     */     }
/*     */     
/*  40 */     return locala;
/*     */   }
/*     */   
/*     */   private static boolean b(Context paramContext) {
/*  44 */     SharedHepler localc = SharedHepler.getInstance(paramContext);
/*  45 */     long l = localc.b("lbstime", -1L).longValue();
/*  46 */     return (l == -1L) || 
/*  47 */       (l - System.currentTimeMillis() > 7200000L);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   private static a c(Context paramContext) {
/*  52 */     SharedHepler localc = SharedHepler.getInstance(paramContext);
/*  53 */     float f1 = localc.b("latitude", -1.0F);
/*  54 */     float f2 = localc.b("longitude", -1.0F);
/*  55 */     if ((f1 == -1.0F) || (f2 == -1.0F)) {
/*  56 */       return null;
/*     */     }
/*  58 */     return new a(f1, f2);
/*     */   }
/*     */   
/*     */   private static a d(final Context paramContext)
/*     */   {
/*  63 */     @SuppressLint("WrongConstant") final LocationManager localLocationManager = (LocationManager)paramContext.getSystemService("location");
/*  64 */     a locala = null;
/*  65 */     if (localLocationManager != null)
/*     */     {          try
/*     */       {

/*  77 */         Location localLocation = a(localLocationManager);
/*  78 */         if ((localLocation != null) && (b(localLocation))) {
/*  79 */           b(paramContext, localLocation);
/*     */           
/*  81 */           locala = new a((float)localLocation.getLatitude(), (float)localLocation.getLongitude());
/*     */         }
/*     */         
/*  84 */         if (Looper.myLooper() != Looper.getMainLooper()) {
/*  85 */           new Handler(Looper.getMainLooper()).post(new Runnable()
/*     */           {
/*     */             public void run() {
/*  88 */              com.bytedance.sdk.openadsdk.ggg.b.b(paramContext, localLocationManager);
/*     */             }
/*     */           });
/*     */         } else {
/*  92 */           b(paramContext, localLocationManager);
/*     */         }
/*     */       }
/*     */       catch (Throwable localThrowable) {
/*  96 */         localThrowable.printStackTrace();
/*     */       }
/*     */     }
/*  99 */     return locala;
/*     */   }
/*     */   
/*     */   private static Location a(LocationManager paramLocationManager) {
/* 103 */     Location localLocation = a(paramLocationManager, "gps");
/* 104 */     if (localLocation == null) {
/* 105 */       localLocation = a(paramLocationManager, "network");
/*     */     }
/* 107 */     if (localLocation == null) {
/* 108 */       localLocation = a(paramLocationManager, "passive");
/*     */     }
/* 110 */     return localLocation;
/*     */   }
/*     */   
/*     */   private static Location a(LocationManager paramLocationManager, String paramString)
/*     */   {
/*     */     try {
/* 116 */       return paramLocationManager.getLastKnownLocation(paramString);
/*     */     } catch (SecurityException localSecurityException) {}
/* 118 */     return null;
/*     */   }
/*     */   
/*     */   private static String b(LocationManager paramLocationManager)
/*     */   {
/* 123 */     if (paramLocationManager.isProviderEnabled("gps"))
/* 124 */       return "gps";
/* 125 */     if (paramLocationManager.isProviderEnabled("network"))
/* 126 */       return "network";
/* 127 */     if (paramLocationManager.isProviderEnabled("passive")) {
/* 128 */       return "passive";
/*     */     }
/* 130 */     return null;
/*     */   }
/*     */   
/*     */   private static void b(final Context paramContext, final LocationManager paramLocationManager) {
/*     */     try {
/* 135 */       String str = b(paramLocationManager);
/* 136 */       if (TextUtils.isEmpty(str)) {
/* 137 */         return;
/*     */       }
/*     */       
/* 140 */       paramLocationManager.requestSingleUpdate(str, new LocationListener()
/*     */       {
/*     */         public void onLocationChanged(Location paramAnonymousLocation) {
/* 143 */           if ((paramAnonymousLocation != null) && (b.b(paramAnonymousLocation))) {
/* 144 */             b.b(paramContext, paramAnonymousLocation);
/* 145 */             paramLocationManager.removeUpdates(this);
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */         public void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle) {}
/*     */         
/*     */ 
/*     */ 
/*     */         public void onProviderEnabled(String paramAnonymousString) {}
/*     */         
/*     */ 
/*     */ 
/*     */         public void onProviderDisabled(String paramAnonymousString) {}
/* 160 */       }, Looper.getMainLooper());
/*     */     }
/*     */     catch (SecurityException localSecurityException) {
/* 163 */       localSecurityException.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   private static void b(Context paramContext, Location paramLocation) {
/* 168 */     if (!b(paramLocation)) {
/* 169 */       return;
/*     */     }
/* 171 */     SharedHepler localc = SharedHepler.getInstance(paramContext);
/* 172 */     localc.a("latitude", (float)paramLocation.getLatitude());
/* 173 */     localc.a("longitude", (float)paramLocation.getLongitude());
/* 174 */     localc.a("lbstime", System.currentTimeMillis());
/*     */   }
/*     */   
/*     */   private static boolean b(Location paramLocation) {
/* 178 */     return (paramLocation.getLatitude() != 0.0D) && (paramLocation.getLongitude() != 0.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\ApiException\result.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */