/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.c;
/*     */ 
/*     */ import android.database.Cursor;
/*     */ 
/*     */ public class d { public long a;
/*     */   public String b;
/*     */   public boolean c;
/*     */   public String d;
/*     */   public String e;
/*     */   public String f;
/*     */   public int g;
/*     */   public int h;
/*     */   public int i;
/*     */   public int j;
/*     */   public int k;
/*     */   public int l;
/*     */   public long m;
/*     */   public String n;
/*     */   public String o;
/*     */   public String p;
/*     */   public String q;
/*     */   public String r;
/*     */   public long s;
/*     */   public long t;
/*     */   public String u;
/*     */   public int v;
/*     */   public boolean w;
/*     */   public String x;
/*     */   public int y;
/*     */   public boolean z;
/*     */   public String A;
/*     */   public String B;
/*     */   public String C;
/*     */   public int D;
/*     */   public int E;
/*     */   
/*     */   public static enum a { private a() {} }
/*     */   
/*     */   public static class b { private i a;
/*     */     
/*  41 */     public b(i parami, Cursor paramCursor) { this.a = parami;
/*  42 */       this.b = paramCursor;
/*     */     }
/*     */     
/*     */     public d a(android.content.Context paramContext, w paramw, v paramv, g paramg)
/*     */     {
/*  47 */       d locald = new d(paramContext, paramw, paramv, paramg, null);
/*     */       
/*  49 */       a(locald);
/*  50 */       b(locald);
/*  51 */       return locald;
/*     */     }
/*     */     
/*     */     public void a(d paramd) {
/*  55 */       paramd.a = c("_id").longValue();
/*  56 */       paramd.b = a("uri");
/*  57 */       paramd.c = (b("no_integrity").intValue() == 1);
/*  58 */       paramd.d = a("hint");
/*  59 */       paramd.e = a("_data");
/*  60 */       paramd.f = a("mimetype");
/*  61 */       paramd.g = b("destination").intValue();
/*  62 */       paramd.h = b("visibility").intValue();
/*  63 */       paramd.j = b("status").intValue();
/*  64 */       paramd.k = b("numfailed").intValue();
/*  65 */       int i = b("method").intValue();
/*  66 */       paramd.l = (i & 0xFFFFFFF);
/*  67 */       paramd.m = c("lastmod").longValue();
/*  68 */       paramd.n = a("notificationpackage");
/*  69 */       paramd.o = a("notificationextras");
/*  70 */       paramd.p = a("cookiedata");
/*  71 */       paramd.q = a("useragent");
/*  72 */       paramd.r = a("referer");
/*  73 */       paramd.s = c("total_bytes").longValue();
/*  74 */       paramd.t = c("current_bytes").longValue();
/*  75 */       paramd.u = a("etag");
/*  76 */       paramd.v = b("scanned").intValue();
/*  77 */       paramd.w = (b("deleted").intValue() == 1);
/*  78 */       paramd.x = a("mediaprovider_uri");
/*  79 */       paramd.y = b("allowed_network_types").intValue();
/*  80 */       paramd.z = (b("allow_roaming").intValue() != 0);
/*  81 */       paramd.A = a("title");
/*  82 */       paramd.B = a("description");
/*  83 */       paramd.C = a("icon_url");
/*     */       
/*  85 */       paramd.D = b("bypass_recommended_size_limit").intValue();
/*     */       
/*  87 */       synchronized (this) {
/*  88 */         paramd.i = b("control").intValue();
/*     */       }
/*     */     }
/*     */     
/*     */     private void b(d paramd) {
/*  93 */       d.a(paramd).clear();
/*  94 */       android.net.Uri localUri = android.net.Uri.withAppendedPath(paramd
/*  95 */         .d(), "headers");
/*  96 */       Cursor localCursor = this.a.a(localUri, null, null, null, null);
/*     */       try
/*     */       {
/*  99 */         int i = localCursor.getColumnIndexOrThrow("header");
/*     */         
/* 101 */         int j = localCursor.getColumnIndexOrThrow("value");
/* 102 */         for (localCursor.moveToFirst(); !localCursor.isAfterLast(); localCursor.moveToNext()) {
/* 103 */           a(paramd, localCursor.getString(i), localCursor.getString(j));
/*     */         }
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 109 */           if (localCursor != null) {
/* 110 */             localCursor.close();
/*     */           }
/*     */         }
/*     */         catch (Exception localException1) {}
/*     */         
/*     */ 
/*     */ 
/* 117 */         if (paramd.p == null) {
/*     */           break label175;
/*     */         }
/*     */       }
/*     */       catch (Exception localException2) {}finally
/*     */       {
/*     */         try
/*     */         {
/* 109 */           if (localCursor != null) {
/* 110 */             localCursor.close();
/*     */           }
/*     */         }
/*     */         catch (Exception localException4) {}
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 118 */       a(paramd, "Cookie", paramd.p);
/*     */       label175:
/* 120 */       if (paramd.r != null) {
/* 121 */         a(paramd, "Referer", paramd.r);
/*     */       }
/*     */     }
/*     */     
/*     */     @android.annotation.TargetApi(5)
/*     */     private void a(d paramd, String paramString1, String paramString2) {
/* 127 */       d.a(paramd).add(android.util.Pair.create(paramString1, paramString2));
/*     */     }
/*     */     
/*     */     private String a(String paramString) {
/* 131 */       int i = this.b.getColumnIndexOrThrow(paramString);
/* 132 */       String str = this.b.getString(i);
/* 133 */       return android.text.TextUtils.isEmpty(str) ? null : str;
/*     */     }
/*     */     
/*     */     private Integer b(String paramString) {
/* 137 */       return Integer.valueOf(this.b.getInt(this.b.getColumnIndexOrThrow(paramString)));
/*     */     }
/*     */     
/*     */     private Long c(String paramString) {
/* 141 */       return Long.valueOf(this.b.getLong(this.b.getColumnIndexOrThrow(paramString)));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private Cursor b;
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
/* 223 */   private java.util.List<android.util.Pair<String, String>> F = new java.util.ArrayList();
/*     */   
/*     */   private java.util.concurrent.Future<?> G;
/*     */   
/*     */   private k H;
/*     */   
/*     */   private final android.content.Context I;
/*     */   
/*     */   private android.app.NotificationManager J;
/*     */   
/*     */   private final w K;
/*     */   
/*     */   private final v L;
/*     */   
/*     */   private final g M;
/*     */   
/*     */ 
/*     */   private d(android.content.Context paramContext, w paramw, v paramv, g paramg)
/*     */   {
/* 242 */     this.I = paramContext;
/* 243 */     this.J = ((android.app.NotificationManager)this.I.getSystemService("notification"));
/*     */     
/* 245 */     this.K = paramw;
/* 246 */     this.L = paramv;
/* 247 */     this.M = paramg;
/* 248 */     this.E = n.a.nextInt(1001);
/*     */   }
/*     */   
/*     */   public java.util.Collection<android.util.Pair<String, String>> a() {
/* 252 */     return java.util.Collections.unmodifiableList(this.F);
/*     */   }
/*     */   
/*     */   @android.annotation.TargetApi(4)
/*     */   public void a(int paramInt) {
/* 257 */     if (this.n == null) {
/* 258 */       return;
/*     */     }
/*     */     
/*     */ 
/* 262 */     android.content.Intent localIntent = new android.content.Intent("android.ss.intent.action.DOWNLOAD_COMPLETE");
/*     */     try {
/* 264 */       if (this.e != null) {
/* 265 */         android.content.pm.PackageManager localPackageManager = this.I.getPackageManager();
/* 266 */         android.content.pm.PackageInfo localPackageInfo = localPackageManager.getPackageArchiveInfo(this.e, 1);
/* 267 */         String str = localPackageInfo == null ? null : localPackageInfo.packageName;
/* 268 */         if (str != null) {
/* 269 */           localIntent.putExtra("extra_app_package", str);
/*     */         }
/*     */       }
/*     */     } catch (Exception localException) {
/* 273 */       localException.printStackTrace();
/*     */     }
/* 275 */     localIntent.setPackage(this.n);
/* 276 */     localIntent.putExtra("extra_download_id", this.a);
/* 277 */     localIntent.putExtra("extra_download_visibility", this.h);
/* 278 */     localIntent.putExtra("status", paramInt);
/* 279 */     this.K.a(localIntent);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long a(long paramLong)
/*     */   {
/* 286 */     if (this.k == 0) {
/* 287 */       return paramLong;
/*     */     }
/* 289 */     if (this.l > 0) {
/* 290 */       return this.m + this.l;
/*     */     }
/* 292 */     return this.m + 30 * (1000 + this.E) * (1 << this.k - 1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean f()
/*     */   {
/* 301 */     if (this.i == 1)
/*     */     {
/* 303 */       return false;
/*     */     }
/* 305 */     switch (this.j)
/*     */     {
/*     */     case 0: 
/*     */     case 190: 
/*     */     case 192: 
/* 310 */       return true;
/*     */     
/*     */     case 195: 
/*     */     case 196: 
/* 314 */       return (!h()) && (b() == a.a);
/*     */     
/*     */ 
/*     */     case 194: 
/* 318 */       long l1 = this.K.a();
/* 319 */       return (!h()) && (a(l1) <= l1);
/*     */     
/*     */     case 199: 
/* 322 */       return android.os.Environment.getExternalStorageState().equals("mounted");
/*     */     
/*     */     case 198: 
/* 325 */       return false;
/*     */     }
/* 327 */     return false;
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
/*     */   public a b()
/*     */   {
/* 350 */     android.net.NetworkInfo localNetworkInfo = this.K.b();
/* 351 */     if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected())) {
/* 352 */       return a.b;
/*     */     }
/* 354 */     if ((this.K.c()) && (!g())) {
/* 355 */       return a.e;
/*     */     }
/* 357 */     return b(localNetworkInfo.getType());
/*     */   }
/*     */   
/*     */   private boolean g() {
/* 361 */     return this.z;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private a b(int paramInt)
/*     */   {
/* 371 */     int i1 = c(paramInt);
/* 372 */     int i2 = this.y == -1 ? 1 : 0;
/* 373 */     if ((i2 == 0) && ((i1 & this.y) == 0)) {
/* 374 */       return a.f;
/*     */     }
/* 376 */     return d(paramInt);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int c(int paramInt)
/*     */   {
/* 386 */     switch (paramInt) {
/*     */     case 0: 
/* 388 */       return 1;
/*     */     
/*     */     case 1: 
/* 391 */       return 2;
/*     */     }
/*     */     
/* 394 */     return 0;
/*     */   }
/*     */   
/*     */   private boolean h()
/*     */   {
/* 399 */     android.net.NetworkInfo localNetworkInfo = this.K.b();
/* 400 */     return (localNetworkInfo != null) && (localNetworkInfo.isConnected()) && 
/* 401 */       (c(localNetworkInfo.getType()) == 1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private a d(int paramInt)
/*     */   {
/* 410 */     if (this.s <= 0L) {
/* 411 */       return a.a;
/*     */     }
/* 413 */     if (paramInt == 1) {
/* 414 */       return a.a;
/*     */     }
/* 416 */     Long localLong1 = this.K.d();
/* 417 */     if ((localLong1 != null) && (this.s > localLong1.longValue())) {
/* 418 */       return a.c;
/*     */     }
/* 420 */     if (this.D == 0) {
/* 421 */       Long localLong2 = this.K.e();
/* 422 */       if ((localLong2 != null) && 
/* 423 */         (this.s > localLong2.longValue())) {
/* 424 */         return a.d;
/*     */       }
/*     */     }
/* 427 */     return a.a;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean a(java.util.concurrent.ExecutorService paramExecutorService)
/*     */   {
/* 438 */     synchronized (this) {
/* 439 */       boolean bool = f();
/* 440 */       int i1 = (this.G != null) && (!this.G.isDone()) ? 1 : 0;
/* 441 */       if ((bool) && (i1 == 0)) {
/* 442 */         if (this.j != 192) {
/* 443 */           this.j = 192;
/* 444 */           android.content.ContentValues localContentValues = new android.content.ContentValues();
/* 445 */           localContentValues.put("status", Integer.valueOf(this.j));
/* 446 */           i.a(this.I).a(d(), localContentValues, null, null);
/*     */         }
/*     */         
/* 449 */         this.H = new k(this.I, this.K, this, this.L, this.M);
/*     */         
/* 451 */         this.G = paramExecutorService.submit(this.H);
/*     */       }
/* 453 */       return bool;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean a(j paramj)
/*     */   {
/* 464 */     synchronized (this) {
/* 465 */       boolean bool = e();
/* 466 */       if (bool) {
/* 467 */         paramj.a(this);
/*     */       }
/* 469 */       return bool;
/*     */     }
/*     */   }
/*     */   
/*     */   public void c() {
/* 474 */     String str1 = this.e;
/* 475 */     if (this.e != null) {
/* 476 */       java.io.File localFile = new java.io.File(str1);
/* 477 */       if ((this.j == 200) && 
/* 478 */         (!localFile.exists())) {
/* 479 */         String str2 = g.a(this);
/* 480 */         g.a(this.I).a(str2);
/* 481 */         i.a(this.I).a(d(), null, null);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public android.net.Uri d()
/*     */   {
/* 491 */     return android.content.ContentUris.withAppendedId(m.a.a, this.a);
/*     */   }
/*     */   
/*     */   public void a(p paramp) {
/* 495 */     paramp.println("DownloadInfo:");
/* 496 */     paramp.a();
/*     */     
/* 498 */     paramp.a("mId", Long.valueOf(this.a));
/* 499 */     paramp.a("mLastMod", Long.valueOf(this.m));
/* 500 */     paramp.a("mPackage", this.n);
/* 501 */     paramp.println();
/*     */     
/* 503 */     paramp.a("mUri", this.b);
/* 504 */     paramp.println();
/*     */     
/* 506 */     paramp.a("mMimeType", this.f);
/* 507 */     paramp.a("mCookies", this.p != null ? "yes" : "no");
/* 508 */     paramp.a("mReferer", this.r != null ? "yes" : "no");
/* 509 */     paramp.a("mUserAgent", this.q);
/* 510 */     paramp.println();
/*     */     
/* 512 */     paramp.a("mFileName", this.e);
/* 513 */     paramp.a("mDestination", Integer.valueOf(this.g));
/* 514 */     paramp.println();
/*     */     
/* 516 */     paramp.a("mStatus", m.a.d(this.j));
/* 517 */     paramp.a("mCurrentBytes", Long.valueOf(this.t));
/* 518 */     paramp.a("mTotalBytes", Long.valueOf(this.s));
/* 519 */     paramp.println();
/*     */     
/* 521 */     paramp.a("mNumFailed", Integer.valueOf(this.k));
/* 522 */     paramp.a("mRetryAfter", Integer.valueOf(this.l));
/* 523 */     paramp.a("mETag", this.u);
/* 524 */     paramp.println();
/*     */     
/* 526 */     paramp.a("mAllowedNetworkTypes", Integer.valueOf(this.y));
/* 527 */     paramp.a("mAllowRoaming", Boolean.valueOf(this.z));
/* 528 */     paramp.println();
/*     */     
/* 530 */     paramp.b();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long b(long paramLong)
/*     */   {
/* 541 */     if (m.a.c(this.j)) {
/* 542 */       return Long.MAX_VALUE;
/*     */     }
/* 544 */     if (this.j != 194) {
/* 545 */       return 0L;
/*     */     }
/* 547 */     long l1 = a(paramLong);
/* 548 */     if (l1 <= paramLong) {
/* 549 */       return 0L;
/*     */     }
/* 551 */     return l1 - paramLong;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean e()
/*     */   {
/* 558 */     if ((this.v == 0) && ((this.g == 0) || (this.g == 1))) {} return 
/*     */     
/*     */ 
/* 561 */       m.a.a(this.j);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static int a(i parami, long paramLong)
/*     */   {
/* 568 */     Cursor localCursor = parami.a(
/* 569 */       android.content.ContentUris.withAppendedId(m.a.a, paramLong), new String[] { "status" }, null, null, null);
/*     */     try {
/*     */       int i1;
/* 572 */       if (localCursor.moveToFirst()) {
/* 573 */         return localCursor.getInt(0);
/*     */       }
/*     */       
/*     */ 
/* 577 */       return 190;
/*     */     }
/*     */     finally {
/*     */       try {
/* 581 */         if (localCursor != null) {
/* 582 */           localCursor.close();
/*     */         }
/*     */       }
/*     */       catch (Exception localException3) {}
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\c\d.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */