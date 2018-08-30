/*     */ package com.bytedance.sdk.openadsdk.ccccc;
/*     */ 
/*     */

/*     */

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Binder;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import com.bytedance.sdk.openadsdk.ggg.LogUtils;
import com.bytedance.sdk.openadsdk.service.TTDownloadService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
        /*     */

/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class i
/*     */ {
/*  50 */   private static final UriMatcher c = new UriMatcher(-1);
/*     */   
/*     */   private static final Uri[] d;
/*     */   
/*     */   private static final HashMap<String, String> e;
/*     */   
/*     */   static
/*     */   {
/*  58 */     c.addURI("com.ss.android.newmedia.downloads", "all_downloads", 1);
/*  59 */     c.addURI("com.ss.android.newmedia.downloads", "all_downloads/#", 2);
/*  60 */     c.addURI("com.ss.android.newmedia.downloads", "all_downloads/#/headers", 3);
/*     */     
/*     */ 
/*  63 */     c.addURI("com.ss.android.newmedia.downloads", "download/#/headers", 3);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  69 */     d = new Uri[] { com.bytedance.sdk.openadsdk.ccccc.m.a.a };
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  76 */     e = new HashMap();
/*  77 */     e.put("_display_name", "title AS _display_name");
/*     */     
/*  79 */     e.put("_size", "total_bytes AS _size");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*  84 */   private SQLiteOpenHelper f = null;
/*  85 */   private static final Object g = new Object();
/*     */   
/*     */ 
/*     */   private static i h;
/*     */   
/*     */   protected w a;
/*     */   
/*     */   protected final Context b;
/*     */   
/*     */ 
/*     */   private static class b
/*     */   {
/*  97 */     public StringBuilder a = new StringBuilder();
/*  98 */     public List<String> b = new ArrayList();
/*     */     
/*     */     public <T> void a(String paramString, T... paramVarArgs) {
/* 101 */       if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
/* 102 */         return;
/*     */       }
/* 104 */       if (this.a.length() != 0) {
/* 105 */         this.a.append(" AND ");
/*     */       }
/* 107 */       this.a.append("(");
/* 108 */       this.a.append(paramString);
/* 109 */       this.a.append(")");
/* 110 */       if (paramVarArgs != null) {
/* 111 */         for (T t : paramVarArgs) {
/* 112 */           this.b.add(t.toString());
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     public String a() {
/* 118 */       return this.a.toString();
/*     */     }
/*     */     
/*     */     public String[] b() {
/* 122 */       String[] arrayOfString = new String[this.b.size()];
/* 123 */       return (String[])this.b.toArray(arrayOfString);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private final class a
/*     */     extends SQLiteOpenHelper
/*     */   {
/*     */     public a(Context paramContext)
/*     */     {
/* 135 */       super(paramContext,"ss_downloads.db", null, 101);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public void onCreate(SQLiteDatabase paramSQLiteDatabase)
/*     */     {
/* 143 */       if (SsAndroidDownloadManager.d) {
/* 144 */         Log.v("SsAndroidDownloadManager", "populating new database");
/*     */       }
/* 146 */       onUpgrade(paramSQLiteDatabase, 100, 101);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
/*     */     {
/*     */       try
/*     */       {
/* 159 */         if (paramInt1 < 100)
/*     */         {
/* 161 */           Log.i("SsAndroidDownloadManager", "Upgrading downloads database from version " + paramInt1 + " to version " + paramInt2 + ", which will destroy all old data");
/*     */           
/* 163 */           paramInt1 = 99;
/* 164 */         } else if (paramInt1 > paramInt2)
/*     */         {
/*     */ 
/* 167 */           Log.i("SsAndroidDownloadManager", "Downgrading downloads database from version " + paramInt1 + " (current version is " + paramInt2 + "), destroying all old data");
/*     */           
/* 169 */           paramInt1 = 99;
/*     */         }
/*     */         
/* 172 */         for (int i = paramInt1 + 1; i <= paramInt2; i++) {
/* 173 */           a(paramSQLiteDatabase, i);
/*     */         }
/*     */       } catch (Throwable localThrowable) {
/* 176 */         Log.i("SsAndroidDownloadManager", "onUpgrade " + paramInt1 + " to " + paramInt2 + " exception: " + localThrowable);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     private void a(SQLiteDatabase paramSQLiteDatabase, int paramInt)
/*     */     {
/* 184 */       switch (paramInt) {
/*     */       case 101: 
/* 186 */         c(paramSQLiteDatabase);
/* 187 */         d(paramSQLiteDatabase);
/* 188 */         b(paramSQLiteDatabase);
/* 189 */         a(paramSQLiteDatabase);
/* 190 */         break;
/*     */       default: 
/* 192 */         throw new IllegalStateException("Don'MineHandler know how to upgrade to " + paramInt);
/*     */       }
/*     */       
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     private void a(SQLiteDatabase paramSQLiteDatabase)
/*     */     {
/* 201 */       ContentValues localContentValues = new ContentValues();
/* 202 */       localContentValues.put("current_bytes", Integer.valueOf(0));
/* 203 */       a(paramSQLiteDatabase, localContentValues);
/* 204 */       localContentValues.put("total_bytes", Integer.valueOf(-1));
/* 205 */       a(paramSQLiteDatabase, localContentValues);
/* 206 */       localContentValues.put("title", "");
/* 207 */       a(paramSQLiteDatabase, localContentValues);
/* 208 */       localContentValues.put("description", "");
/* 209 */       a(paramSQLiteDatabase, localContentValues);
/* 210 */       localContentValues.put("icon_url", "");
/* 211 */       a(paramSQLiteDatabase, localContentValues);
/*     */     }
/*     */     
/*     */     private void a(SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues) {
/* 215 */       String str = (String)((Map.Entry)paramContentValues.valueSet().iterator().next()).getKey();
/* 216 */       paramSQLiteDatabase.update("ss_downloads", paramContentValues, str + " is null", null);
/* 217 */       paramContentValues.clear();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     private void b(SQLiteDatabase paramSQLiteDatabase)
/*     */     {
/* 224 */       ContentValues localContentValues = new ContentValues();
/* 225 */       localContentValues.put("is_visible_in_downloads_ui", Boolean.valueOf(false));
/* 226 */       String str = "destination != 0";
/*     */       
/* 228 */       paramSQLiteDatabase.update("ss_downloads", localContentValues, str, null);
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
/*     */     private void c(SQLiteDatabase paramSQLiteDatabase)
/*     */     {
/*     */       try
/*     */       {
/* 249 */         paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS ss_downloads");
/* 250 */         paramSQLiteDatabase.execSQL("CREATE TABLE ss_downloads(_id INTEGER PRIMARY KEY AUTOINCREMENT,uri TEXT, entity TEXT, no_integrity BOOLEAN, hint TEXT, _data TEXT, mimetype TEXT, destination INTEGER, visibility INTEGER, control INTEGER, status INTEGER, numfailed INTEGER, lastmod BIGINT, notificationpackage TEXT, notificationextras TEXT, cookiedata TEXT, useragent TEXT, referer TEXT, total_bytes INTEGER, current_bytes INTEGER, title TEXT, description TEXT, icon_url TEXT, allow_roaming INTEGER NOT NULL DEFAULT 0, allowed_network_types INTEGER NOT NULL DEFAULT 0, is_visible_in_downloads_ui INTEGER NOT NULL DEFAULT 1, bypass_recommended_size_limit INTEGER NOT NULL DEFAULT 0, mediaprovider_uri TEXT, deleted BOOLEAN NOT NULL DEFAULT 0, errorMsg TEXT, allow_write BOOLEAN NOT NULL DEFAULT 0, etag TEXT, scanned INTEGER, method INTEGER);");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/*     */       catch (SQLException localSQLException)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 287 */         Log.e("SsAndroidDownloadManager", "couldn'MineHandler create table in downloads database");
/* 288 */         throw localSQLException;
/*     */       }
/*     */     }
/*     */     
/*     */     private void d(SQLiteDatabase paramSQLiteDatabase) {
/* 293 */       paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS request_headers");
/* 294 */       paramSQLiteDatabase.execSQL("CREATE TABLE request_headers(id INTEGER PRIMARY KEY AUTOINCREMENT,download_id INTEGER NOT NULL,header TEXT NOT NULL,value TEXT NOT NULL);");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static i a(Context paramContext)
/*     */   {
/* 304 */     synchronized (g) {
/* 305 */       if (h == null)
/* 306 */         h = new i(paramContext.getApplicationContext());
/*     */     }
/* 308 */     return h;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private i(Context paramContext)
/*     */   {
/* 315 */     this.b = paramContext;
/* 316 */     if (this.a == null) {
/* 317 */       this.a = t.a(paramContext);
/*     */     }
/* 319 */     this.f = new a(paramContext);
/*     */     
/*     */     try
/*     */     {
/* 323 */       Intent localIntent = new Intent(paramContext, TTDownloadService.class);
/* 324 */       localIntent.putExtra("isFirstStart", true);
/* 325 */       paramContext.startService(localIntent);
/*     */     }
/*     */     catch (Exception localException) {}
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
/*     */   public Uri a(Uri paramUri, ContentValues paramContentValues)
/*     */   {
/* 373 */     b(paramContentValues);
/*     */     try {
/* 375 */       SQLiteDatabase localSQLiteDatabase = this.f.getWritableDatabase();
/*     */       
/*     */ 
/* 378 */       int i = c.match(paramUri);
/* 379 */       if (i != 1) {
/* 380 */         Log.d("SsAndroidDownloadManager", "calling insert on an unknown/invalid URI: " + paramUri);
/* 381 */         throw new IllegalArgumentException("Unknown/Invalid URI " + paramUri);
/*     */       }
/*     */       
/*     */ 
/* 385 */       ContentValues localContentValues = new ContentValues();
/* 386 */       c("uri", paramContentValues, localContentValues);
/* 387 */       c("entity", paramContentValues, localContentValues);
/* 388 */       b("no_integrity", paramContentValues, localContentValues);
/* 389 */       c("hint", paramContentValues, localContentValues);
/* 390 */       c("mimetype", paramContentValues, localContentValues);
/*     */       
/*     */ 
/* 393 */       Integer localInteger1 = paramContentValues.getAsInteger("destination");
/* 394 */       if (localInteger1 != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 403 */         a(paramContentValues);
/* 404 */         localContentValues.put("destination", localInteger1);
/*     */       }
/*     */       
/*     */ 
/* 408 */       Integer localInteger2 = paramContentValues.getAsInteger("visibility");
/* 409 */       if (localInteger2 == null) {
/* 410 */         if (localInteger1.intValue() == 0) {
/* 411 */           localContentValues.put("visibility", 
/* 412 */             Integer.valueOf(1));
/*     */         } else {
/* 414 */           localContentValues.put("visibility", 
/* 415 */             Integer.valueOf(2));
/*     */         }
/*     */       } else {
/* 418 */         localContentValues.put("visibility", localInteger2);
/*     */       }
/*     */       
/* 421 */       a("control", paramContentValues, localContentValues);
/*     */       
/* 423 */       localContentValues.put("status", Integer.valueOf(190));
/* 424 */       localContentValues.put("total_bytes", Integer.valueOf(-1));
/* 425 */       localContentValues.put("current_bytes", Integer.valueOf(0));
/*     */       
/*     */ 
/* 428 */       long l1 = this.a.a();
/* 429 */       localContentValues.put("lastmod", Long.valueOf(l1));
/*     */       
/*     */ 
/* 432 */       String str = paramContentValues.getAsString("notificationpackage");
/* 433 */       if (str != null) {
/* 434 */         localContentValues.put("notificationpackage", str);
/*     */       }
/*     */       
/*     */ 
/* 438 */       c("notificationextras", paramContentValues, localContentValues);
/* 439 */       c("cookiedata", paramContentValues, localContentValues);
/* 440 */       c("useragent", paramContentValues, localContentValues);
/* 441 */       c("referer", paramContentValues, localContentValues);
/*     */       
/*     */ 
/* 444 */       a("title", paramContentValues, localContentValues, "");
/* 445 */       a("description", paramContentValues, localContentValues, "");
/* 446 */       a("icon_url", paramContentValues, localContentValues, "");
/*     */       
/*     */ 
/* 449 */       if (paramContentValues.containsKey("is_visible_in_downloads_ui")) {
/* 450 */         b("is_visible_in_downloads_ui", paramContentValues, localContentValues);
/*     */       }
/*     */       else {
/* 453 */         boolean bool = (localInteger1 == null) || (localInteger1.intValue() == 0);
/* 454 */         localContentValues.put("is_visible_in_downloads_ui", Boolean.valueOf(bool));
/*     */       }
/*     */       
/* 457 */       a("allowed_network_types", paramContentValues, localContentValues);
/* 458 */       b("allow_roaming", paramContentValues, localContentValues);
/*     */       
/* 460 */       long l2 = localSQLiteDatabase.insert("ss_downloads", null, localContentValues);
/* 461 */       if (l2 == -1L) {
/* 462 */         Log.d("SsAndroidDownloadManager", "couldn'MineHandler insert into downloads database");
/* 463 */         return null;
/*     */       }
/*     */       
/* 466 */       a(localSQLiteDatabase, l2, paramContentValues);
/* 467 */       a(paramUri, i);
/*     */       
/*     */ 
/* 470 */       Context localContext = this.b;
/*     */       try {
/* 472 */         localContext.startService(new Intent(localContext, TTDownloadService.class));
/*     */       } catch (Exception localException2) {
/* 474 */         Log.d("lzq", "cannot start Download Service");
/*     */       }
/*     */       
/* 477 */       return ContentUris.withAppendedId(com.bytedance.sdk.openadsdk.ccccc.m.a.a, l2);
/*     */     } catch (Exception localException1) {
/* 479 */       LogUtils.b("TT_AD_SDK", localException1.getMessage());
/*     */     }
/* 481 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void a(ContentValues paramContentValues)
/*     */   {
/* 488 */     String str1 = paramContentValues.getAsString("hint");
/* 489 */     if (str1 == null) {
/* 490 */       throw new IllegalArgumentException("DESTINATION_FILE_URI must include SslHepler file URI under COLUMN_FILE_NAME_HINT");
/*     */     }
/*     */     
/* 493 */     Uri localUri = Uri.parse(str1);
/* 494 */     String str2 = localUri.getScheme();
/* 495 */     if ((str2 == null) || (!str2.equals("file"))) {
/* 496 */       throw new IllegalArgumentException("Not SslHepler file URI: " + localUri);
/*     */     }
/* 498 */     String str3 = localUri.getPath();
/* 499 */     if (str3 == null) {
/* 500 */       throw new IllegalArgumentException("Invalid file URI: " + localUri);
/*     */     }
/*     */     try
/*     */     {
/* 504 */       String str4 = new File(str3).getCanonicalPath();
/* 505 */       String str5 = Environment.getExternalStorageDirectory().getAbsolutePath();
/* 506 */       if (!str4.startsWith(str5)) {
/* 507 */         throw new SecurityException("Destination must be on external storage: " + localUri);
/*     */       }
/*     */     } catch (IOException localIOException) {
/* 510 */       throw new SecurityException("Problem resolving path: " + localUri);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void b(ContentValues paramContentValues)
/*     */   {
/* 523 */     this.b.enforceCallingOrSelfPermission("android.permission.INTERNET", "INTERNET permission is required to use the download manager");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 528 */     paramContentValues = new ContentValues(paramContentValues);
/*     */     
/* 530 */     a(paramContentValues, "destination", new Object[] {
/* 531 */       Integer.valueOf(1) });
/*     */     
/* 533 */     a(paramContentValues, "visibility", new Object[] {
/* 534 */       Integer.valueOf(0), 
/* 535 */       Integer.valueOf(1), 
/* 536 */       Integer.valueOf(3), 
/* 537 */       Integer.valueOf(2) });
/*     */     
/*     */ 
/* 540 */     paramContentValues.remove("uri");
/* 541 */     paramContentValues.remove("title");
/* 542 */     paramContentValues.remove("description");
/* 543 */     paramContentValues.remove("icon_url");
/* 544 */     paramContentValues.remove("mimetype");
/* 545 */     paramContentValues.remove("hint");
/* 546 */     paramContentValues.remove("notificationpackage");
/* 547 */     paramContentValues.remove("allowed_network_types");
/* 548 */     paramContentValues.remove("allow_roaming");
/* 549 */     paramContentValues.remove("is_visible_in_downloads_ui");
/* 550 */     paramContentValues.remove("scanned");
/* 551 */     paramContentValues.remove("allow_write");
/* 552 */     Iterator localIterator1 = paramContentValues.valueSet().iterator();
/* 553 */     Object localObject; while (localIterator1.hasNext()) {
/* 554 */       localObject = (String)((Map.Entry)localIterator1.next()).getKey();
/* 555 */       if (((String)localObject).startsWith("http_header_")) {
/* 556 */         localIterator1.remove();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 561 */     if (paramContentValues.size() > 0) {
/* 562 */       localObject = new StringBuilder("Invalid columns in request: ");
/* 563 */       int i = 1;
/* 564 */       for (Map.Entry localEntry : paramContentValues.valueSet()) {
/* 565 */         if (i == 0) {
/* 566 */           ((StringBuilder)localObject).append(", ");
/*     */         }
/* 568 */         ((StringBuilder)localObject).append((String)localEntry.getKey());
/*     */       }
/* 570 */       throw new SecurityException(((StringBuilder)localObject).toString());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void a(ContentValues paramContentValues, String paramString, Object... paramVarArgs)
/*     */   {
/* 580 */     Object localObject1 = paramContentValues.get(paramString);
/* 581 */     paramContentValues.remove(paramString);
/* 582 */     for (Object localObject2 : paramVarArgs) {
/* 583 */       if ((localObject1 == null) && (localObject2 == null)) {
/* 584 */         return;
/*     */       }
/* 586 */       if ((localObject1 != null) && (localObject1.equals(localObject2))) {
/* 587 */         return;
/*     */       }
/*     */     }
/* 590 */     throw new SecurityException("Invalid value for " + paramString + ": " + localObject1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
/*     */   {
/*     */     try
/*     */     {
/* 600 */       SQLiteDatabase localSQLiteDatabase = this.f.getReadableDatabase();
/*     */       
/* 602 */       int i = c.match(paramUri);
/* 603 */       if (i == -1) {
/* 604 */         if (SsAndroidDownloadManager.c) {
/* 605 */           Log.v("SsAndroidDownloadManager", "querying unknown URI: " + paramUri);
/*     */         }
/* 607 */         throw new IllegalArgumentException("Unknown URI: " + paramUri);
/*     */       }
/*     */       
/* 610 */       if (i == 3) {
/* 611 */         if ((paramArrayOfString1 != null) || (paramString1 != null) || (paramString2 != null)) {
/* 612 */           throw new UnsupportedOperationException("Request header queries do not support projections, selections or sorting");
/*     */         }
/*     */         
/* 615 */         return a(localSQLiteDatabase, paramUri);
/*     */       }
/*     */       
/* 618 */       b localb = a(paramUri, paramString1, paramArrayOfString2, i);
/*     */       
/* 620 */       if (SsAndroidDownloadManager.d) {
/* 621 */         a(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, localSQLiteDatabase);
/*     */       }
/*     */       
/* 624 */       Cursor localCursor = localSQLiteDatabase.query("ss_downloads", paramArrayOfString1, localb.a(), localb
/* 625 */         .b(), null, null, paramString2);
/*     */       
/* 627 */       if (localCursor != null) {
/* 628 */         localCursor.setNotificationUri(this.b.getContentResolver(), paramUri);
/* 629 */         if (SsAndroidDownloadManager.d) {
/* 630 */           Log.v("SsAndroidDownloadManager", "created cursor " + localCursor + " on behalf of " +
/* 631 */             Binder.getCallingPid());
/*     */         }
/*     */       }
/* 634 */       else if (SsAndroidDownloadManager.c) {
/* 635 */         Log.v("SsAndroidDownloadManager", "query failed in downloads database");
/*     */       }
/*     */       
/*     */ 
/* 639 */       return localCursor;
/*     */     }
/*     */     catch (Exception localException) {}
/*     */     
/* 643 */     return null;
/*     */   }
/*     */   
/*     */   private void a(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, SQLiteDatabase paramSQLiteDatabase)
/*     */   {
/* 648 */     StringBuilder localStringBuilder = new StringBuilder();
/* 649 */     localStringBuilder.append("starting query, database is ");
/* 650 */     if (paramSQLiteDatabase != null) {
/* 651 */       localStringBuilder.append("not ");
/*     */     }
/* 653 */     localStringBuilder.append("null; ");
/* 654 */     int i; if (paramArrayOfString1 == null) {
/* 655 */       localStringBuilder.append("projection is null; ");
/* 656 */     } else if (paramArrayOfString1.length == 0) {
/* 657 */       localStringBuilder.append("projection is empty; ");
/*     */     } else {
/* 659 */       for (i = 0; i < paramArrayOfString1.length; i++) {
/* 660 */         localStringBuilder.append("projection[");
/* 661 */         localStringBuilder.append(i);
/* 662 */         localStringBuilder.append("] is ");
/* 663 */         localStringBuilder.append(paramArrayOfString1[i]);
/* 664 */         localStringBuilder.append("; ");
/*     */       }
/*     */     }
/* 667 */     localStringBuilder.append("selection is ");
/* 668 */     localStringBuilder.append(paramString1);
/* 669 */     localStringBuilder.append("; ");
/* 670 */     if (paramArrayOfString2 == null) {
/* 671 */       localStringBuilder.append("selectionArgs is null; ");
/* 672 */     } else if (paramArrayOfString2.length == 0) {
/* 673 */       localStringBuilder.append("selectionArgs is empty; ");
/*     */     } else {
/* 675 */       for (i = 0; i < paramArrayOfString2.length; i++) {
/* 676 */         localStringBuilder.append("selectionArgs[");
/* 677 */         localStringBuilder.append(i);
/* 678 */         localStringBuilder.append("] is ");
/* 679 */         localStringBuilder.append(paramArrayOfString2[i]);
/* 680 */         localStringBuilder.append("; ");
/*     */       }
/*     */     }
/* 683 */     localStringBuilder.append("sort is ");
/* 684 */     localStringBuilder.append(paramString2);
/* 685 */     localStringBuilder.append(".");
/* 686 */     Log.v("SsAndroidDownloadManager", localStringBuilder.toString());
/*     */   }
/*     */   
/*     */   private String a(Uri paramUri) {
/* 690 */     return (String)paramUri.getPathSegments().get(1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void a(SQLiteDatabase paramSQLiteDatabase, long paramLong, ContentValues paramContentValues)
/*     */   {
/* 697 */     ContentValues localContentValues = new ContentValues();
/* 698 */     localContentValues.put("download_id", Long.valueOf(paramLong));
/* 699 */     for (Map.Entry localEntry : paramContentValues.valueSet()) {
/* 700 */       String str1 = (String)localEntry.getKey();
/* 701 */       if (str1.startsWith("http_header_")) {
/* 702 */         String str2 = localEntry.getValue().toString();
/* 703 */         if (!str2.contains(":")) {
/* 704 */           throw new IllegalArgumentException("Invalid HTTP header line: " + str2);
/*     */         }
/* 706 */         String[] arrayOfString = str2.split(":", 2);
/* 707 */         localContentValues.put("header", arrayOfString[0].trim());
/* 708 */         localContentValues.put("value", arrayOfString[1].trim());
/* 709 */         paramSQLiteDatabase.insert("request_headers", null, localContentValues);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private Cursor a(SQLiteDatabase paramSQLiteDatabase, Uri paramUri)
/*     */   {
/* 719 */     String str = "download_id=" + a(paramUri);
/* 720 */     String[] arrayOfString = { "header", "value" };
/*     */     
/* 722 */     return paramSQLiteDatabase.query("request_headers", arrayOfString, str, null, null, null, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void a(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
/*     */   {
/* 730 */     String[] arrayOfString = { "_id" };
/* 731 */     Cursor localCursor = paramSQLiteDatabase.query("ss_downloads", arrayOfString, paramString, paramArrayOfString, null, null, null, null);
/*     */     try {
/* 733 */       for (localCursor.moveToFirst(); !localCursor.isAfterLast(); localCursor.moveToNext()) {
/* 734 */         long l = localCursor.getLong(0);
/* 735 */         String str = "download_id=" + l;
/* 736 */         paramSQLiteDatabase.delete("request_headers", str, null);
/*     */       }
/*     */       return;
/*     */     } finally {
/* 740 */       try { if (localCursor != null) {
/* 741 */           localCursor.close();
/*     */         }
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
/*     */   {
/*     */     try
/*     */     {
/* 755 */       SQLiteDatabase localSQLiteDatabase = this.f.getWritableDatabase();
/*     */       
/*     */ 
/* 758 */       int j = 0;
/*     */       
/* 760 */       if ((paramContentValues.containsKey("deleted")) && 
/* 761 */         (paramContentValues.getAsInteger("deleted").intValue() == 1))
/*     */       {
/* 763 */         j = 1;
/*     */       }
/*     */       
/*     */ 
/* 767 */       ContentValues localContentValues = paramContentValues;
/* 768 */       String str = paramContentValues.getAsString("_data");
/* 769 */       Object localObject1 = null; if (str != null) {
/* 770 */         localObject1 = null;
/*     */         try {
/* 772 */           localObject1 = a(paramUri, new String[] { "title" }, null, null, null);
/*     */           
/* 774 */           if ((!((Cursor)localObject1).moveToFirst()) || (TextUtils.isEmpty(((Cursor)localObject1).getString(0)))) {
/* 775 */             paramContentValues.put("title", new File(str).getName());
/*     */           }
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 781 */             if (localObject1 != null) {
/* 782 */               ((Cursor)localObject1).close();
/*     */             }
/*     */           }
/*     */           catch (Exception localException2) {}
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 790 */           localObject1 = paramContentValues.getAsInteger("status");
/*     */         }
/*     */         catch (Exception localException3) {}finally
/*     */         {
/*     */           try
/*     */           {
/* 781 */             if (localObject1 != null) {
/* 782 */               ((Cursor)localObject1).close();
/*     */             }
/*     */           }
/*     */           catch (Exception localException5) {}
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 793 */       int k = (localObject1 != null) && ((((Integer)localObject1).intValue() == 190) || (((Integer)localObject1).intValue() == 201) || (((Integer)localObject1).intValue() == 193)) ? 1 : 0;
/*     */       
/* 795 */       boolean bool = paramContentValues.containsKey("bypass_recommended_size_limit");
/* 796 */       if ((k != 0) || (bool)) {
/* 797 */         j = 1;
/*     */       }
/*     */       
/* 800 */       int m = c.match(paramUri);
/* 801 */       Object localObject3; int i; switch (m) {
/*     */       case 1: 
/*     */       case 2: 
/* 804 */         localObject3 = a(paramUri, paramString, paramArrayOfString, m);
/* 805 */         if (localContentValues.size() > 0) {
/* 806 */           i = localSQLiteDatabase.update("ss_downloads", localContentValues, ((b)localObject3).a(), ((b)localObject3)
/* 807 */             .b());
/*     */         } else {
/* 809 */           i = 0;
/*     */         }
/* 811 */         break;
/*     */       
/*     */       default: 
/* 814 */         Log.d("SsAndroidDownloadManager", "updating unknown/invalid URI: " + paramUri);
/* 815 */         throw new UnsupportedOperationException("Cannot update URI: " + paramUri);
/*     */       }
/*     */       
/* 818 */       a(paramUri, m);
/* 819 */       if (j != 0) {
/* 820 */         localObject3 = this.b;
/*     */         try {
/* 822 */           ((Context)localObject3).startService(new Intent((Context)localObject3, TTDownloadService.class));
/*     */         }
/*     */         catch (Exception localException6) {}
/*     */       }
/*     */       
/* 827 */       return i;
/*     */     }
/*     */     catch (Exception localException1) {}
/*     */     
/* 831 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void a(Uri paramUri, int paramInt)
/*     */   {
/* 840 */     Long localLong = null;
/* 841 */     if (paramInt == 2) {
/* 842 */       localLong = Long.valueOf(Long.parseLong(a(paramUri)));
/*     */     }
/* 844 */     for (Uri localUri : d) {
/* 845 */       if (localLong != null) {
/* 846 */         localUri = ContentUris.withAppendedId(localUri, localLong.longValue());
/*     */       }
/* 848 */       this.b.getContentResolver().notifyChange(localUri, null);
/*     */     }
/*     */   }
/*     */   
/*     */   private b a(Uri paramUri, String paramString, String[] paramArrayOfString, int paramInt)
/*     */   {
/* 854 */     b localb = new b();
/* 855 */     localb.a(paramString, paramArrayOfString);
/* 856 */     if (paramInt == 2) {
/* 857 */       localb.a("_id = ?", new String[] { a(paramUri) });
/*     */     }
/* 859 */     return localb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int a(Uri paramUri, String paramString, String[] paramArrayOfString)
/*     */   {
/*     */     try
/*     */     {
/* 868 */       SQLiteDatabase localSQLiteDatabase = this.f.getWritableDatabase();
/*     */       
/* 870 */       int j = c.match(paramUri);
/* 871 */       int i; switch (j) {
/*     */       case 1: 
/*     */       case 2: 
/* 874 */         b localb = a(paramUri, paramString, paramArrayOfString, j);
/* 875 */         a(localSQLiteDatabase, localb.a(), localb.b());
/* 876 */         i = localSQLiteDatabase.delete("ss_downloads", localb.a(), localb.b());
/* 877 */         break;
/*     */       
/*     */       default: 
/* 880 */         Log.d("SsAndroidDownloadManager", "deleting unknown/invalid URI: " + paramUri);
/* 881 */         throw new UnsupportedOperationException("Cannot delete URI: " + paramUri);
/*     */       }
/* 883 */       a(paramUri, j);
/* 884 */       return i;
/*     */     }
/*     */     catch (Exception localException) {}
/*     */     
/* 888 */     return 0;
/*     */   }
/*     */   
/*     */   private static final void a(String paramString, ContentValues paramContentValues1, ContentValues paramContentValues2) {
/* 892 */     Integer localInteger = paramContentValues1.getAsInteger(paramString);
/* 893 */     if (localInteger != null) {
/* 894 */       paramContentValues2.put(paramString, localInteger);
/*     */     }
/*     */   }
/*     */   
/*     */   private static final void b(String paramString, ContentValues paramContentValues1, ContentValues paramContentValues2) {
/* 899 */     Boolean localBoolean = paramContentValues1.getAsBoolean(paramString);
/* 900 */     if (localBoolean != null) {
/* 901 */       paramContentValues2.put(paramString, localBoolean);
/*     */     }
/*     */   }
/*     */   
/*     */   private static final void c(String paramString, ContentValues paramContentValues1, ContentValues paramContentValues2) {
/* 906 */     String str = paramContentValues1.getAsString(paramString);
/* 907 */     if (str != null) {
/* 908 */       paramContentValues2.put(paramString, str);
/*     */     }
/*     */   }
/*     */   
/*     */   private static final void a(String paramString1, ContentValues paramContentValues1, ContentValues paramContentValues2, String paramString2)
/*     */   {
/* 914 */     c(paramString1, paramContentValues1, paramContentValues2);
/* 915 */     if (!paramContentValues2.containsKey(paramString1)) {
/* 916 */       paramContentValues2.put(paramString1, paramString2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\cdsss\mOnClick.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */