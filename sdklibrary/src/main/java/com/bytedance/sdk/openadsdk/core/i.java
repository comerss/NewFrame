/*     */ package com.bytedance.sdk.openadsdk.core;
/*     */ 
/*     */

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.support.annotation.RequiresPermission;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.bytedance.sdk.openadsdk.ggg.ToolUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.channels.FileLock;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Locale;

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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class i
/*     */ {
/*     */   private static String a;
/*     */   private static String b;
/*     */   private static String c;
/*     */   private static String d;
/*     */   private static String e;
/*     */   private static String f;
/*     */   private static String g;
/*     */   private static String h;
/*     */   private static String i;
/*     */   private static boolean j;
/*     */   private static boolean k;
/*     */   
/*     */   public static String a(Context paramContext)
/*     */   {
/*  54 */     if (TextUtils.isEmpty(a) && !j) {
        Class var1 = i.class;
        synchronized(i.class) {
            if (!j) {
                k(paramContext);
            }
        }

/*     */     }
/*     */     
/*  63 */     return a;
/*     */   }
/*     */   
/*     */   public static String b(Context paramContext) {
/*  67 */     if ((h == null) && 
/*  68 */       (!j)) {
/*  69 */       synchronized (i.class) {
/*  70 */         if (!j) {
/*  71 */           k(paramContext);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  76 */     return h;
/*     */   }
/*     */   
/*     */   public static String c(Context paramContext) {
/*  80 */     if ((TextUtils.isEmpty(b)) && 
/*  81 */       (!j)) {
/*  82 */       synchronized (i.class) {
/*  83 */         if (!j) {
/*  84 */           k(paramContext);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  89 */     return b;
/*     */   }
/*     */   
/*     */   public static String d(Context paramContext) {
/*  93 */     if ((TextUtils.isEmpty(c)) && 
/*  94 */       (!j)) {
/*  95 */       synchronized (i.class) {
/*  96 */         if (!j) {
/*  97 */           k(paramContext);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 102 */     return c;
/*     */   }
/*     */   
/*     */   public static String e(Context paramContext) {
/* 106 */     if ((TextUtils.isEmpty(i)) && 
/* 107 */       (!j)) {
/* 108 */       synchronized (i.class) {
/* 109 */         if (!j) {
/* 110 */           k(paramContext);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 115 */     return i;
/*     */   }
/*     */   
/*     */   public static String f(Context paramContext) {
/* 119 */     if ((TextUtils.isEmpty(f)) && 
/* 120 */       (!j)) {
/* 121 */       synchronized (i.class) {
/* 122 */         if (!j) {
/* 123 */           k(paramContext);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 128 */     return f;
/*     */   }
/*     */   
/*     */   public static String g(Context paramContext) {
/* 132 */     if ((TextUtils.isEmpty(d)) && 
/* 133 */       (!j)) {
/* 134 */       synchronized (i.class) {
/* 135 */         if (!j) {
/* 136 */           k(paramContext);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 141 */     return d;
/*     */   }
/*     */   
/*     */   public static String h(Context paramContext) {
/* 145 */     if ((TextUtils.isEmpty(g)) && 
/* 146 */       (!j)) {
/* 147 */       synchronized (i.class) {
/* 148 */         if (!j) {
/* 149 */           k(paramContext);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 154 */     return g;
/*     */   }
/*     */   
/*     */   public static String i(Context paramContext) {
/* 158 */     if ((TextUtils.isEmpty(e)) && 
/* 159 */       (!j)) {
/* 160 */       synchronized (i.class) {
/* 161 */         if (!j) {
/* 162 */           k(paramContext);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 167 */     return e;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void a(Context paramContext, String paramString)
/*     */   {
/* 177 */     if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(a))) {
/* 178 */       SharedHepler localc = SharedHepler.getInstance(paramContext);
/* 179 */       localc.a("did", paramString);
/* 180 */       a = paramString;
/*     */     }
/*     */   }
/*     */   
/*     */   @SuppressLint("MissingPermission")
@RequiresPermission(anyOf={"android.permission.ACCESS_WIFI_STATE"})
/*     */   private static void k(Context paramContext) {
/* 186 */     if (j) {
/* 187 */       return;
/*     */     }
/* 189 */     @SuppressLint("WrongConstant") TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getApplicationContext().getSystemService("phone");
/* 190 */     @SuppressLint("WrongConstant") WifiManager localWifiManager = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
/*     */     try {
/* 192 */       c = localTelephonyManager.getDeviceId();
/* 193 */       f = localTelephonyManager.getSubscriberId();
/* 194 */       WifiInfo localWifiInfo = localWifiManager.getConnectionInfo();
/* 195 */       if (localWifiInfo != null) {
/* 196 */         d = localWifiInfo.getSSID();
/* 197 */         e = localWifiInfo.getMacAddress();
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/*     */     
/* 202 */     b = a(paramContext, true);
/* 203 */     a = SharedHepler.getInstance(paramContext).b("did", null);
/* 204 */     g = a();
/* 205 */     h = b();
/* 206 */     i = SharedHepler.getInstance(paramContext).b("uuid", null);
/* 207 */     j = true;
/*     */   }
/*     */   
/*     */   @SuppressLint("MissingPermission")
public static void j(Context paramContext)
/*     */   {
/* 212 */     if (k) {
/* 213 */       return;
/*     */     }
/* 215 */     @SuppressLint("WrongConstant") TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getApplicationContext().getSystemService("phone");
/*     */     try {
/* 217 */       c = localTelephonyManager.getDeviceId();
/* 218 */       f = localTelephonyManager.getSubscriberId();
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/*     */     
/* 222 */     k = true;
/*     */   }
/*     */   
/*     */   @SuppressLint({"TrulyRandom"})
/*     */   private static synchronized String a(Context paramContext, boolean paramBoolean) {
/* 227 */     Object localObject1 = null;
/*     */     try {
/* 229 */       localObject1 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/*     */     
/*     */     try
/*     */     {
/* 235 */       if ((localObject1 == null) || (((String)localObject1).equals("9774d56d682e549c")) || 
/* 236 */         (((String)localObject1).length() < 13))
/*     */       {
/* 238 */         SharedHepler localc = SharedHepler.getInstance(paramContext);
/* 239 */         Object localObject2 = localc.b("openudid", null);
/* 240 */         if (!a((String)localObject2)) {
/* 241 */           SecureRandom localSecureRandom = new SecureRandom();
/* 242 */           localObject2 = new BigInteger(64, localSecureRandom).toString(16);
/* 243 */           if (((String)localObject2).charAt(0) == '-')
/* 244 */             localObject2 = ((String)localObject2).substring(1);
/* 245 */           int m = 13 - ((String)localObject2).length();
/* 246 */           Object localObject3; if (m > 0) {
/* 247 */             localObject3 = new StringBuilder();
/* 248 */             while (m > 0) {
/* 249 */               ((StringBuilder)localObject3).append('F');
/* 250 */               m--;
/*     */             }
/* 252 */             ((StringBuilder)localObject3).append((String)localObject2);
/* 253 */             localObject2 = ((StringBuilder)localObject3).toString();
/*     */           }
/* 255 */           if (paramBoolean) {
/* 256 */             localObject3 = a("openudid.dat", (String)localObject2);
/* 257 */             if (a((String)localObject3)) {
/* 258 */               localObject2 = localObject3;
/*     */             }
/*     */           }
/* 261 */           localc.a("openudid", (String)localObject2);
/*     */         }
/* 263 */         localObject1 = localObject2;
/*     */       }
/*     */     }
/*     */     catch (Exception localException) {}
/*     */     
/*     */ 
/* 269 */     return (String)localObject1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static String a(String paramString1, String paramString2)
/*     */   {
/* 276 */     String str1 = Environment.getExternalStorageState();
/* 277 */     if (!"mounted".equals(str1)) {
/* 278 */       return paramString2;
/*     */     }
/* 280 */     String str2 = Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.snssdk.api/cache";
/*     */     
/* 282 */     String str3 = str2 + "/" + paramString1;
/* 283 */     FileLock localFileLock = null;
/* 284 */     RandomAccessFile localRandomAccessFile = null;
/*     */     try {
/* 286 */       File localFile = new File(str2);
/* 287 */       if ((!localFile.exists()) && 
/* 288 */         (!localFile.mkdirs())) {
/* 289 */         return paramString2;
/*     */       }
/* 291 */       Object localObject1 = new File(str3);
/* 292 */       localRandomAccessFile = new RandomAccessFile((File)localObject1, "rwd");
/* 293 */       localFileLock = localRandomAccessFile.getChannel().lock();
/* 294 */       Object localObject2; if (((File)localObject1).isFile()) {
/* 295 */         int m = 129;
/* 296 */         localObject2 = new byte[m];
/* 297 */         int n = localRandomAccessFile.read((byte[])localObject2, 0, m);
/* 298 */         if ((n > 0) && (n < m)) {
/* 299 */           String str4 = new String((byte[])localObject2, 0, n, "UTF-8");
/* 300 */           if (a(str4)) {
/* 301 */             return str4;
/*     */           }
/*     */         }
/*     */       }
/* 305 */       byte[] arrayOfByte = paramString2.getBytes("UTF-8");
/* 306 */       localRandomAccessFile.setLength(0L);
/* 307 */       localRandomAccessFile.write(arrayOfByte);
/* 308 */       return paramString2;
/*     */     }
/*     */     catch (Exception localException1) {}finally
/*     */     {
/*     */       try
/*     */       {
/* 314 */         if (localFileLock != null) {
/* 315 */           localFileLock.release();
/*     */         }
/*     */       }
/*     */       catch (Exception localException10) {}
/*     */       try {
/* 320 */         if (localRandomAccessFile != null) {
/* 321 */           localRandomAccessFile.close();
/*     */         }
/*     */       }
/*     */       catch (Exception localException11) {}
/*     */     }
/* 326 */     return paramString2;
/*     */   }
/*     */   
/*     */   private static boolean a(String paramString)
/*     */   {
/* 331 */     if (paramString == null)
/* 332 */       return false;
/* 333 */     int m = paramString.length();
/* 334 */     if ((m < 13) || (m > 128))
/* 335 */       return false;
/* 336 */     for (int n = 0; n < m; n++) {
/* 337 */       int i1 = paramString.charAt(n);
/* 338 */       if (((i1 < 48) || (i1 > 57)) && ((i1 < 97) || (i1 > 102)) && ((i1 < 65) || (i1 > 70)) && (i1 != 45))
/* 339 */         return false;
/*     */     }
/* 341 */     return true;
/*     */   }
/*     */   
/*     */   private static String a() {
/* 345 */     StringBuilder localStringBuilder = new StringBuilder();
/*     */     
/*     */ 
/*     */     try
/*     */     {
/* 350 */       if (ToolUtils.c()) {
/* 351 */         localStringBuilder.append("MIUI-");
/* 352 */       } else if (ToolUtils.d()) {
/* 353 */         localStringBuilder.append("FLYME-");
/*     */       } else {
/* 355 */         String str = ToolUtils.b();
/* 356 */         if (ToolUtils.a(str)) {
/* 357 */           localStringBuilder.append("EMUI-");
/*     */         }
/* 359 */         if (!TextUtils.isEmpty(str)) {
/* 360 */           localStringBuilder.append(str).append("-");
/*     */         }
/*     */       }
/* 363 */       localStringBuilder.append(Build.VERSION.INCREMENTAL);
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/* 366 */     return localStringBuilder.toString();
/*     */   }
/*     */   
/*     */   private static String b() {
/* 370 */     String str1 = "/proc/version";
/*     */     try
/*     */     {
/* 373 */       FileReader localFileReader = new FileReader(str1);
/* 374 */       BufferedReader localBufferedReader = new BufferedReader(localFileReader, 8192);
/*     */       
/* 376 */       String[] arrayOfString = localBufferedReader.readLine().split("\\s+");
/* 377 */       if ((arrayOfString == null) || (arrayOfString.length < 6)) {
/* 378 */         return "";
/*     */       }
/* 380 */       StringBuilder localStringBuilder = new StringBuilder();
/* 381 */       for (int m = arrayOfString.length - 1; (m >= arrayOfString.length - 6) && (m >= 0); m--) {
/* 382 */         localStringBuilder.insert(0, arrayOfString[m] + " ");
/*     */       }
/* 384 */       localBufferedReader.close();
/* 385 */       String str2 = localStringBuilder.toString().trim();
/* 386 */       SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE MMM TTSplashAdImpl HH:mm:ss z yyyy", Locale.US);
/* 387 */       localSimpleDateFormat.parse(str2);
/* 388 */       return str2;
/*     */     } catch (Exception localException) {
/* 390 */       localException.printStackTrace();
/*     */     }
/* 392 */     return "";
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\i.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */