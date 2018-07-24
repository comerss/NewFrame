/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.c;
/*     */ 
/*     */ import android.annotation.TargetApi;
/*     */ import android.content.Context;
/*     */ import android.content.SharedPreferences;
/*     */ import android.content.SharedPreferences.Editor;
/*     */ import android.os.AsyncTask;
/*     */ import android.os.AsyncTask.Status;
/*     */ import android.os.Build.VERSION;
/*     */ import android.text.TextUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class h
/*     */ {
/*     */   static String a;
/*  30 */   private static AsyncTask<Void, Integer, Void> b = null;
/*     */   
/*  32 */   public static void a(Context paramContext, final b paramb) { if (TextUtils.isEmpty(a)) {
/*  33 */       return;
/*     */     }
/*  35 */     if ((b != null) && 
/*  36 */       (b.getStatus() != Status.FINISHED)) {
/*  37 */       b.cancel(true);
/*     */     }
/*  39 */     Context localContext = paramContext.getApplicationContext();
/*     */     try {
/*  41 */       b = new AsyncTask()
/*     */       {
/*     */         protected Void a(Void... paramAnonymousVarArgs)
/*     */         {
/*  45 */           synchronized (h.a) {
/*  46 */             SharedPreferences localSharedPreferences = this.a.getSharedPreferences(h.a, 0);
/*     */             
/*  48 */             Editor localEditor = localSharedPreferences.edit();
/*  49 */             if (paramb != null) {
/*  50 */               paramb.a(localEditor);
/*     */             }
/*  52 */             h.c.a(localEditor);
/*     */           }
/*  54 */           return null;
/*     */         }
/*     */         
/*  57 */       };
/*  58 */       b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/*     */   }
/*     */   
/*     */ 
/*  64 */   private static AsyncTask<Void, Integer, Void> c = null;
/*     */   
/*  66 */   public static void a(Context paramContext, final a parama) { if (TextUtils.isEmpty(a)) {
/*  67 */       return;
/*     */     }
/*  69 */     if ((c != null) && 
/*  70 */       (c.getStatus() != Status.FINISHED)) {
/*  71 */       c.cancel(true);
/*     */     }
/*     */     try {
/*  74 */       c = new AsyncTask()
/*     */       {
/*     */         protected Void a(Void... paramAnonymousVarArgs) {
/*  77 */           synchronized (h.a) {
/*  78 */             SharedPreferences localSharedPreferences = this.a.getSharedPreferences(h.a, 0);
/*     */             
/*  80 */             if (parama != null) {
/*  81 */               parama.a(localSharedPreferences);
/*     */             }
/*     */           }
/*  84 */           return null;
/*     */         }
/*  86 */       };
/*  87 */       c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/*     */   }
/*     */   
/*     */ 
/*     */   private static class c
/*     */   {
/*     */     static final b a;
/*     */     
/*     */     static abstract interface b
/*     */     {
/*     */       public abstract void a(Editor paramEditor);
/*     */     }
/*     */     
/*     */     static class a
/*     */       implements h.c.b
/*     */     {
/*     */       public void a(Editor paramEditor)
/*     */       {
/* 107 */         paramEditor.commit();
/*     */       }
/*     */     }
/*     */     
/*     */     static class c implements h.c.b
/*     */     {
/*     */       @TargetApi(9)
/*     */       public void a(Editor paramEditor)
/*     */       {
/* 116 */         paramEditor.apply();
/*     */       }
/*     */     }
/*     */     
/*     */     static
/*     */     {
/* 122 */       if (Build.VERSION.SDK_INT >= 9) {
/* 123 */         a = new c();
/*     */       } else {
/* 125 */         a = new a();
/*     */       }
/*     */     }
/*     */     
/*     */     public static void a(Editor paramEditor)
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
/*     */     public abstract void a(Editor paramEditor);
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\c\h.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */