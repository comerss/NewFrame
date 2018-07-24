/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.service;
/*     */ 
/*     */ import android.annotation.SuppressLint;
/*     */ import android.annotation.TargetApi;
/*     */ import android.app.AlarmManager;
/*     */ import android.app.PendingIntent;
/*     */ import android.app.Service;
/*     */ import android.content.ContentResolver;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.database.ContentObserver;
/*     */ import android.database.Cursor;
/*     */ import android.net.Uri;
/*     */ import android.os.Build.VERSION;
/*     */ import android.os.Handler;
/*     */ import android.os.Handler.Callback;
/*     */ import android.os.HandlerThread;
/*     */ import android.os.IBinder;
/*     */ import android.os.Message;
/*     */ import android.os.Process;
/*     */ import android.text.TextUtils;
/*     */ import android.util.Log;
/*     */ import com.bytedance.sdk.openadsdk.c.b;
/*     */ import com.bytedance.sdk.openadsdk.c.d;
/*     */ import com.bytedance.sdk.openadsdk.c.d.b;
/*     */ import com.bytedance.sdk.openadsdk.c.g;
/*     */ import com.bytedance.sdk.openadsdk.c.i;
/*     */ import com.bytedance.sdk.openadsdk.c.j;
/*     */ import com.bytedance.sdk.openadsdk.c.m.a;
/*     */ import com.bytedance.sdk.openadsdk.c.p;
/*     */ import com.bytedance.sdk.openadsdk.c.t;
/*     */ import com.bytedance.sdk.openadsdk.c.v;
/*     */ import com.bytedance.sdk.openadsdk.c.w;
/*     */ import java.io.File;
/*     */ import java.io.FileDescriptor;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import java.util.concurrent.ThreadPoolExecutor;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @TargetApi(3)
/*     */ public class TTDownloadService
/*     */   extends Service
/*     */ {
/*     */   w a;
/*     */   private AlarmManager b;
/*     */   private v c;
/*     */   private a d;
/*     */   private g e;
/*     */   @SuppressLint({"UseSparseArrays"})
/*  88 */   private final Map<Long, d> f = new HashMap();
/*     */   
/*     */ 
/*  91 */   private final ExecutorService g = a();
/*     */   private j h;
/*     */   
/*     */   @TargetApi(9)
/*  95 */   private static ExecutorService a() { int m = 5;
/*     */     
/*     */ 
/*     */ 
/*  99 */     ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(5, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
/*     */     
/*     */ 
/* 102 */     if (Build.VERSION.SDK_INT >= 9) {
/* 103 */       localThreadPoolExecutor.allowCoreThreadTimeOut(true);
/*     */     }
/* 105 */     return localThreadPoolExecutor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private HandlerThread i;
/*     */   
/*     */ 
/*     */   public static void a(Context paramContext)
/*     */   {
/*     */     try
/*     */     {
/* 117 */       paramContext.startService(new Intent(paramContext, TTDownloadService.class));
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */ 
/*     */   private class a
/*     */     extends ContentObserver
/*     */   {
/*     */     public a()
/*     */     {
/* 128 */       super();
/*     */     }
/*     */     
/*     */     public void onChange(boolean paramBoolean)
/*     */     {
/* 133 */       TTDownloadService.a(TTDownloadService.this, false);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private Handler j;
/*     */   
/*     */   private volatile int k;
/*     */   
/*     */   public IBinder onBind(Intent paramIntent)
/*     */   {
/* 145 */     throw new UnsupportedOperationException("Cannot bind to Download Manager Service");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @TargetApi(3)
/*     */   public void onCreate()
/*     */   {
/* 154 */     super.onCreate();
/* 155 */     if (b.d) {
/* 156 */       Log.v("SsDownloadManager", "Service onCreate");
/*     */     }
/*     */     
/* 159 */     if (this.a == null) {
/* 160 */       this.a = t.a(this);
/*     */     }
/*     */     
/* 163 */     this.b = ((AlarmManager)getSystemService("alarm"));
/* 164 */     this.c = new v(this);
/*     */     
/* 166 */     this.i = new HandlerThread("SsDownloadManager-UpdateThread");
/* 167 */     this.i.start();
/* 168 */     this.j = new Handler(this.i.getLooper(), this.l);
/*     */     
/* 170 */     this.h = new j(this);
/*     */     
/* 172 */     this.e = g.a(this);
/* 173 */     this.e.a();
/*     */     
/* 175 */     this.d = new a();
/* 176 */     getContentResolver().registerContentObserver(m.a.a, true, this.d);
/*     */   }
/*     */   
/*     */ 
/*     */   @TargetApi(5)
/*     */   public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
/*     */   {
/* 183 */     int m = super.onStartCommand(paramIntent, paramInt1, paramInt2);
/* 184 */     if (b.d) {
/* 185 */       Log.v("SsDownloadManager", "Service onStart");
/*     */     }
/* 187 */     this.k = paramInt2;
/* 188 */     boolean bool = false;
/* 189 */     if (paramIntent != null) {
/* 190 */       bool = paramIntent.getBooleanExtra("isFirstStart", false);
/*     */     }
/* 192 */     a(bool);
/* 193 */     return m;
/*     */   }
/*     */   
/*     */   @TargetApi(5)
/*     */   public void onDestroy()
/*     */   {
/*     */     try {
/* 200 */       if (this.d != null) {
/* 201 */         getContentResolver().unregisterContentObserver(this.d);
/*     */       }
/* 203 */       if (this.h != null) {
/* 204 */         this.h.a();
/*     */       }
/* 206 */       if (this.i != null) {
/* 207 */         this.i.quit();
/*     */       }
/* 209 */       if (this.g != null) {
/* 210 */         this.g.shutdown();
/*     */       }
/* 212 */       if (b.d) {
/* 213 */         Log.v("SsDownloadManager", "Service onDestroy");
/*     */       }
/*     */     }
/*     */     catch (Exception localException) {}
/*     */     
/* 218 */     super.onDestroy();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void a(boolean paramBoolean)
/*     */   {
/* 225 */     this.j.removeMessages(1);
/* 226 */     this.j.obtainMessage(1, this.k, paramBoolean ? 1 : 0).sendToTarget();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void b()
/*     */   {
/* 235 */     this.j.removeMessages(2);
/* 236 */     this.j.sendMessageDelayed(this.j
/* 237 */       .obtainMessage(2, this.k, -1), 300000L);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 245 */   private Callback l = new Callback()
/*     */   {
/*     */     @TargetApi(5)
/*     */     public boolean handleMessage(Message paramAnonymousMessage) {
/* 249 */       Process.setThreadPriority(10);
/*     */       
/* 251 */       int i = paramAnonymousMessage.arg1;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       boolean bool;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 262 */       synchronized (TTDownloadService.a(TTDownloadService.this)) {
/* 263 */         int j = paramAnonymousMessage.arg2;
/* 264 */         bool = TTDownloadService.b(TTDownloadService.this, j > 0);
/*     */       }
/*     */       
/* 267 */       if (paramAnonymousMessage.what == 2)
/*     */       {
/*     */ 
/* 270 */         for (??? = Thread.getAllStackTraces().entrySet().iterator(); ((Iterator)???).hasNext();) { Entry localEntry = (Entry)((Iterator)???).next();
/* 271 */           if (((Thread)localEntry.getKey()).getName().startsWith("pool")) {
/* 272 */             Log.d("SsDownloadManager", localEntry.getKey() + ": " + Arrays.toString((Object[])localEntry.getValue()));
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 277 */         TTDownloadService.b(TTDownloadService.this).b();
/*     */         
/* 279 */         Log.w("SsDownloadManager", "Final update pass triggered, isActive=" + bool + "; someone didn't update correctly.");
/*     */       }
/*     */       
/*     */ 
/* 283 */       if (bool)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 289 */         TTDownloadService.c(TTDownloadService.this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 296 */       else if (TTDownloadService.this.stopSelfResult(i))
/*     */       {
/* 298 */         if (TTDownloadService.d(TTDownloadService.this) != null) {
/* 299 */           TTDownloadService.this.getContentResolver().unregisterContentObserver(TTDownloadService.d(TTDownloadService.this));
/*     */         }
/* 301 */         if (TTDownloadService.e(TTDownloadService.this) != null) {
/* 302 */           TTDownloadService.e(TTDownloadService.this).a();
/*     */         }
/* 304 */         if (TTDownloadService.f(TTDownloadService.this) != null) {
/* 305 */           TTDownloadService.f(TTDownloadService.this).quit();
/*     */         }
/* 307 */         if (TTDownloadService.g(TTDownloadService.this) != null) {
/* 308 */           TTDownloadService.g(TTDownloadService.this).shutdown();
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 313 */       return true;
/*     */     }
/*     */   };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean b(boolean paramBoolean)
/*     */   {
/* 330 */     long l1 = this.a.a();
/*     */     
/* 332 */     boolean bool1 = false;
/* 333 */     long l2 = Long.MAX_VALUE;
/*     */     
/* 335 */     HashSet localHashSet = new HashSet(this.f.keySet());
/*     */     
/* 337 */     i locali = i.a(getApplicationContext());
/* 338 */     Cursor localCursor = locali.a(m.a.a, null, null, null, null);
/*     */     
/* 340 */     d locald = null;
/*     */     try {
/* 342 */       d.b localb = new d.b(locali, localCursor);
/* 343 */       int m = localCursor.getColumnIndexOrThrow("_id");
/* 344 */       while (localCursor.moveToNext()) {
/* 345 */         long l3 = localCursor.getLong(m);
/* 346 */         localHashSet.remove(Long.valueOf(l3));
/*     */         
/* 348 */         locald = (d)this.f.get(Long.valueOf(l3));
/* 349 */         if (locald != null) {
/* 350 */           a(localb, locald, l1);
/*     */         } else {
/* 352 */           locald = a(localb, l1);
/*     */         }
/*     */         
/* 355 */         if (locald.w)
/*     */         {
/* 357 */           if (!TextUtils.isEmpty(locald.x)) {
/* 358 */             getContentResolver().delete(Uri.parse(locald.x), null, null);
/*     */           }
/* 360 */           this.f.remove(Long.valueOf(locald.a));
/* 361 */           a(locald.e);
/* 362 */           locali.a(locald.d(), null, null);
/* 363 */           this.e.a(g.a(locald));
/*     */         } else {
/* 365 */           locald.c();
/*     */           
/* 367 */           boolean bool2 = locald.a(this.g);
/*     */           
/*     */ 
/* 370 */           boolean bool3 = locald.a(this.h);
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 379 */           bool1 |= bool2;
/* 380 */           bool1 |= bool3;
/*     */         }
/*     */         
/*     */ 
/* 384 */         l2 = Math.min(locald.b(l1), l2);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       try
/*     */       {
/* 397 */         if (localCursor != null) {
/* 398 */           localCursor.close();
/*     */         }
/*     */       }
/*     */       catch (Exception localException1) {}
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 406 */       localObject1 = localHashSet.iterator();
/*     */     }
/*     */     catch (Exception localException2)
/*     */     {
/* 388 */       if ((locald != null) && (locald.w)) {
/* 389 */         this.f.remove(Long.valueOf(locald.a));
/* 390 */         a(locald.e);
/* 391 */         locali.a(locald.d(), null, null);
/* 392 */         this.e.a(g.a(locald));
/*     */       }
/* 394 */       localException2.printStackTrace();
/*     */     } finally {
/*     */       try {
/* 397 */         if (localCursor != null) {
/* 398 */           localCursor.close();
/*     */         }
/*     */       }
/*     */       catch (Exception localException4) {}
/*     */     }
/*     */     
/*     */     Object localObject1;
/*     */     
/* 406 */     while (((Iterator)localObject1).hasNext()) { Long localLong = (Long)((Iterator)localObject1).next();
/* 407 */       a(localLong.longValue());
/*     */     }
/*     */     
/*     */ 
/* 411 */     this.e.a(this.f.values(), paramBoolean);
/*     */     
/*     */ 
/*     */ 
/* 415 */     if ((l2 > 0L) && (l2 < Long.MAX_VALUE)) {
/* 416 */       if (b.c) {
/* 417 */         Log.v("SsDownloadManager", "scheduling start in " + l2 + "ms");
/*     */       }
/*     */       
/* 420 */       localObject1 = new Intent("android.ss.intent.action.DOWNLOAD_WAKEUP");
/* 421 */       ((Intent)localObject1).setClass(this, TTDownloadHandlerService.class);
/* 422 */       int n = 1;
/*     */       try {
/* 424 */         b.a(this.b, n, l1 + l2, 
/* 425 */           PendingIntent.getService(this, 0, (Intent)localObject1, 1073741824));
/*     */       }
/*     */       catch (Throwable localThrowable) {}
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 432 */     return bool1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private d a(d.b paramb, long paramLong)
/*     */   {
/* 440 */     d locald = paramb.a(this, this.a, this.c, this.e);
/*     */     
/* 442 */     this.f.put(Long.valueOf(locald.a), locald);
/*     */     
/* 444 */     if (b.d) {
/* 445 */       Log.v("SsDownloadManager", "processing inserted download " + locald.a);
/*     */     }
/*     */     
/* 448 */     return locald;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void a(d.b paramb, d paramd, long paramLong)
/*     */   {
/* 455 */     paramb.a(paramd);
/* 456 */     if (b.d) {
/* 457 */       Log.v("SsDownloadManager", "processing updated download " + paramd.a + ", status: " + paramd.j);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void a(long paramLong)
/*     */   {
/* 466 */     d locald = (d)this.f.get(Long.valueOf(paramLong));
/* 467 */     if (locald.j == 192) {
/* 468 */       locald.j = 490;
/*     */     }
/* 470 */     if ((locald.g != 0) && (locald.e != null)) {
/* 471 */       if (b.d) {
/* 472 */         Log.d("SsDownloadManager", "deleteDownloadLocked() deleting " + locald.e);
/*     */       }
/* 474 */       a(locald.e);
/*     */     }
/* 476 */     this.e.a(g.a(locald));
/* 477 */     this.f.remove(Long.valueOf(locald.a));
/*     */   }
/*     */   
/*     */   private void a(String paramString) {
/* 481 */     if (!TextUtils.isEmpty(paramString)) {
/* 482 */       if (b.d) {
/* 483 */         Log.d("SsDownloadManager", "deleteFileIfExists() deleting " + paramString);
/*     */       }
/* 485 */       File localFile = new File(paramString);
/* 486 */       if ((localFile.exists()) && (!localFile.delete())) {
/* 487 */         Log.w("SsDownloadManager", "file: '" + paramString + "' couldn't be deleted");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   protected void dump(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
/*     */   {
/* 494 */     p localp = new p(paramPrintWriter, "  ");
/* 495 */     synchronized (this.f) {
/* 496 */       ArrayList localArrayList = new ArrayList(this.f.keySet());
/* 497 */       Collections.sort(localArrayList);
/* 498 */       for (Long localLong : localArrayList) {
/* 499 */         d locald = (d)this.f.get(localLong);
/* 500 */         locald.a(localp);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static class b
/*     */   {
/*     */     static final a a;
/*     */     
/*     */     private static class a
/*     */     {
/*     */       public void a(AlarmManager paramAlarmManager, int paramInt, long paramLong, PendingIntent paramPendingIntent)
/*     */       {
/*     */         try
/*     */         {
/* 515 */           if (paramAlarmManager != null) {
/* 516 */             paramAlarmManager.set(paramInt, paramLong, paramPendingIntent);
/*     */           }
/*     */         } catch (Throwable localThrowable) {}
/*     */       }
/*     */     }
/*     */     
/*     */     @TargetApi(19)
/*     */     private static class b extends TTDownloadService.b.a {
/*     */       private b() {
/* 525 */         super();
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       public void a(AlarmManager paramAlarmManager, int paramInt, long paramLong, PendingIntent paramPendingIntent)
/*     */       {
/*     */         try
/*     */         {
/* 536 */           if (paramAlarmManager != null) {
/* 537 */             paramAlarmManager.setExact(paramInt, paramLong, paramPendingIntent);
/*     */           }
/*     */         } catch (Throwable localThrowable1) {
/* 540 */           if ((localThrowable1 instanceof NoSuchMethodError)) {
/*     */             try {
/* 542 */               if (paramAlarmManager != null) {
/* 543 */                 paramAlarmManager.set(paramInt, paramLong, paramPendingIntent);
/*     */               }
/*     */             }
/*     */             catch (Throwable localThrowable2) {}
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     static
/*     */     {
/* 555 */       if (Build.VERSION.SDK_INT >= 19) {
/* 556 */         a = new b(null);
/*     */       } else {
/* 558 */         a = new a(null);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public static void a(AlarmManager paramAlarmManager, int paramInt, long paramLong, PendingIntent paramPendingIntent)
/*     */     {
/* 570 */       a.a(paramAlarmManager, paramInt, paramLong, paramPendingIntent);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\service\TTDownloadService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */