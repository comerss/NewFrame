/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.c;
/*     */ 
/*     */ import android.annotation.SuppressLint;
/*     */ import android.app.Notification;
/*     */ import android.app.NotificationManager;
/*     */ import android.app.PendingIntent;
/*     */ import android.content.ContentUris;
/*     */ import android.content.ContentValues;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.SharedPreferences;
/*     */ import android.content.SharedPreferences.Editor;
/*     */ import android.content.res.Resources;
/*     */ import android.database.Cursor;
/*     */ import android.graphics.Bitmap;
/*     */ import android.net.Uri;
/*     */ import android.os.SystemClock;
/*     */ import android.text.TextUtils;
/*     */ import android.util.Log;
/*     */ import android.util.LruCache;
/*     */ import android.widget.RemoteViews;
/*     */ import com.androidquery.callback.AQuery2;
/*     */ import com.androidquery.callback.AjaxCallback;
/*     */ import com.androidquery.callback.AjaxStatus;
/*     */ import com.bytedance.sdk.openadsdk.R.color;
/*     */ import com.bytedance.sdk.openadsdk.R.drawable;
/*     */ import com.bytedance.sdk.openadsdk.R.id;
/*     */ import com.bytedance.sdk.openadsdk.R.layout;
/*     */ import com.bytedance.sdk.openadsdk.R.string;
/*     */ import com.bytedance.sdk.openadsdk.TTAppDownloadInfo;
/*     */ import com.bytedance.sdk.openadsdk.TTGlobalAppDownloadListener;
/*     */ import com.bytedance.sdk.openadsdk.c.a.b;
/*     */ import com.bytedance.sdk.openadsdk.g.m;
/*     */ import com.bytedance.sdk.openadsdk.g.s;
/*     */ import com.bytedance.sdk.openadsdk.service.TTDownloadHandlerService;
/*     */ import java.text.ParseException;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.WeakHashMap;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SuppressLint({"UseSparseArrays"})
/*     */ public class g
/*     */ {
/*  72 */   private Map<Long, WeakHashMap<e, Boolean>> a = new ConcurrentHashMap();
/*     */   
/*     */ 
/*  75 */   private Map<Long, com.bytedance.sdk.openadsdk.core.d.e> b = new ConcurrentHashMap();
/*     */   
/*  77 */   private Map<Long, y> c = new ConcurrentHashMap();
/*     */   private AQuery2 d;
/*     */   private LruCache<String, Bitmap> e;
/*     */   
/*     */   public void a(Long paramLong, e parame, com.bytedance.sdk.openadsdk.core.d.e parame1)
/*     */   {
/*  83 */     WeakHashMap localWeakHashMap = (WeakHashMap)this.a.get(paramLong);
/*  84 */     if (localWeakHashMap == null) {
/*  85 */       localWeakHashMap = new WeakHashMap();
/*  86 */       this.a.put(paramLong, localWeakHashMap);
/*     */     }
/*  88 */     if (parame != null) {
/*  89 */       parame.a(paramLong.longValue());
/*  90 */       localWeakHashMap.put(parame, Boolean.TRUE);
/*  91 */       y localy = new y();
/*  92 */       this.c.put(paramLong, localy);
/*     */     }
/*  94 */     if ((parame1 != null) && (parame1.c())) {
/*  95 */       this.b.put(paramLong, parame1);
/*     */     }
/*     */   }
/*     */   
/*     */   public com.bytedance.sdk.openadsdk.core.d.e a(long paramLong) {
/* 100 */     if (this.b != null) {
/* 101 */       return (com.bytedance.sdk.openadsdk.core.d.e)this.b.get(Long.valueOf(paramLong));
/*     */     }
/* 103 */     return null;
/*     */   }
/*     */   
/*     */   public void b(long paramLong) {
/* 107 */     if (this.b != null) {
/* 108 */       this.b.remove(Long.valueOf(paramLong));
/*     */     }
/*     */   }
/*     */   
/*     */   private void a(String paramString, Bitmap paramBitmap)
/*     */   {
/* 114 */     if (b(paramString) == null) {
/* 115 */       this.e.put(paramString, paramBitmap);
/*     */     }
/*     */   }
/*     */   
/*     */   private Bitmap b(String paramString)
/*     */   {
/* 121 */     return (Bitmap)this.e.get(paramString);
/*     */   }
/*     */   
/*     */ 
/*     */   private final Context f;
/*     */   private final NotificationManager g;
/*     */   private static g h;
/*     */   private Bitmap c(String paramString)
/*     */   {
/* 130 */     if (b(paramString) == null) {
/* 131 */       this.d.ajax(paramString, Bitmap.class, new AjaxCallback()
/*     */       {
/*     */         public void a(String paramAnonymousString, Bitmap paramAnonymousBitmap, AjaxStatus paramAnonymousAjaxStatus) {
/* 134 */           super.callback(paramAnonymousString, paramAnonymousBitmap, paramAnonymousAjaxStatus);
/* 135 */           if ((paramAnonymousAjaxStatus != null) && (paramAnonymousBitmap != null) && (paramAnonymousAjaxStatus.getCode() == 200)) {
/* 136 */             float f = s.a(g.a(g.this), 44.0F);
/* 137 */             g.a(g.this, paramAnonymousString, com.bytedance.sdk.openadsdk.g.f.a(paramAnonymousBitmap, f, f));
/*     */           }
/*     */         }
/*     */       });
/*     */     }
/* 142 */     return b(paramString);
/*     */   }
/*     */   
/*     */   public void a(Long paramLong, e parame) {
/* 146 */     WeakHashMap localWeakHashMap = (WeakHashMap)this.a.get(paramLong);
/* 147 */     if (localWeakHashMap != null) {
/* 148 */       localWeakHashMap.remove(parame);
/* 149 */       this.c.remove(paramLong);
/*     */     }
/* 151 */     if ((localWeakHashMap == null) || (localWeakHashMap.isEmpty())) {
/* 152 */       this.a.remove(paramLong);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 160 */   private final Set<String> i = new HashSet();
/* 161 */   private static final Object j = new Object();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 169 */   private final HashMap<String, Long> k = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 175 */   private final q l = new q();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 181 */   private final q m = new q();
/*     */   
/*     */   public static synchronized g a(Context paramContext) {
/* 184 */     if (h == null) {
/* 185 */       h = new g(paramContext);
/*     */     }
/* 187 */     return h;
/*     */   }
/*     */   
/*     */   private g(Context paramContext) {
/* 191 */     this.f = paramContext.getApplicationContext();
/* 192 */     this.g = ((NotificationManager)this.f.getSystemService("notification"));
/*     */     
/* 194 */     e();
/* 195 */     this.d = new AQuery2(this.f);
/* 196 */     long l1 = Runtime.getRuntime().maxMemory();
/* 197 */     int n = (int)(l1 / 8L);
/* 198 */     this.e = new LruCache(n)
/*     */     {
/*     */       protected int a(String paramAnonymousString, Bitmap paramAnonymousBitmap) {
/* 201 */         return paramAnonymousBitmap.getByteCount();
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */   public void a() {
/* 207 */     synchronized (j) {
/* 208 */       Iterator localIterator = this.i.iterator();
/* 209 */       while (localIterator.hasNext()) {
/* 210 */         String str = (String)localIterator.next();
/* 211 */         this.g.cancel(str, 0);
/* 212 */         localIterator.remove();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void a(long paramLong1, long paramLong2)
/*     */   {
/* 222 */     synchronized (this.l) {
/* 223 */       if (paramLong2 != 0L) {
/* 224 */         this.l.b(paramLong1, paramLong2);
/* 225 */         this.m.b(paramLong1, SystemClock.elapsedRealtime());
/*     */       } else {
/* 227 */         this.l.b(paramLong1);
/* 228 */         this.m.b(paramLong1);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void a(Collection<d> paramCollection, boolean paramBoolean)
/*     */   {
/* 238 */     synchronized (this.k) {
/* 239 */       b(paramCollection, paramBoolean);
/*     */     }
/*     */   }
/*     */   
/*     */   private void b(Collection<d> paramCollection, boolean paramBoolean) {
/* 244 */     Resources localResources = this.f.getResources();
/* 245 */     HashMap localHashMap = new HashMap();
/* 246 */     for (Iterator localIterator = paramCollection.iterator(); localIterator.hasNext();) { localObject1 = (d)localIterator.next();
/* 247 */       String str1 = a((d)localObject1);
/* 248 */       int i1 = 0;
/* 249 */       if (str1 != null) {
/* 250 */         localHashMap.put(str1, localObject1);
/*     */       }
/* 252 */       if (((d)localObject1).j == 192) {
/* 253 */         a((d)localObject1, 1, 0L);
/* 254 */         i1 = 1;
/* 255 */       } else if ((((d)localObject1).j == 196) || (((d)localObject1).j == 193) || (((d)localObject1).j == 194) || (((d)localObject1).j == 195))
/*     */       {
/*     */ 
/*     */ 
/* 259 */         a((d)localObject1, 2, 0L);
/* 260 */         i1 = 2;
/* 261 */       } else if ((((d)localObject1).j == 199) || (((d)localObject1).j == 198))
/*     */       {
/* 263 */         a((d)localObject1, 4, 0L);
/* 264 */         i1 = 4;
/*     */       }
/* 266 */       else if (m.a.c(((d)localObject1).j)) {
/* 267 */         a((d)localObject1, 3, 0L);
/* 268 */         i1 = 3;
/*     */       }
/* 270 */       if ((!paramBoolean) && (((d)localObject1).j != 201))
/* 271 */         a(i1, d((d)localObject1));
/*     */     }
/*     */     Object localObject1;
/* 274 */     for (localIterator = localHashMap.keySet().iterator(); localIterator.hasNext();) { localObject1 = (String)localIterator.next();
/*     */       
/* 276 */       if (!com.bytedance.sdk.openadsdk.core.h.a().j()) {
/* 277 */         return;
/*     */       }
/* 279 */       int n = d((String)localObject1);
/* 280 */       d locald = (d)localHashMap.get(localObject1);
/* 281 */       if (locald != null)
/*     */       {
/*     */ 
/* 284 */         r localr = new r(this.f);
/*     */         
/*     */         long l1;
/* 287 */         if (this.k.containsKey(localObject1)) {
/* 288 */           l1 = ((Long)this.k.get(localObject1)).longValue();
/*     */         } else {
/* 290 */           l1 = System.currentTimeMillis();
/* 291 */           this.k.put(localObject1, Long.valueOf(l1));
/*     */         }
/* 293 */         int i2 = 0;
/* 294 */         int i3 = 0;
/* 295 */         int i4 = 0;
/* 296 */         if (n == 1) {
/* 297 */           i2 = 17301633;
/* 298 */           i3 = this.f.getResources().getColor(R.color.tt_download_action_active);
/* 299 */           i4 = R.drawable.tt_download_active;
/* 300 */         } else if (n == 2) {
/* 301 */           i2 = 17301642;
/* 302 */           i3 = this.f.getResources().getColor(R.color.tt_download_action_pause);
/* 303 */           i4 = R.drawable.tt_download_pause;
/* 304 */           a(locald, 2, 0L);
/* 305 */         } else if (n == 3) {
/* 306 */           i2 = 17301634;
/* 307 */           i3 = this.f.getResources().getColor(R.color.tt_download_action_active);
/* 308 */           i4 = R.drawable.tt_download_active;
/* 309 */           a(locald, 3, 0L);
/*     */         }
/*     */         Uri localUri;
/* 312 */         if ((n == 1) || (n == 2)) {
/* 313 */           localUri = ContentUris.withAppendedId(m.a.a, locald.a);
/*     */           
/* 315 */           localObject2 = new Intent("android.ss.intent.action.DOWNLOAD_DELETE", localUri, this.f, TTDownloadHandlerService.class);
/*     */           
/* 317 */           localr.a(PendingIntent.getService(this.f, 0, (Intent)localObject2, 134217728));
/*     */           
/* 319 */           if (n == 1) {
/* 320 */             localr.a(true);
/*     */           } else {
/* 322 */             localr.b(true);
/*     */           }
/* 324 */         } else if (n == 3) {
/* 325 */           localUri = ContentUris.withAppendedId(m.a.a, locald.a);
/*     */           
/* 327 */           localr.b(true);
/*     */           
/*     */ 
/* 330 */           if ((m.a.b(locald.j)) || (b(locald))) {
/* 331 */             localObject2 = "android.ss.intent.action.DOWNLOAD_DELETE";
/*     */           } else {
/* 333 */             localObject2 = "android.ss.intent.action.DOWNLOAD_OPEN";
/*     */           }
/*     */           
/* 336 */           localObject3 = new Intent((String)localObject2, localUri, this.f, TTDownloadHandlerService.class);
/* 337 */           ((Intent)localObject3).putExtra("extra_click_download_ids", locald.a);
/*     */           
/* 339 */           localr.a(PendingIntent.getService(this.f, 0, (Intent)localObject3, 134217728));
/*     */           
/*     */ 
/* 342 */           localIntent = new Intent("android.ss.intent.action.DOWNLOAD_HIDE", localUri, this.f, TTDownloadHandlerService.class);
/*     */           
/* 344 */           localr.b(PendingIntent.getService(this.f, 0, localIntent, 0));
/*     */         }
/*     */         
/*     */ 
/* 348 */         int i5 = 0;
/* 349 */         Object localObject2 = ContentUris.withAppendedId(m.a.a, locald.a);
/*     */         
/* 351 */         Object localObject3 = "android.ss.intent.action.DOWNLOAD_CLICK";
/* 352 */         Intent localIntent = new Intent((String)localObject3, (Uri)localObject2, this.f, TTDownloadHandlerService.class);
/* 353 */         localIntent.putExtra("extra_click_download_ids", locald.a);
/*     */         
/* 355 */         localIntent.putExtra("extra_notification_tag", (String)localObject1);
/*     */         
/* 357 */         if ((n == 1) || (n == 2)) {
/* 358 */           long l2 = 0L;
/* 359 */           long l3 = 0L;
/* 360 */           long l4 = 0L;
/* 361 */           synchronized (this.l) {
/* 362 */             if (locald.s != -1L) {
/* 363 */               l2 += locald.t;
/* 364 */               l3 += locald.s;
/* 365 */               l4 += this.l.a(locald.a);
/*     */             }
/*     */           }
/* 368 */           if (l3 > 0L) {
/* 369 */             i5 = (int)(l2 * 100L / l3);
/*     */           } else {
/* 371 */             i5 = 0;
/*     */           }
/* 373 */           if (n == 1) {
/* 374 */             a(locald, 1, l4);
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 379 */         if (!paramBoolean)
/*     */         {
/*     */ 
/* 382 */           localr.a(l1);
/* 383 */           localr.a(i2);
/* 384 */           RemoteViews localRemoteViews = new RemoteViews(this.f.getPackageName(), R.layout.tt_ttopenad_download_notification_layout);
/* 385 */           String str2 = null;
/* 386 */           String str3 = null;
/* 387 */           Long localLong = Long.valueOf(locald.m);
/* 388 */           str2 = locald.C;
/* 389 */           if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.h.a().c())) {
/* 390 */             str3 = this.f.getResources().getString(R.string.tt_download_source) + this.f.getResources().getString(R.string.tt_open_ad_sdk_source);
/*     */           } else {
/* 392 */             str3 = this.f.getResources().getString(R.string.tt_download_source) + com.bytedance.sdk.openadsdk.core.h.a().c();
/*     */           }
/* 394 */           if (TextUtils.isEmpty(str2)) {
/* 395 */             localRemoteViews.setImageViewResource(R.id.icon, i2);
/*     */           }
/* 397 */           else if (c(str2) != null) {
/* 398 */             localRemoteViews.setImageViewBitmap(R.id.icon, c(str2));
/*     */           } else {
/* 400 */             localRemoteViews.setImageViewResource(R.id.icon, R.drawable.tt_ad_logo_small);
/*     */           }
/*     */           try
/*     */           {
/* 404 */             localRemoteViews.setTextViewText(R.id.tt_download_time, com.bytedance.sdk.openadsdk.g.r.a(localLong.longValue(), "HH:mm"));
/*     */           } catch (ParseException localParseException) {
/* 406 */             localParseException.printStackTrace();
/*     */           }
/* 408 */           localRemoteViews.setProgressBar(R.id.tt_download_progress, 100, i5, false);
/* 409 */           localRemoteViews.setImageViewResource(R.id.action_download_img, i4);
/* 410 */           localRemoteViews.setTextViewText(R.id.tt_download_source, str3);
/*     */           
/* 412 */           localRemoteViews.setOnClickPendingIntent(R.id.ll_action, PendingIntent.getService(this.f, 0, localIntent, 134217728));
/*     */           
/* 414 */           localRemoteViews.setTextViewText(R.id.desc, c(locald));
/* 415 */           String str4 = "";
/* 416 */           ??? = "";
/* 417 */           if (n == 1) {
/* 418 */             str4 = com.bytedance.sdk.openadsdk.g.q.a(locald.t) + "/" + com.bytedance.sdk.openadsdk.g.q.a(locald.s);
/* 419 */             ??? = this.f.getResources().getString(R.string.tt_downloading);
/* 420 */           } else if (n == 2) {
/* 421 */             str4 = com.bytedance.sdk.openadsdk.g.q.a(locald.t) + "/" + com.bytedance.sdk.openadsdk.g.q.a(locald.s);
/* 422 */             ??? = this.f.getResources().getString(R.string.tt_download_pause);
/* 423 */           } else if (n == 3) {
/* 424 */             if ((m.a.b(locald.j)) || (b(locald))) {
/* 425 */               str4 = this.f.getResources().getString(R.string.tt_download_failed);
/* 426 */               if (b(locald)) {
/* 427 */                 ??? = this.f.getResources().getString(R.string.tt_download_size_off);
/*     */               } else {
/* 429 */                 ??? = this.f.getResources().getString(R.string.tt_download_restart);
/*     */               }
/* 431 */             } else if (m.a.a(locald.j)) {
/* 432 */               str4 = this.f.getResources().getString(R.string.tt_download_finish);
/* 433 */               if (com.bytedance.sdk.openadsdk.g.r.c(this.f, locald.e)) {
/* 434 */                 ??? = this.f.getResources().getString(R.string.tt_download_open);
/*     */               } else {
/* 436 */                 ??? = this.f.getResources().getString(R.string.tt_download_install);
/*     */               }
/*     */             }
/*     */           }
/* 440 */           localRemoteViews.setTextViewText(R.id.download_size, str4);
/* 441 */           localRemoteViews.setTextViewText(R.id.action, (CharSequence)???);
/* 442 */           localRemoteViews.setTextColor(R.id.action, i3);
/* 443 */           Notification localNotification = localr.a();
/* 444 */           localNotification.contentView = localRemoteViews;
/* 445 */           this.g.notify((String)localObject1, 0, localNotification);
/*     */         }
/*     */       } }
/* 448 */     if (!paramBoolean)
/*     */     {
/* 450 */       localIterator = this.k.keySet().iterator();
/* 451 */       while (localIterator.hasNext()) {
/* 452 */         localObject1 = (String)localIterator.next();
/* 453 */         if (!localHashMap.containsKey(localObject1)) {
/* 454 */           this.g.cancel((String)localObject1, 0);
/* 455 */           synchronized (j) {
/* 456 */             if (this.i.contains(localObject1)) {
/* 457 */               this.i.remove(localObject1);
/* 458 */               d();
/*     */             }
/*     */           }
/* 461 */           localIterator.remove();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private CharSequence c(d paramd) {
/* 468 */     if (!TextUtils.isEmpty(paramd.A)) {
/* 469 */       return paramd.A;
/*     */     }
/* 471 */     return this.f.getResources().getString(R.string.tt_download_title_unnamed);
/*     */   }
/*     */   
/*     */   public void a(String paramString)
/*     */   {
/* 476 */     if (!TextUtils.isEmpty(paramString)) {
/* 477 */       this.g.cancel(paramString, 0);
/* 478 */       synchronized (j) {
/* 479 */         if (this.i.contains(paramString)) {
/* 480 */           this.i.remove(paramString);
/* 481 */           d();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void a(d paramd, int paramInt, long paramLong) {
/* 488 */     if (this.a.get(Long.valueOf(paramd.a)) != null)
/*     */     {
/* 490 */       Map localMap = (Map)this.a.get(Long.valueOf(paramd.a));
/* 491 */       y localy = (y)this.c.get(Long.valueOf(paramd.a));
/* 492 */       if (localy == null) {
/* 493 */         localy = new y();
/* 494 */         this.c.put(Long.valueOf(paramd.a), localy);
/*     */       }
/* 496 */       localy.a = paramd.a;
/* 497 */       localy.b = f.a(paramd.j);
/* 498 */       localy.c = paramd.s;
/* 499 */       localy.d = paramd.t;
/* 500 */       localy.e = paramd.e;
/* 501 */       Object localObject; if (localy.b == 16) {
/* 502 */         localObject = n.a();
/* 503 */         if (localObject != null) {
/* 504 */           ((b)localObject).a(paramd.a, 5, "");
/*     */         }
/*     */       }
/*     */       try {
/* 508 */         if ((localMap != null) && (!localMap.isEmpty())) {
/* 509 */           localObject = localMap.keySet();
/* 510 */           for (e locale : (Set)localObject) {
/* 511 */             if (locale != null) {
/* 512 */               locale.a(localy, paramInt, paramd.s, paramd.t, paramLong);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       catch (Throwable localThrowable) {}
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private TTAppDownloadInfo d(d paramd)
/*     */   {
/* 524 */     if (paramd == null) {
/* 525 */       return null;
/*     */     }
/* 527 */     TTAppDownloadInfo localTTAppDownloadInfo = new TTAppDownloadInfo();
/* 528 */     localTTAppDownloadInfo.setId(paramd.a);
/* 529 */     localTTAppDownloadInfo.setAppName(paramd.A);
/* 530 */     localTTAppDownloadInfo.setTotalBytes(paramd.s);
/* 531 */     localTTAppDownloadInfo.setCurrBytes(paramd.t);
/* 532 */     localTTAppDownloadInfo.setFileName(paramd.e);
/* 533 */     localTTAppDownloadInfo.setInternalStatusKey(paramd.j);
/* 534 */     return localTTAppDownloadInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void a(int paramInt, TTAppDownloadInfo paramTTAppDownloadInfo)
/*     */   {
/* 544 */     TTGlobalAppDownloadListener localTTGlobalAppDownloadListener = com.bytedance.sdk.openadsdk.core.h.a().l();
/* 545 */     if ((paramTTAppDownloadInfo == null) || (localTTGlobalAppDownloadListener == null)) {
/* 546 */       return;
/*     */     }
/*     */     
/* 549 */     switch (paramInt) {
/*     */     case 1: 
/* 551 */       localTTGlobalAppDownloadListener.onDownloadActive(paramTTAppDownloadInfo);
/* 552 */       break;
/*     */     case 2: 
/* 554 */       localTTGlobalAppDownloadListener.onDownloadPaused(paramTTAppDownloadInfo);
/* 555 */       break;
/*     */     case 3: 
/* 557 */       localTTGlobalAppDownloadListener.onDownloadFinished(paramTTAppDownloadInfo);
/* 558 */       c(this.f, paramTTAppDownloadInfo.getId());
/* 559 */       break;
/*     */     case 4: 
/* 561 */       localTTGlobalAppDownloadListener.onDownloadFailed(paramTTAppDownloadInfo);
/* 562 */       break;
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */   public void b()
/*     */   {
/* 569 */     synchronized (this.l) {
/* 570 */       for (int n = 0; n < this.l.b(); n++) {
/* 571 */         long l1 = this.l.b(n);
/* 572 */         long l2 = SystemClock.elapsedRealtime() - this.m.a(l1);
/* 573 */         Log.d("DownloadNotifier", "Download " + l1 + " speed " + this.l.c(n) + "bps, " + l2 + "ms ago");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String a(d paramd)
/*     */   {
/* 584 */     if (f(paramd))
/* 585 */       return "2:" + paramd.a;
/* 586 */     if (e(paramd))
/* 587 */       return "1:" + paramd.a;
/* 588 */     if ((b(paramd)) || (g(paramd))) {
/* 589 */       return "3:" + paramd.a;
/*     */     }
/* 591 */     return null;
/*     */   }
/*     */   
/*     */   void a(long paramLong, int paramInt1, int paramInt2)
/*     */   {
/* 596 */     if (b(paramInt1, paramInt2)) {
/* 597 */       String str = "3:" + paramLong;
/* 598 */       a(str);
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean b(d paramd) {
/* 603 */     return a(paramd.j, paramd.h);
/*     */   }
/*     */   
/*     */   static boolean a(int paramInt1, int paramInt2) {
/* 607 */     if (((paramInt1 == 199) || (paramInt1 == 198)) && 
/* 608 */       (a(paramInt2))) {
/* 609 */       return true;
/*     */     }
/* 611 */     return false;
/*     */   }
/*     */   
/*     */   static boolean b(int paramInt1, int paramInt2) {
/* 615 */     if ((m.a.c(paramInt1)) && 
/* 616 */       (a(paramInt2))) {
/* 617 */       return true;
/*     */     }
/* 619 */     return false;
/*     */   }
/*     */   
/*     */   static boolean a(int paramInt) {
/* 623 */     if ((paramInt == 1) || (paramInt == 3))
/*     */     {
/* 625 */       return true;
/*     */     }
/* 627 */     return false;
/*     */   }
/*     */   
/*     */   static boolean b(int paramInt) {
/* 631 */     if ((paramInt == 1) || (paramInt == 0))
/*     */     {
/* 633 */       return true;
/*     */     }
/* 635 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int d(String paramString)
/*     */   {
/* 643 */     return Integer.parseInt(paramString.substring(0, paramString.indexOf(':')));
/*     */   }
/*     */   
/*     */   private static boolean e(d paramd) {
/* 647 */     return (paramd.j == 192) && 
/* 648 */       (b(paramd.h));
/*     */   }
/*     */   
/*     */   private static boolean f(d paramd) {
/* 652 */     if ((paramd.j == 196) || (paramd.j == 193) || (paramd.j == 194) || (paramd.j == 195)) {} return 
/*     */     
/*     */ 
/*     */ 
/* 656 */       b(paramd.h);
/*     */   }
/*     */   
/*     */   private static boolean g(d paramd) {
/* 660 */     return b(paramd.j, paramd.h);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void a(Context paramContext, long paramLong, int paramInt1, int paramInt2)
/*     */   {
/* 668 */     if ((b(paramInt1, paramInt2)) || 
/* 669 */       (a(paramInt1, paramInt2))) {
/* 670 */       ContentValues localContentValues = new ContentValues();
/* 671 */       localContentValues.put("visibility", 
/* 672 */         Integer.valueOf(200));
/* 673 */       localContentValues.put("visibility", 
/* 674 */         Integer.valueOf(0));
/* 675 */       Uri localUri = ContentUris.withAppendedId(m.a.a, paramLong);
/* 676 */       i.a(paramContext).a(localUri, localContentValues, null, null);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void a(Context paramContext, long paramLong)
/*     */   {
/* 688 */     Uri localUri = ContentUris.withAppendedId(m.a.a, paramLong);
/* 689 */     Cursor localCursor = i.a(paramContext).a(localUri, null, null, null, null);
/*     */     int n;
/* 691 */     int i1; try { if (localCursor.moveToFirst()) {
/* 692 */         n = a(localCursor, "status");
/* 693 */         i1 = a(localCursor, "visibility");
/*     */       } else {
/* 695 */         Log.w("DownloadNotifier", "Missing details for download " + paramLong);
/* 696 */         return;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       try
/*     */       {
/* 703 */         if (localCursor != null) {
/* 704 */           localCursor.close();
/*     */         }
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */       
/*     */ 
/* 710 */       a(paramContext, paramLong, n, i1);
/*     */     }
/*     */     catch (Exception localException3)
/*     */     {
/* 700 */       return;
/*     */     } finally {
/*     */       try {
/* 703 */         if (localCursor != null) {
/* 704 */           localCursor.close();
/*     */         }
/*     */       }
/*     */       catch (Exception localException5) {}
/*     */     }
/*     */     
/*     */ 
/* 711 */     a(paramLong, n, i1);
/*     */   }
/*     */   
/*     */   public static int a(Cursor paramCursor, String paramString) {
/* 715 */     return paramCursor.getInt(paramCursor.getColumnIndexOrThrow(paramString));
/*     */   }
/*     */   
/*     */   private void d() {
/* 719 */     if (this.i != null) {
/*     */       try {
/* 721 */         StringBuilder localStringBuilder = new StringBuilder();
/* 722 */         synchronized (j) {
/* 723 */           Iterator localIterator = this.i.iterator();
/* 724 */           int n = 0;
/* 725 */           while (localIterator.hasNext()) {
/* 726 */             String str = (String)localIterator.next();
/* 727 */             if (n != this.i.size() - 1) {
/* 728 */               localStringBuilder.append(str).append("|");
/*     */             } else {
/* 730 */               localStringBuilder.append(str);
/*     */             }
/* 732 */             n++;
/*     */           }
/*     */         }
/* 735 */         ??? = localStringBuilder.toString();
/* 736 */         h.a(this.f, new h.b()
/*     */         {
/*     */           public void a(Editor paramAnonymousEditor) {
/* 739 */             if (m.a()) {
/* 740 */               m.b("DownloadNotifier saveToMiscConfig", Ljava/lang/Object;);
/*     */             }
/* 742 */             paramAnonymousEditor.putString("notifs_string", Ljava/lang/Object;);
/*     */           }
/*     */         });
/*     */       }
/*     */       catch (Exception localException) {}
/*     */     }
/*     */   }
/*     */   
/*     */   private void e()
/*     */   {
/*     */     try {
/* 753 */       h.a(this.f, new h.a()
/*     */       {
/*     */         public void a(SharedPreferences paramAnonymousSharedPreferences) {
/* 756 */           String str = paramAnonymousSharedPreferences.getString("notifs_string", "");
/* 757 */           if (m.a()) {
/* 758 */             m.b("DownloadNotifier loadFromMiscConfig", str);
/*     */           }
/* 760 */           String[] arrayOfString = str.split("\\|");
/* 761 */           if (arrayOfString != null) {
/* 762 */             synchronized (g.c()) {
/* 763 */               for (int i = 0; i < arrayOfString.length; i++) {
/* 764 */                 if (TextUtils.isEmpty(arrayOfString[i])) {
/* 765 */                   g.b(g.this).add(arrayOfString[i]);
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       });
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public static void b(Context paramContext, long paramLong)
/*     */   {
/* 778 */     if ((paramContext == null) || (paramLong < 0L)) {
/* 779 */       return;
/*     */     }
/* 781 */     ContentValues localContentValues = new ContentValues();
/* 782 */     localContentValues.put("visibility", 
/* 783 */       Integer.valueOf(2));
/* 784 */     Uri localUri = ContentUris.withAppendedId(m.a.a, paramLong);
/* 785 */     i.a(paramContext).a(localUri, localContentValues, null, null);
/*     */   }
/*     */   
/*     */   public static void c(Context paramContext, long paramLong) {
/* 789 */     if ((paramContext == null) || (paramLong < 0L)) {
/* 790 */       return;
/*     */     }
/* 792 */     ContentValues localContentValues1 = new ContentValues();
/* 793 */     localContentValues1.put("visibility", 
/* 794 */       Integer.valueOf(200));
/* 795 */     Uri localUri = ContentUris.withAppendedId(m.a.a, paramLong);
/* 796 */     i.a(paramContext).a(localUri, localContentValues1, null, null);
/*     */     
/* 798 */     ContentValues localContentValues2 = new ContentValues();
/* 799 */     localContentValues2.put("status", 
/* 800 */       Integer.valueOf(201));
/* 801 */     i.a(paramContext).a(localUri, localContentValues2, null, null);
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\c\g.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */