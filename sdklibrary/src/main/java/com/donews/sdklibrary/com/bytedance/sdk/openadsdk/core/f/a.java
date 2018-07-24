/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core.f;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.SharedPreferences;
/*     */ import android.content.SharedPreferences.Editor;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import android.support.annotation.NonNull;
/*     */ import com.bytedance.sdk.openadsdk.core.d.h;
/*     */ import com.bytedance.sdk.openadsdk.core.d.i;
/*     */ import com.bytedance.sdk.openadsdk.core.n;
/*     */ import com.bytedance.sdk.openadsdk.core.p.a;
/*     */ import com.bytedance.sdk.openadsdk.g.f;
/*     */ import com.bytedance.sdk.openadsdk.g.m;
/*     */ import com.bytedance.sdk.openadsdk.g.q;
/*     */ import com.bytedance.sdk.openadsdk.g.t;
/*     */ import com.bytedance.sdk.openadsdk.g.t.a;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ScheduledExecutorService;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class a
/*     */   implements t.a
/*     */ {
/*     */   private static volatile a a;
/*     */   private Context b;
/*  61 */   private t c = new t(Looper.getMainLooper(), this);
/*     */   
/*     */   private a d;
/*     */   
/*     */   private b e;
/*     */   
/*     */   private c f;
/*     */   
/*  69 */   private ScheduledExecutorService g = Executors.newSingleThreadScheduledExecutor();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private a(Context paramContext)
/*     */   {
/*  76 */     if (paramContext != null) {
/*  77 */       this.b = paramContext.getApplicationContext();
/*     */     }
/*     */   }
/*     */   
/*     */   static a a(Context paramContext) {
/*  82 */     if (a == null) {
/*  83 */       synchronized (a.class) {
/*  84 */         if (a == null) {
/*  85 */           a = new a(paramContext);
/*     */         }
/*     */       }
/*     */     }
/*  89 */     return a;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void a(i parami)
/*     */   {
/*  98 */     if (parami == null) {
/*  99 */       return;
/*     */     }
/*     */     
/* 102 */     File localFile = a(this.b, "/splash_ad_cache/", "tt_splash_image_cache");
/* 103 */     if (localFile == null) {
/* 104 */       return;
/*     */     }
/*     */     
/* 107 */     a(parami.a().r());
/*     */     
/* 109 */     a(parami, localFile);
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
/*     */   private void a(i parami, File paramFile)
/*     */   {
/* 137 */     if (this.f == null) {
/* 138 */       this.f = new c(parami, paramFile);
/*     */     } else {
/* 140 */       this.f.a(parami);
/* 141 */       this.f.a(paramFile);
/*     */     }
/* 143 */     this.g.execute(this.f);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void a(long paramLong)
/*     */   {
/* 150 */     SharedPreferences localSharedPreferences = this.b.getSharedPreferences("tt_splash", 0);
/* 151 */     Editor localEditor = localSharedPreferences.edit();
/* 152 */     localEditor.putLong("expiration", paramLong)
/* 153 */       .putLong("update", System.currentTimeMillis() / 1000L)
/* 154 */       .putBoolean("has_ad_cache", true)
/* 155 */       .apply();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void a(@NonNull a parama)
/*     */   {
/* 164 */     File localFile = a(this.b, "/splash_ad_cache/", "tt_splash_image_cache");
/* 165 */     if (localFile == null) {
/* 166 */       parama.a();
/*     */     }
/* 168 */     this.d = parama;
/* 169 */     this.g.execute(a(localFile));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private Runnable a(File paramFile)
/*     */   {
/* 176 */     if (this.e == null) {
/* 177 */       this.e = new b(paramFile);
/*     */     } else {
/* 179 */       this.e.a(paramFile);
/*     */     }
/* 181 */     return this.e;
/*     */   }
/*     */   
/*     */   boolean a() {
/* 185 */     SharedPreferences localSharedPreferences = this.b.getSharedPreferences("tt_splash", 0);
/* 186 */     boolean bool = localSharedPreferences.getBoolean("has_ad_cache", false);
/* 187 */     return bool;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean b()
/*     */   {
/* 196 */     SharedPreferences localSharedPreferences = this.b.getSharedPreferences("tt_splash", 0);
/* 197 */     long l1 = localSharedPreferences.getLong("expiration", 0L);
/* 198 */     long l2 = localSharedPreferences.getLong("update", 0L);
/* 199 */     long l3 = System.currentTimeMillis() / 1000L;
/*     */     
/* 201 */     if ((l3 < l2) || (l3 >= l1)) {
/* 202 */       return true;
/*     */     }
/*     */     
/* 205 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private File a(Context paramContext, String paramString1, String paramString2)
/*     */   {
/* 215 */     return f.a(paramContext, paramString1, paramString2);
/*     */   }
/*     */   
/*     */ 
/*     */   public void a(Message paramMessage)
/*     */   {
/* 221 */     if (paramMessage.what == 1) {
/* 222 */       if (this.d != null) {
/* 223 */         if ((paramMessage.obj != null) && ((paramMessage.obj instanceof i))) {
/* 224 */           this.d.a((i)paramMessage.obj);
/* 225 */           m.b("SplashAdCacheManager", "缓存反序列化成功");
/*     */         } else {
/* 227 */           this.d.a();
/* 228 */           m.b("SplashAdCacheManager", "缓存反序列化失败");
/*     */         }
/*     */       }
/* 231 */       this.c.removeCallbacksAndMessages(null);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void c()
/*     */   {
/* 239 */     SharedPreferences localSharedPreferences1 = this.b.getSharedPreferences("tt_materialMeta", 0);
/* 240 */     localSharedPreferences1.edit().clear().apply();
/* 241 */     SharedPreferences localSharedPreferences2 = this.b.getSharedPreferences("tt_splash", 0);
/* 242 */     localSharedPreferences2.edit().clear().apply();
/*     */   }
/*     */   
/*     */   private class b implements Runnable {
/*     */     private File b;
/*     */     
/*     */     public b(File paramFile) {
/* 249 */       this.b = paramFile;
/*     */     }
/*     */     
/*     */     public void a(File paramFile) {
/* 253 */       this.b = paramFile;
/*     */     }
/*     */     
/*     */     public void run()
/*     */     {
/* 258 */       Message localMessage = a.b(a.this).obtainMessage();
/* 259 */       localMessage.what = 1;
/*     */       try {
/* 261 */         h localh = a();
/* 262 */         if (localh != null) {
/* 263 */           byte[] arrayOfByte = b(this.b);
/*     */           
/* 265 */           if ((arrayOfByte != null) && (arrayOfByte.length != 0)) {
/* 266 */             localMessage.obj = new i(localh, arrayOfByte);
/*     */           }
/*     */         }
/*     */         
/* 270 */         a.this.c();
/*     */       }
/*     */       catch (Exception localException) {}finally {
/* 273 */         a.b(a.this).sendMessage(localMessage);
/*     */       }
/*     */     }
/*     */     
/*     */     public byte[] b(File paramFile) {
/* 278 */       localByteArrayOutputStream = new ByteArrayOutputStream();
/*     */       
/* 280 */       byte[] arrayOfByte = new byte['Ѐ'];
/* 281 */       FileInputStream localFileInputStream = null;
/*     */       try {
/* 283 */         localFileInputStream = new FileInputStream(paramFile);
/* 284 */         int i; while ((i = localFileInputStream.read(arrayOfByte, 0, arrayOfByte.length)) != -1) {
/* 285 */           localByteArrayOutputStream.write(arrayOfByte, 0, i);
/*     */         }
/* 287 */         localByteArrayOutputStream.flush();
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 300 */         return localByteArrayOutputStream.toByteArray();
/*     */       }
/*     */       catch (Exception localException) {}finally
/*     */       {
/*     */         try
/*     */         {
/* 291 */           if (localByteArrayOutputStream != null) {
/* 292 */             localByteArrayOutputStream.close();
/*     */           }
/* 294 */           if (localFileInputStream != null) {
/* 295 */             localFileInputStream.close();
/*     */           }
/*     */         }
/*     */         catch (IOException localIOException3) {}
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     private h a()
/*     */     {
/* 305 */       SharedPreferences localSharedPreferences = a.a(a.this).getSharedPreferences("tt_materialMeta", 0);
/* 306 */       String str = localSharedPreferences.getString("materialMeta", null);
/* 307 */       if (!q.a(str)) {
/*     */         try {
/* 309 */           p.a locala = p.a.a(new JSONObject(str));
/*     */           
/* 311 */           if ((locala != null) && (locala.d != null) && (locala.d.b() != null) && 
/* 312 */             (!locala.d.b().isEmpty()))
/*     */           {
/* 314 */             h localh = (h)locala.d.b().get(0);
/* 315 */             if (localh.v()) {
/* 316 */               return localh;
/*     */             }
/*     */           }
/*     */         }
/*     */         catch (JSONException localJSONException) {}
/*     */       }
/* 322 */       return null;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class c implements Runnable
/*     */   {
/*     */     private i a;
/*     */     private File b;
/*     */     
/*     */     public c(i parami, File paramFile) {
/* 332 */       this.a = parami;
/* 333 */       this.b = paramFile;
/*     */     }
/*     */     
/*     */     public void a(i parami) {
/* 337 */       this.a = parami;
/*     */     }
/*     */     
/*     */     public void a(File paramFile) {
/* 341 */       this.b = paramFile;
/*     */     }
/*     */     
/*     */     public void run()
/*     */     {
/* 346 */       a();
/* 347 */       b();
/*     */     }
/*     */     
/*     */     /* Error */
/*     */     private void a()
/*     */     {
/*     */       // Byte code:
/*     */       //   0: aconst_null
/*     */       //   1: astore_1
/*     */       //   2: new 11	java/io/BufferedOutputStream
/*     */       //   5: dup
/*     */       //   6: new 12	java/io/FileOutputStream
/*     */       //   9: dup
/*     */       //   10: aload_0
/*     */       //   11: getfield 17	com/bytedance/sdk/openadsdk/core/f/a$c:b	Ljava/io/File;
/*     */       //   14: invokespecial 29	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
/*     */       //   17: invokespecial 25	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
/*     */       //   20: astore_1
/*     */       //   21: aload_1
/*     */       //   22: aload_0
/*     */       //   23: getfield 16	com/bytedance/sdk/openadsdk/core/f/a$c:a	Lcom/bytedance/sdk/openadsdk/core/d/i;
/*     */       //   26: invokevirtual 20	com/bytedance/sdk/openadsdk/core/d/i:b	()[B
/*     */       //   29: invokevirtual 28	java/io/BufferedOutputStream:write	([B)V
/*     */       //   32: aload_1
/*     */       //   33: invokevirtual 27	java/io/BufferedOutputStream:flush	()V
/*     */       //   36: aload_1
/*     */       //   37: ifnull +7 -> 44
/*     */       //   40: aload_1
/*     */       //   41: invokevirtual 26	java/io/BufferedOutputStream:close	()V
/*     */       //   44: goto +39 -> 83
/*     */       //   47: astore_2
/*     */       //   48: goto +35 -> 83
/*     */       //   51: astore_2
/*     */       //   52: aload_1
/*     */       //   53: ifnull +7 -> 60
/*     */       //   56: aload_1
/*     */       //   57: invokevirtual 26	java/io/BufferedOutputStream:close	()V
/*     */       //   60: goto +23 -> 83
/*     */       //   63: astore_2
/*     */       //   64: goto +19 -> 83
/*     */       //   67: astore_3
/*     */       //   68: aload_1
/*     */       //   69: ifnull +7 -> 76
/*     */       //   72: aload_1
/*     */       //   73: invokevirtual 26	java/io/BufferedOutputStream:close	()V
/*     */       //   76: goto +5 -> 81
/*     */       //   79: astore 4
/*     */       //   81: aload_3
/*     */       //   82: athrow
/*     */       //   83: return
/*     */       // Line number table:
/*     */       //   Java source line #354	-> byte code offset #0
/*     */       //   Java source line #356	-> byte code offset #2
/*     */       //   Java source line #357	-> byte code offset #21
/*     */       //   Java source line #358	-> byte code offset #32
/*     */       //   Java source line #362	-> byte code offset #36
/*     */       //   Java source line #363	-> byte code offset #40
/*     */       //   Java source line #366	-> byte code offset #44
/*     */       //   Java source line #365	-> byte code offset #47
/*     */       //   Java source line #367	-> byte code offset #48
/*     */       //   Java source line #359	-> byte code offset #51
/*     */       //   Java source line #362	-> byte code offset #52
/*     */       //   Java source line #363	-> byte code offset #56
/*     */       //   Java source line #366	-> byte code offset #60
/*     */       //   Java source line #365	-> byte code offset #63
/*     */       //   Java source line #367	-> byte code offset #64
/*     */       //   Java source line #361	-> byte code offset #67
/*     */       //   Java source line #362	-> byte code offset #68
/*     */       //   Java source line #363	-> byte code offset #72
/*     */       //   Java source line #366	-> byte code offset #76
/*     */       //   Java source line #365	-> byte code offset #79
/*     */       //   Java source line #366	-> byte code offset #81
/*     */       //   Java source line #368	-> byte code offset #83
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	signature
/*     */       //   0	84	0	this	c
/*     */       //   1	72	1	localBufferedOutputStream	java.io.BufferedOutputStream
/*     */       //   47	1	2	localIOException1	IOException
/*     */       //   51	1	2	localIOException2	IOException
/*     */       //   63	1	2	localIOException3	IOException
/*     */       //   67	15	3	localObject	Object
/*     */       //   79	1	4	localIOException4	IOException
/*     */       // Exception table:
/*     */       //   from	to	target	type
/*     */       //   36	44	47	java/io/IOException
/*     */       //   2	36	51	java/io/IOException
/*     */       //   52	60	63	java/io/IOException
/*     */       //   2	36	67	finally
/*     */       //   68	76	79	java/io/IOException
/*     */     }
/*     */     
/*     */     private void b()
/*     */     {
/* 374 */       SharedPreferences localSharedPreferences = n.a().getSharedPreferences("tt_materialMeta", 0);
/* 375 */       Editor localEditor = localSharedPreferences.edit();
/*     */       
/* 377 */       localEditor.putString("materialMeta", this.a.c().c()).apply();
/*     */     }
/*     */   }
/*     */   
/*     */   static abstract interface a
/*     */   {
/*     */     public abstract void a(@NonNull i parami);
/*     */     
/*     */     public abstract void a();
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\f\a.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */