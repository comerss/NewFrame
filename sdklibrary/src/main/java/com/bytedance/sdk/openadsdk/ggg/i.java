/*     */ package com.bytedance.sdk.openadsdk.ggg;
/*     */ 
/*     */ import android.content.Context;
/*     */
/*     */ import android.content.pm.PackageInfo;
/*     */ import android.content.pm.PackageManager;
/*     */ import android.support.annotation.MainThread;
/*     */ import android.support.annotation.NonNull;
/*     */ import android.support.annotation.Nullable;
/*     */ import android.support.annotation.WorkerThread;
/*     */ import android.text.TextUtils;
/*     */ import com.bytedance.sdk.openadsdk.core.c;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import org.json.JSONArray;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   @Nullable
/*     */   @MainThread
/*     */   public static JSONArray a(@NonNull Context paramContext, @NonNull ExecutorService paramExecutorService)
/*     */   {
/*  39 */     if (!e(paramContext)) {
/*  40 */       return null;
/*     */     }
/*  42 */     paramExecutorService.submit(new Runnable()
/*     */     {
/*     */       public void run() {
/*  45 */         i.a(this.a);
/*     */       }
/*  47 */     });
/*  48 */     return c(paramContext);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   private static List<String> b(Context paramContext)
/*     */   {
/*  58 */     PackageManager localPackageManager = paramContext.getPackageManager();
/*  59 */     List localList = null;
/*     */     try {
/*  61 */       localList = localPackageManager.getInstalledPackages(8192);
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/*     */     
/*  65 */     if (k.a(localList)) {
/*  66 */       return null;
/*     */     }
/*  68 */     ArrayList localArrayList = new ArrayList();
/*  69 */     if (k.b(localList)) {
/*  70 */       for (PackageInfo localPackageInfo : localList) {
/*  71 */         if ((localPackageInfo.applicationInfo.flags & 0x1) == 0)
/*     */         {
/*  73 */           String str = localPackageInfo.applicationInfo.loadLabel(localPackageManager).toString();
/*  74 */           localArrayList.add(str + ":" + localPackageInfo.packageName);
/*     */         }
/*     */       }
/*     */     }
/*  78 */     return localArrayList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   private static JSONArray c(Context paramContext)
/*     */   {
/*  88 */     c localc = c.a(paramContext);
/*  89 */     String str = localc.b("install_app_incremental_string", null);
/*  90 */     if (!TextUtils.isEmpty(str)) {
/*  91 */       List localList = a(str);
/*  92 */       return new JSONArray(localList);
/*     */     }
/*  94 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @WorkerThread
/*     */   private static void d(Context paramContext)
/*     */   {
/* 103 */     List localList1 = b(paramContext);
/* 104 */     if ((localList1 == null) || (localList1.isEmpty())) {
/* 105 */       return;
/*     */     }
/* 107 */     c localc = c.a(paramContext);
/* 108 */     String str = localc.b("install_app_string", null);
/* 109 */     List localList2 = a(str);
/* 110 */     a(paramContext, a(localList1));
/* 111 */     if ((localList2 != null) && (!localList2.isEmpty())) {
/* 112 */       localList1.removeAll(localList2);
/*     */     }
/* 114 */     b(paramContext, a(localList1));
/*     */   }
/*     */   
/*     */   @WorkerThread
/*     */   private static void a(Context paramContext, String paramString) {
/* 119 */     c localc = c.a(paramContext);
/* 120 */     localc.a("install_app_string", paramString);
/*     */   }
/*     */   
/*     */   @WorkerThread
/*     */   private static void b(Context paramContext, String paramString)
/*     */   {
/* 126 */     c localc = c.a(paramContext);
/* 127 */     localc.a("install_app_incremental_string", paramString);
/* 128 */     localc.a("apptime", System.currentTimeMillis());
/*     */   }
/*     */   
/*     */   private static boolean e(Context paramContext) {
/* 132 */     c localc = c.a(paramContext);
/* 133 */     long l = localc.b("apptime", -1L).longValue();
/* 134 */     return (l == -1L) || 
/* 135 */       (System.currentTimeMillis() - l > 43200000L);
/*     */   }
/*     */   
/*     */   private static List<String> a(String paramString) {
/* 139 */     if (TextUtils.isEmpty(paramString)) {
/* 140 */       return null;
/*     */     }
/* 142 */     String[] arrayOfString = paramString.split(",");
/* 143 */     return Arrays.asList(arrayOfString);
/*     */   }
/*     */   
/*     */   private static String a(List<String> paramList) {
/* 147 */     if ((paramList == null) || (paramList.isEmpty())) {
/* 148 */       return null;
/*     */     }
/* 150 */     StringBuilder localStringBuilder = new StringBuilder();
/* 151 */     for (int i = 0; i < paramList.size(); i++) {
/* 152 */       localStringBuilder.append((String)paramList.get(i));
/* 153 */       if (i != paramList.size() - 1) {
/* 154 */         localStringBuilder.append(",");
/*     */       }
/*     */     }
/* 157 */     return localStringBuilder.toString().trim();
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\g\i.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */