/*     */ package com.donews.sdklibrary.com.ss.android.crash.log;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.SharedPreferences;
/*     */ import android.content.SharedPreferences.Editor;
/*     */ import android.os.Build.VERSION;
/*     */ import android.os.HandlerThread;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import android.os.Process;
/*     */ import android.text.TextUtils;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */ {
/*     */   private a a;
/*  33 */   private HandlerThread b = null;
/*     */   private b c;
/*     */   private d d;
/*     */   private final Context e;
/*     */   private volatile long f;
/*  38 */   private volatile boolean g = false;
/*     */   private final SharedPreferences h;
/*     */   
/*     */   public c(Context paramContext) {
/*  42 */     if (paramContext == null)
/*  43 */       throw new IllegalArgumentException("context is not be null");
/*  44 */     this.e = paramContext.getApplicationContext();
/*  45 */     this.h = this.e.getSharedPreferences("anr_monitor_table", 0);
/*  46 */     this.f = this.h.getLong("trace_anr_happen_time", 0L);
/*     */   }
/*     */   
/*     */   public void a() {
/*  50 */     if (this.g)
/*  51 */       return;
/*  52 */     this.b = new HandlerThread("anr_monitor");
/*  53 */     this.b.start();
/*  54 */     this.c = new b(this, this.b.getLooper());
/*  55 */     if (Build.VERSION.SDK_INT < 21) {
/*  56 */       this.a = new a(this, "/data/anr/", 8);
/*  57 */       this.a.startWatching();
/*     */     } else {
/*  59 */       this.d = new d(this, 5000L);
/*  60 */       this.d.start();
/*     */     }
/*  62 */     this.g = true;
/*     */   }
/*     */   
/*  65 */   public void a(int paramInt, String paramString) { if (this.c != null) {
/*  66 */       this.c.obtainMessage(paramInt, paramString).sendToTarget();
/*     */     }
/*     */   }
/*     */   
/*     */   public void b(int paramInt, String paramString) {
/*     */     try {
/*  72 */       if (this.e != null) {
/*  73 */         JSONObject localJSONObject1 = new JSONObject();
/*  74 */         String str = this.e.getPackageName();
/*  75 */         if (!e.a(this.e, str))
/*  76 */           return;
/*  77 */         int i = Process.myPid();
/*  78 */         if ((TextUtils.isEmpty(str)) || (i <= 0))
/*  79 */           return;
/*  80 */         if (paramInt == 200) {
/*  81 */           localJSONObject1 = a(paramString, i, str);
/*  82 */         } else if (paramInt == 100) {
/*  83 */           localJSONObject1 = e.a();
/*     */         }
/*  85 */         if ((localJSONObject1 != null) && (localJSONObject1.length() > 0)) {
/*  86 */           localJSONObject1.put("pid", i);
/*  87 */           localJSONObject1.put("package", str);
/*  88 */           localJSONObject1.put("is_remote_process", 0);
/*  89 */           JSONObject localJSONObject2 = new JSONObject();
/*  90 */           localJSONObject2.put("data", localJSONObject1.toString());
/*  91 */           localJSONObject2.put("is_anr", 1);
/*  92 */           localJSONObject2.put("anr_time", System.currentTimeMillis());
/*  93 */           i.b().a(localJSONObject2);
/*     */         }
/*     */       }
/*     */     } catch (Throwable localThrowable) {
/*  97 */       localThrowable.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public JSONObject a(String paramString1, int paramInt, String paramString2) {
/* 102 */     if (TextUtils.isEmpty(paramString1))
/* 103 */       return null;
/* 104 */     File localFile = new File(paramString1);
/* 105 */     if ((!localFile.exists()) || (!localFile.canRead()))
/* 106 */       return null;
/*     */     try {
/* 108 */       BufferedReader localBufferedReader = new BufferedReader(new FileReader(localFile));
/* 109 */       Pattern localPattern1 = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
/* 110 */       Pattern localPattern2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
/* 111 */       Pattern localPattern3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
/* 112 */       Pattern localPattern4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
/* 113 */       SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
/*     */       Object[] arrayOfObject1;
/* 115 */       if ((arrayOfObject1 = a(localBufferedReader, new Pattern[] { localPattern1 })) == null)
/* 116 */         return null;
/* 117 */       long l1 = Long.parseLong(arrayOfObject1[1].toString().split("\\s")[2]);
/* 118 */       long l2 = localSimpleDateFormat.parse(arrayOfObject1[1].toString().split("\\s")[4] + " " + arrayOfObject1[1].toString().split("\\s")[5]).getTime();
/*     */       
/*     */       Object[] arrayOfObject2;
/* 121 */       if ((arrayOfObject2 = a(localBufferedReader, new Pattern[] { localPattern3 })) == null)
/* 122 */         return null;
/* 123 */       String str1 = arrayOfObject2[1].toString().split("\\s")[2];
/*     */       
/* 125 */       if ((l1 != paramInt) || (!str1.equalsIgnoreCase(paramString2)))
/* 126 */         return null;
/* 127 */       if ((this.f != 0L) && (Math.abs(this.f - l2) < 20000L))
/* 128 */         return null;
/* 129 */       this.f = l2;
/* 130 */       if (this.h != null) {
/* 131 */         this.h.edit().putLong("trace_anr_happen_time", this.f).apply();
/*     */       }
/* 133 */       JSONObject localJSONObject1 = new JSONObject();
/* 134 */       localJSONObject1.put("anrTime", l2);
/* 135 */       JSONArray localJSONArray = new JSONArray();
/*     */       
/* 137 */       int i = 0;
/* 138 */       int j = 0;
/* 139 */       Object[] arrayOfObject3; while (((arrayOfObject3 = a(localBufferedReader, new Pattern[] { localPattern2, localPattern4 })) != null) && (arrayOfObject3[0] == localPattern4))
/*     */       {
/* 141 */         int k = -1;
/* 142 */         String str2 = "";
/* 143 */         Matcher localMatcher1 = Pattern.compile("\".+\"").matcher(arrayOfObject3[1].toString());
/* 144 */         if (localMatcher1.find()) {
/* 145 */           str2 = localMatcher1.group().substring(1, localMatcher1.group().length() - 1);
/*     */         }
/* 147 */         Matcher localMatcher2 = Pattern.compile("tid=\\d+").matcher(arrayOfObject3[1].toString());
/* 148 */         if (localMatcher2.find()) {
/* 149 */           str3 = localMatcher2.group();
/* 150 */           k = Integer.parseInt(str3.substring(str3.indexOf("=") + 1));
/*     */         }
/* 152 */         String str3 = a(localBufferedReader);
/* 153 */         if ((k != -1) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))
/*     */         {
/* 155 */           if (str2.equalsIgnoreCase("main")) {
/* 156 */             localJSONObject1.put("mainStackFromTrace", str3);
/* 157 */             i = 1;
/*     */           }
/* 159 */           j++;
/* 160 */           if (j <= 5L)
/*     */           {
/* 162 */             JSONObject localJSONObject2 = new JSONObject();
/* 163 */             localJSONObject2.put("id", k);
/* 164 */             localJSONObject2.put("name", str2);
/* 165 */             localJSONObject2.put("stack", str3);
/* 166 */             localJSONArray.put(localJSONObject2);
/*     */           } } }
/* 168 */       localJSONObject1.put("allThreadStack", localJSONArray);
/* 169 */       if (i == 0) {
/* 170 */         localJSONObject1.put("main", b());
/*     */       }
/* 172 */       localJSONObject1.put("thread_number", j);
/*     */       
/* 174 */       return localJSONObject1;
/*     */     } catch (Exception localException) {
/* 176 */       localException.printStackTrace();
/*     */     }
/* 178 */     return null;
/*     */   }
/*     */   
/*     */   private Object[] a(BufferedReader paramBufferedReader, Pattern... paramVarArgs) throws IOException {
/* 182 */     if ((paramBufferedReader == null) || (paramVarArgs == null) || (paramVarArgs.length <= 0))
/* 183 */       return null;
/*     */     String str;
/* 185 */     while ((str = paramBufferedReader.readLine()) != null) {
/* 186 */       for (Pattern localPattern : paramVarArgs) {
/* 187 */         if (localPattern.matcher(str).matches()) {
/* 188 */           return new Object[] { localPattern, str };
/*     */         }
/*     */       }
/*     */     }
/* 192 */     return null;
/*     */   }
/*     */   
/*     */   private String a(BufferedReader paramBufferedReader) throws IOException {
/* 196 */     if (paramBufferedReader == null)
/* 197 */       return null;
/* 198 */     StringBuilder localStringBuilder = new StringBuilder();
/*     */     String str;
/* 200 */     while (((str = paramBufferedReader.readLine()) != null) && (str.trim().length() > 0)) {
/* 201 */       localStringBuilder.append(str).append("\n");
/*     */     }
/* 203 */     return localStringBuilder.toString();
/*     */   }
/*     */   
/*     */   private String b() {
/* 207 */     StringBuilder localStringBuilder = new StringBuilder();
/* 208 */     StackTraceElement[] arrayOfStackTraceElement1 = Looper.getMainLooper().getThread().getStackTrace();
/* 209 */     for (StackTraceElement localStackTraceElement : arrayOfStackTraceElement1) {
/* 210 */       String str = localStackTraceElement.getClassName();
/* 211 */       localStringBuilder.append(str).append(".").append(localStackTraceElement.getMethodName())
/* 212 */         .append("(").append(localStackTraceElement.getFileName()).append(":")
/* 213 */         .append(localStackTraceElement.getLineNumber()).append(")\n");
/*     */     }
/* 215 */     return localStringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\ss\android\crash\log\c.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */