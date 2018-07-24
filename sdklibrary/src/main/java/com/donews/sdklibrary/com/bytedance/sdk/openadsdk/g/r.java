/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.g;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.app.ActivityManager;
/*     */ import android.app.ActivityManager.RunningAppProcessInfo;
/*     */ import android.app.ActivityManager.RunningTaskInfo;
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.pm.PackageInfo;
/*     */ import android.content.pm.PackageManager;
/*     */ import android.content.pm.PackageManager.NameNotFoundException;
/*     */ import android.net.ConnectivityManager;
/*     */ import android.net.NetworkInfo;
/*     */ import android.net.Uri;
/*     */ import android.os.Build;
/*     */ import android.os.Build.VERSION;
/*     */ import android.support.annotation.NonNull;
/*     */ import android.support.annotation.Nullable;
/*     */ import android.text.TextUtils;
/*     */ import android.view.View;
/*     */ import android.webkit.WebSettings;
/*     */ import com.bytedance.sdk.openadsdk.core.d.h;
/*     */ import com.bytedance.sdk.openadsdk.core.n;
/*     */ import com.bytedance.sdk.openadsdk.core.o;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class r
/*     */ {
/*     */   public static Intent a(Context paramContext, String paramString)
/*     */   {
/*  80 */     Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
/*  81 */     if (localIntent == null) {
/*  82 */       return null;
/*     */     }
/*     */     
/*  85 */     if (!localIntent.hasCategory("android.intent.category.LAUNCHER")) {
/*  86 */       localIntent.addCategory("android.intent.category.LAUNCHER");
/*     */     }
/*     */     
/*     */ 
/*  90 */     localIntent.setPackage(null);
/*  91 */     localIntent.addFlags(2097152);
/*  92 */     localIntent.addFlags(268435456);
/*  93 */     return localIntent;
/*     */   }
/*     */   
/*     */   public static boolean b(Context paramContext, String paramString) {
/*  97 */     boolean bool = false;
/*  98 */     if ((null != paramContext) && (!q.a(paramString))) {
/*  99 */       PackageManager localPackageManager = paramContext.getPackageManager();
/*     */       try {
/* 101 */         if (localPackageManager.getPackageInfo(paramString, 0) != null) {
/* 102 */           bool = true;
/*     */         }
/*     */       }
/*     */       catch (Exception localException) {}
/*     */     }
/* 107 */     return bool;
/*     */   }
/*     */   
/*     */   public static boolean a(Context paramContext, Intent paramIntent) {
/* 111 */     if (paramIntent == null) {
/* 112 */       return false;
/*     */     }
/* 114 */     PackageManager localPackageManager = paramContext.getPackageManager();
/* 115 */     List localList = localPackageManager.queryIntentActivities(paramIntent, 65536);
/*     */     
/* 117 */     if ((localList != null) && (localList.size() > 0)) {
/* 118 */       return true;
/*     */     }
/* 120 */     return false;
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
/*     */   public static boolean a()
/*     */   {
/* 162 */     boolean bool = false;
/*     */     
/*     */ 
/*     */     try
/*     */     {
/* 167 */       bool = ((!q.a(Build.BRAND)) && (Build.BRAND.toLowerCase().startsWith("huawei"))) || ((!q.a(Build.MANUFACTURER)) && (Build.MANUFACTURER.toLowerCase().startsWith("huawei")));
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/*     */     
/* 171 */     return bool;
/*     */   }
/*     */   
/*     */   public static boolean a(String paramString) {
/* 175 */     if (TextUtils.isEmpty(paramString)) {
/* 176 */       paramString = b();
/*     */     }
/* 178 */     if ((!TextUtils.isEmpty(paramString)) && 
/* 179 */       (paramString.toLowerCase().startsWith("emotionui"))) {
/* 180 */       return true;
/*     */     }
/* 182 */     if (a()) {
/* 183 */       return true;
/*     */     }
/* 185 */     return false;
/*     */   }
/*     */   
/*     */   public static String b() {
/* 189 */     return c("ro.build.version.emui");
/*     */   }
/*     */   
/*     */   private static String c(String paramString) {
/* 193 */     str1 = null;
/* 194 */     BufferedReader localBufferedReader = null;
/*     */     try {
/* 196 */       Process localProcess = Runtime.getRuntime().exec("getprop " + paramString);
/*     */       
/* 198 */       localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()), 1024);
/* 199 */       str1 = localBufferedReader.readLine();
/* 200 */       localBufferedReader.close();
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
/* 213 */       return str1;
/*     */     }
/*     */     catch (Throwable localThrowable)
/*     */     {
/* 202 */       m.a("ToolUtils", "Unable to read sysprop " + paramString, localThrowable);
/* 203 */       return str1;
/*     */     } finally {
/* 205 */       if (localBufferedReader != null) {
/*     */         try {
/* 207 */           localBufferedReader.close();
/*     */         } catch (IOException localIOException3) {
/* 209 */           m.a("ToolUtils", "Exception while closing InputStream", localIOException3);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/* 217 */   public static boolean a = false;
/* 218 */   public static boolean b = false;
/*     */   
/* 220 */   public static boolean c() { if (!b) {
/*     */       try {
/* 222 */         Class localClass = Class.forName("miui.os.Build");
/* 223 */         if (localClass != null) {
/* 224 */           a = true;
/* 225 */           b = true;
/* 226 */           return a;
/*     */         }
/*     */       }
/*     */       catch (Exception localException) {}
/*     */       
/* 231 */       b = true;
/*     */     }
/* 233 */     return a;
/*     */   }
/*     */   
/*     */   public static boolean d() {
/* 237 */     if ((Build.DISPLAY.indexOf("Flyme") >= 0) || (Build.USER.equals("flyme")))
/* 238 */       return true;
/* 239 */     return false;
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
/*     */   public static boolean c(Context paramContext, String paramString)
/*     */   {
/* 418 */     boolean bool = false;
/* 419 */     if ((paramContext == null) || (paramString == null) || (q.a(paramString))) {
/* 420 */       return bool;
/*     */     }
/*     */     try {
/* 423 */       File localFile = new File(paramString);
/* 424 */       if (localFile.exists()) {
/* 425 */         PackageManager localPackageManager = paramContext.getPackageManager();
/* 426 */         PackageInfo localPackageInfo1 = localPackageManager.getPackageArchiveInfo(localFile.getAbsolutePath(), 1);
/* 427 */         if (localPackageInfo1 == null) {
/* 428 */           return bool;
/*     */         }
/* 430 */         String str = localPackageInfo1.packageName;
/* 431 */         int i = localPackageInfo1.versionCode;
/* 432 */         PackageInfo localPackageInfo2 = null;
/*     */         try {
/* 434 */           localPackageInfo2 = paramContext.getPackageManager().getPackageInfo(str, 1);
/*     */         }
/*     */         catch (NameNotFoundException localNameNotFoundException) {
/* 437 */           localPackageInfo2 = null;
/*     */         }
/* 439 */         if (localPackageInfo2 == null) {
/* 440 */           bool = false;
/*     */         } else {
/* 442 */           int j = localPackageInfo2.versionCode;
/* 443 */           if (i <= j) {
/* 444 */             bool = true;
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception localException) {
/* 449 */       localException.printStackTrace();
/*     */     }
/* 451 */     return bool;
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
/* 462 */   private static String c = null;
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
/*     */   public static boolean d(Context paramContext, String paramString)
/*     */   {
/* 521 */     if ((paramContext == null) || (q.a(paramString))) {
/* 522 */       return false;
/*     */     }
/* 524 */     ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
/* 525 */     List localList; Object localObject; if (VERSION.SDK_INT < 21) {
/* 526 */       localList = localActivityManager.getRunningTasks(1);
/* 527 */       if (!localList.isEmpty()) {
/* 528 */         localObject = ((RunningTaskInfo)localList.get(0)).topActivity;
/* 529 */         if ((localObject != null) && (paramString.equals(((ComponentName)localObject).getPackageName()))) {
/* 530 */           return true;
/*     */         }
/*     */       }
/*     */     } else {
/* 534 */       localList = localActivityManager.getRunningAppProcesses();
/* 535 */       for (localObject = localList.iterator(); ((Iterator)localObject).hasNext();) { RunningAppProcessInfo localRunningAppProcessInfo = (RunningAppProcessInfo)((Iterator)localObject).next();
/* 536 */         if (localRunningAppProcessInfo.importance == 100) {
/* 537 */           return paramString.equals(localRunningAppProcessInfo.pkgList[0]);
/*     */         }
/*     */       }
/*     */     }
/* 541 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean e(Context paramContext, String paramString)
/*     */   {
/* 550 */     if ((paramContext == null) || (q.a(paramString))) {
/* 551 */       return false;
/*     */     }
/*     */     try {
/* 554 */       Uri localUri = Uri.parse("tel:" + Uri.encode(paramString));
/* 555 */       Intent localIntent = new Intent("android.intent.action.DIAL", localUri);
/* 556 */       if (!(paramContext instanceof Activity)) {
/* 557 */         localIntent.setFlags(268435456);
/*     */       }
/* 559 */       paramContext.startActivity(localIntent);
/* 560 */       return true;
/*     */     }
/*     */     catch (Exception localException) {}
/*     */     
/* 564 */     return false;
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
/*     */   public static boolean a(Context paramContext)
/*     */   {
/*     */     try
/*     */     {
/* 647 */       ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
/* 648 */       NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
/* 649 */       return (localNetworkInfo != null) && (localNetworkInfo.isAvailable());
/*     */     }
/*     */     catch (Exception localException) {}
/*     */     
/* 653 */     return false;
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
/*     */   @Nullable
/*     */   public static String b(Context paramContext)
/*     */   {
/* 672 */     if (paramContext == null) {
/* 673 */       return null;
/*     */     }
/* 675 */     String str1 = paramContext.getPackageName();
/*     */     try {
/* 677 */       return paramContext.getPackageManager().getPackageInfo(str1, 0).versionName + "";
/*     */     }
/*     */     catch (Exception localException) {}
/*     */     
/* 681 */     return null;
/*     */   }
/*     */   
/*     */   public static String a(long paramLong, String paramString) throws ParseException
/*     */   {
/* 686 */     Date localDate = b(paramLong, paramString);
/* 687 */     return a(localDate, paramString);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Date b(long paramLong, String paramString)
/*     */     throws ParseException
/*     */   {
/* 698 */     Date localDate = new Date(paramLong);
/* 699 */     String str = a(localDate, paramString);
/* 700 */     return a(str, paramString);
/*     */   }
/*     */   
/*     */   public static String a(Date paramDate, String paramString) {
/* 704 */     return new SimpleDateFormat(paramString).format(paramDate);
/*     */   }
/*     */   
/*     */ 
/*     */   public static Date a(String paramString1, String paramString2)
/*     */     throws ParseException
/*     */   {
/* 711 */     SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(paramString2);
/* 712 */     return localSimpleDateFormat.parse(paramString1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String a(int paramInt)
/*     */   {
/* 721 */     switch (paramInt) {
/*     */     case 1: 
/* 723 */       return "embeded_ad_landingpage";
/*     */     case 2: 
/* 725 */       return "banner_ad_landingpage";
/*     */     case 3: 
/* 727 */       return "interaction_landingpage";
/*     */     case 4: 
/* 729 */       return "splash_ad_landingpage";
/*     */     }
/* 731 */     return null;
/*     */   }
/*     */   
/*     */   public static JSONObject b(String paramString)
/*     */   {
/* 736 */     JSONObject localJSONObject = null;
/* 737 */     if (paramString != null) {
/*     */       try {
/* 739 */         localJSONObject = new JSONObject(paramString);
/*     */       } catch (JSONException localJSONException) {
/* 741 */         localJSONException.printStackTrace();
/*     */       }
/*     */     }
/* 744 */     return localJSONObject;
/*     */   }
/*     */   
/*     */   public static void a(@NonNull h paramh, @NonNull View paramView) {
/* 748 */     JSONObject localJSONObject = b(paramh.o());
/* 749 */     if (localJSONObject != null) {
/* 750 */       int i = localJSONObject.optInt("rit", 0);
/* 751 */       String str = localJSONObject.optString("req_id", "");
/* 752 */       n.c().a(i, str, paramh.l(), s.d(paramView.getRootView()));
/*     */     }
/*     */   }
/*     */   
/*     */   public static String e() {
/* 757 */     String str = "";
/* 758 */     if (VERSION.SDK_INT >= 17) {
/*     */       try {
/* 760 */         str = WebSettings.getDefaultUserAgent(n.a());
/*     */       } catch (Exception localException) {
/* 762 */         str = System.getProperty("http.agent");
/*     */       }
/*     */     } else {
/* 765 */       str = System.getProperty("http.agent");
/*     */     }
/* 767 */     StringBuffer localStringBuffer = new StringBuffer();
/* 768 */     if (str == null) {
/* 769 */       return "";
/*     */     }
/* 771 */     int i = 0; for (int j = str.length(); i < j; i++) {
/* 772 */       char c1 = str.charAt(i);
/* 773 */       if ((c1 <= '\037') || (c1 >= '')) {
/* 774 */         localStringBuffer.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c1) }));
/*     */       } else {
/* 776 */         localStringBuffer.append(c1);
/*     */       }
/*     */     }
/* 779 */     return localStringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\g\r.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */