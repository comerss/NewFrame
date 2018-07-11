/*     */ package com.ss.android.crash.log;
/*     */ 
/*     */ import android.app.ActivityManager;
/*     */ import android.app.ActivityManager.MemoryInfo;
/*     */ import android.app.ActivityManager.RunningAppProcessInfo;
/*     */ import android.content.Context;
/*     */ import android.os.Build.VERSION;
/*     */ import android.os.Debug;
/*     */ import android.os.Debug.MemoryInfo;
/*     */ import android.os.Process;
/*     */ import android.text.TextUtils;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.Closeable;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.net.URLEncoder;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.zip.Deflater;
/*     */ import java.util.zip.GZIPInputStream;
/*     */ import java.util.zip.GZIPOutputStream;
/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class l
/*     */ {
/*     */   static enum a
/*     */   {
/*     */     final int d;
/*     */     
/*     */     private a(int paramInt)
/*     */     {
/*  49 */       this.d = paramInt;
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean a(Context paramContext)
/*     */   {
/*  55 */     String str = b(paramContext);
/*  56 */     if ((str != null) && (str.contains(":"))) {
/*  57 */       return false;
/*     */     }
/*  59 */     return (str != null) && (str.equals(paramContext.getPackageName())); }
/*     */   
/*  61 */   private static String a = null;
/*     */   
/*  63 */   static String b(Context paramContext) { String str = a;
/*  64 */     if (!TextUtils.isEmpty(str)) {
/*  65 */       return str;
/*     */     }
/*     */     try {
/*  68 */       i = Process.myPid();
/*  69 */       ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
/*  70 */       for (ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo : localActivityManager.getRunningAppProcesses())
/*  71 */         if (localRunningAppProcessInfo.pid == i) {
/*  72 */           a = localRunningAppProcessInfo.processName;
/*  73 */           return a;
/*     */         }
/*     */     } catch (Exception localException) {
/*     */       int i;
/*  77 */       localException.printStackTrace();
/*     */     }
/*  79 */     a = a();
/*  80 */     return a;
/*     */   }
/*     */   
/*  83 */   private static String a() { BufferedReader localBufferedReader = null;
/*     */     
/*     */     try
/*     */     {
/*  87 */       localBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
/*     */       
/*     */ 
/*  90 */       StringBuilder localStringBuilder = new StringBuilder();
/*  91 */       int i; while ((i = localBufferedReader.read()) > 0) {
/*  92 */         localStringBuilder.append((char)i);
/*     */       }
/*  94 */       return localStringBuilder.toString();
/*     */     }
/*     */     catch (Throwable localThrowable) {}finally
/*     */     {
/*  98 */       if (localBufferedReader != null) {
/*     */         try {
/* 100 */           localBufferedReader.close();
/*     */         }
/*     */         catch (Exception localException3) {}
/*     */       }
/*     */     }
/*     */     
/* 106 */     return null;
/*     */   }
/*     */   
/*     */   static String c(Context paramContext) throws NullPointerException {
/* 110 */     if (paramContext == null) {
/* 111 */       throw new NullPointerException("Context is NUll");
/*     */     }
/* 113 */     String str = null;
/*     */     try {
/* 115 */       if (paramContext.getCacheDir() != null) {
/* 116 */         str = paramContext.getCacheDir().getPath();
/*     */       } else {
/* 118 */         File localFile = paramContext.getDir("/data/data/" + paramContext.getPackageName() + "/cache/", 0);
/* 119 */         if (localFile != null) {
/* 120 */           str = localFile.getPath();
/*     */         } else {
/* 122 */           str = null;
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/*     */     
/* 128 */     if (TextUtils.isEmpty(str)) {
/* 129 */       throw new NullPointerException("Cannot Create Cache Dir");
/*     */     }
/* 131 */     return str;
/*     */   }
/*     */   
/*     */   static void a(Context paramContext, JSONObject paramJSONObject) {
/* 135 */     try { if (paramJSONObject == null) {
/* 136 */         return;
/*     */       }
/* 138 */       if (paramContext != null) {
/* 139 */         paramContext = paramContext.getApplicationContext();
/*     */       }
/* 141 */       Debug.MemoryInfo localMemoryInfo = new Debug.MemoryInfo();
/* 142 */       Debug.getMemoryInfo(localMemoryInfo);
/* 143 */       JSONObject localJSONObject = new JSONObject();
/* 144 */       localJSONObject.put("dalvikPrivateDirty", localMemoryInfo.dalvikPrivateDirty);
/* 145 */       localJSONObject.put("dalvikPss", localMemoryInfo.dalvikPss);
/* 146 */       localJSONObject.put("dalvikSharedDirty", localMemoryInfo.dalvikSharedDirty);
/* 147 */       localJSONObject.put("nativePrivateDirty", localMemoryInfo.nativePrivateDirty);
/* 148 */       localJSONObject.put("nativePss", localMemoryInfo.nativePss);
/* 149 */       localJSONObject.put("nativeSharedDirty", localMemoryInfo.nativeSharedDirty);
/* 150 */       localJSONObject.put("otherPrivateDirty", localMemoryInfo.otherPrivateDirty);
/* 151 */       localJSONObject.put("otherPss", localMemoryInfo.otherPss);
/* 152 */       localJSONObject.put("otherSharedDirty", localMemoryInfo.otherSharedDirty);
/* 153 */       localJSONObject.put("totalPrivateClean", m.a(localMemoryInfo));
/* 154 */       localJSONObject.put("totalPrivateDirty", localMemoryInfo.getTotalPrivateDirty());
/* 155 */       localJSONObject.put("totalPss", localMemoryInfo.getTotalPss());
/* 156 */       localJSONObject.put("totalSharedClean", m.b(localMemoryInfo));
/* 157 */       localJSONObject.put("totalSharedDirty", localMemoryInfo.getTotalSharedDirty());
/* 158 */       localJSONObject.put("totalSwappablePss", m.c(localMemoryInfo));
/* 159 */       paramJSONObject.put("memory_info", localJSONObject);
/* 160 */       ActivityManager localActivityManager = null;
/* 161 */       if (paramContext != null) {
/* 162 */         localJSONObject = new JSONObject();
/* 163 */         localObject = new ActivityManager.MemoryInfo();
/* 164 */         localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
/* 165 */         localActivityManager.getMemoryInfo((ActivityManager.MemoryInfo)localObject);
/* 166 */         localJSONObject.put("availMem", ((ActivityManager.MemoryInfo)localObject).availMem);
/* 167 */         localJSONObject.put("lowMemory", ((ActivityManager.MemoryInfo)localObject).lowMemory);
/* 168 */         localJSONObject.put("threshold", ((ActivityManager.MemoryInfo)localObject).threshold);
/* 169 */         localJSONObject.put("totalMem", o.a((ActivityManager.MemoryInfo)localObject));
/* 170 */         paramJSONObject.put("sys_memory_info", localJSONObject);
/*     */       }
/* 172 */       localJSONObject = new JSONObject();
/* 173 */       localJSONObject.put("native_heap_size", Debug.getNativeHeapSize());
/* 174 */       localJSONObject.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
/* 175 */       localJSONObject.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
/* 176 */       Object localObject = Runtime.getRuntime();
/* 177 */       localJSONObject.put("max_memory", ((Runtime)localObject).maxMemory());
/* 178 */       localJSONObject.put("free_memory", ((Runtime)localObject).freeMemory());
/* 179 */       localJSONObject.put("total_memory", ((Runtime)localObject).totalMemory());
/* 180 */       if (localActivityManager != null) {
/* 181 */         localJSONObject.put("memory_class", localActivityManager.getMemoryClass());
/* 182 */         localJSONObject.put("large_memory_class", a(localActivityManager));
/*     */       }
/* 184 */       paramJSONObject.put("app_memory_info", localJSONObject);
/*     */     } catch (Throwable localThrowable) {}
/*     */   }
/*     */   
/*     */   static int a(ActivityManager paramActivityManager) {
/* 189 */     if (Build.VERSION.SDK_INT >= 11) {
/*     */       try {
/* 191 */         return paramActivityManager.getLargeMemoryClass();
/*     */       } catch (Throwable localThrowable) {
/* 193 */         return -1;
/*     */       }
/*     */     }
/* 196 */     return -1;
/*     */   }
/*     */   
/*     */   static boolean a(long paramLong, String paramString1, byte[] paramArrayOfByte, a parama, String paramString2) throws Throwable {
/* 200 */     if (paramString1 == null)
/* 201 */       return false;
/* 202 */     if (paramArrayOfByte == null)
/* 203 */       paramArrayOfByte = new byte[0];
/* 204 */     int i = paramArrayOfByte.length;
/* 205 */     byte[] arrayOfByte1 = paramArrayOfByte;
/* 206 */     String str = null;
/* 207 */     int j = 128;
/* 208 */     ByteArrayOutputStream localByteArrayOutputStream; Object localObject1; if ((a.b == parama) && (i > 128)) {
/* 209 */       localByteArrayOutputStream = new ByteArrayOutputStream(8192);
/* 210 */       localObject1 = new GZIPOutputStream(localByteArrayOutputStream);
/*     */       try {
/* 212 */         ((GZIPOutputStream)localObject1).write(paramArrayOfByte);
/*     */       } catch (Throwable localThrowable) {
/* 214 */         return false;
/*     */       } finally {
/* 216 */         ((GZIPOutputStream)localObject1).close();
/*     */       }
/* 218 */       localObject1 = null;
/* 219 */       arrayOfByte1 = localByteArrayOutputStream.toByteArray();
/* 220 */       str = "gzip";
/* 221 */     } else if ((a.c == parama) && (i > 128)) {
/* 222 */       localByteArrayOutputStream = new ByteArrayOutputStream(8192);
/* 223 */       localObject1 = new Deflater();
/* 224 */       ((Deflater)localObject1).setInput(paramArrayOfByte);
/* 225 */       ((Deflater)localObject1).finish();
/* 226 */       byte[] arrayOfByte2 = new byte[' '];
/* 227 */       while (!((Deflater)localObject1).finished()) {
/* 228 */         int k = ((Deflater)localObject1).deflate(arrayOfByte2);
/* 229 */         localByteArrayOutputStream.write(arrayOfByte2, 0, k);
/*     */       }
/* 231 */       ((Deflater)localObject1).end();
/* 232 */       arrayOfByte2 = null;
/* 233 */       localObject1 = null;
/* 234 */       arrayOfByte1 = localByteArrayOutputStream.toByteArray();
/* 235 */       str = "deflate";
/*     */     }
/* 237 */     return a(paramString1, arrayOfByte1, paramString2, str, "POST", true);
/*     */   }
/*     */   
/*     */   static boolean a(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3, String paramString4, boolean paramBoolean) throws Throwable {
/* 241 */     try { URL localURL = new URL(paramString1);
/* 242 */       HttpURLConnection localHttpURLConnection = (HttpURLConnection)localURL.openConnection();
/* 243 */       if (paramBoolean) {
/* 244 */         localHttpURLConnection.setDoOutput(true);
/*     */       } else
/* 246 */         localHttpURLConnection.setDoOutput(false);
/* 247 */       if (paramString2 != null)
/* 248 */         localHttpURLConnection.setRequestProperty("Content-Type", paramString2);
/* 249 */       if (paramString3 != null)
/* 250 */         localHttpURLConnection.setRequestProperty("Content-Encoding", paramString3);
/* 251 */       localHttpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
/* 252 */       if (paramString4 == null)
/* 253 */         throw new IllegalArgumentException("request method is not null");
/* 254 */       localHttpURLConnection.setRequestMethod(paramString4);
/* 255 */       if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
/* 256 */         localObject = new DataOutputStream(localHttpURLConnection.getOutputStream());
/* 257 */         ((DataOutputStream)localObject).write(paramArrayOfByte);
/* 258 */         ((DataOutputStream)localObject).flush();
/* 259 */         ((DataOutputStream)localObject).close();
/*     */       }
/* 261 */       Object localObject = localHttpURLConnection.getInputStream();
/* 262 */       int i = localHttpURLConnection.getResponseCode();
/* 263 */       if (i == 200)
/*     */       {
/* 265 */         String str = localHttpURLConnection.getContentEncoding();
/* 266 */         byte[] arrayOfByte; if (str.equalsIgnoreCase("gzip")) {
/* 267 */           GZIPInputStream localGZIPInputStream = new GZIPInputStream((InputStream)localObject);
/* 268 */           arrayOfByte = a(localGZIPInputStream);
/* 269 */           if (localGZIPInputStream != null) {
/* 270 */             localGZIPInputStream.close();
/* 271 */             localGZIPInputStream = null;
/*     */           }
/*     */         } else {
/* 274 */           arrayOfByte = a((InputStream)localObject);
/*     */         }
/* 276 */         if (localObject != null) {
/* 277 */           ((InputStream)localObject).close();
/* 278 */           localObject = null;
/*     */         }
/* 280 */         return true;
/*     */       }
/* 282 */       if (localObject != null) {
/* 283 */         ((InputStream)localObject).close();
/* 284 */         localObject = null;
/*     */       }
/* 286 */       return false;
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/* 289 */     return false;
/*     */   }
/*     */   
/*     */   static boolean a(String paramString, Map paramMap) {
/* 293 */     try { if (TextUtils.isEmpty(paramString))
/* 294 */         return false;
/* 295 */       String str = b("http://log.snssdk.com/service/2/app_log_exception/", paramMap);
/* 296 */       return a(2097152L, str, paramString.getBytes(), a.b, "application/json; charset=utf-8");
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/*     */     
/* 300 */     return false;
/*     */   }
/*     */   
/*     */   private static String b(String paramString, Map paramMap) {
/* 304 */     if ((TextUtils.isDigitsOnly(paramString)) || (paramMap == null))
/* 305 */       return paramString;
/* 306 */     if (paramString.indexOf("?") < 0)
/* 307 */       paramString = paramString + "?";
/* 308 */     if ((paramMap != null) && (paramMap.size() > 0)) {
/* 309 */       Iterator localIterator = paramMap.entrySet().iterator();
/* 310 */       while (localIterator.hasNext()) {
/* 311 */         Map.Entry localEntry = (Map.Entry)localIterator.next();
/* 312 */         if (paramMap.get(localEntry.getKey()) != null) {
/* 313 */           if (paramString.endsWith("?")) {
/* 314 */             paramString = paramString + a(localEntry.getKey().toString(), "UTF-8") + "=" + a(paramMap.get(localEntry.getKey()).toString(), "UTF-8");
/*     */           } else {
/* 316 */             paramString = paramString + "&" + a(localEntry.getKey().toString(), "UTF-8") + "=" + a(paramMap.get(localEntry.getKey()).toString(), "UTF-8");
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 321 */     return paramString;
/*     */   }
/*     */   
/*     */   private static String a(String paramString1, String paramString2) {
/* 325 */     try { return URLEncoder.encode(paramString1, paramString2 != null ? paramString2 : "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException localUnsupportedEncodingException) {
/* 328 */       throw new IllegalArgumentException(localUnsupportedEncodingException);
/*     */     }
/*     */   }
/*     */   
/* 332 */   static byte[] a(InputStream paramInputStream) throws IOException { ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
/* 333 */     byte[] arrayOfByte = new byte[' '];
/* 334 */     int i = 0;
/* 335 */     while (-1 != (i = paramInputStream.read(arrayOfByte))) {
/* 336 */       localByteArrayOutputStream.write(arrayOfByte, 0, i);
/*     */     }
/* 338 */     if (paramInputStream != null) {
/* 339 */       paramInputStream.close();
/* 340 */       paramInputStream = null;
/*     */     }
/* 342 */     return localByteArrayOutputStream.toByteArray();
/*     */   }
/*     */   
/* 345 */   static void a(Closeable paramCloseable) { if (paramCloseable == null) {
/* 346 */       return;
/*     */     }
/*     */     try {
/* 349 */       paramCloseable.close();
/*     */     }
/*     */     catch (IOException localIOException) {}
/*     */   }
/*     */   
/*     */   static JSONObject a(Context paramContext, Thread paramThread, Throwable paramThrowable)
/*     */   {
/* 356 */     if (paramThrowable == null) {
/* 357 */       return null;
/*     */     }
/* 359 */     JSONObject localJSONObject = new JSONObject();
/*     */     try {
/* 361 */       if (paramContext != null) {
/* 362 */         paramContext = paramContext.getApplicationContext();
/*     */       }
/* 364 */       Throwable localThrowable1 = paramThrowable;
/* 365 */       String str1 = null;
/* 366 */       StringWriter localStringWriter = new StringWriter();
/* 367 */       PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
/* 368 */       localThrowable1.printStackTrace(localPrintWriter);
/* 369 */       localThrowable1 = localThrowable1.getCause();
/* 370 */       if (localThrowable1 != null) {
/* 371 */         localThrowable1.printStackTrace(localPrintWriter);
/* 372 */         localThrowable1 = localThrowable1.getCause();
/* 373 */         if (localThrowable1 != null) {
/* 374 */           localThrowable1.printStackTrace(localPrintWriter);
/*     */         }
/*     */       }
/* 377 */       str1 = localStringWriter.toString();
/* 378 */       localPrintWriter.close();
/* 379 */       if (str1 == null) {
/* 380 */         return localJSONObject;
/*     */       }
/* 382 */       localJSONObject.put("data", str1);
/* 383 */       localJSONObject.put("crash_time", System.currentTimeMillis());
/* 384 */       String str2 = "";
/* 385 */       if (paramContext != null) {
/* 386 */         str2 = b(paramContext);
/* 387 */         localJSONObject.put("process_name", str2);
/* 388 */         if (!a(paramContext)) {
/* 389 */           localJSONObject.put("remote_process", 1);
/*     */         }
/*     */       }
/* 392 */       if (paramContext != null) {
/* 393 */         a(paramContext, localJSONObject);
/*     */       }
/* 395 */       if ((a(paramThrowable)) || (a(str2, paramThrowable))) {
/* 396 */         if ((str2 != null) && (str2.endsWith(":ad"))) {
/* 397 */           localJSONObject.put("data_files", d(paramContext));
/*     */         }
/* 399 */         localJSONObject.put("all_thread_stacks", b());
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable2) {}
/* 403 */     return localJSONObject;
/*     */   }
/*     */   
/*     */   private static String d(Context paramContext) {
/* 407 */     if (paramContext == null) {
/* 408 */       return "";
/*     */     }
/*     */     try {
/* 411 */       File localFile = paramContext.getFilesDir();
/* 412 */       return a(localFile).toString();
/*     */     }
/*     */     catch (Throwable localThrowable) {
/* 415 */       localThrowable.printStackTrace();
/*     */     }
/* 417 */     return "";
/*     */   }
/*     */   
/*     */   private static JSONArray a(File paramFile) {
/* 421 */     JSONArray localJSONArray = new JSONArray();
/* 422 */     if ((paramFile == null) || (!paramFile.exists())) {
/* 423 */       return localJSONArray;
/*     */     }
/* 425 */     if (paramFile.isFile()) {
/* 426 */       localJSONArray.put(paramFile.getName());
/* 427 */       return localJSONArray;
/*     */     }
/* 429 */     File[] arrayOfFile1 = paramFile.listFiles();
/* 430 */     if (arrayOfFile1 == null) {
/* 431 */       return localJSONArray;
/*     */     }
/* 433 */     for (File localFile : arrayOfFile1) {
/* 434 */       if (localFile.isFile()) {
/* 435 */         localJSONArray.put(localFile.getName());
/* 436 */       } else if (localFile.isDirectory()) {
/*     */         try {
/* 438 */           JSONObject localJSONObject = new JSONObject();
/* 439 */           localJSONObject.put(localFile.getName(), a(localFile));
/* 440 */           localJSONArray.put(localJSONObject);
/*     */         }
/*     */         catch (JSONException localJSONException) {
/* 443 */           localJSONException.printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/* 447 */     return localJSONArray;
/*     */   }
/*     */   
/*     */   private static boolean a(String paramString, Throwable paramThrowable) {
/* 451 */     if ((paramString == null) || (!paramString.endsWith(":ad"))) {
/* 452 */       return false;
/*     */     }
/*     */     try {
/* 455 */       Throwable localThrowable1 = paramThrowable;
/* 456 */       int i = 0;
/* 457 */       while (localThrowable1 != null) {
/* 458 */         if ((localThrowable1 instanceof NullPointerException)) {
/* 459 */           return true;
/*     */         }
/* 461 */         if (i > 20) {
/* 462 */           return false;
/*     */         }
/* 464 */         i++;
/* 465 */         localThrowable1 = localThrowable1.getCause();
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable2) {}
/*     */     
/* 470 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean a(Throwable paramThrowable) {
/* 474 */     if (paramThrowable == null) {
/* 475 */       return false;
/*     */     }
/*     */     try {
/* 478 */       Throwable localThrowable1 = paramThrowable;
/* 479 */       int i = 0;
/* 480 */       while (localThrowable1 != null) {
/* 481 */         if ((localThrowable1 instanceof OutOfMemoryError)) {
/* 482 */           return true;
/*     */         }
/* 484 */         if (i > 20) {
/* 485 */           return false;
/*     */         }
/* 487 */         i++;
/* 488 */         localThrowable1 = localThrowable1.getCause();
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable2) {}
/*     */     
/* 493 */     return false;
/*     */   }
/*     */   
/*     */ 
/* 497 */   private static Set<String> b = new HashSet();
/* 498 */   private static Set<String> c = new HashSet();
/*     */   
/* 500 */   static { b.add("ThreadPlus");
/* 501 */     b.add("ApiDispatcher");
/* 502 */     b.add("ApiLocalDispatcher");
/* 503 */     b.add("AsyncLoader");
/* 504 */     b.add("AsyncTask");
/* 505 */     b.add("Binder");
/* 506 */     b.add("PackageProcessor");
/* 507 */     b.add("SettingsObserver");
/* 508 */     b.add("WifiManager");
/* 509 */     b.add("JavaBridge");
/* 510 */     b.add("Compiler");
/* 511 */     b.add("Signal Catcher");
/* 512 */     b.add("GC");
/* 513 */     b.add("ReferenceQueueDaemon");
/* 514 */     b.add("FinalizerDaemon");
/* 515 */     b.add("FinalizerWatchdogDaemon");
/* 516 */     b.add("CookieSyncManager");
/* 517 */     b.add("RefQueueWorker");
/* 518 */     b.add("CleanupReference");
/* 519 */     b.add("VideoManager");
/* 520 */     b.add("DBHelper-AsyncOp");
/* 521 */     b.add("InstalledAppTracker2");
/* 522 */     b.add("AppData-AsyncOp");
/* 523 */     b.add("IdleConnectionMonitor");
/* 524 */     b.add("LogReaper");
/* 525 */     b.add("ActionReaper");
/* 526 */     b.add("Okio Watchdog");
/* 527 */     b.add("CheckWaitingQueue");
/* 528 */     c.add("com.facebook.imagepipeline.core.PriorityThreadFactory");
/* 529 */     c.add("com.ss.android.common.util.SimpleThreadFactory");
/*     */   }
/*     */   
/*     */   private static String b()
/*     */   {
/*     */     try {
/* 535 */       Map localMap = Thread.getAllStackTraces();
/* 536 */       JSONObject localJSONObject1 = new JSONObject();
/* 537 */       if (localMap != null) {
/* 538 */         localJSONObject1.put("tr_all_count", localMap.size());
/*     */       }
/* 540 */       JSONArray localJSONArray = new JSONArray();
/* 541 */       for (Object localObject1 = localMap.entrySet().iterator(); ((Iterator)localObject1).hasNext();) { Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
/* 542 */         if (localEntry != null) {
/* 543 */           JSONObject localJSONObject2 = new JSONObject();
/* 544 */           Thread localThread = (Thread)localEntry.getKey();
/* 545 */           String str1 = localThread.getName();
/* 546 */           int i = 0;
/* 547 */           Object localObject2; if (b.contains(str1)) {
/* 548 */             i = 1;
/*     */           } else
/* 550 */             for (localObject2 = b.iterator(); ((Iterator)localObject2).hasNext();) { localObject3 = (String)((Iterator)localObject2).next();
/* 551 */               if ((!TextUtils.isEmpty(str1)) && 
/* 552 */                 (str1.startsWith((String)localObject3))) {
/* 553 */                 i = 1;
/* 554 */                 break;
/*     */               }
/*     */             }
/*     */           Object localObject3;
/* 558 */           if (i == 0)
/*     */           {
/*     */ 
/* 561 */             localJSONObject2.put("tr_n", localThread.getName());
/* 562 */             localObject2 = (StackTraceElement[])localEntry.getValue();
/* 563 */             if (localObject2 != null) {
/* 564 */               localObject3 = new JSONArray();
/* 565 */               for (Object localObject5 : localObject2) {
/* 566 */                 String str2 = ((StackTraceElement)localObject5).getClassName();
/* 567 */                 if (c.contains(str2)) {
/* 568 */                   i = 1;
/* 569 */                   break;
/*     */                 }
/* 571 */                 for (Object localObject6 = c.iterator(); ((Iterator)localObject6).hasNext();) { String str3 = (String)((Iterator)localObject6).next();
/* 572 */                   if ((!TextUtils.isEmpty(str2)) && 
/* 573 */                     (str2.startsWith(str3))) {
/* 574 */                     i = 1;
/* 575 */                     break;
/*     */                   }
/*     */                 }
/*     */                 
/*     */ 
/*     */ 
/* 581 */                 localObject6 = str2 + "." + ((StackTraceElement)localObject5).getMethodName() + "(" + ((StackTraceElement)localObject5).getLineNumber() + ")";
/* 582 */                 ((JSONArray)localObject3).put(localObject6);
/*     */               }
/* 584 */               if (i == 0)
/*     */               {
/*     */ 
/* 587 */                 localJSONObject2.put("tr_st", localObject3);
/*     */               }
/* 589 */             } else if (i == 0)
/*     */             {
/*     */ 
/* 592 */               localJSONArray.put(localJSONObject2);
/*     */             }
/* 594 */           } } else { localJSONObject1.put("tr_stacks", localJSONArray);
/*     */         } }
/* 596 */       return localJSONObject1.toString();
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/*     */     
/*     */ 
/* 601 */     return "";
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\ss\android\crash\log\l.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */