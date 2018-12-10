/*     */ package com.bytedance.sdk.openadsdk.ccccc;
/*     */ 
/*     */

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
/*     */ 
/*     */ class h
/*     */ {
/*     */   static String a;
/*  30 */   private static AsyncTask<Void, Integer, Void> sAsyncTask = null;
/*     */   
/*  32 */   public static void a(final Context paramContext, final b paramb) { if (TextUtils.isEmpty(a)) {
/*  33 */       return;
/*     */     }
/*  35 */     if ((sAsyncTask != null) &&
/*  36 */       (sAsyncTask.getStatus() != AsyncTask.Status.FINISHED)) {
/*  37 */       sAsyncTask.cancel(true);
/*     */     }
/*  39 */     Context localContext = paramContext.getApplicationContext();
/*     */     try {
/*  41 */       sAsyncTask = new AsyncTask()
/*     */       {
            @Override
            protected Object doInBackground(Object[] objects) {
                synchronized (h.a) {
                    /*  46 */             SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(h.a, 0);
                    /*     */
                    /*  48 */             SharedPreferences.Editor localEditor = localSharedPreferences.edit();
                    /*  49 */             if (paramb != null) {
                        /*  50 */               paramb.a(localEditor);
                        /*     */             }
                    /*  52 */             cccc.a(localEditor);
                    /*     */           }
                /*  54 */           return null;
            }
            /*     */
/*     */         
/*  57 */       };
/*  58 */       sAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/*     */   }
/*     */   
/*     */ 
/*  64 */   private static AsyncTask<Void, Integer, Void> sTask = null;
/*     */   
/*  66 */   public static void a(final Context paramContext, final a parama) { if (TextUtils.isEmpty(a)) {
/*  67 */       return;
/*     */     }
/*  69 */     if ((sTask != null) &&
/*  70 */       (sTask.getStatus() != AsyncTask.Status.FINISHED)) {
/*  71 */       sTask.cancel(true);
/*     */     }
/*     */     try {
/*  74 */       sTask = new AsyncTask()
/*     */       {
            @Override
            protected Object doInBackground(Object[] objects) {
                synchronized (h.a) {
                    /*  78 */             SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(h.a, 0);
                    /*     */
                    /*  80 */             if (parama != null) {
                        /*  81 */               parama.a(localSharedPreferences);
                        /*     */             }
                    /*     */           }
                /*  84 */           return null;
            }
            /*     */
/*  86 */       };
/*  87 */       sTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/*     */   }
/*     */   
/*     */ 
/*     */   private static class cccc
/*     */   {
/*     */     static final b a;
/*     */     
/*     */     static abstract interface b
/*     */     {
/*     */       public abstract void a(SharedPreferences.Editor paramEditor);
/*     */     }
/*     */     
/*     */     static class a
/*     */       implements cccc.b
/*     */     {
/*     */       public void a(SharedPreferences.Editor paramEditor)
/*     */       {
/* 107 */         paramEditor.commit();
/*     */       }
/*     */     }
/*     */     
/*     */     static class ccccc implements cccc.b
/*     */     {
/*     */       @TargetApi(9)
/*     */       public void a(SharedPreferences.Editor paramEditor)
/*     */       {
/* 116 */         paramEditor.apply();
/*     */       }
/*     */     }
/*     */     
/*     */     static
/*     */     {
/* 122 */       if (Build.VERSION.SDK_INT >= 9) {
/* 123 */         a = new ccccc();
/*     */       } else {
/* 125 */         a = new a();
/*     */       }
/*     */     }
/*     */     
/*     */     public static void a(SharedPreferences.Editor paramEditor)
/*     */     {
/* 131 */       if (paramEditor == null)
/* 132 */         return;
/* 133 */       a.a(paramEditor);
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract interface a
/*     */   {
/*     */     public abstract void a(SharedPreferences paramSharedPreferences);
/*     */   }
/*     */   
/*     */   public static abstract interface b
/*     */   {
/*     */     public abstract void a(SharedPreferences.Editor paramEditor);
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\cdsss\ImageHelper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */