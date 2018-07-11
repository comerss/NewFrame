/*     */ package com.bytedance.sdk.openadsdk.ccccc;
/*     */ 
/*     */

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;

import com.bytedance.sdk.openadsdk.ggg.m;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class k
/*     */   implements Runnable
/*     */ {
/*     */   private final Context a;
/*     */   private final d b;
/*     */   private final w c;
/*     */   private final v d;
/*     */   private final g e;
/*     */   private volatile boolean f;
/*     */   
/*     */   public k(Context paramContext, w paramw, d paramd, v paramv, g paramg)
/*     */   {
/*  64 */     this.a = paramContext;
/*  65 */     this.c = paramw;
/*  66 */     this.b = paramd;
/*  67 */     this.d = paramv;
/*  68 */     this.e = paramg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private String a()
/*     */   {
/*  75 */     String str = this.b.q;
/*  76 */     if (str == null) {
/*  77 */       str = b.b;
/*     */     }
/*  79 */     return str;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public void run()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: bipush 10
/*     */     //   2: invokestatic 195	android/os/Process:setThreadPriority	(I)V
/*     */     //   5: aload_0
/*     */     //   6: invokespecial 223	com/bytedance/sdk/openadsdk/cdsss/m:Result	()V
/*     */     //   9: aload_0
/*     */     //   10: getfield 164	com/bytedance/sdk/openadsdk/cdsss/m:eee	Lcom/bytedance/sdk/openadsdk/cdsss/g;
/*     */     //   13: aload_0
/*     */     //   14: getfield 161	com/bytedance/sdk/openadsdk/cdsss/m:Result	Lcom/bytedance/sdk/openadsdk/cdsss/d;
/*     */     //   17: getfield 147	com/bytedance/sdk/openadsdk/cdsss/d:ssl	J
/*     */     //   20: lconst_0
/*     */     //   21: invokevirtual 209	com/bytedance/sdk/openadsdk/cdsss/g:ssl	(JJ)V
/*     */     //   24: goto +21 -> 45
/*     */     //   27: astore_1
/*     */     //   28: aload_0
/*     */     //   29: getfield 164	com/bytedance/sdk/openadsdk/cdsss/m:eee	Lcom/bytedance/sdk/openadsdk/cdsss/g;
/*     */     //   32: aload_0
/*     */     //   33: getfield 161	com/bytedance/sdk/openadsdk/cdsss/m:Result	Lcom/bytedance/sdk/openadsdk/cdsss/d;
/*     */     //   36: getfield 147	com/bytedance/sdk/openadsdk/cdsss/d:ssl	J
/*     */     //   39: lconst_0
/*     */     //   40: invokevirtual 209	com/bytedance/sdk/openadsdk/cdsss/g:ssl	(JJ)V
/*     */     //   43: aload_1
/*     */     //   44: athrow
/*     */     //   45: return
/*     */     // Line number table:
/*     */     //   Java source line #132	-> byte code offset #0
/*     */     //   Java source line #134	-> byte code offset #5
/*     */     //   Java source line #136	-> byte code offset #9
/*     */     //   Java source line #137	-> byte code offset #24
/*     */     //   Java source line #136	-> byte code offset #27
/*     */     //   Java source line #138	-> byte code offset #45
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	46	0	this	m
/*     */     //   27	17	1	localObject	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   5	9	27	finally
/*     */   }
/*     */   
/*     */   static class a
/*     */   {
/*     */     public String a;
/*     */     public String b;
/*  88 */     public int c = 0;
/*  89 */     public boolean d = false;
/*     */     public String e;
/*  91 */     public long f = -1L;
/*  92 */     public long g = 0L;
/*     */     public String h;
/*  94 */     public boolean i = false;
/*  95 */     public long j = 0L;
/*  96 */     public long k = 0L;
/*  97 */     public int l = -1;
/*     */     
/*     */ 
/*     */     public long m;
/*     */     
/*     */     public long n;
/*     */     
/*     */     public long o;
/*     */     
/* 106 */     public long p = -1L;
/*     */     public String q;
/*     */     public String r;
/*     */     public int s;
/*     */     public URL t;
/*     */     
/*     */     public a(d paramd)
/*     */     {
/* 114 */       this.b = paramd.f;
/* 115 */       this.e = paramd.b;
/* 116 */       this.a = paramd.e;
/* 117 */       this.f = paramd.s;
/* 118 */       this.g = paramd.t;
/*     */     }
/*     */     
/*     */     public void a()
/*     */     {
/* 123 */       this.p = -1L;
/* 124 */       this.q = null;
/* 125 */       this.r = null;
/* 126 */       this.s = 0;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void b()
/*     */   {
/* 143 */     if (com.bytedance.sdk.openadsdk.ccccc.d.a(i.a(this.a), this.b.a) == 200)
/*     */     {
/* 145 */       Log.d("SsDownloadManager", "Download " + this.b.a + " already finished; skipping");
/* 146 */       return;
/*     */     }
/*     */     
/* 149 */     a locala = new a(this.b);
/* 150 */     Object localObject1 = null;
/* 151 */     int i = 491;
/* 152 */     int j = this.b.k;
/* 153 */     String str1 = null;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 161 */       Log.i("SsDownloadManager", "Download " + this.b.a + " starting");
/*     */       
/*     */ 
/*     */ 
/* 165 */       NetworkInfo localNetworkInfo1 = this.c.b();
/* 166 */       if (localNetworkInfo1 != null) {
/* 167 */         locala.l = localNetworkInfo1.getType();
/*     */       }
/*     */       
/*     */       try
/*     */       {
/* 172 */         locala.t = new URL(locala.e);
/*     */       } catch (MalformedURLException localMalformedURLException) {
/* 174 */         throw new u(400, localMalformedURLException);
/*     */       }
/*     */       
/* 177 */       a(locala);
/*     */       
/* 179 */       b(locala);
/* 180 */       i = 200;
/*     */     }
/*     */     catch (u localu) {
/* 183 */       str1 = localu.getMessage();
///* 184 */       str2 = "Aborting request for download " + this.bee.bb + ": " + str1;
///* 185 */       Log.w("SsDownloadManager", str2);
/* 186 */       if (b.c) {
///* 187 */         Log.w("SsDownloadManager", str2, localu);
/*     */       }
/* 189 */       i = localu.a();
/*     */       
/*     */ 
/*     */ 
/* 193 */       if (i == 194) {
/* 194 */         throw new IllegalStateException("Execution should always throw final error codes");
/*     */       }
/*     */       
/*     */ 
/* 198 */       if (a(i)) {
/* 199 */         if (locala.d) {
/* 200 */           j = 1;
/*     */         } else {
/* 202 */           j++;
/*     */         }
/*     */         
/* 205 */         if (j < 5) {
/* 206 */           NetworkInfo localNetworkInfo2 = this.c.b();
/* 207 */           if ((localNetworkInfo2 != null) && (localNetworkInfo2.getType() == locala.l) && 
/* 208 */             (localNetworkInfo2.isConnected()))
/*     */           {
/* 210 */             i = 194;
/*     */           }
/*     */           else {
/* 213 */             i = 195;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable)
/*     */     {
/* 220 */       str1 = localThrowable.getMessage();
/* 221 */       String str2 = "Exception for id " + this.b.a + ": " + str1;
/* 222 */       Log.w("SsDownloadManager", str2, localThrowable);
/* 223 */       i = 491;
/*     */     }
/*     */     finally {
/* 226 */       a(locala, i);
/* 227 */       a(locala, i, str1, j);
/*     */       
///* 229 */       Log.i("SsDownloadManager", "Download " + this.bee.bb + " finished with status " +
///* 230 */         mM.bb.d(i));
/*     */       
/* 232 */       if (localObject1 != null) {
/* 233 */         ((PowerManager.WakeLock)localObject1).release();
/* 234 */         localObject1 = null;
/*     */       }
/*     */     }
/* 237 */     this.d.a();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void a(a parama)
/*     */     throws u
/*     */   {
/* 245 */     parama.a();
/* 246 */     h(parama);
/*     */     
/*     */ 
/* 249 */     if (parama.g == parama.f) {
/* 250 */       Log.i("SsDownloadManager", "Skipping initiating request for download " + this.b.a + "; already completed");
/*     */     }
/*     */     else
/*     */     {
/*     */       for (;;) {
/* 255 */         if (parama.s++ >= 5) {
/*     */           break;
/*     */         }
/* 258 */         HttpURLConnection localHttpURLConnection = null;
/*     */         try {
/* 260 */           c();
/* 261 */           localHttpURLConnection = (HttpURLConnection)parama.t.openConnection();
/* 262 */           localHttpURLConnection.setInstanceFollowRedirects(false);
/* 263 */           localHttpURLConnection.setConnectTimeout(20000);
/* 264 */           localHttpURLConnection.setReadTimeout(20000);
/*     */           
/* 266 */           e(parama, localHttpURLConnection);
/*     */           
/* 268 */           int i = localHttpURLConnection.getResponseCode();
/* 269 */           switch (i) {
/*     */           case 200: 
/* 271 */             if (parama.i) {
/* 272 */               throw new u(489, "Expected partial, but received OK");
/*     */             }
/*     */             
/* 275 */             b(parama, localHttpURLConnection);
/* 276 */             a(parama, localHttpURLConnection);
/* 277 */             return;
/*     */           
/*     */           case 206: 
/* 280 */             if (!parama.i) {
/* 281 */               throw new u(489, "Expected OK, but received partial");
/*     */             }
/*     */             
/* 284 */             a(parama, localHttpURLConnection);
/* 285 */             return;
/*     */           
/*     */           case 301: 
/*     */           case 302: 
/*     */           case 303: 
/*     */           case 307: 
/* 291 */             String str = localHttpURLConnection.getHeaderField("Location");
/* 292 */             parama.t = new URL(parama.t, str);
/* 293 */             if (i == 301)
/*     */             {
/* 295 */               parama.e = parama.t.toString();
/*     */             }
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
/* 320 */             if (localHttpURLConnection != null) localHttpURLConnection.disconnect();
/*     */             break;
/*     */           case 416: 
/* 299 */             throw new u(489, "Requested range not satisfiable");
/*     */           
/*     */ 
/*     */           case 503: 
/* 303 */             d(parama, localHttpURLConnection);
/*     */             
/* 305 */             throw new u(503, localHttpURLConnection.getResponseMessage());
/*     */           
/*     */ 
/*     */           case 500: 
/* 309 */             throw new u(500, localHttpURLConnection.getResponseMessage());
/*     */           
/*     */           default: 
/* 312 */             u.a(i, localHttpURLConnection
/* 313 */               .getResponseMessage());
/*     */           }
/*     */         }
/*     */         catch (IOException localIOException) {
/* 317 */           throw new u(495, localIOException);
/*     */         }
/*     */         finally {
/* 320 */           if (localHttpURLConnection != null) { localHttpURLConnection.disconnect();
/*     */           }
/*     */         }
/*     */       }
/* 324 */       throw new u(497, "Too many redirects");
/*     */     }
/*     */   }
/*     */   
/*     */   private void a(a parama, HttpURLConnection paramHttpURLConnection)
/*     */     throws u
/*     */   {
/* 331 */     InputStream localInputStream = null;
/* 332 */     FileOutputStream localFileOutputStream = null;
/* 333 */     FileDescriptor localFileDescriptor = null;
/*     */     try {
/*     */       try {
/* 336 */         localInputStream = paramHttpURLConnection.getInputStream();
/*     */       } catch (IOException localIOException1) {
/* 338 */         throw new u(495, localIOException1);
/*     */       }
/*     */       try
/*     */       {
/* 342 */         localFileOutputStream = new FileOutputStream(parama.a, true);
/* 343 */         localFileDescriptor = ((FileOutputStream)localFileOutputStream).getFD();
/*     */       } catch (IOException localIOException2) {
/* 345 */         throw new u(492, localIOException2);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 350 */       a(parama, localInputStream, localFileOutputStream);
/*     */       
/* 352 */       if (localInputStream != null) {
/*     */         try {
/* 354 */           localInputStream.close();
/*     */         } catch (IOException localIOException3) {
/* 356 */           localIOException3.printStackTrace();
/*     */         }
/*     */       }
/*     */       try {
/* 360 */         if (localFileOutputStream != null) localFileOutputStream.flush();
/* 361 */         if (localFileDescriptor != null) localFileDescriptor.sync();
/*     */       }
/*     */       catch (IOException localIOException5) {}finally {
/* 364 */         if (localFileOutputStream != null) {
/*     */           try {
/* 366 */             localFileOutputStream.close();
/*     */           } catch (IOException localIOException7) {
/* 368 */             localIOException7.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */       return;
/*     */     }
/*     */     finally
/*     */     {
/* 352 */       if (localInputStream != null) {
/*     */         try {
/* 354 */           localInputStream.close();
/*     */         } catch (IOException localIOException8) {
/* 356 */           localIOException8.printStackTrace();
/*     */         }
/*     */       }
/*     */       try {
/* 360 */         if (localFileOutputStream != null) localFileOutputStream.flush();
/* 361 */         if (localFileDescriptor != null) { localFileDescriptor.sync();
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
///* 369 */         throw ((Throwable)localObject2);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/*     */       catch (IOException localIOException10) {}finally
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
/* 364 */         if (localFileOutputStream != null) {
/*     */           try {
/* 366 */             localFileOutputStream.close();
/*     */           } catch (IOException localIOException12) {
/* 368 */             localIOException12.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void c()
/*     */     throws u
/*     */   {
/* 380 */     this.f = false;
/*     */     
/* 382 */     com.bytedance.sdk.openadsdk.ccccc.d.aenumse locala = this.b.b();
/* 383 */     /*if (locala != d.bb.bb) {
*//* 384 *//*       throw new u(195, locala.name());
*//*     *//*     }*/
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void a(a parama, InputStream paramInputStream, OutputStream paramOutputStream)
/*     */     throws u
/*     */   {
/* 394 */     byte[] arrayOfByte = new byte['က'];
/*     */     for (;;) {
/* 396 */       int i = a(parama, arrayOfByte, paramInputStream);
/* 397 */       if (i == -1) {
/* 398 */         e(parama);
/* 399 */         return;
/*     */       }
/*     */       
/* 402 */       parama.d = true;
/* 403 */       a(parama, arrayOfByte, i, paramOutputStream);
/* 404 */       parama.g += i;
/* 405 */       d(parama);
/*     */       
/* 407 */      /* if (bee.d) {
*//* 408 *//*         Log.v("SsDownloadManager", "downloaded " + parama.g + " for " + this.bee.bee);
*//*     *//*       }*/
/*     */       
/*     */ 
/* 412 */       c(parama);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void b(a parama)
/*     */   {
/* 420 */     if (parama.a != null)
/*     */     {
/* 422 */       a(parama.a, 420);
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
/*     */   public void a(String paramString, int paramInt)
/*     */   {
/*     */     try
/*     */     {
/* 437 */       Class localClass = Class.forName("android.os.FileUtils");
/* 438 */       if (localClass == null) {
/* 439 */         return;
/*     */       }
/*     */       
/* 442 */       Method localMethod = localClass.getMethod("setPermissions", new Class[] { String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE });
/* 443 */       if (localMethod == null) {
/* 444 */         return;
/*     */       }
/* 446 */       int i = ((Integer)localMethod.invoke(null, new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(-1), Integer.valueOf(-1) })).intValue();
/* 447 */       if (i != 0) {
/* 448 */         m.b("NetHackDbg", "android.os.FileUtils.setPermissions() returned " + i + " for '" + paramString + "', probably didn't work.");
/*     */       }
/*     */     }
/*     */     catch (ClassNotFoundException localClassNotFoundException) {
/* 452 */       m.b("NetHackDbg", "android.os.FileUtils.setPermissions() failed - ClassNotFoundException.");
/*     */     } catch (IllegalAccessException localIllegalAccessException) {
/* 454 */       m.b("NetHackDbg", "android.os.FileUtils.setPermissions() failed - IllegalAccessException.");
/*     */     } catch (InvocationTargetException localInvocationTargetException) {
/* 456 */       m.b("NetHackDbg", "android.os.FileUtils.setPermissions() failed - InvocationTargetException.");
/*     */     } catch (NoSuchMethodException localNoSuchMethodException) {
/* 458 */       m.b("NetHackDbg", "android.os.FileUtils.setPermissions() failed - NoSuchMethodException.");
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void a(a parama, int paramInt)
/*     */   {
/* 468 */     if ((parama.a != null) && (com.bytedance.sdk.openadsdk.ccccc.m.a.b(paramInt))) {
/* 469 */     /*  if (bee.d) {
*//* 470 *//*         Log.d("SsDownloadManager", "cleanupDestination() deleting " + parama.bb);
*//*     *//*       }*/
/* 472 */       new File(parama.a).delete();
/* 473 */       parama.a = null;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void c(a parama)
/*     */     throws u
/*     */   {
/* 482 */     synchronized (this.b) {
/* 483 */       if (this.b.i == 1) {
/* 484 */         throw new u(193, "download paused by owner");
/*     */       }
/*     */       
/* 487 */       if ((this.b.j == 490) || (this.b.w)) {
/* 488 */         throw new u(490, "download canceled");
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 493 */     if (this.f) {
/* 494 */       c();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void d(a parama)
/*     */   {
/* 502 */     long l1 = SystemClock.elapsedRealtime();
/*     */     
/* 504 */     long l2 = l1 - parama.n;
/* 505 */     if (l2 > 500L) {
/* 506 */       long l3 = (parama.g - parama.o) * 1000L / l2;
/*     */       
/*     */ 
/* 509 */       if (parama.m == 0L) {
/* 510 */         parama.m = l3;
/*     */       } else {
/* 512 */         parama.m = ((parama.m * 3L + l3) / 4L);
/*     */       }
/*     */       
/*     */ 
/* 516 */       if (parama.n != 0L) {
/* 517 */         this.e.a(this.b.a, parama.m);
/*     */       }
/*     */       
/* 520 */       parama.n = l1;
/* 521 */       parama.o = parama.g;
/*     */     }
/*     */     
/* 524 */     if ((parama.g - parama.j > 4096L) && (l1 - parama.k > 1500L))
/*     */     {
/* 526 */       ContentValues localContentValues = new ContentValues();
/* 527 */       localContentValues.put("current_bytes", Long.valueOf(parama.g));
/* 528 */       i.a(this.a).a(this.b.d(), localContentValues, null, null);
/* 529 */       parama.j = parama.g;
/* 530 */       parama.k = l1;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void a(a parama, byte[] paramArrayOfByte, int paramInt, OutputStream paramOutputStream)
/*     */     throws u
/*     */   {
/* 541 */     this.d.a(this.b.g, parama.a, paramInt);
/*     */     
/*     */ 
/* 544 */     int i = 0;
/*     */     for (;;) {
/*     */       try {
/* 547 */         paramOutputStream.write(paramArrayOfByte, 0, paramInt);
/* 548 */         return;
/*     */       }
/*     */       catch (IOException localIOException) {
/* 551 */         if (i == 0)
/*     */         {
/* 553 */           this.d.b(this.b.g, parama.a, paramInt);
/* 554 */           i = 1;
/*     */         } else {
/* 556 */           throw new u(492, "Failed to write data: " + localIOException);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void e(a parama)
/*     */     throws u
/*     */   {
/* 568 */     ContentValues localContentValues = new ContentValues();
/* 569 */     localContentValues.put("current_bytes", Long.valueOf(parama.g));
/* 570 */     if (parama.p == -1L) {
/* 571 */       localContentValues.put("total_bytes", Long.valueOf(parama.g));
/*     */     }
/* 573 */     i.a(this.a).a(this.b.d(), localContentValues, null, null);
/*     */     
/* 575 */     int i = (parama.p != -1L) && (parama.g != parama.p) ? 1 : 0;
/*     */     
/* 577 */     if (i != 0) {
/* 578 */       if (f(parama)) {
/* 579 */         throw new u(489, "mismatched content length; unable to resume");
/*     */       }
/*     */       
/* 582 */       throw new u(495, "closed socket before end of file");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean f(a parama)
/*     */   {
/* 589 */     return (parama.g > 0L) && (!this.b.c) && (parama.h == null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int a(a parama, byte[] paramArrayOfByte, InputStream paramInputStream)
/*     */     throws u
/*     */   {
/*     */     try
/*     */     {
/* 601 */       return paramInputStream.read(paramArrayOfByte);
/*     */     }
/*     */     catch (IOException localIOException) {
/* 604 */       if ("unexpected end of stream".equals(localIOException.getMessage())) {
/* 605 */         return -1;
/*     */       }
/*     */       
/* 608 */       ContentValues localContentValues = new ContentValues();
/* 609 */       localContentValues.put("current_bytes", Long.valueOf(parama.g));
/* 610 */       i.a(this.a).a(this.b.d(), localContentValues, null, null);
/* 611 */       if (f(parama)) {
/* 612 */         throw new u(489, "Failed reading response: " + localIOException + "; unable to resume", localIOException);
/*     */       }
/*     */       
/* 615 */       throw new u(495, "Failed reading response: " + localIOException, localIOException);
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
/*     */   private void b(a parama, HttpURLConnection paramHttpURLConnection)
/*     */     throws u
/*     */   {
/* 629 */     c(parama, paramHttpURLConnection);
/*     */     
/* 631 */     parama.a = n.a(this.a, this.b.b, this.b.d, parama.q, parama.r, parama.b, this.b.g, parama.p, this.d);
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
/* 642 */     g(parama);
/*     */     
/* 644 */     c();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void g(a parama)
/*     */   {
/* 652 */     ContentValues localContentValues = new ContentValues();
/* 653 */     localContentValues.put("_data", parama.a);
/* 654 */     if (parama.h != null) {
/* 655 */       localContentValues.put("etag", parama.h);
/*     */     }
/* 657 */     if (parama.b != null) {
/* 658 */       localContentValues.put("mimetype", parama.b);
/*     */     }
/* 660 */     localContentValues.put("total_bytes", Long.valueOf(this.b.s));
/* 661 */     i.a(this.a).a(this.b.d(), localContentValues, null, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void c(a parama, HttpURLConnection paramHttpURLConnection)
/*     */     throws u
/*     */   {
/* 669 */     parama.q = paramHttpURLConnection.getHeaderField("Content-Disposition");
/* 670 */     parama.r = paramHttpURLConnection.getHeaderField("Content-Location");
/*     */     
/* 672 */     if (parama.b == null) {
/* 673 */       parama.b = paramHttpURLConnection.getContentType();
/*     */     }
/*     */     
/* 676 */     parama.h = paramHttpURLConnection.getHeaderField("ETag");
/*     */     
/* 678 */     String str = paramHttpURLConnection.getHeaderField("Transfer-Encoding");
/* 679 */     if (str == null) {
/* 680 */       parama.p = a(paramHttpURLConnection, "Content-Length", -1L);
/*     */     } else {
/* 682 */       Log.i("SsDownloadManager", "Ignoring Content-Length since Transfer-Encoding is also defined");
/* 683 */       parama.p = -1L;
/*     */     }
/*     */     
/* 686 */     parama.f = parama.p;
/* 687 */     this.b.s = parama.p;
/*     */     
/*     */ 
/* 690 */     int i = (parama.p == -1L) && ((str == null) || (!str.equalsIgnoreCase("chunked"))) ? 1 : 0;
/* 691 */     if ((!this.b.c) && (i != 0)) {
/* 692 */       throw new u(489, "can't know size of download, giving up");
/*     */     }
/*     */   }
/*     */   
/*     */   private void d(a parama, HttpURLConnection paramHttpURLConnection)
/*     */   {
/* 698 */     parama.c = paramHttpURLConnection.getHeaderFieldInt("Retry-After", -1);
/* 699 */     if (parama.c < 0) {
/* 700 */       parama.c = 0;
/*     */     } else {
/* 702 */       if (parama.c < 30) {
/* 703 */         parama.c = 30;
/* 704 */       } else if (parama.c > 86400) {
/* 705 */         parama.c = 86400;
/*     */       }
/* 707 */       parama.c += n.a.nextInt(31);
/* 708 */       parama.c *= 1000;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void h(a parama)
/*     */     throws u
/*     */   {
/* 717 */     if (!TextUtils.isEmpty(parama.a)) {
/* 718 */       if (b.c) {
/* 719 */         Log.i("SsDownloadManager", "have run thread before for id: " + this.b.a + ", and state.mFilename: " + parama.a);
/*     */       }
/*     */       
/* 722 */       if (!n.a(parama.a, this.d
/* 723 */         .b()))
/*     */       {
/* 725 */         throw new u(492, "found invalid internal destination filename");
/*     */       }
/*     */       
/*     */ 
/* 729 */       File localFile = new File(parama.a);
/* 730 */       if (localFile.exists()) {
/* 731 */         if (b.c) {
/* 732 */           Log.i("SsDownloadManager", "resuming download for id: " + this.b.a + ", and state.mFilename: " + parama.a);
/*     */         }
/*     */         
/* 735 */         long l = localFile.length();
/* 736 */         if (l == 0L)
/*     */         {
/* 738 */          /* if (bee.d) {
*//* 739 *//*             Log.d("SsDownloadManager", "setupDestinationFile() found fileLength=0, deleting " + parama.bb);
*//*     *//*           }*/
/*     */           
/* 742 */           localFile.delete();
/* 743 */           parama.a = null;
/* 744 */           if (b.c) {
/* 745 */             Log.i("SsDownloadManager", "resuming download for id: " + this.b.a + ", BUT starting from scratch again: ");
/*     */           }
/*     */         } else {
/* 748 */           if ((this.b.u == null) && (!this.b.c))
/*     */           {
/* 750 */            /* if (bee.d) {
*//* 751 *//*               Log.d("SsDownloadManager", "setupDestinationFile() unable to resume download, deleting " + parama.bb);
*//*     *//*             }*/
/*     */             
/* 754 */             localFile.delete();
/* 755 */             throw new u(489, "Trying to resume ssl download that can't be resumed");
/*     */           }
/*     */           
/*     */ 
/* 759 */           if (b.c) {
/* 760 */             Log.i("SsDownloadManager", "resuming download for id: " + this.b.a + ", and starting with file of length: " + l);
/*     */           }
/*     */           
/* 763 */           parama.g = ((int)l);
/* 764 */           if (this.b.s != -1L) {
/* 765 */             parama.p = this.b.s;
/*     */           }
/* 767 */           parama.h = this.b.u;
/* 768 */           parama.i = true;
/* 769 */           if (b.c) {
/* 770 */             Log.i("SsDownloadManager", "resuming download for id: " + this.b.a + ", state.mCurrentBytes: " + parama.g + ", and setting mContinuingDownload to true: ");
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @TargetApi(5)
/*     */   private void e(a parama, HttpURLConnection paramHttpURLConnection)
/*     */   {
/* 784 */     for (Pair localPair : this.b.a()) {
/* 785 */       paramHttpURLConnection.addRequestProperty((String)localPair.first, (String)localPair.second);
/*     */     }
/*     */     
/*     */ 
/* 789 */     if (paramHttpURLConnection.getRequestProperty("User-Agent") == null) {
/* 790 */       paramHttpURLConnection.addRequestProperty("User-Agent", a());
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 795 */     paramHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
/*     */     
/* 797 */     if (parama.i) {
/* 798 */       if (parama.h != null) {
/* 799 */         paramHttpURLConnection.addRequestProperty("If-Match", parama.h);
/*     */       }
/* 801 */       paramHttpURLConnection.addRequestProperty("Range", "bytes=" + parama.g + "-");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void a(a parama, int paramInt1, String paramString, int paramInt2)
/*     */   {
/* 810 */     b(parama, paramInt1, paramString, paramInt2);
/* 811 */     if (com.bytedance.sdk.openadsdk.ccccc.m.a.c(paramInt1)) {
/* 812 */       this.b.a(paramInt1);
/*     */     }
/*     */   }
/*     */   
/*     */   private void b(a parama, int paramInt1, String paramString, int paramInt2)
/*     */   {
/* 818 */     ContentValues localContentValues = new ContentValues();
/* 819 */     localContentValues.put("status", Integer.valueOf(paramInt1));
/* 820 */     localContentValues.put("_data", parama.a);
/* 821 */     localContentValues.put("mimetype", parama.b);
/* 822 */     localContentValues.put("lastmod", Long.valueOf(this.c.a()));
/* 823 */     localContentValues.put("numfailed", Integer.valueOf(paramInt2));
/* 824 */     localContentValues.put("method", Integer.valueOf(parama.c));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 831 */     if (!TextUtils.isEmpty(paramString)) {
/* 832 */       localContentValues.put("errorMsg", paramString);
/*     */     }
/* 834 */     i.a(this.a).a(this.b.d(), localContentValues, null, null);
/*     */   }
/*     */   
/*     */   public static long a(URLConnection paramURLConnection, String paramString, long paramLong)
/*     */   {
/*     */     try {
/* 840 */       return Long.parseLong(paramURLConnection.getHeaderField(paramString));
/*     */     } catch (NumberFormatException localNumberFormatException) {}
/* 842 */     return paramLong;
/*     */   }
/*     */   
/*     */   public static boolean a(int paramInt)
/*     */   {
/* 847 */     switch (paramInt) {
/*     */     case 495: 
/*     */     case 500: 
/*     */     case 503: 
/* 851 */       return true;
/*     */     }
/* 853 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\cdsss\m.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */