/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.c;
/*     */ 
/*     */ import android.content.ContentUris;
/*     */ import android.content.Context;
/*     */ import android.database.Cursor;
/*     */ import android.database.sqlite.SQLiteException;
/*     */ import android.net.Uri;
/*     */ import android.os.Environment;
/*     */ import android.os.StatFs;
/*     */ import android.text.TextUtils;
/*     */ import android.util.Log;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
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
/*     */ public class v
/*     */ {
/*     */   private final File a;
/*     */   private final File b;
/*     */   private final File c;
/*  49 */   private int d = 0;
/*     */   
/*     */   private final Context e;
/*     */   
/*     */   public v(Context paramContext)
/*     */   {
/*  55 */     this.e = paramContext;
/*  56 */     this.c = a(paramContext);
/*  57 */     this.a = Environment.getExternalStorageDirectory();
/*  58 */     this.b = Environment.getDownloadCacheDirectory();
/*  59 */     c();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  67 */   private int f = 0;
/*     */   
/*     */   synchronized void a() {
/*  70 */     if (++this.f % 250 == 0) {
/*  71 */       c();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  78 */   private Thread g = null;
/*     */   
/*  80 */   private synchronized void c() { if ((this.g != null) && (this.g.isAlive())) {
/*  81 */       return;
/*     */     }
/*  83 */     this.g = new Thread() {
/*     */       public void run() {
/*  85 */         v.a(v.this);
/*  86 */         v.b(v.this);
/*     */       }
/*  88 */     };
/*  89 */     this.g.start();
/*     */   }
/*     */   
/*     */   void a(int paramInt, String paramString, long paramLong)
/*     */     throws u
/*     */   {
/*  95 */     if (a(paramLong) < 1048576)
/*     */     {
/*  97 */       return;
/*     */     }
/*  99 */     b(paramInt, paramString, paramLong);
/*     */   }
/*     */   
/*     */   void b(int paramInt, String paramString, long paramLong) throws u {
/* 103 */     f();
/* 104 */     File localFile = null;
/* 105 */     if (b.c) {
/* 106 */       Log.i("SsDownloadManager", "in verifySpace, destination: " + paramInt + ", path: " + paramString + ", length: " + paramLong);
/*     */     }
/*     */     
/* 109 */     if (paramString == null) {
/* 110 */       throw new IllegalArgumentException("path can't be null");
/*     */     }
/* 112 */     switch (paramInt) {
/*     */     case 0: 
/* 114 */       localFile = this.a;
/* 115 */       break;
/*     */     case 1: 
/* 117 */       if (paramString.startsWith(this.a.getPath())) {
/* 118 */         localFile = this.a;
/* 119 */       } else if (paramString.startsWith(this.c.getPath())) {
/* 120 */         localFile = this.c;
/* 121 */       } else if (paramString.startsWith(this.b.getPath())) {
/* 122 */         localFile = this.b;
/*     */       }
/*     */       break;
/*     */     }
/* 126 */     if (localFile == null) {
/* 127 */       throw new IllegalStateException("invalid combination of destination: " + paramInt + ", path: " + paramString);
/*     */     }
/*     */     
/* 130 */     a(localFile, paramLong, paramInt);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private synchronized void a(File paramFile, long paramLong, int paramInt)
/*     */     throws u
/*     */   {
/* 140 */     if (paramLong == 0L) {
/* 141 */       return;
/*     */     }
/* 143 */     if ((paramInt == 1) || (paramInt == 0))
/*     */     {
/* 145 */       if (!Environment.getExternalStorageState().equals("mounted")) {
/* 146 */         throw new u(199, "external media not mounted");
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 151 */     long l = b(paramFile);
/* 152 */     if (l < 10485760L)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 157 */       a(paramInt, 10485760L);
/* 158 */       d();
/* 159 */       l = b(paramFile);
/* 160 */       if (l < 10485760L)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 169 */         if (paramFile.equals(this.b)) {
/* 170 */           Log.w("SsDownloadManager", "System cache dir ('/cache') is running low on space.space available (in bytes): " + l);
/*     */         }
/*     */         else {
/* 173 */           throw new u(198, "space in the filesystem rooted at: " + paramFile + " is below 10% availability. stopping this download.");
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 179 */     if (paramFile.equals(this.c))
/*     */     {
/* 181 */       l = a(this.c);
/* 182 */       if (l < 10485760L)
/*     */       {
/* 184 */         Log.w("SsDownloadManager", "Downloads data dir: " + paramFile + " is running low on space. space available (in bytes): " + l);
/*     */       }
/*     */       
/* 187 */       if (l < paramLong)
/*     */       {
/* 189 */         a(paramInt, 10485760L);
/* 190 */         d();
/* 191 */         l = a(this.c);
/*     */       }
/*     */     }
/* 194 */     if (l < paramLong) {
/* 195 */       throw new u(198, "not enough free space in the filesystem rooted at: " + paramFile + " and unable to free any more");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private long a(File paramFile)
/*     */   {
/* 206 */     File[] arrayOfFile = paramFile.listFiles();
/* 207 */     long l = 104857600L;
/* 208 */     if (arrayOfFile == null) {
/* 209 */       return l;
/*     */     }
/* 211 */     int i = arrayOfFile.length;
/* 212 */     for (int j = 0; j < i; j++) {
/* 213 */       l -= arrayOfFile[j].length();
/*     */     }
/* 215 */     if (b.c) {
/* 216 */       Log.i("SsDownloadManager", "available space (in bytes) in downloads data dir: " + l);
/*     */     }
/* 218 */     return l;
/*     */   }
/*     */   
/*     */   private long b(File paramFile) {
/* 222 */     StatFs localStatFs = new StatFs(paramFile.getPath());
/*     */     
/*     */ 
/* 225 */     long l1 = localStatFs.getAvailableBlocks() - 4L;
/*     */     
/* 227 */     long l2 = localStatFs.getBlockSize() * l1;
/* 228 */     if (b.c) {
/* 229 */       Log.i("SsDownloadManager", "available space (in bytes) in filesystem rooted at: " + paramFile
/* 230 */         .getPath() + " is: " + l2);
/*     */     }
/* 232 */     return l2;
/*     */   }
/*     */   
/*     */   File a(String paramString, int paramInt, long paramLong) throws u
/*     */   {
/* 237 */     switch (paramInt) {
/*     */     case 0: 
/* 239 */       File localFile = new File(this.a.getPath() + b.a);
/* 240 */       if ((!localFile.isDirectory()) && (!localFile.mkdir()))
/*     */       {
/*     */ 
/*     */ 
/* 244 */         throw new u(492, "unable to create external downloads directory " + localFile.getPath());
/*     */       }
/* 246 */       return localFile;
/*     */     }
/* 248 */     throw new IllegalStateException("unexpected value for destination: " + paramInt);
/*     */   }
/*     */   
/*     */   File b()
/*     */   {
/* 253 */     return this.c;
/*     */   }
/*     */   
/*     */   public static File a(Context paramContext) {
/* 257 */     return paramContext.getCacheDir();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private long a(int paramInt, long paramLong)
/*     */   {
/* 266 */     if (b.c) {
/* 267 */       Log.i("SsDownloadManager", "discardPurgeableFiles: destination = " + paramInt + ", targetBytes = " + paramLong);
/*     */     }
/*     */     
/* 270 */     String str1 = String.valueOf(paramInt);
/* 271 */     String[] arrayOfString = { str1 };
/* 272 */     Cursor localCursor = i.a(this.e).a(m.a.a, null, "( status = '200' AND destination = ? )", arrayOfString, "lastmod");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 280 */     if (localCursor == null) {
/* 281 */       return 0L;
/*     */     }
/* 283 */     long l1 = 0L;
/*     */     try {
/* 285 */       int i = localCursor.getColumnIndex("_data");
/* 286 */       while ((localCursor.moveToNext()) && (l1 < paramLong)) {
/* 287 */         String str2 = localCursor.getString(i);
/* 288 */         if (!TextUtils.isEmpty(str2))
/*     */         {
/* 290 */           File localFile = new File(str2);
/* 291 */           if (b.c) {
/* 292 */             Log.d("SsDownloadManager", "purging " + localFile.getAbsolutePath() + " for " + localFile
/* 293 */               .length() + " bytes");
/*     */           }
/* 295 */           l1 += localFile.length();
/* 296 */           localFile.delete();
/* 297 */           long l2 = localCursor.getLong(localCursor.getColumnIndex("_id"));
/* 298 */           i.a(this.e).a(
/* 299 */             ContentUris.withAppendedId(m.a.a, l2), null, null);
/*     */         }
/*     */       }
/*     */       try
/*     */       {
/* 304 */         if (localCursor != null) {
/* 305 */           localCursor.close();
/*     */         }
/*     */       }
/*     */       catch (Exception localException1) {}
/*     */       
/*     */ 
/* 311 */       if (!b.c) {
/*     */         break label349;
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/* 304 */         if (localCursor != null) {
/* 305 */           localCursor.close();
/*     */         }
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */     
/*     */ 
/* 312 */     Log.i("SsDownloadManager", "Purged files, freed " + l1 + " for " + paramLong + " requested");
/*     */     
/*     */     label349:
/* 315 */     return l1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void d()
/*     */   {
/* 326 */     if (b.c) {
/* 327 */       Log.i("SsDownloadManager", "in removeSpuriousFiles");
/*     */     }
/*     */     try
/*     */     {
/* 331 */       ArrayList localArrayList = new ArrayList();
/* 332 */       File[] arrayOfFile = this.b.listFiles();
/* 333 */       if (arrayOfFile != null) {
/* 334 */         localArrayList.addAll(Arrays.asList(arrayOfFile));
/*     */       }
/* 336 */       arrayOfFile = this.c.listFiles();
/* 337 */       if (arrayOfFile != null) {
/* 338 */         localArrayList.addAll(Arrays.asList(arrayOfFile));
/*     */       }
/* 340 */       if (localArrayList.size() == 0) {
/* 341 */         return;
/*     */       }
/* 343 */       Cursor localCursor = i.a(this.e).a(m.a.a, new String[] { "_data" }, null, null, null);
/*     */       
/*     */       try
/*     */       {
/* 347 */         if (localCursor != null) {
/* 348 */           while (localCursor.moveToNext()) {
/* 349 */             String str = localCursor.getString(0);
/* 350 */             if (!TextUtils.isEmpty(str)) {
/* 351 */               if (b.c) {
/* 352 */                 Log.i("SsDownloadManager", "in removeSpuriousFiles, preserving file " + str);
/*     */               }
/*     */               
/* 355 */               localArrayList.remove(new File(str));
/*     */             }
/*     */           }
/*     */         }
/*     */       } finally {
/*     */         try {
/* 361 */           if (localCursor != null) {
/* 362 */             localCursor.close();
/*     */           }
/*     */         }
/*     */         catch (Exception localException3) {}
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       return;
/*     */     }
/*     */     catch (Exception localException1) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void e()
/*     */   {
/* 379 */     if (b.c) {
/* 380 */       Log.i("SsDownloadManager", "in trimDatabase");
/*     */     }
/* 382 */     Cursor localCursor = null;
/*     */     try {
/* 384 */       localCursor = i.a(this.e).a(m.a.a, new String[] { "_id" }, "status >= '200'", null, "lastmod");
/*     */       
/*     */ 
/*     */ 
/* 388 */       if (localCursor == null)
/*     */       {
/*     */ 
/* 391 */         Log.e("SsDownloadManager", "null cursor in trimDatabase");
/* 392 */         return;
/*     */       }
/* 394 */       if (localCursor.moveToFirst()) {
/* 395 */         int i = localCursor.getCount() - 1000;
/* 396 */         int j = localCursor.getColumnIndexOrThrow("_id");
/* 397 */         while (i > 0) {
/* 398 */           Uri localUri = ContentUris.withAppendedId(m.a.a, localCursor
/* 399 */             .getLong(j));
/* 400 */           i.a(this.e).a(localUri, null, null);
/* 401 */           if (!localCursor.moveToNext()) {
/*     */             break;
/*     */           }
/* 404 */           i--;
/*     */         }
/*     */       }
/*     */       return;
/*     */     }
/*     */     catch (SQLiteException localSQLiteException)
/*     */     {
/* 411 */       Log.w("SsDownloadManager", "trimDatabase failed with exception: " + localSQLiteException.getMessage());
/* 412 */       return;
/*     */     } finally {
/*     */       try {
/* 415 */         if (localCursor != null) {
/* 416 */           localCursor.close();
/*     */         }
/*     */       }
/*     */       catch (Exception localException4) {}
/*     */     }
/*     */   }
/*     */   
/*     */   private synchronized int a(long paramLong)
/*     */   {
/* 425 */     this.d = ((int)(this.d + paramLong));
/* 426 */     return this.d;
/*     */   }
/*     */   
/*     */   private synchronized void f() {
/* 430 */     this.d = 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\c\v.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */