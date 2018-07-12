/*     */ package com.ss.android.crash.log;
/*     */ 
/*     */

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class f
/*     */ {
/*     */   private Application a;
/*     */   private Context b;
/*  22 */   private List<String> c = new ArrayList();
/*  23 */   private List<String> d = new ArrayList();
/*     */   private String e;
/*     */   private String f;
/*     */   private a g;
/*     */   
/*  28 */   f(Context paramContext, a parama) { this.a = ((Application)paramContext.getApplicationContext());
/*  29 */     this.b = paramContext.getApplicationContext();
/*  30 */     this.g = parama;
/*  31 */     e(); }
/*     */   
/*  33 */   private final Application.ActivityLifecycleCallbacks h = new Application.ActivityLifecycleCallbacks()
/*     */   {
/*     */     public void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
/*     */     {
/*  37 */       String var3 = paramAnonymousActivity.getClass().getName();
    f.this.c.add(var3);
    f.this.e = var3 + "(" + System.currentTimeMillis() + ")";
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void onActivityStarted(Activity paramAnonymousActivity) {}
/*     */     
/*     */ 
/*     */     public void onActivityResumed(Activity var1) {
    String var2 = var1.getClass().getName();
    f.this.f = var2 + "(" + System.currentTimeMillis() + ")";
    if (f.this.g != null) {
        f.this.g.a();
    }

}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public void onActivityPaused(Activity paramAnonymousActivity) {}
/*     */     
/*     */ 
/*     */ 
/*     */     public void onActivityStopped(Activity paramAnonymousActivity) {}
/*     */     
/*     */ 
/*     */ 
/*     */     public void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
/*     */     
/*     */ 
/*     */ 
/*     */     public void onActivityDestroyed(Activity paramAnonymousActivity)
/*     */     {
/*  73 */         String var2 = paramAnonymousActivity.getClass().getName();
    f.this.c.remove(var2);
    f.this.d.add(var2);
/*     */     }
/*     */   };
/*     */   
/*  79 */   private void e() { if (Build.VERSION.SDK_INT >= 14)
/*  80 */       this.a.registerActivityLifecycleCallbacks(this.h);
/*     */   }
/*     */   
/*     */   public String a() {
/*  84 */     if ((this.c == null) || (this.c.isEmpty())) {
/*  85 */       return "";
/*     */     }
/*     */     try {
/*  88 */       StringBuilder localStringBuilder = new StringBuilder();
/*  89 */       int i = 0;
/*  90 */       for (String str : this.c) {
/*  91 */         if (i < this.c.size() - 1) {
/*  92 */           localStringBuilder.append(str).append("|");
/*     */         } else {
/*  94 */           localStringBuilder.append(str);
/*     */         }
/*  96 */         i++;
/*     */       }
/*  98 */       return localStringBuilder.toString();
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/*     */     
/* 102 */     return "";
/*     */   }
/*     */   
/* 105 */   public String b() { return this.e; }
/*     */   
/*     */   public String c() {
/* 108 */     return this.f;
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
/*     */   public String d()
/*     */   {
/* 134 */     if (this.b == null)
/* 135 */       return "";
/*     */     String str;
/*     */     StringBuilder localStringBuilder;
/* 138 */     try { ActivityManager localActivityManager = (ActivityManager)this.b.getSystemService("activity");
/* 139 */       List<ActivityManager.RunningTaskInfo> localList = localActivityManager.getRunningTasks(5);
/* 140 */       if (localList == null)
/* 141 */         return "";
/* 142 */       str = this.b.getPackageName();
/* 143 */       localStringBuilder = new StringBuilder();
/* 144 */       for (ActivityManager.RunningTaskInfo localRunningTaskInfo : localList) {
/* 145 */         if ((localRunningTaskInfo != null) && (localRunningTaskInfo.baseActivity != null) && 
/* 146 */           (str.equals(localRunningTaskInfo.baseActivity.getPackageName())))
/*     */         {
/*     */ 
/* 149 */           localStringBuilder.append("id = ").append(localRunningTaskInfo.id).append(" ");
/* 150 */           localStringBuilder.append("description = ").append(localRunningTaskInfo.description).append(" ");
/* 151 */           localStringBuilder.append("number_of_activities = ").append(localRunningTaskInfo.numActivities).append(" ");
/* 152 */           localStringBuilder.append("number_of_running_activities = ").append(localRunningTaskInfo.numRunning).append(" ");
/* 153 */           localStringBuilder.append("topActivity = ").append(localRunningTaskInfo.topActivity.toString()).append(" ");
/* 154 */           localStringBuilder.append("baseActivity = ").append(localRunningTaskInfo.baseActivity.toString());
/* 155 */           return localStringBuilder.toString();
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/* 160 */     return "";
/*     */   }
/*     */   
/*     */   public static abstract interface a
/*     */   {
/*     */     public abstract void a();
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\ss\android\crash\log\doErrorHelper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */