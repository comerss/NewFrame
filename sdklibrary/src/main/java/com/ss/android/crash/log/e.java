/*     */ package com.ss.android.crash.log;
/*     */ 
/*     */ import android.app.ActivityManager;
/*     */ import android.app.ActivityManager.RunningAppProcessInfo;
/*     */ import android.app.ActivityManager.RunningTaskInfo;
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.os.Build.VERSION;
/*     */ import android.os.Looper;
/*     */ import android.text.TextUtils;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ public class e
/*     */ {
/*     */   public static void a(long paramLong)
/*     */   {
/*  25 */     if (paramLong <= 0L)
/*  26 */       throw new IllegalArgumentException("duration not be minus");
/*     */     try {
/*  28 */       TimeUnit.MILLISECONDS.sleep(paramLong);
/*     */     } catch (InterruptedException localInterruptedException) {
/*  30 */       localInterruptedException.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public static JSONObject a() throws JSONException
/*     */   {
/*  36 */     Map localMap = Thread.getAllStackTraces();
/*  37 */     if ((localMap == null) || (localMap.size() <= 0))
/*  38 */       return null;
/*  39 */     JSONObject localJSONObject1 = new JSONObject();
/*  40 */     localJSONObject1.put("thread_number", localMap.size());
/*  41 */     int i = 0;
/*  42 */     JSONArray localJSONArray = new JSONArray();
/*  43 */     int j = 0;
/*  44 */     for (Map.Entry localEntry : localMap.entrySet()) {
/*  45 */       j++;
/*  46 */       if (j > 5L)
/*     */         break;
/*  48 */       JSONObject localJSONObject2 = new JSONObject();
/*  49 */       StringBuilder localStringBuilder = new StringBuilder();
/*  50 */       for (StackTraceElement localStackTraceElement : (StackTraceElement[])localEntry.getValue()) {
/*  51 */         if (localStringBuilder.length() > 15000)
/*     */           break;
/*  53 */         localStringBuilder.append(localStackTraceElement.toString()).append("\n");
/*     */       }
/*     */       try {
/*  56 */         if (((Thread)localEntry.getKey()).getName().equalsIgnoreCase("main")) {
/*  57 */           localJSONObject1.put("mainStackFromTrace", localStringBuilder.toString());
/*  58 */           i = 1;
/*     */         }
/*  60 */         localJSONObject2.put("id", ((Thread)localEntry.getKey()).getId());
/*  61 */         localJSONObject2.put("name", ((Thread)localEntry.getKey()).getName());
/*  62 */         localJSONObject2.put("stack", localStringBuilder.toString());
/*     */       } catch (JSONException localJSONException) {
/*  64 */         localJSONException.printStackTrace();
/*     */       }
/*  66 */       localJSONArray.put(localJSONObject2);
/*     */     }
/*  68 */     if (i == 0) {
/*  69 */       localJSONObject1.put("mainStackFromTrace", b());
/*     */     }
/*  71 */     localJSONObject1.put("allThreadStack", localJSONArray);
/*  72 */     localJSONObject1.put("anrTime", System.currentTimeMillis());
/*  73 */     return localJSONObject1;
/*     */   }
/*     */   
/*     */   private static String b() {
/*  77 */     StringBuilder localStringBuilder = new StringBuilder();
/*  78 */     StackTraceElement[] arrayOfStackTraceElement1 = Looper.getMainLooper().getThread().getStackTrace();
/*  79 */     for (StackTraceElement localStackTraceElement : arrayOfStackTraceElement1) {
/*  80 */       String str = localStackTraceElement.getClassName();
/*  81 */       localStringBuilder.append(str).append(".").append(localStackTraceElement.getMethodName())
/*  82 */         .append("(").append(localStackTraceElement.getFileName()).append(":")
/*  83 */         .append(localStackTraceElement.getLineNumber()).append(")\n");
/*     */     }
/*  85 */     return localStringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static boolean a(Context paramContext, String paramString) {
/*  89 */     if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
/*  90 */       return false;
/*     */     Object localObject;
/*     */     try {
/*  93 */       ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
/*  94 */       List localList; if (Build.VERSION.SDK_INT < 21) {
/*  95 */         localList = localActivityManager.getRunningTasks(1);
/*  96 */         if (!localList.isEmpty()) {
/*  97 */           localObject = ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity;
/*  98 */           if ((localObject != null) && (paramString.equals(((ComponentName)localObject).getPackageName()))) {
/*  99 */             return true;
/*     */           }
/*     */         }
/*     */       } else {
/* 103 */         localList = localActivityManager.getRunningAppProcesses();
/* 104 */         for (localObject = localList.iterator(); ((Iterator)localObject).hasNext();) { ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
/* 105 */           if (localRunningAppProcessInfo.importance == 100) {
/* 106 */             return paramString.equals(localRunningAppProcessInfo.pkgList[0]);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/*     */     
/* 113 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\ss\android\crash\log\eee.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */