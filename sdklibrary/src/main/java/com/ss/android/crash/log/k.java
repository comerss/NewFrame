/*     */ package com.ss.android.crash.log;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.SharedPreferences;
/*     */ import android.content.SharedPreferences.Editor;
/*     */ import android.text.TextUtils;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.Closeable;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.FilenameFilter;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class k
/*     */ {
/*     */   private volatile Context a;
/*     */   private j.a b;
/*     */   private SharedPreferences c;
/*     */   private volatile String d;
/*     */   private volatile boolean e;
/*  34 */   private static final Object f = new Object();
/*  35 */   private static final FilenameFilter g = new FilenameFilter()
/*     */   {
/*     */     public boolean accept(File paramAnonymousFile, String paramAnonymousString) {
/*  38 */       return (paramAnonymousString != null) && (paramAnonymousString.startsWith("ss_native_crash-"));
/*     */     }
/*     */   };
/*     */   
/*     */   k(Context paramContext, j.a parama) {
/*  43 */     if ((parama == null) || (paramContext == null))
/*  44 */       throw new IllegalArgumentException("context and ICommonParams must not be null");
/*  45 */     this.b = parama;
/*  46 */     this.a = paramContext.getApplicationContext();
/*  47 */     this.c = this.a.getSharedPreferences("app_crash_copy", 0);
/*  48 */     this.d = this.c.getString("header", null);
/*  49 */     c();
/*     */   }
/*     */   
/*     */   public void a() {
/*  53 */     if (this.e)
/*  54 */       return;
/*  55 */     if ((this.b.a() != null) && (this.b.a().containsKey("device_id"))) {
/*  56 */       Map localMap = this.b.a();
/*  57 */       JSONObject localJSONObject = new JSONObject();
/*  58 */       for (String str : localMap.keySet()) {
/*     */         try {
/*  60 */           localJSONObject.put(str, localMap.get(str));
/*     */         } catch (JSONException localJSONException) {
/*  62 */           localJSONException.printStackTrace();
/*     */         }
/*     */       }
/*  65 */       this.c.edit().putString("header", localJSONObject.toString()).apply();
/*  66 */       this.e = true;
/*     */     }
/*     */   }
/*     */   
/*  70 */   private void c() { p.a().a(new Runnable()
/*     */     {
/*     */       public void run() {
/*     */         try {
/*  74 */           k.a(k.this);
/*  75 */           k.b(k.this);
/*     */         }
/*     */         catch (Throwable localThrowable) {}
/*     */       }
/*     */     }); }
/*     */   
/*     */   private void d()
/*     */     throws IOException
/*     */   {
/*  84 */     File localFile1 = new File(l.c(this.a), "tt_crash_log_dir");
/*  85 */     if (!localFile1.exists())
/*  86 */       return;
/*  87 */     File[] arrayOfFile = localFile1.listFiles();
/*  88 */     Arrays.sort(arrayOfFile, Collections.reverseOrder());
/*  89 */     for (int i = 0; i < arrayOfFile.length; i++) {
/*  90 */       File localFile2 = arrayOfFile[i];
/*  91 */       if (i < 5) {
/*     */         try {
/*  93 */           String str = null;
/*  94 */           synchronized (f) {
/*  95 */             str = n.b(localFile2.getAbsolutePath());
/*     */           }
/*  97 */           l.a(str, this.b.a());
/*     */         }
/*     */         catch (Exception localException) {}
/*     */       }
/* 101 */       localFile2.delete();
/*     */     } }
/*     */   
/* 104 */   private String h = null;
/*     */   
/* 106 */   private void e() { Object localObject1 = null;
/*     */     try {
/* 108 */       File localFile1 = new File(l.c(this.a), "ss_native_crash_logs");
/* 109 */       File[] arrayOfFile = localFile1.listFiles(g);
/* 110 */       if ((arrayOfFile == null) || (arrayOfFile.length <= 0)) {
/* 111 */         return;
/*     */       }
/* 113 */       Arrays.sort(arrayOfFile, Collections.reverseOrder());
/* 114 */       String str1 = this.h;
/* 115 */       this.h = arrayOfFile[0].getName();
/* 116 */       int i = arrayOfFile.length;
/* 117 */       int j = 0;
/*     */       
/* 119 */       for (int k = 0; k < i; k++) {
/* 120 */         File localFile2 = arrayOfFile[k];
/* 121 */         if ((k >= 5) || ((str1 != null) && (str1.equals(localFile2.getName())))) {
/* 122 */           j = 1;
/*     */         }
/* 124 */         long l = 0L;
/* 125 */         String str2 = null;
/* 126 */         StringBuffer localStringBuffer = new StringBuffer();
/* 127 */         String str3 = null;
/* 128 */         int m = 0;
/* 129 */         if ((j == 0) && (localFile2.length() < 16384L)) {
/*     */           try {
/* 131 */             localObject1 = new BufferedReader(new FileReader(localFile2));
/* 132 */             while ((str2 = ((BufferedReader)localObject1).readLine()) != null) {
/* 133 */               if (m == 0) {
/* 134 */                 l = Long.parseLong(str2);
/*     */               }
/* 136 */               else if (m == 1) {
/* 137 */                 str3 = str2;
/*     */               } else {
/* 139 */                 localStringBuffer.append(str2 + "\n");
/*     */               }
/* 141 */               m++;
/*     */             }
/* 143 */             ((BufferedReader)localObject1).close();
/* 144 */             localObject1 = null;
/* 145 */             JSONObject localJSONObject = null;
/* 146 */             if (this.d != null) {
/* 147 */               localJSONObject = new JSONObject(this.d);
/*     */             } else {
/* 149 */               localObject2 = this.b.a();
/* 150 */               for (String str4 : ((Map)localObject2).keySet()) {
/* 151 */                 localJSONObject.put(str4, ((Map)localObject2).get(str4));
/*     */               }
/*     */             }
/* 154 */             Object localObject2 = new JSONObject();
/* 155 */             ((JSONObject)localObject2).put("header", localJSONObject);
/* 156 */             ((JSONObject)localObject2).put("data", localStringBuffer.toString().trim());
/* 157 */             ((JSONObject)localObject2).put("is_native_crash", 1);
/* 158 */             if (!str3.startsWith("no_process_name"))
/* 159 */               ((JSONObject)localObject2).put("process_name", str3);
/* 160 */             if (l > 0L)
/* 161 */               ((JSONObject)localObject2).put("crash_time", l);
/* 162 */             if ((str3 != null) && (str3.contains(":"))) {
/* 163 */               ((JSONObject)localObject2).put("remote_process", 1);
/*     */             } else
/* 165 */               ((JSONObject)localObject2).put("remote_process", 0);
/* 166 */             l.a(((JSONObject)localObject2).toString(), this.b.a());
/*     */           }
/*     */           catch (Exception localException1) {}
/*     */         }
/*     */         try {
/* 171 */           localFile2.delete();
/*     */         }
/*     */         catch (Exception localException2) {}
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable) {}finally {
/* 177 */       l.a((Closeable)localObject1);
/*     */     }
/*     */   }
/*     */   
/* 181 */   public void a(final JSONObject paramJSONObject) { if ((paramJSONObject == null) || (paramJSONObject.length() <= 0))
/* 182 */       return;
/*     */     try {
/* 184 */       JSONObject localJSONObject = new JSONObject();
/* 185 */       Map localMap = this.b.a();
/* 186 */       for (final Object localObject = localMap.keySet().iterator(); ((Iterator)localObject).hasNext();) { String str = (String)((Iterator)localObject).next();
/* 187 */         localJSONObject.put(str, localMap.get(str));
/*     */       }
/* 189 */       paramJSONObject.put("header", localJSONObject);
/* 190 */       localObject = a(paramJSONObject.toString(), String.valueOf(System.currentTimeMillis()));
/* 191 */       p.a().a(new Runnable()
/*     */       {
/*     */         public void run() {
/* 194 */           if (l.a(paramJSONObject.toString(), k.c(k.this).a())) {
/* 195 */             synchronized (k.b()) {
/* 196 */               n.a(localObject);
/*     */             }
/*     */           }
/*     */         }
/*     */       });
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/*     */   }
/*     */   
/*     */   private String a(String paramString1, String paramString2) throws IOException {
/* 206 */     if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
/* 207 */       return null;
/* 208 */     synchronized (f) {
/* 209 */       File localFile1 = new File(l.c(this.a), "tt_crash_log_dir");
/* 210 */       if (!localFile1.exists())
/* 211 */         localFile1.mkdirs();
/* 212 */       File localFile2 = new File(localFile1, paramString2);
/* 213 */       n.a(localFile2, paramString1);
/* 214 */       return localFile2.getAbsolutePath();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\ss\android\crash\log\m.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */