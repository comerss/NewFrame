/*     */ package com.bytedance.sdk.openadsdk.ccccc;
/*     */ 
/*     */

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import com.bytedance.sdk.openadsdk.ccccc.asasa.b;
import com.bytedance.sdk.openadsdk.ggg.StringUtils;
import com.bytedance.sdk.openadsdk.ggg.r;

import java.io.File;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class s
/*     */ {
/*     */   public static boolean a(Context paramContext, long paramLong, int paramInt)
/*     */   {
/*  25 */     return a(paramContext, paramLong, paramInt, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean a(Context paramContext, long paramLong, int paramInt, String paramString)
/*     */   {
/*  33 */     Intent localIntent = a(paramContext, paramLong, paramString);
/*  34 */     if (localIntent == null) {
/*  35 */       Log.w("SsDownloadManager", "No intent built for " + paramLong);
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     localIntent.addFlags(paramInt);
/*     */     try {
/*  41 */       paramContext.startActivity(localIntent);
/*  42 */       return true;
/*     */     } catch (Throwable localThrowable) {
/*  44 */       Log.w("SsDownloadManager", "Failed to start " + localIntent + ": " + localThrowable); }
/*  45 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean a(Context paramContext, long paramLong, int[] paramArrayOfInt, String paramString)
/*     */   {
/*  54 */     Intent localIntent = a(paramContext, paramLong, paramString);
/*  55 */     if (localIntent == null) {
/*  56 */       Log.w("SsDownloadManager", "No intent built for " + paramLong);
/*  57 */       return false;
/*     */     }
/*  59 */     if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
/*  60 */       for (int k : paramArrayOfInt) {
/*  61 */         localIntent.addFlags(k);
/*     */       }
/*     */     }
/*     */     try {
/*  65 */       paramContext.startActivity(localIntent);
/*  66 */       return true;
/*     */     } catch (Throwable localThrowable) {
/*  68 */       Log.w("SsDownloadManager", "Failed to start " + localIntent + ": " + localThrowable); }
/*  69 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Intent a(Context paramContext, long paramLong, String paramString)
/*     */   {
/*  78 */     ImageUtils localf = ImageUtils.aaaaaa(paramContext);
/*  79 */     Cursor localCursor = localf.aaaaaa(new ImageUtils.fbbb().a(new long[] { paramLong }));
/*     */     try {
/*  81 */       if (!localCursor.moveToFirst()) {
/*  82 */         return null;
/*     */       }
/*  84 */       Object localObject1 = localCursor.getString(localCursor.getColumnIndexOrThrow("local_filename"));
/*  85 */       Intent localIntent; if (StringUtils.isEmpty((String)localObject1))
/*  86 */         return null;
/*     */       Object localObject2;
/*     */       Object localObject3;
/*  89 */       Object localObject4; if (r.c(paramContext, (String)localObject1)) {
/*  90 */         localObject2 = paramContext.getPackageManager();
/*  91 */         localObject3 = new File((String)localObject1);
/*  92 */         localObject4 = ((PackageManager)localObject2).getPackageArchiveInfo(((File)localObject3).getAbsolutePath(), PackageManager.GET_ACTIVITIES);
/*  93 */         String str = ((PackageInfo)localObject4).packageName;
/*  94 */         localIntent = ((PackageManager)localObject2).getLaunchIntentForPackage(str);
/*     */         
/*  96 */         b localb = n.a();
/*  97 */         if (localb != null) {
/*  98 */           localb.a(paramLong, 2, paramString);
/*     */         }
/* 100 */       } else if ((!StringUtils.isEmpty(paramString)) && (r.b(paramContext, paramString))) {
/* 101 */         localObject2 = paramContext.getPackageManager();
/* 102 */         localIntent = ((PackageManager)localObject2).getLaunchIntentForPackage(paramString);
/* 103 */         localObject3 = n.a();
/* 104 */         if (localObject3 != null) {
/* 105 */           ((b)localObject3).a(paramLong, 2, paramString);
/*     */         }
/*     */       } else {
/* 108 */         localObject2 = b(localCursor, "local_uri");
/* 109 */         localObject3 = a(localCursor, "media_type");
/* 110 */         if ((localObject2 == null) || (localObject3 == null) || (!new File((String)localObject1).exists())) {
/* 111 */           return null;
/*     */         }
/* 113 */         localIntent = new Intent("android.intent.action.VIEW");
/* 114 */         if ("application/vnd.android.package-archive".equals(localObject3))
/*     */         {
/* 116 */           localIntent.setDataAndType((Uri)localObject2, (String)localObject3);
/* 117 */         } else if ("file".equals(((Uri)localObject2).getScheme()))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 123 */           localIntent.setDataAndType((Uri)localObject2, (String)localObject3);
/*     */         }
/*     */         else {
/* 126 */           localIntent.setDataAndType((Uri)localObject2, (String)localObject3);
/*     */         }
/*     */         
/* 129 */         localObject4 = n.a();
/* 130 */         if (localObject4 != null) {
/* 131 */           ((b)localObject4).a(paramLong, 3, paramString);
/*     */         }
/*     */         
/* 134 */         if (Build.VERSION.SDK_INT >= 24) {
/* 135 */           localIntent.addFlags(1);
/*     */         }
/*     */       }
/* 138 */       return localIntent;
/*     */     } catch (Exception localException1) {
/* 140 */       localException1.printStackTrace();
/*     */     } finally {
/*     */       try {
/* 143 */         if (localCursor != null) {
/* 144 */           localCursor.close();
/*     */         }
/*     */       }
/*     */       catch (Exception localException7) {}
/*     */     }
/*     */     
/* 150 */     return null;
/*     */   }
/*     */   
/*     */   private static String a(Cursor paramCursor, String paramString) {
/* 154 */     return paramCursor.getString(paramCursor.getColumnIndexOrThrow(paramString));
/*     */   }
/*     */   
/*     */   private static Uri b(Cursor paramCursor, String paramString) {
/*     */     try {
/* 159 */       return Uri.parse(a(paramCursor, paramString));
/*     */     } catch (NullPointerException localNullPointerException) {}
/* 161 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\cdsss\s.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */